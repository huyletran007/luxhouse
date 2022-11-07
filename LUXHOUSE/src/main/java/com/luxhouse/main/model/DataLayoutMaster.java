package com.luxhouse.main.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLayoutMaster implements Serializable{
    private String title;
    private String heading_text;
    private String view;
    private String mainCss = "/css/main.min.css";
    private List<String> cssList;
    private List<String> jsList;
    private Map<String, Object> objs;
}
