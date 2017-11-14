package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	private RowMapper<Member> memRowMapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
			Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getTimestamp("REGDATE"));
			member.setId(rs.getLong("ID"));
			return member;
		}
	};
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		List<Member> result = jdbcTemplate.query("select * from MEMBER3 where EMAIL=?", memRowMapper, email);
		return result.isEmpty() ? null : result.get(0);
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER3", memRowMapper);
		return results;
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member3", Integer.class);
		return count;
	}
	
	public void update(Member member) {
		jdbcTemplate.update("update MEMBER3 set NAME=?, PASSWORD=? where EMAIL=?", member.getName(), member.getPassword(), member.getEmail());
	}
	
	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement("insert into MEMBER3 (ID, EMAIL, PASSWORD, NAME, REGDATE) values(MEMBER_SEQ.nextval, ?, ?, ?, ?)", new String[] {"ID"});
				//인덱스 파라미터 값 설정
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, new Timestamp(member.getRegdate().getTime()));
				//생성한 PreparedStatement 객체 반환
				return pstmt;
			}
		}, keyHolder);
		
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}
		
	public List<Member> selectByRegdate(Date from, Date to){
		List<Member> results = jdbcTemplate.query("select * from MEMBER3 where REGDATE between ? and ? order by REGDATE desc", memRowMapper, from, to);
		return results;
	}
	
	public Member selectById(Long id) {
		List<Member> results = jdbcTemplate.query("select * from MEMBER3 where ID = ?", memRowMapper, id);
		return results.isEmpty() ? null : results.get(0);
	}
}