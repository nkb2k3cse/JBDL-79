package com.example.L11_Spring_JDBC_demo;

import com.example.L11_Spring_JDBC_demo.entity.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Configuration
public class ProjectConfig {

    @Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/demo_system");
		dataSource.setUsername("user1");
		dataSource.setPassword("Pass@123");
		return dataSource;
	}

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
}
