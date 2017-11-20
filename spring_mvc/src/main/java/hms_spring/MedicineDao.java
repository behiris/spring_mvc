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

import hms_controller.MedicineCommand;

public class MedicineDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<MedicineCommand> m_RowMapper = new RowMapper<MedicineCommand>() {
		@Override
		public MedicineCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			MedicineCommand medicine = new MedicineCommand(rs.getLong("num"), rs.getString("name"), rs.getInt("stock"));
			return medicine;
		}
	};
	
	public MedicineDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from MEDICINE", Integer.class);
		return count;
	}
	
	public void update(MedicineCommand medicine, int stock) {
		jdbcTemplate.update("update MEDICINE set NAME=?, STOCK=? where NUM=?", medicine.getName(), medicine.getStock()+stock, medicine.getNum());
	}
	
	public void insert(final MedicineCommand medicine) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement("insert into MEDICINE (NUM, NAME) values(MEDICINE_SEQ.nextval, ?)");
				//인덱스 파라미터 값 설정
				pstmt.setString(1, medicine.getName());
				//생성한 PreparedStatement 객체 반환
				return pstmt;
			}
		});
	}
	
	public MedicineCommand selectMedicine(long num) {
		List<MedicineCommand> result = jdbcTemplate.query("select * from MEDICINE where NUM=?", m_RowMapper, num);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<MedicineCommand> selectAll() {
		List<MedicineCommand> results = jdbcTemplate.query("select * from MEDICINE", m_RowMapper);
		return results;
	}
	
	public void orderMedicine(final MedicineCommand medicine, int stock) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement("insert into MEDICINE_STOCK (NUM, STOCK) values(?, ?)");
				pstmt.setLong(1, medicine.getNum());
				pstmt.setInt(2, stock);
				return pstmt;
			}
		});
	}
}
