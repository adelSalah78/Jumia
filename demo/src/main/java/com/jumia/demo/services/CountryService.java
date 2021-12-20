package com.jumia.demo.services;

import com.jumia.demo.infrastructure.CountryLoader;
import com.jumia.demo.interfaces.ICountry;
import com.jumia.demo.models.services.Countries;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Data
public class CountryService {
    @Autowired
    CountryLoader countryLoader;

    public Countries getCountries(String state, String code, Integer pageNo) {
        List<ICountry> result = new ArrayList<>();
        List<ICountry> tempCountries = null;
        if(state!=null && code == null) {
            tempCountries = countryLoader.getCountriesStatesCache().get(state);
        }
        else if(state == null && code!=null){
            tempCountries = countryLoader.getCountriesCache().get(code);
        }
        else if(state != null && code!=null){
            tempCountries = new ArrayList<>();
            if(countryLoader.getCountriesCache().get(code)!=null)
                tempCountries.addAll(countryLoader.getCountriesCache().get(code));
            if(countryLoader.getCountriesStatesCache().get(state)!=null)
                tempCountries.addAll(countryLoader.getCountriesStatesCache().get(state));
        }
        else{
            tempCountries = new ArrayList<>();
            for(Map.Entry<String,List<ICountry>> entry : countryLoader.getCountriesCache().entrySet()) {
                if(entry.getValue()!=null)
                    tempCountries.addAll(entry.getValue());
            }
            for(Map.Entry<String,List<ICountry>> entry : countryLoader.getCountriesStatesCache().entrySet()) {
                if(entry.getValue()!=null)
                    tempCountries.addAll(entry.getValue());
            }
        }
        int start = (pageNo-1)* countryLoader.getPageSize();
        int totalCount = 0;
        if(tempCountries!=null) {
            totalCount = tempCountries.size();
            for (int i = start; i < start + countryLoader.getPageSize() && i < tempCountries.size(); i++) {
                if (tempCountries != null && tempCountries.get(i) != null)
                    result.add(tempCountries.get(i));
            }
        }
        return new Countries(result,totalCount);
    }
}
