package com.luxhouse.main.controller.admin;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/productManager")
public class ProductAdminController extends com.luxhouse.main.controller.Controller{
    @GetMapping("/table")
    public String layoutTable(Model model) {
        dataLayoutMaster.setView("admin/products/table");
        dataLayoutMaster.setJsList(Arrays.asList("/admin/product/table.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }
    
    @GetMapping("/edit")
    public String layoutEdit(Model model) {
        dataLayoutMaster.setView("admin/products/edit");
        dataLayoutMaster.setJsList(Arrays.asList("/admin/product/edit.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }
}
