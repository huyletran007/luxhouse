package com.luxhouse.main.controller.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.repository.ProductsRepository;
import com.luxhouse.main.service.ProductImagesService;
import com.luxhouse.main.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductListController extends com.luxhouse.main.controller.Controller {
    @Autowired
    ProductsService productsService;
    @Autowired
    ProductsRepository productsRepository;
    @Autowired
    ProductImagesService productImagesService;
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
    
    @GetMapping("/search")
    public String layoutProductSearch(Model model) {

        dataLayoutMaster.setView("client/product/product-search");
        dataLayoutMaster.setMainCss("/css/search.css");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product-search.js"));

        objsDataLayout.put("key", "value");

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

    @GetMapping("/{id}")
    public String layoutProductDetail(Model model, @PathVariable Long id) throws IOException {

        Optional<Products> product = productsService.findById(id);
        List<ProductImages> productImage = productImagesService.selectsByProductId(id);
        if (!product.isPresent()) {

            objsDataLayout.put("products", new Products());
            objsDataLayout.put("productImages", new ProductImages());
            response.sendRedirect("/products");
        } else {
            objsDataLayout.put("products", product.get());
            objsDataLayout.put("productImages", productImage);
        }

        dataLayoutMaster.setView("client/product/product-detail");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/productdetail.js"));

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
    
    @GetMapping("/CateP/{Code}")
    public String CateP(Model model, @PathVariable String Code) throws IOException {

        List<Products> product = productsRepository.selectsByCategoryProductCode(Code);
        if (!product.isEmpty()) {
            objsDataLayout.put("products", new Products());
//            response.sendRedirect("/CateP/{Code}");
        } else {
            objsDataLayout.put("products", product);
        }
        
        dataLayoutMaster.setView("client/product/product-cate");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product-cate.js"));

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }
    
    @GetMapping("/CateM/{Code}")
    public String CateM(Model model, @PathVariable String Code) throws IOException {

        List<Products> product = productsRepository.selectsByCategoryMCode(Code);
        if (!product.isEmpty()) {
            objsDataLayout.put("products", new Products());
        } else {
            objsDataLayout.put("products", product);
        }
        
        dataLayoutMaster.setView("client/product/product-cate");
        dataLayoutMaster.setJsList(Arrays.asList("/js/product/product-cate.js"));

        dataLayoutMaster.setObjs(objsDataLayout);

        model.addAttribute(__CONTENT__, dataLayoutMaster);

        return clientLayout;
    }

}
