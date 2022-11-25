package com.luxhouse.main.controller.rest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luxhouse.main.domain.Categories;
import com.luxhouse.main.domain.Products;
import com.luxhouse.main.domain.Users;
import com.luxhouse.main.exception.NotFoundEx;
import com.luxhouse.main.exception.NotYetImplementedEx;
import com.luxhouse.main.model.PatchDTO;
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
    
    @GetMapping("/get/{start}/{total}") // api get all Products
    public List<Users> getPageUsers(@PathVariable int start, @PathVariable int total) {
        
        List<Users> list = usersService.findAll();
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
     * Api get item by id in Products
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public Users getIdUser(@PathVariable Long id) {
        Optional<Users> idUser = usersService.findById(id);
        if (idUser.isPresent()) {
            return idUser.get();
        }

        return null;
    }
    
    /**
     * Api get item by id in Products
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/users/{id}")
    public Users getEmailUser(@PathVariable Long id) {
        Optional<Users> idUserId = usersService.findById(id);
        if (idUserId.isPresent()) {
            return idUserId.get();
        }

        return null;
    }
    
    @GetMapping("/get/{id}/fullname")
    public String getOneFullName(@PathVariable Long id) {
        Users idUserId = usersService.getOne(id);
        
        return idUserId.getFullname();
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
    @PutMapping("/update")
    public Users updateUsers(@RequestBody Users Users) {

        usersService.save(Users);

        return usersService.findById(Users.getId()).get();
    }
    
    
    @PatchMapping("/update/{id}")
    public ResponseEntity<Boolean> updatePartially(@PathVariable(name = "id") Long id,
        @RequestBody PatchDTO dto) throws NotYetImplementedEx, NotFoundEx {
      // skipping validations for brevity
      if (dto.getOp().equalsIgnoreCase("update")) {
        boolean result = usersService.partialUpdate(id, dto.getKey(), dto.getValue());
        return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
      } else {
        throw new NotYetImplementedEx("NOT_YET_IMPLEMENTED");
      }
    }


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
