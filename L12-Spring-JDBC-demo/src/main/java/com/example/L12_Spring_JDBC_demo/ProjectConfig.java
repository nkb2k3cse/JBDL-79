package com.example.L12_Spring_JDBC_demo;

import com.example.L12_Spring_JDBC_demo.entity.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class ProjectConfig {

	@Value("${db.url}")
	private String dbUrl;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

//    @Bean
//	public DataSource mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl(dbUrl);
//		dataSource.setUsername(username);
//		dataSource.setPassword(password);
//		return dataSource;
//	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public RowMapper<Product> productRowMapper(){
		RowMapper<Product> productRowMapper = new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getLong(1));
				product.setName(rs.getString(2));
				product.setCost(rs.getDouble(3));
				return product;
			}
		};
		return productRowMapper;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(JdbcTemplate jdbcTemplate){
		return new NamedParameterJdbcTemplate(jdbcTemplate);
	}
}
