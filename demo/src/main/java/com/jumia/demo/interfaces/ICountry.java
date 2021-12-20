package com.jumia.demo.interfaces;

public interface ICountry {
    void setId(Integer id);
    Integer getId();

    void setName(String name);
    String getName();

    void setPhone(String phone);
    String getPhone();

    void setState();
    String getState();

    void setCountryCode(String countryCode);
    String getCountryCode();
}
