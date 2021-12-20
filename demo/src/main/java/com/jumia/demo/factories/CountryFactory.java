package com.jumia.demo.factories;

import com.jumia.demo.entities.Country;
import com.jumia.demo.exceptions.BusinessException;
import com.jumia.demo.interfaces.ICountry;
import com.jumia.demo.models.countries.*;

public class CountryFactory {

    static final String cameroonCode = "(237)";
    static final String ethiopiaCode = "(251)";
    static final String moroccoCode = "(212)";
    static final String mozambiqueCode = "(258)";
    static final String ugandaCode = "(256)";

    public static ICountry createCountry(Country country) {
        if(country.getPhone().startsWith(cameroonCode))
            return new Cameroon(country.getId(), country.getName());
        else if(country.getPhone().startsWith(ethiopiaCode))
            return new Ethiopia(country.getId(), country.getName());
        else if(country.getPhone().startsWith(moroccoCode))
            return new Morocco(country.getId(), country.getName());
        else if(country.getPhone().startsWith(mozambiqueCode))
            return new Mozambique(country.getId(), country.getName());
        else if(country.getPhone().startsWith(ugandaCode))
            return new Uganda(country.getId(), country.getName());
        throw new BusinessException("Invalid country code");
    }
}
