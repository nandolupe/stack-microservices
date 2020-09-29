package com.example.hateoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	//@Autowired
    //private CustomerService customerService;
 
    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable String customerId) {
        return new Customer();
    }
}
