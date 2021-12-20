package com.jumia.demo.models.countries;

import com.jumia.demo.interfaces.ICountry;
import lombok.Data;

import java.util.regex.Pattern;

@Data
public class Mozambique implements ICountry {
    Integer id;
    String phone;
    String name;
    String state;
    String countryCode;

    static final String regex=".[28]\\d{7,8}$ ";

    public Mozambique(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setPhone(String wholePhone) {
        this.phone = wholePhone.split(" ")[1];
    }

    public void setState() {
        this.state =
                Pattern.matches(Mozambique.regex,this.getPhone()) == true ? "Valid" : "InValid";
    }

    public void setCountryCode(String wholePhone) {
        this.countryCode = "+"+wholePhone.substring(1,4);
    }
}
