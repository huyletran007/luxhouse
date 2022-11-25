package com.luxhouse.main.controller.rest;

import java.util.Arrays;
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
import com.luxhouse.main.domain.CartUsers;
import com.luxhouse.main.domain.ProductImages;
import com.luxhouse.main.service.CartUserService;

@RestController
@RequestMapping("/cartuser")
@CrossOrigin
public class CartUserController {
    @Autowired
    CartUserService cartUserService;

    /**
     * Api get all CartUsers
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all CartUsers
    public List<CartUsers> getAllCartUsers() {

        return cartUserService.findAll();
    }

    /**
     * Api get last item in CartUsers
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public CartUsers getLastCartUsers() {

        List<CartUsers> list = cartUserService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in CartUsers
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public CartUsers getFirstCartUsers() {

        return cartUserService.findAll().get(0);
    }

    /**
     * Api get item by id in CartUsers
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public CartUsers getShopVoucher(@PathVariable Long id) {
        Optional<CartUsers> itemCartUsers = cartUserService.findById(id);
        if (itemCartUsers.isPresent()) {
            return itemCartUsers.get();
        }

        return null;
    }

    @GetMapping("/get/users/{id}")
    public List<CartUsers> getUserId(@PathVariable Long id) {
        List<CartUsers> itemUserId = cartUserService.findByUserId(id);
        if (!itemUserId.isEmpty()) {
            return itemUserId;
        }

        return Arrays.asList(new CartUsers());
    }

    /**
     * Api add item to CartUsers
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public CartUsers addCartUsers(@RequestBody CartUsers CartUsers) {

        cartUserService.save(CartUsers);

        return getLastCartUsers();
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
    public CartUsers updateCartUsers(@RequestBody CartUsers CartUsers) {

        cartUserService.save(CartUsers);

        return cartUserService.findById(CartUsers.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public CartUsers deleteCartUsers(@PathVariable Long id) {

        CartUsers item = cartUserService.findById(id).get();

        cartUserService.delete(item);

        return item;
    }

    @DeleteMapping("/delete/user/{id}")
    public List<CartUsers> deleteCartUsersName(@PathVariable Long id) {

        List<CartUsers> itemUserId = cartUserService.findByUserId(id);

        for (CartUsers item : itemUserId) {

            cartUserService.delete(item);

        }

        return itemUserId;

//        CartUsers item = cartUserService.findById(id).get();
//
//        cartUserService.delete(item);
//
//        return item;
    }
}
