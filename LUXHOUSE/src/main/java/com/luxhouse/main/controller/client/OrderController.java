package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OrderController extends com.luxhouse.main.controller.Controller {
    @GetMapping("/CartDetail")
    public String layout(Model model) {
        dataLayoutMaster.setView("client/cart/cart-detail");
        dataLayoutMaster.setJsList(Arrays.asList("/js/cart/cart-detail.js","/js/detail-cart.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
    
}
