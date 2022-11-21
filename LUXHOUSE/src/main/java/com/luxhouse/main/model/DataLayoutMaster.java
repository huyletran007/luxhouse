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
    private String mainCssAd = "/admin/css/main.min.css";
    private String mainCssAd2 = "/admin/css/atlantis.css";
    private String demoCss = "/admin/css/demo.css";
    private String webfont = "/admin/js/plugin/webfont/webfont.min.js";
    private String fonts = "/admin/css/fonts.min.css";
    private List<String> cssList;
    private List<String> jsList;
    private Map<String, Object> objs;
}
