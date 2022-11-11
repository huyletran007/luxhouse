package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productList")
public class ProductListController extends com.luxhouse.main.controller.Controller {
    @GetMapping("/all")
    public String layoutProductList(Model model) {

        dataLayoutMaster.setView("client/product/product");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

}
