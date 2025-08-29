package com.jimmy.springsec.service;

import com.jimmy.springsec.Exceptions.CustomFailedException;
import com.jimmy.springsec.entity.Customer;
import com.jimmy.springsec.entity.Role;
import com.jimmy.springsec.repository.CustomerRepository;
import com.jimmy.springsec.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public Customer registerCustomer(Customer customer) {
        Optional<Role> roleOpt = roleRepository.findById(1);
        if(roleOpt.isEmpty()) {
            throw new CustomFailedException("Something went wrong. There is no id as 1 in table Role");
        }
        customer.setRole(roleOpt.get());
        try {
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            Customer savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getCustomerId() > 0) {
                return savedCustomer;
            }
        } catch(DataIntegrityViolationException dave) {
            throw new CustomFailedException("Email already exist");
        }

        throw new CustomFailedException("Customer is not created");
    }
}
