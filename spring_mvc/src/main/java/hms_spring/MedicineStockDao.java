package hms_spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import hms_controller.MedicineStockCommand;

public class MedicineStockDao {

	private JdbcTemplate jdbcTemplate;
	private RowMapper<MedicineStockCommand> m_RowMapper = new RowMapper<MedicineStockCommand>() {
		@Override
		public MedicineStockCommand mapRow(ResultSet rs, int rowNum) throws SQLException {
			MedicineStockCommand medicineStock = new MedicineStockCommand(rs.getLong("num"), rs.getString("name"),
					rs.getInt("stock"), rs.getDate("regDate"));
			return medicineStock;
		}
	};

	public MedicineStockDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public MedicineStockCommand selectMedicineStock(long num) {
		List<MedicineStockCommand> result = jdbcTemplate.query("select * from medicine_stock where NUM=?", m_RowMapper,
				num);
		return result.isEmpty() ? null : result.get(0);
	}

	public List<MedicineStockCommand> selectAll() {
		List<MedicineStockCommand> results = jdbcTemplate.query("select medicine_stock.num, name, medicine_stock.stock, regdate from medicine_stock,medicine where medicine.num=medicine_stock.num", m_RowMapper);
		return results;
	}
}
