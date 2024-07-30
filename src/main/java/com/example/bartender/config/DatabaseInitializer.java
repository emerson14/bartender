package com.example.bartender.config;



import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DatabaseInitializer {

	private final JdbcTemplate jdbcTemplate;

	public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

 @PostConstruct
    public void init() {
        String sql = """
            -- Eliminar la tabla 'arrays' si ya existe
            DROP TABLE IF EXISTS arrays;

            -- Crear la tabla 'arrays'
            CREATE TABLE arrays (
              id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
              input_array VARCHAR(20) NOT NULL
            );

            -- Insertar datos en la tabla 'arrays'
            INSERT INTO arrays (input_array) VALUES
            ('2,4,5,6,7,8'),
            ('3,7,9,5,4,2'),
            ('5,7,9,11,13'),
            ('6,4,2,12,15'),
            ('7,10,15,11,9');
        """;
        jdbcTemplate.execute(sql);
    }
}
