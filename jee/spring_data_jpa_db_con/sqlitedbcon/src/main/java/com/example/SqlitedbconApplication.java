package com.example;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SqlitedbconApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlitedbconApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
	        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.driverClassName("org.sqlite.JDBC");
	        dataSourceBuilder.url("jdbc:sqlite:your.db");
	        return dataSourceBuilder.build();   
	}
}
