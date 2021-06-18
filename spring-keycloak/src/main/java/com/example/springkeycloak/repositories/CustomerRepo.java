package com.example.springkeycloak.repositories;

import com.example.springkeycloak.models.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepo extends CrudRepository<Customer, Long> {


}
