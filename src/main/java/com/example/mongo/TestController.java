package com.example.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final MongoTemplate mongoTemplate;
    private final AccountRepository accountRepository;

    @Autowired
    public TestController(MongoTemplate mongoTemplate, AccountRepository accountRepository) {
        this.mongoTemplate = mongoTemplate;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/insert-template")
    String insertByTemplate(){
        Account account = new Account();
        account.setEmail("leebokeum@hanmail.net");
        account.setUsername("leebokeum");
        mongoTemplate.insert(account);
        return "success";
    }


    @GetMapping("/insert-repository")
    String insertByRepository(){
        Account account = new Account();
        account.setEmail("leebokeum@hanmail.net");
        account.setUsername("leebokeum");
        accountRepository.insert(account);
        return "success";
    }
}
