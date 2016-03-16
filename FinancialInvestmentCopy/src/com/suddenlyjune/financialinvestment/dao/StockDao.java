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

@Component("stockDao")
public class StockDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Stock> getStocks() {

		return jdbc.query("select * from stocks", new RowMapper<Stock>() {

			public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
				Stock stock = new Stock();
				stock.setUserid(rs.getInt("userId"));
				stock.setName(rs.getString("name"));
				stock.setPrice(rs.getDouble("price"));
				stock.setQuantity(rs.getInt("quantity"));
				stock.setTotalPrice(rs.getDouble("totalPrice"));

				return stock;
			}

		});
	}

	public boolean insertStock(Stock stock) {

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(stock);

		return jdbc.update(
				"insert into stocks (userId, name, price, quantity, totalprice) values (:userId, :name, :price, :quantity, :totalprice)",
				params) == 1;
	}

	@Transactional
	public int[] create(List<Stock> stock) {

		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(stock.toArray());

		return jdbc.batchUpdate(
				"insert into stocks (userId, name, price, quantity, totalprice) values (:userId, :name, :price, :quantity, :totalprice)",
				params);
	}

	public boolean delete(String name) {
		MapSqlParameterSource params = new MapSqlParameterSource("name", name);

		return jdbc.update("delete from stocks where name=:name", params) == 1;
	}

	public Stock getStock(String name) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", name);

		return jdbc.queryForObject("select * from Stock where name =:name", params, new RowMapper<Stock>() {

			public Stock mapRow(ResultSet rs, int rowNum) throws SQLException {
				Stock stock = new Stock();

				stock.setUserid(rs.getInt("userid"));
				stock.setName(rs.getString("name"));
				stock.setPrice(rs.getDouble("price"));
				stock.setQuantity(rs.getInt("quantity"));
				stock.setTotalPrice(rs.getDouble("totalprice"));

				return stock;
			}

		});
	}

}
