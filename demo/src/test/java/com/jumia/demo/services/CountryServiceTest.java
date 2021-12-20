package com.jumia.demo.services;

import com.jumia.demo.infrastructure.CountryLoader;
import com.jumia.demo.interfaces.ICountry;
import com.jumia.demo.models.countries.Cameroon;
import com.jumia.demo.models.countries.Morocco;
import com.jumia.demo.models.countries.Mozambique;
import com.jumia.demo.models.services.Countries;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

public class CountryServiceTest {

    @Test
    public void nullCodeAndFilledState(){
        CountryService countryService = new CountryService();

        CountryLoader countryLoaderMock = mock(CountryLoader.class);
        when(countryLoaderMock.getCountriesStatesCache()).thenReturn(new HashMap<>());
        countryService.setCountryLoader(countryLoaderMock);
        countryService.getCountries("InValid",null,5);
        verify(countryLoaderMock, atLeast(1)).getCountriesStatesCache();
    }

    @Test
    public void filledCodeAndNullState(){
        CountryService countryService = new CountryService();

        CountryLoader countryLoaderMock = mock(CountryLoader.class);
        when(countryLoaderMock.getCountriesCache()).thenReturn(new HashMap<>());
        countryService.setCountryLoader(countryLoaderMock);
        countryService.getCountries(null,"444",5);
        verify(countryLoaderMock, atLeast(1)).getCountriesCache();
    }

    @Test
    public void filledCodeAndFilledState(){
        CountryService countryService = new CountryService();

        CountryLoader countryLoaderMock = mock(CountryLoader.class);
        when(countryLoaderMock.getCountriesCache()).thenReturn(new HashMap<>());
        when(countryLoaderMock.getCountriesStatesCache()).thenReturn(new HashMap<>());
        countryService.setCountryLoader(countryLoaderMock);
        countryService.getCountries("Valid","444",5);
        verify(countryLoaderMock, atLeast(1)).getCountriesCache();
        verify(countryLoaderMock, atLeast(1)).getCountriesStatesCache();
    }

    @Test
    public void nullCodeAndNullState(){
        CountryService countryService = new CountryService();

        CountryLoader countryLoaderMock = mock(CountryLoader.class);

        Map<String, List<ICountry>> countriesCache = new HashMap<>();
        countriesCache.put("444", Arrays.asList(new Cameroon(1,"Test"),new Mozambique(2,"Test2")));

        Map<String, List<ICountry>> countriesStatesCache = new HashMap<>();
        countriesStatesCache.put("Valid", Arrays.asList(new Cameroon(1,"Test"),new Mozambique(2,"Test2")));

        when(countryLoaderMock.getCountriesCache()).thenReturn(countriesCache);
        when(countryLoaderMock.getCountriesStatesCache()).thenReturn(countriesStatesCache);
        when(countryLoaderMock.getPageSize()).thenReturn(5);

        countryService.setCountryLoader(countryLoaderMock);
        Countries countries = countryService.getCountries(null,null,1);

        verify(countryLoaderMock, atLeast(1)).getCountriesCache();
        verify(countryLoaderMock, atLeast(1)).getCountriesStatesCache();

        Assertions.assertTrue(countries.getCountries().size() == 4);
        Assertions.assertTrue(countries.getTotalCount() == 4);
    }

    @Test
    public void nullCodeAndNullStatePagination(){
        CountryService countryService = new CountryService();

        CountryLoader countryLoaderMock = mock(CountryLoader.class);

        Map<String, List<ICountry>> countriesCache = new HashMap<>();
        countriesCache.put("444", Arrays.asList(new Cameroon(1,"Test"),new Mozambique(2,"Test2"),new Morocco(3,"Test3")));

        Map<String, List<ICountry>> countriesStatesCache = new HashMap<>();
        countriesStatesCache.put("Valid", Arrays.asList(new Cameroon(1,"Test"),new Mozambique(2,"Test2"),new Morocco(3,"Test3")));

        when(countryLoaderMock.getCountriesCache()).thenReturn(countriesCache);
        when(countryLoaderMock.getCountriesStatesCache()).thenReturn(countriesStatesCache);
        when(countryLoaderMock.getPageSize()).thenReturn(5);

        countryService.setCountryLoader(countryLoaderMock);
        Countries countries = countryService.getCountries(null,null,1);

        Assertions.assertTrue(countries.getCountries().size() == countryLoaderMock.getPageSize());
        Assertions.assertTrue(countries.getTotalCount() == 6);
    }
}
