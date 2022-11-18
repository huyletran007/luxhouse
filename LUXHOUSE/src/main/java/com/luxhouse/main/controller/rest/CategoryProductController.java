package com.luxhouse.main.controller.rest;


import com.luxhouse.main.domain.CategoryProducts;
import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.service.CategoryProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/CategoryProduct")
@CrossOrigin
public class CategoryProductController {

    @Autowired
    CategoryProductService categoryProductService;
    /**
     * Api get all CategoryProducts
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all CategoryProducts
    public List<CategoryProducts> getAllCategoryProducts() {

        return categoryProductService.findAll();
    }

    /**
     * Api get last item in CategoryProducts
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public CategoryProducts getLastCategoryProducts() {

        List<CategoryProducts> list = categoryProductService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in CategoryProducts
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public CategoryProducts getFirstCategoryProducts() {

        return categoryProductService.findAll().get(0);
    }

    /**
     * Api get item by id in CategoryProducts
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public CategoryProducts getShopVoucher(@PathVariable Integer id) {
        Optional<CategoryProducts> itemCategoryProducts = categoryProductService.findById(id);
        if (itemCategoryProducts.isPresent()) {
            return itemCategoryProducts.get();
        }

        return null;
    }
    
    @GetMapping("/get/cate")
    public List<CategoryProducts> getCate() {
        List<CategoryProducts> itemCate = categoryProductService.selectByCategoryId();
        if(!itemCate.isEmpty()) {
            return itemCate;
        } 

        return Arrays.asList(new CategoryProducts());
    }

    /**
     * Api add item to CategoryProducts
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public CategoryProducts addCategoryProducts(@RequestBody CategoryProducts CategoryProducts) {

        categoryProductService.save(CategoryProducts);

        return getLastCategoryProducts();
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
    public CategoryProducts updateCategoryProducts(@RequestBody CategoryProducts CategoryProducts) {

        categoryProductService.save(CategoryProducts);

        return categoryProductService.findById(CategoryProducts.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public CategoryProducts deleteCategoryProducts(@PathVariable Integer id) {

        CategoryProducts item = categoryProductService.findById(id).get();

        categoryProductService.delete(item);

        return item;
    }
}
