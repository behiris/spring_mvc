package hms_spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import hms_controller.PrescriptionCommand;

public class PrescriptionDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<PrescriptionCommand> m_RowMapper = new RowMapper<PrescriptionCommand>() {
		@Override
		public PrescriptionCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			PrescriptionCommand prescription = new PrescriptionCommand(rs.getLong("num"), rs.getString("department"),
					rs.getString("disease"), rs.getString("desc"), rs.getString("medicine"), rs.getInt("patient"),
					rs.getString("doctor"), rs.getTimestamp("regdate"), rs.getInt("check"));
			return prescription;
		}
	};

	public PrescriptionDao(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from prescription", Integer.class);
		return count;
	}

	public void update(PrescriptionCommand prescription) {
		jdbcTemplate.update("update prescription set DEPARTMENT=?, MEDICINE=?, PATIENT=?, DOCTOR=? where NUM=?",
				prescription.getDepartment(), prescription.getMedicine(), prescription.getPatient(),
				prescription.getDoctor(), prescription.getNum());
	}

	public void insert(final PrescriptionCommand prescription) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into prescription (NUM,DEPARTMENT,MEDICINE,PATIENT,DOCTOR) values(prescription_SEQ.nextval, ?)");
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, prescription.getDepartment());
				pstmt.setString(2, prescription.getMedicine());
				pstmt.setInt(3, prescription.getPatient());
				pstmt.setString(4, prescription.getDoctor());
				// 생성한 PreparedStatement 객체 반환
				return pstmt;
			}
		});
	}

	public PrescriptionCommand selectprescription(long num) {
		List<PrescriptionCommand> result = jdbcTemplate.query("select * from prescription where NUM=?", m_RowMapper,
				num);
		return result.isEmpty() ? null : result.get(0);
	}

	public List<PrescriptionCommand> selectAll() {
		List<PrescriptionCommand> results = jdbcTemplate.query("select * from prescription", m_RowMapper);
		return results;
	}
}
