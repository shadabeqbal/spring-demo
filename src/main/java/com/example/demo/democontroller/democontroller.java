package com.example.demo.democontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democontroller {

    @RequestMapping(value = "/hello")
    public String sayHi(){
        return "Hi";
    }
}
