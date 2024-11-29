package com.bankManager.bankManager.Service;

import com.bankManager.bankManager.DTO.Converter.CustomerDTOConverter;
import com.bankManager.bankManager.DTO.CustomerDTO;
import com.bankManager.bankManager.DTO.Request.RequestBodyForCreateCustomer;
import com.bankManager.bankManager.Exception.CustomerNotFoundException;
import com.bankManager.bankManager.Model.Customer;
import com.bankManager.bankManager.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDTOConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDTOConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }


    protected Customer findCustomerById(Long id){
        return customerRepository.findById(id).
                orElseThrow(()->new CustomerNotFoundException("Customer Not Found"+id));
    }

    public CustomerDTO getCustomerById(Long id){
        return converter.convertToCustomerDto(findCustomerById(id));
    }

    public Customer addCustomer(RequestBodyForCreateCustomer request){
        Customer customer=new Customer();
        customer.setName(request.getName());
        customer.setSurName(request.getSurName());
        customer.setEmailAddress(request.getEmailAddress());
        customer.setPhoneNumber(request.getPhoneNumber());
        return customerRepository.save(customer);
    }
}
