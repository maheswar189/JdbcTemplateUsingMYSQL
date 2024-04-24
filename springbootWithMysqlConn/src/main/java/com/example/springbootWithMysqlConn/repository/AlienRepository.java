package com.example.springbootWithMysqlConn.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.springbootWithMysqlConn.model.Alien;

@Component
public class AlienRepository {

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void saveObject(Alien alien) {
		String saveQuery = "Insert into alien (id,name,technology) values(?,?,?)";

		System.out.println("Successfully Saved..." + alien);
		int update = jdbcTemplate.update(saveQuery, alien.getId(), alien.getName(), alien.getTechnology());
	}

	public List<Alien> getAlienList() {
		String selectAliensQuery = "select * from alien";

		RowMapper<Alien> mapper = new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Alien alien = new Alien();
				alien.setId(rs.getString("id"));
				alien.setName(rs.getString("id"));
				alien.setTechnology(rs.getString("technology"));
				return alien;
			}

		};

		RowMapper<Alien> mapper2 = (rs, rowNum) -> {
			Alien alien = new Alien();
			alien.setId(rs.getString("id"));
			alien.setName(rs.getString("name"));
			alien.setTechnology(rs.getString("technology"));
			return alien;
		};

		return jdbcTemplate.query(selectAliensQuery, mapper2);
	}

	public Alien findById(String id) {
		String idQuery = "select * from alien where id=?";
		Alien responseObject = jdbcTemplate.queryForObject(idQuery, (rs, rowNum) -> {
			Alien alien = new Alien();
			alien.setId(rs.getString("id"));
			alien.setName(rs.getString("name"));
			alien.setTechnology(rs.getString("technology"));
			return alien;
		}, id);
		System.out.println("Alien Response::" + responseObject);
		return responseObject;
	}

	public void updateObject(Alien alien) {
		String udateQuery = "update alien set id=? , name=?,technology=?";
		System.out.println("Successfully updated...." + alien);
		jdbcTemplate.update(udateQuery, alien.getId(), alien.getName(), alien.getTechnology());
	}

	public void deleteId(String id) {
		String deleteQuery = "Delete from alien where id=?";
		jdbcTemplate.update(deleteQuery, id);
		System.out.println("Successfully deleted with id:" + id);
	}
}
