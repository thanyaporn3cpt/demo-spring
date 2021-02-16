package com.example.demo.controller;

import com.example.demo.model.Cosmetic;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
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
    public List<Cosmetic> postCmt(@RequestBody Cosmetic tempCosmetic){
        tempCosmetic.setId(tempCosmetic.getId());
        tempCosmetic.setName(tempCosmetic.getName());
        tempCosmetic.setAmount(tempCosmetic.getAmount());
        cosmetics.add(tempCosmetic);
        return cosmetics;
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
