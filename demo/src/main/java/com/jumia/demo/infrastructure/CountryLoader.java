package com.jumia.demo.infrastructure;

import com.jumia.demo.entities.Country;
import com.jumia.demo.factories.CountryFactory;
import com.jumia.demo.interfaces.ICountry;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

@Configuration
@Data
public class CountryLoader {

    @Autowired
    CountryDB countryDB;

    private Map<String,List<ICountry>> countriesCache = new LinkedHashMap<>(); // country code as key
    private Map<String,List<ICountry>> countriesStatesCache = new LinkedHashMap<>(); // country state as key

    Integer pageSize = 5;

    @Bean
    public void loadCountries(){
        List<Country> countries = countryDB.getAllCountries();
        for(Country country : countries){
            ICountry iCountry = CountryFactory.createCountry(country);
            iCountry.setCountryCode(country.getPhone());
            iCountry.setPhone(country.getPhone());
            iCountry.setState();

            if(countriesCache.get(iCountry.getCountryCode()) == null){
                List<ICountry> iCountries = new ArrayList<>();
                iCountries.add(iCountry);
                countriesCache.put(iCountry.getCountryCode(), iCountries);
            }
            else{
                countriesCache.get(iCountry.getCountryCode()).add(iCountry);
            }

            if(countriesStatesCache.get(iCountry.getState()) == null){
                List<ICountry> iCountries = new ArrayList<>();
                iCountries.add(iCountry);
                countriesStatesCache.put(iCountry.getState(), iCountries);
            }
            else{
                countriesStatesCache.get(iCountry.getState()).add(iCountry);
            }
        }
        System.out.println("Loaded!");
    }
}
