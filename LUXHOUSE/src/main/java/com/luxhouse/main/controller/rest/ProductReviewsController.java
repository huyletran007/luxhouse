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

import com.luxhouse.main.domain.ProductReviews;
import com.luxhouse.main.domain.ProductReviews;
import com.luxhouse.main.service.ProductReviewsService;

@RestController
@RequestMapping("/ProductReviews")
@CrossOrigin
public class ProductReviewsController {
    @Autowired
    ProductReviewsService productReviewsService;
    
    /**
     * Api get all ProductReviews
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all ProductReviews
    public List<ProductReviews> getAllProductReviews() {

        return productReviewsService.findAll();
    }

    /**
     * Api get last item in ProductReviews
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public ProductReviews getLastProductReviews() {

        List<ProductReviews> list = productReviewsService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in ProductReviews
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public ProductReviews getFirstProductReviews() {

        return productReviewsService.findAll().get(0);
    }

    /**
     * Api get item by id in ProductReviews
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public ProductReviews getShopVoucher(@PathVariable Long id) {
        Optional<ProductReviews> itemProductReviews = productReviewsService.findById(id);
        if (itemProductReviews.isPresent()) {
            return itemProductReviews.get();
        }

        return null;
    }

    /**
     * Api add item to ProductReviews
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public ProductReviews addProductReviews(@RequestBody ProductReviews ProductReviews) {

        productReviewsService.save(ProductReviews);

        return getLastProductReviews();
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
    public ProductReviews updateProductReviews(@RequestBody ProductReviews ProductReviews) {

        productReviewsService.save(ProductReviews);

        return productReviewsService.findById(ProductReviews.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public ProductReviews deleteProductReviews(@PathVariable Long id) {

        ProductReviews item = productReviewsService.findById(id).get();

        productReviewsService.delete(item);

        return item;
    }
}
