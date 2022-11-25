package com.luxhouse.main.controller.rest;

import com.luxhouse.main.domain.Categories;
import com.luxhouse.main.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Categories")
@CrossOrigin
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    /**
     * Api get all Categories
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Categories
    public List<Categories> getAllCategories() {

        return categoryService.findAll();
    }

    @GetMapping("/get/{start}/{total}") // api get all Products
    public List<Categories> getPageCategories(@PathVariable int start, @PathVariable int total) {
        
        List<Categories> list = categoryService.findAll();
        Collections.reverse(list);
        int toStart = start*total;
        // 12
        // start-total
        // 0-5 : toStart = 0*5, toIndex = toStart+total = 5 
        // 1-5 : toStart = 1*5, toIndex = toStart+total = 10
        // 2-5 : toStart = 2*5, toIndex = toStart+total = 15 => 12
        int toIndex = total + toStart;
        toIndex = toIndex > list.size() ? list.size() : toIndex;
        
        return list.subList(toStart, toIndex);
    }
    
    /**
     * Api get last item in Categories
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public Categories getLastCategories() {

        List<Categories> list = categoryService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in Categories
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public Categories getFirstCategories() {

        return categoryService.findAll().get(0);
    }

    /**
     * Api get item by id in Categories
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public Categories getShopVoucher(@PathVariable Integer id) {
        Optional<Categories> itemCategories = categoryService.findById(id);
        if (itemCategories.isPresent()) {
            return itemCategories.get();
        }

        return null;
    }

    /**
     * Api add item to Categories
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public Categories addCategories(@RequestBody Categories Categories) {

        categoryService.save(Categories);

        return getLastCategories();
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
    public Categories updateCategories(@RequestBody Categories Categories) {

        categoryService.save(Categories);

        return categoryService.findById(Categories.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public Categories deleteCategories(@PathVariable Integer id) {

        Categories item = categoryService.findById(id).get();

        categoryService.delete(item);

        return item;
    }
}
