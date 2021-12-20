package com.jumia.demo.infrastructure;

import com.jumia.demo.entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Configuration
public class CountryDB {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Country> getAllCountries() {
        return jdbcTemplate.query("SELECT * FROM customer",
                (resultSet, rowNum) -> new Country(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("phone")));
    }
}
