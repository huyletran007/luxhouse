package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController extends com.luxhouse.main.controller.Controller {
    @GetMapping("/login")
    public String layoutLogin(Model model) {
        dataLayoutMaster.setView("client/security/login");
        dataLayoutMaster.setJsList(Arrays.asList(""));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

    @GetMapping("/register")
    public String layoutRegister_free(Model model) {
        dataLayoutMaster.setView("client/security/sign-up");
        dataLayoutMaster.setJsList(Arrays.asList(""));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
}