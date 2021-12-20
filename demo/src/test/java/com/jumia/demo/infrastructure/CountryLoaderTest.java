package com.jumia.demo.infrastructure;

import com.jumia.demo.entities.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CountryLoaderTest {

    @Test
    public void testGroupingByCountryCodeCameroon() {
        Country country1 = new Country(1,"test","(237) 2222");
        Country country2 = new Country(1,"test","(237) 3333");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);

        CountryDB countryDB = mock(CountryDB.class);
        CountryLoader countryLoader = new CountryLoader();
        when(countryDB.getAllCountries()).thenReturn(countries);
        countryLoader.setCountryDB(countryDB);
        countryLoader.loadCountries();


        Assertions.assertTrue(countryLoader.getCountriesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesCache().get("+237").size() == 2);

        Assertions.assertTrue(countryLoader.getCountriesStatesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesStatesCache().get("InValid").size() == 2);
    }

    @Test
    public void testGroupingByCountryCodeEthiopia() {
        Country country1 = new Country(1,"test","(251) 2222");
        Country country2 = new Country(1,"test","(251) 3333");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);

        CountryDB countryDB = mock(CountryDB.class);
        CountryLoader countryLoader = new CountryLoader();
        when(countryDB.getAllCountries()).thenReturn(countries);
        countryLoader.setCountryDB(countryDB);
        countryLoader.loadCountries();


        Assertions.assertTrue(countryLoader.getCountriesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesCache().get("+251").size() == 2);

        Assertions.assertTrue(countryLoader.getCountriesStatesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesStatesCache().get("InValid").size() == 2);
    }

    @Test
    public void testGroupingByCountryCodeMorocco() {
        Country country1 = new Country(1,"test","(212) 2222");
        Country country2 = new Country(1,"test","(212) 3333");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);

        CountryDB countryDB = mock(CountryDB.class);
        CountryLoader countryLoader = new CountryLoader();
        when(countryDB.getAllCountries()).thenReturn(countries);
        countryLoader.setCountryDB(countryDB);
        countryLoader.loadCountries();


        Assertions.assertTrue(countryLoader.getCountriesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesCache().get("+212").size() == 2);

        Assertions.assertTrue(countryLoader.getCountriesStatesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesStatesCache().get("InValid").size() == 2);
    }

    @Test
    public void testGroupingByCountryCodeMozambique() {
        Country country1 = new Country(1,"test","(258) 2222");
        Country country2 = new Country(1,"test","(258) 3333");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);

        CountryDB countryDB = mock(CountryDB.class);
        CountryLoader countryLoader = new CountryLoader();
        when(countryDB.getAllCountries()).thenReturn(countries);
        countryLoader.setCountryDB(countryDB);
        countryLoader.loadCountries();


        Assertions.assertTrue(countryLoader.getCountriesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesCache().get("+258").size() == 2);

        Assertions.assertTrue(countryLoader.getCountriesStatesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesStatesCache().get("InValid").size() == 2);
    }

    @Test
    public void testGroupingByCountryCodeUganda() {
        Country country1 = new Country(1,"test","(256) 2222");
        Country country2 = new Country(1,"test","(256) 3333");

        List<Country> countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);

        CountryDB countryDB = mock(CountryDB.class);
        CountryLoader countryLoader = new CountryLoader();
        when(countryDB.getAllCountries()).thenReturn(countries);
        countryLoader.setCountryDB(countryDB);
        countryLoader.loadCountries();


        Assertions.assertTrue(countryLoader.getCountriesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesCache().get("+256").size() == 2);

        Assertions.assertTrue(countryLoader.getCountriesStatesCache().size() == 1);
        Assertions.assertTrue(countryLoader.getCountriesStatesCache().get("InValid").size() == 2);
    }
}
