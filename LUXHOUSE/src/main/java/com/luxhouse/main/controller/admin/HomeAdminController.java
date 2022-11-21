package com.luxhouse.main.controller.admin;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class HomeAdminController extends com.luxhouse.main.controller.Controller{
    @GetMapping("")
    public String layout(Model model) {
        dataLayoutMaster.setView("admin/home/home");
        dataLayoutMaster.setJsList(Arrays.asList("/admin/home/home.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }
}
