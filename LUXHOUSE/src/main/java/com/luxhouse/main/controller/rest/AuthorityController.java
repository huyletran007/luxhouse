package com.luxhouse.main.controller.rest;

import com.luxhouse.main.domain.Authorities;
import com.luxhouse.main.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Auth")
@CrossOrigin
public class AuthorityController {

    @Autowired
    AuthService authService;

    /**
     * Api get all Authorities
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all Authorities
    public List<Authorities> getAllAuthorities() {

        return authService.findAll();
    }

    /**
     * Api get last item in Authorities
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public Authorities getLastAuthorities() {

        List<Authorities> list = authService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in Authorities
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public Authorities getFirstAuthorities() {

        return authService.findAll().get(0);
    }

    /**
     * Api get item by id in Authorities
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public Authorities getShopVoucher(@PathVariable Long id) {
        Optional<Authorities> itemAuthorities = authService.findById(id);
        if (itemAuthorities.isPresent()) {
            return itemAuthorities.get();
        }

        return null;
    }

    /**
     * Api add item to Authorities
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public Authorities addAuthorities(@RequestBody Authorities Authorities) {

        authService.save(Authorities);

        return getLastAuthorities();
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
    public Authorities updateAuthorities(@RequestBody Authorities Authorities) {

        authService.save(Authorities);

        return authService.findById(Authorities.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public Authorities deleteAuthorities(@PathVariable Long id) {

        Authorities item = authService.findById(id).get();

        authService.delete(item);

        return item;
    }
}
