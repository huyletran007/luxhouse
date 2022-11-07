package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productList")
public class ProductListController extends com.luxhouse.main.controller.Controller{
    @GetMapping("")
    public String layout(Model model) {
        
        dataLayoutMaster.setView("client/product/product");
        
//        dataLayoutMaster.setMainCss("css/style.min.css");
        
        objsDataLayout.put("key", "value");
        
        dataLayoutMaster.setObjs(objsDataLayout);
        
        model.addAttribute(__CONTENT__, dataLayoutMaster);
        
        return clientLayout;
    }

}
