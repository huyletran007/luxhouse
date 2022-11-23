package com.luxhouse.main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PatchDTO {
    private String op;
    
    private String key;
   
    private String value;
}
