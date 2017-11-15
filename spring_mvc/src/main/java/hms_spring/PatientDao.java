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

import hms_controller.PatientCommand;

public class PatientDao {
	
	private JdbcTemplate jdbcTemplate;
	private RowMapper<PatientCommand> m_RowMapper = new RowMapper<PatientCommand>() {
		@Override
		public PatientCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			PatientCommand patient = new PatientCommand(
				rs.getInt("num"),
				rs.getInt("ssn"),
				rs.getString("name"),
				rs.getString("gender"),
				rs.getInt("phone"),
				rs.getString("zipcode"),
				rs.getString("address1"),
				rs.getString("address2"));
			return patient;
		}
	};
	
	public PatientDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from PATIENT", Integer.class);
		return count;
	}

	public void update(PatientCommand patient) {
		jdbcTemplate.update("update PATIENT set SSN=?, NAME=?, GENDER=?, PHONE=?, ZIPCODE=?, ADDRESS1=?, ADDRESS2=? where NUM=?", 
				patient.getSsn(), patient.getName(), patient.getGender(), 
				patient.getPhone(), patient.getZipcode(), patient.getAddress1(), patient.getAddress2());
	}
	
	public void insert(final PatientCommand patient) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement("insert into PATIENT (NUM, NAME) values(PATIENT_SEQ.nextval, ?)");
				//인덱스 파라미터 값 설정
				pstmt.setString(1, patient.getName());
				//생성한 PreparedStatement 객체 반환
				return pstmt;
			}
		});
	}
	
	public PatientCommand selectPatient(long num) {
		List<PatientCommand> result = jdbcTemplate.query("select * from PATIENT where NUM=?", m_RowMapper, num);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<PatientCommand> selectAll() {
		List<PatientCommand> results = jdbcTemplate.query("select * from PATIENT", m_RowMapper);
		return results;
	}
}
