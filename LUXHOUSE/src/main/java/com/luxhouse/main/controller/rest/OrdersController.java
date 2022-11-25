package com.luxhouse.main.controller.rest;

import com.luxhouse.main.domain.Orders;
import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.domain.Roles;
import com.luxhouse.main.domain.Users;
import com.luxhouse.main.model.OrderDTO;
import com.luxhouse.main.model.SignUpDTO;
import com.luxhouse.main.repository.OrdersRespository;
import com.luxhouse.main.service.OrdersService;
import com.luxhouse.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/Orders")
@CrossOrigin
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrdersRespository ordersRespository;

    /**
     * Api get all Orders
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Orders
    public List<Orders> getAllOrders() {

        return ordersService.findAll();
    }

    /**
     * Api get last item in Orders
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public Orders getLastOrders() {

        List<Orders> list = ordersService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in Orders
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public Orders getFirstOrders() {

        return ordersService.findAll().get(0);
    }

    /**
     * Api get item by id in Orders
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public Orders getShopVoucher(@PathVariable Long id) {
        Optional<Orders> itemOrders = ordersService.findById(id);
        if (itemOrders.isPresent()) {
            return itemOrders.get();
        }

        return null;
    }
    
    @GetMapping("/get/user/{id}")
    public List<Orders> getOrderUser(@PathVariable Long id) {
        List<Orders> itemOrders = ordersService.selectsByUserId(id);
        if (itemOrders.isEmpty()) {
            return itemOrders;
        }

        return Arrays.asList(new Orders());
    }

    /**
     * Api add item to Orders
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public Orders addOrders(@RequestBody Orders Orders) {

        ordersService.save(Orders);

        return getLastOrders();
    }

    @PostMapping("/addOrder")
    public Orders addOrderss(@RequestBody Orders Orders) {

        ordersService.save(Orders);
        
        return getLastOrders();
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
    public Orders updateOrders(@RequestBody Orders Orders) {

        ordersService.save(Orders);

        return ordersService.findById(Orders.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public Orders deleteOrders(@PathVariable Long id) {

        Orders item = ordersService.findById(id).get();

        ordersService.delete(item);

        return item;
    }
}
