package com.luxhouse.main.controller.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luxhouse.main.domain.OrderDetails;
import com.luxhouse.main.service.OrderDetailsService;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OrderDetail")
@CrossOrigin
public class OrderDetailController {

    @Autowired
    OrderDetailsService orderDetailsService;

    /**
     * Api get all OrderDetails
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all OrderDetails
    public List<OrderDetails> getAllOrderDetails() {

        return orderDetailsService.findAll();
    }

    /**
     * Api get last item in OrderDetails
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public OrderDetails getLastOrderDetails() {

        List<OrderDetails> list = orderDetailsService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in OrderDetails
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public OrderDetails getFirstOrderDetails() {

        return orderDetailsService.findAll().get(0);
    }

    /**
     * Api get item by id in OrderDetails
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public OrderDetails getShopVoucher(@PathVariable Long id) {
        Optional<OrderDetails> itemOrderDetails = orderDetailsService.findById(id);
        if (itemOrderDetails.isPresent()) {
            return itemOrderDetails.get();
        }

        return null;
    }

    /**
     * Api add item to OrderDetails
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public OrderDetails addOrderDetails(@RequestBody OrderDetails OrderDetails) {

        orderDetailsService.save(OrderDetails);

        return getLastOrderDetails();
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
    public OrderDetails updateOrderDetails(@RequestBody OrderDetails OrderDetails) {

        orderDetailsService.save(OrderDetails);

        return orderDetailsService.findById(OrderDetails.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public OrderDetails deleteOrderDetails(@PathVariable Long id) {

        OrderDetails item = orderDetailsService.findById(id).get();

        orderDetailsService.delete(item);

        return item;
    }}
