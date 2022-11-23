package com.luxhouse.main.controller.client;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxhouse.main.service.SessionService;


@Controller
@RequestMapping("/account")
public class AccountController extends com.luxhouse.main.controller.Controller{
    
    @Autowired
    SessionService sessionService;
    
    @GetMapping("/profile")
    public String layout(Model model) {
        dataLayoutMaster.setView("client/account/profile");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/profile.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayoutForProfile;
    }
    
    
    @GetMapping("/order")
    public String userOrder(Model model) {
        dataLayoutMaster.setView("client/account/order");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/order.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayoutForProfile;
    }
    
    @GetMapping("/doimatkhau")
    public String userDoiMatKhau(Model model) {
        dataLayoutMaster.setView("client/account/doimatkhau");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/profile.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayoutForProfile;
    }
    
    @GetMapping("/xemdonhang")
    public String userXemDonHang(Model model) {
        dataLayoutMaster.setView("client/account/kiemtradonhang");
        dataLayoutMaster.setJsList(Arrays.asList("/js/security/order.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayoutForProfile;
    }
    
    @GetMapping("/logout")
    public String logout() {
        
        sessionService.remove("remoteUser");
        return "redirect:/";
    }
}
