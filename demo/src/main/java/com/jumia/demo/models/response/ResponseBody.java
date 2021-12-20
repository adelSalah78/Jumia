package com.jumia.demo.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseBody {
    List<Country> country;
    Integer pageSize;
    Integer resultSize;
    Integer pageNo;
}
