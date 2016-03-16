package com.suddenlyjune.financialinvestment.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("userDao")
public class UserDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<User> getUsers() {

		return jdbc.query("select * from users", new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();

				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setAddress(rs.getString("address"));
				user.setCity(rs.getString("city"));
				user.setUsername(rs.getString("username"));
				user.setEmail(rs.getString("email"));
				user.setPassword("password");
				user.setEnabled(rs.getBoolean("enabled"));

				return user;
			}

		});
	}
	
	
	public boolean create(User user) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		return jdbc.update("insert into users (name, address, city, username, password, email, enabled) values (:name, :address, :city, :username, :password, :email, :enabled)", params) == 1;
	}
	
	@Transactional
	public int[] create(List<User> users) {
		
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(users.toArray());
		
		return jdbc.batchUpdate("insert into users (name, address, city, username, password, email, enabled) values (:name, :address, :city, :username, :password, :email, :enabled)", params);
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		
		return jdbc.update("delete from offers where id=:id", params) == 1;
	}

	public User getUser(String username) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", username);

		return jdbc.queryForObject("select * from Users where username =:username", params,
				new RowMapper<User>() {

					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();

						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setAddress(rs.getString("address"));
						user.setCity(rs.getString("city"));
						user.setUsername(rs.getString("username"));
						user.setEmail(rs.getString("email"));
						user.setPassword("password");
						user.setEnabled(rs.getBoolean("enabled"));

						return user;
					}

				});
	}
	
}
