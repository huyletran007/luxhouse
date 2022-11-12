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
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/login.js"));


        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
    
 // Login form with error  
    @RequestMapping("/login-error")  
    public String loginError(Model model) {  
        dataLayoutMaster.setView("client/security/login");
        model.addAttribute("loginError", true);  
        
        objsDataLayout.put("key", "value");
        
        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);
        
        return clientLayout;  
    }  

    @GetMapping("/register")
    public String layoutRegister_free(Model model) {
        dataLayoutMaster.setView("client/security/sign-up");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/sign-up.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
}
