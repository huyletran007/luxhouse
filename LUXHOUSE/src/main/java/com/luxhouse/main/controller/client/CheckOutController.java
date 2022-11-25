package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxhouse.main.service.OrderDetailsService;
import com.luxhouse.main.service.OrdersService;

@Controller
@RequestMapping("/check-out")
public class CheckOutController extends com.luxhouse.main.controller.Controller {
    @Autowired
    OrdersService ordersService;
    
    @Autowired
    OrderDetailsService orderDetailsService;

    @GetMapping("")
    public String layout(Model model) {
    
        dataLayoutMaster.setView("client/checkout/check-out");
        dataLayoutMaster.setMainCss("/css/checkout.css");
        dataLayoutMaster.setJsList(Arrays.asList("/js/checkout/checkout.js"));
                
        dataLayoutMaster.setObjs(objsDataLayout);       
        model.addAttribute(__CONTENT__, dataLayoutMaster);
        
        return clientLayout;
    }
}
