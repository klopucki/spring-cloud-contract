package com.contracts.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

    @RequestMapping(method = GET)
    public String sayHello() {
        return "HELLO";
    }

    @RequestMapping(method = POST)
    public String sayHelloToJohn(@RequestParam("name") String name) {
        return "HELLO " + name;
    }
}
