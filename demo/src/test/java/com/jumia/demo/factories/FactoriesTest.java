package com.jumia.demo.factories;

import com.jumia.demo.entities.Country;
import com.jumia.demo.models.countries.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class FactoriesTest {

    @Test
    public void testFactoriesProductsTypes() {

        Country country = new Country(1,"test","(237) 222222");
        Assertions.assertTrue(CountryFactory.createCountry(country) instanceof Cameroon);

        country = new Country(1,"test","(251) 222222");
        Assertions.assertTrue(CountryFactory.createCountry(country) instanceof Ethiopia);

        country = new Country(1,"test","(212) 222222");
        Assertions.assertTrue(CountryFactory.createCountry(country) instanceof Morocco);

        country = new Country(1,"test","(258) 222222");
        Assertions.assertTrue(CountryFactory.createCountry(country) instanceof Mozambique);

        country = new Country(1,"test","(256) 222222");
        Assertions.assertTrue(CountryFactory.createCountry(country) instanceof Uganda);
    }
}
