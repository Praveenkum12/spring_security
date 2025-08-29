package com.jimmy.springsec.controller;

import com.jimmy.springsec.entity.Customer;
import com.jimmy.springsec.modal.SuccessResponse;
import com.jimmy.springsec.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody Customer customer) {

        Customer customer1 = customerService.registerCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED.value()).body(
                SuccessResponse.normalResponse(customer1, HttpStatus.CREATED.value())
        );
    }

}
