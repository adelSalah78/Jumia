package com.jumia.demo.models.services;

import com.jumia.demo.interfaces.ICountry;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Countries {
    List<ICountry> countries;
    Integer totalCount;
}
