package com.luxhouse.main.controller.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.luxhouse.main.domain.PaymentTypes;
import com.luxhouse.main.service.PaymentTypesService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/PaymentType")
@CrossOrigin
public class PaymentTypeController {

    @Autowired
    PaymentTypesService paymentTypesService;

    /**
     * Api get all PaymentTypes
     * 
     * - GET Method: __/get
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get") // api get all PaymentTypes
    public List<PaymentTypes> getAllPaymentTypes() {

        return paymentTypesService.findAll();
    }

    /**
     * Api get last item in PaymentTypes
     * 
     * - GET Method: __/getLast
     * - Return(JSON): list item
     * 
     */
    @GetMapping("/getLast")
    public PaymentTypes getLastPaymentTypes() {

        List<PaymentTypes> list = paymentTypesService.findAll();
        int totalItem = list.size();

        return list.get(totalItem - 1);
    }

    /**
     * Api get first item in PaymentTypes
     * 
     * - GET Method: __/getFirst
     * - Return(JSON): item
     * 
     */
    @GetMapping("/getFirst")
    public PaymentTypes getFirstPaymentTypes() {

        return paymentTypesService.findAll().get(0);
    }

    /**
     * Api get item by id in PaymentTypes
     * 
     * - GET Method: __/get/{id}
     * - Return(JSON): item
     * 
     */
    @GetMapping("/get/{id}")
    public PaymentTypes getShopVoucher(@PathVariable Integer id) {
        Optional<PaymentTypes> itemPaymentTypes = paymentTypesService.findById(id);
        if (itemPaymentTypes.isPresent()) {
            return itemPaymentTypes.get();
        }

        return null;
    }

    /**
     * Api add item to PaymentTypes
     * 
     * - POST Method: __/add
     * - --data-raw: JSON
     * - Return(JSON): item
     * 
     */
    @PostMapping("/add")
    public PaymentTypes addPaymentTypes(@RequestBody PaymentTypes PaymentTypes) {

        paymentTypesService.save(PaymentTypes);

        return getLastPaymentTypes();
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
    public PaymentTypes updatePaymentTypes(@RequestBody PaymentTypes PaymentTypes) {

        paymentTypesService.save(PaymentTypes);

        return paymentTypesService.findById(PaymentTypes.getId()).get();
    }

    /**
     * Api delete item
     * 
     * - DELETE Method: __/delete/{id}
     * - Return(JSON): item
     * 
     */
    @DeleteMapping("/delete/{id}")
    public PaymentTypes deletePaymentTypes(@PathVariable Integer id) {

        PaymentTypes item = paymentTypesService.findById(id).get();

        paymentTypesService.delete(item);

        return item;
    }}
