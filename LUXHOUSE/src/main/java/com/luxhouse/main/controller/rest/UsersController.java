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

import com.luxhouse.main.domain.Users;
import com.luxhouse.main.service.UserService;

@RestController
@RequestMapping("/Users")
@CrossOrigin
public class UsersController {

    @Autowired
    UserService usersService;

    /**
     * Api get all Users
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Users
    public List<Users> getAllUsers() {

        return usersService.findAll();
    }

    /**
     * Api get last item in Users
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public Users getLastUsers() {

        List<Users> list = usersService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in Users
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public Users getFirstUsers() {

        return usersService.findAll().get(0);
    }

    /**
     * Api get item by id in Users
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
//    @GetMapping("/get/{id}")
//    public Users getShopVoucher(@PathVariable Long id) {
//        Optional<Users> itemUsers = usersService.findById(id);
//        if (itemUsers.isPresent()) {
//            return itemUsers.get();
//        }
//
//        return null;
//    }

    /**
     * Api add item to Users
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public Users addUsers(@RequestBody Users Users) {

        usersService.save(Users);

        return getLastUsers();
    }

    /**
     * Api update item
     * 
     * - PUT Method: __/update
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
//    @PutMapping("/update")
//    public Users updateUsers(@RequestBody Users Users) {
//
//        usersService.save(Users);
//
//        return usersService.findById(Users.getId()).get();
//    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
//    @DeleteMapping("/delete/{id}")
//    public Users deleteUsers(@PathVariable Long id) {
//
//        Users item = usersService.findById(id).get();
//
//        usersService.delete(item);
//
//        return item;
//    }
}
