package com.ITFactory.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ITFactory.accounts.model.Accounts;
import com.ITFactory.accounts.model.Customer;
import com.ITFactory.accounts.repository.AccountsRepository;


@RestController
public class AccountsController {

    @Autowired
    private AccountsRepository accountsRepository;


    @GetMapping("/accounts")
    public Iterable<Accounts> getAll() {
        return accountsRepository.findAll();
    }

    @PostMapping("/myAccount")
    public Accounts getAccountDetails(@RequestBody Customer customer) {

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }

    }

}
