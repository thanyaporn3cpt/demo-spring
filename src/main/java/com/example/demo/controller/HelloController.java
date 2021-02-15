package com.example.demo.controller;

import com.example.demo.model.Cosmetic;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/cosmetic", method= RequestMethod.POST)
    public List<Cosmetic> getAllCosmetics() {
        return null;
    }

}
