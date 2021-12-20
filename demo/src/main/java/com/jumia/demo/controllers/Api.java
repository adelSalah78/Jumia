package com.jumia.demo.controllers;

import com.jumia.demo.interfaces.ICountry;
import com.jumia.demo.models.response.ResponseBody;
import com.jumia.demo.models.services.Countries;
import com.jumia.demo.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
public class Api extends AbstractApi{

    @Autowired
    CountryService countryService;

    @GetMapping("/state/{state}/{pageNo}")
    ResponseBody getCountriesByState(@PathVariable String state, @PathVariable Integer pageNo) {
        Countries countries = countryService.getCountries(state,null,pageNo);
        return formatResponse(countryService.getCountryLoader().getPageSize(),countries,pageNo);
    }

    @GetMapping("/code/{code}/{pageNo}")
    ResponseBody getCountriesByCode(@PathVariable String code, @PathVariable Integer pageNo) {
        Countries countries = countryService.getCountries(null,code,pageNo);
        return formatResponse(countryService.getCountryLoader().getPageSize(),countries,pageNo);
    }

    @GetMapping("/state-code/{state}/{code}/{pageNo}")
    ResponseBody getCountriesByStateAndCode(@PathVariable String state, @PathVariable String code, @PathVariable Integer pageNo) {
        Countries countries = countryService.getCountries(state,code,pageNo);
        return formatResponse(countryService.getCountryLoader().getPageSize(),countries,pageNo);
    }

    @GetMapping("/state-code/all/{pageNo}")
    ResponseBody getAllCountries(@PathVariable Integer pageNo) {
        Countries countries = countryService.getCountries(null,null,pageNo);
        return formatResponse(countryService.getCountryLoader().getPageSize(),countries,pageNo);
    }
}
