package com.luxhouse.main.controller.rest;

import com.luxhouse.main.domain.Roles;
import com.luxhouse.main.domain.Users;
import com.luxhouse.main.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/role")
@CrossOrigin
public class RoleController {

    @Autowired
    RoleService roleService;

    /**
     * Api get all Users
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Users
    public List<Roles> getAllRole() {

        return roleService.findAll();
    }

    /**
     * Api get last item in Users
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */

    /**
     * Api get first item in Users
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */

    /**
     * Api get item by id in Users
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    /**
     * Api add item to Users
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */

    /**
     * Api update item
     * 
     * - PUT Method: __/update
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
}
