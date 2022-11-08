package com.luxhouse.main.controller.rest;

import com.luxhouse.main.domain.Suppliers;
import com.luxhouse.main.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/supplier")
@CrossOrigin
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    /**
     * Api get all Users
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Users
    public List<Suppliers> getAllSupplier() {

        return supplierService.findAll();
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
