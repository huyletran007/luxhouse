package com.luxhouse.main.controller.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxhouse.main.domain.Products;
import com.luxhouse.main.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductListController extends com.luxhouse.main.controller.Controller {
    @Autowired
    ProductsService productsService;
    @Autowired
    HttpServletResponse response;

    @GetMapping("")
    public String layoutProductList(Model model) {

        dataLayoutMaster.setView("client/product/product");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

    @GetMapping("/{id}")
    public String layoutProductDetail(Model model, @PathVariable Long id) throws IOException {

        Optional<Products> product = productsService.findById(id);

        if (!product.isPresent()) {

            objsDataLayout.put("products", new Products());
            response.sendRedirect("/products");
        } else {

            objsDataLayout.put("products", product.get());
        }

        dataLayoutMaster.setView("client/product/product-detail");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product.js"));

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

}
