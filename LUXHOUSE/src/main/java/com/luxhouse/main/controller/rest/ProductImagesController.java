package com.luxhouse.main.controller.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.service.ProductImagesService;

@RestController
@RequestMapping("/ProductImages")
@CrossOrigin
public class ProductImagesController {
    @Autowired
    ProductImagesService productImagesService;

    /**
     * Api get all ProductImages
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all ProductImages
    public List<ProductImages> getAllProductImages() {

        return productImagesService.findAll();
    }

    /**
     * Api get last item in ProductImages
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public ProductImages getLastProductImages() {

        List<ProductImages> list = productImagesService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in ProductImages
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public ProductImages getFirstProductImages() {

        return productImagesService.findAll().get(0);
    }

    /**
     * Api get item by id in ProductImages
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public ProductImages getShopVoucher(@PathVariable Long id) {
        Optional<ProductImages> itemProductImages = productImagesService.findById(id);
        if (itemProductImages.isPresent()) {
            return itemProductImages.get();
        }

        return null;
    }

    @GetMapping("/get/productid/{id}")
    public List<ProductImages> getByProductId(@PathVariable Long id) {
        List<ProductImages> itemProductImages = productImagesService.selectsByProductId(id);
        if (!itemProductImages.isEmpty()) {
            return itemProductImages;
        }

        return Arrays.asList(new ProductImages());
    }

    /**
     * Api add item to ProductImages
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public ProductImages addProductImages(@RequestBody ProductImages ProductImages) {

        productImagesService.save(ProductImages);

        return getLastProductImages();
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
    public ProductImages updateProductImages(@RequestBody ProductImages ProductImages) {

        productImagesService.save(ProductImages);

        return productImagesService.findById(ProductImages.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public ProductImages deleteProductImages(@PathVariable Long id) {

        ProductImages item = productImagesService.findById(id).get();

        productImagesService.delete(item);

        return item;
    }
    
    @DeleteMapping("/delete/product/{id}")
    public List<ProductImages> deleteProductImagesId(@PathVariable Long id) {

        List<ProductImages> item = productImagesService.selectsByProductId(id);

        productImagesService.deleteAll(item);

        return item;
    }

    /**
     * Api upload, download and save in file system
     * 
     * 
     * 
     * 
     */

}
