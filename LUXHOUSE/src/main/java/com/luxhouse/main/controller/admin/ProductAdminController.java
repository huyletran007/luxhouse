package com.luxhouse.main.controller.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luxhouse.main.domain.CategoryProducts;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.service.ProductsService;

import lombok.Data;

@Controller
@RequestMapping("/admin/productManager")
public class ProductAdminController extends com.luxhouse.main.controller.Controller {
    @Autowired
    HttpServletResponse response;
    
    @Autowired
    ProductsService productsService;

    @GetMapping("/table")
    public String layoutTable(Model model) {
        dataLayoutMaster.setView("admin/products/table");
        dataLayoutMaster.setJsList(Arrays.asList("/admin/product/table.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }

    @GetMapping("/add")
    public String layoutEdit(Model model) {
        Products product = new Products();
        product.setCategoryProducts(new CategoryProducts());
        product.setId(-1L);
        objsDataLayout.put("product", product);
        dataLayoutMaster.setView("admin/products/edit");
        dataLayoutMaster.setJsList(Arrays.asList("/admin/product/edit.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }

    @GetMapping("edit/product/{idProduct}")
    public String edit(Model model, @PathVariable Long idProduct) throws IOException {

        Optional<Products> product = productsService.findById(idProduct);

        if (!product.isPresent()) {

            objsDataLayout.put("product", new Products());
            response.sendRedirect("/admin/productManager/table");
        } else {

            objsDataLayout.put("product", product.get());
        }

        dataLayoutMaster.setView("admin/products/edit");

        dataLayoutMaster.setJsList(Arrays.asList("/admin/product/edit.js"));

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return adminLayout;
    }
}
