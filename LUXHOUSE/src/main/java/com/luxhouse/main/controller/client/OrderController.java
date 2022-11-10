package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class OrderController extends com.luxhouse.main.controller.Controller {
    @GetMapping("/OrderDetail")
    public String layout(Model model) {
        dataLayoutMaster.setView("client/order/order-detail");
        dataLayoutMaster.setJsList(Arrays.asList(""));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
}
