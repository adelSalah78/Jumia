package com.jumia.demo.models.response;

import lombok.Data;

@Data
public class Country {
    Integer id;
    String phone;
    String name;
    String state;
    String countryCode;
}
