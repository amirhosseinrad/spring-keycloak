package com.example.springkeycloak.contlollers;

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
       return customerRepo.findAll();
    }

    @PostMapping("/newCustomer")
    public String saveCustomer(@RequestBody Customer customer){
        customerRepo.save(customer);
      return "customer created successfully";
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable ("id") Long id){
        customerRepo.deleteById(id);
        return "customer deleted successfully";
    }

    @GetMapping("/customres/{id}")
    public Customer findByById(Long id){
        return customerRepo.findById(id).get();
    }
}
