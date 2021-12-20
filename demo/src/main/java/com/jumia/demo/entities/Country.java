package com.jumia.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Country {
    Integer id;
    String name;
    String phone;
}
