package com.jumia.demo.controllers;

import com.jumia.demo.interfaces.ICountry;
import com.jumia.demo.models.response.Country;
import com.jumia.demo.models.response.ResponseBody;
import com.jumia.demo.models.services.Countries;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApi {
    ResponseBody formatResponse(int pageSize, Countries countries,int pageNo) {
        List<Country> responses = new ArrayList<>();
        for(ICountry iCountry : countries.getCountries()) {
            Country country = new Country();
            country.setState(iCountry.getState());
            country.setCountryCode(iCountry.getCountryCode());
            country.setPhone(iCountry.getPhone());
            country.setId(iCountry.getId());
            country.setName(iCountry.getName());

            responses.add(country);
        }
        return new ResponseBody(responses,pageSize,countries.getTotalCount(),pageNo);
    }
}
