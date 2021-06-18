package com.example.springkeycloak.contlollers;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import com.example.springkeycloak.models.Customer;
import com.example.springkeycloak.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/getall")
    public List<Customer> findAll(){
       return (List<Customer>) customerRepo.findAll();
    }

    @PostMapping("/newCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
       return customerRepo.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable (value="id") Long customerID){
        //Customer customer = customerRepo.findById(customerID).get();
        customerRepo.deleteById(customerID);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/customers/{id}")
    public Customer findByById(@PathVariable(value = "id") Long customerID){
        return customerRepo.findById(customerID).get();
    }
}
