package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthPfController extends com.luxhouse.main.controller.Controller{
    @GetMapping("/login")
    public String layout(Model model) {
        dataLayoutMaster.setView("client/security/login");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/login.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
    
    @GetMapping("/logout")
    public String logout() {
        
//        sessionService.remove("userLogin");
        return "redirect:/";
    }
}
