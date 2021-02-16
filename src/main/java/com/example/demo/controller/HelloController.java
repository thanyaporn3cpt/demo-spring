package com.example.demo.controller;

import com.example.demo.model.Cosmetic;
import com.example.demo.request.CosmeticRequest;
import com.example.demo.sevices.CosmeticService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {


    private CosmeticService cosmeticService;
    @Autowired
    public HelloController(CosmeticService cosmeticService){
        this.cosmeticService=cosmeticService;
    }
    List<Cosmetic> cosmetics = new ArrayList<>(Arrays.asList(
            new Cosmetic("LIP001", "XOXO Lipstick", 1),
            new Cosmetic("BRO001", "NYX Brush On Palette", 1),
            new Cosmetic("EY001", "MAYU Eye liner", 10)
    ));
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/cosmetic", method= RequestMethod.GET)
    public List<Cosmetic> getAllCosmetics() {
        return cosmetics;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Cosmetic postCmt(@RequestBody CosmeticRequest cosmeticRequest){
        Cosmetic newCosmetic = cosmeticService.newCosmetic(cosmeticRequest);
        return newCosmetic;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public void putCmt(@PathVariable String id,@RequestBody Cosmetic tempCosmetic) {
        for (int i = 0; i < cosmetics.size(); i++) {
            Cosmetic index = cosmetics.get(i);
            if (index.getId().equals(id)) {
                index.setName(tempCosmetic.getName());
                index.setAmount(tempCosmetic.getAmount());
                break;
            }
        }
    }

    @RequestMapping(value = "/delete/{id}", method= RequestMethod.DELETE)
    public void deleteCmt(@PathVariable String id) {
        for (int i = 0; i < cosmetics.size(); i++) {
            if (cosmetics.get(i).getId().equals(id)) {
                cosmetics.remove(i);
                break;
            }
        }
    }
}
