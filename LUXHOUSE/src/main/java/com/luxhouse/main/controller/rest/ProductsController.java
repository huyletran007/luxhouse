package com.luxhouse.main.controller.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxhouse.main.domain.Products;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.service.ProductsService;

@RestController
@RequestMapping("/Product")
@CrossOrigin
public class ProductsController {
    @Autowired
    ProductsService productsService;
    
    /**
     * Api get all Products
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Products
    public List<Products> getAllProducts() {

        return productsService.findAll();
    }

    /**
     * Api get last item in Products
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public Products getLastProducts() {

        List<Products> list = productsService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in Products
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public Products getFirstProducts() {

        return productsService.findAll().get(0);
    }

    /**
     * Api get item by id in Products
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public Products getShopVoucher(@PathVariable Long id) {
        Optional<Products> itemProducts = productsService.findById(id);
        if (itemProducts.isPresent()) {
            return itemProducts.get();
        }

        return null;
    }

    /**
     * Api add item to Products
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public Products addProducts(@RequestBody Products Products) {

        productsService.save(Products);

        return getLastProducts();
    }

    /**
     * Api update item
     * 
     * - PUT Method: __/update
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PutMapping("/update")
    public Products updateProducts(@RequestBody Products Products) {

        productsService.save(Products);

        return productsService.findById(Products.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public Products deleteProducts(@PathVariable Long id) {

        Products item = productsService.findById(id).get();

        productsService.delete(item);

        return item;
    }
}
