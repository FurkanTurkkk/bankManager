package com.bankManager.bankManager.Controller;

import com.bankManager.bankManager.DTO.Converter.CustomerDTOConverter;
import com.bankManager.bankManager.DTO.CustomerDTO;
import com.bankManager.bankManager.DTO.Request.RequestBodyForCreateCustomer;
import com.bankManager.bankManager.Model.Customer;
import com.bankManager.bankManager.Service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDTOConverter converter;

    public CustomerController(CustomerService customerService, CustomerDTOConverter converter, CustomerDTOConverter converter1) {
        this.customerService = customerService;
        this.converter = converter1;
    }

    @PostMapping ResponseEntity<CustomerDTO> addCustomer(@RequestBody RequestBodyForCreateCustomer request){
        Customer customer = customerService.addCustomer(request);

        return ResponseEntity.ok(converter.convertToCustomerDto(customer));
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable("customerId") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

}
