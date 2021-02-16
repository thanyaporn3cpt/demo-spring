package com.example.demo.services;

import com.example.demo.model.Cosmetic;
import com.example.demo.repository.CosmeticRepo;
import com.example.demo.request.CosmeticRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosmeticService {

    @Autowired
    private CosmeticRepo cosmeticRepo;

    public Cosmetic newCosmetic(CosmeticRequest cosmeticRequest){
        Cosmetic cosmetic = Cosmetic.builder()
                .id(cosmeticRequest.getId())
                .name(cosmeticRequest.getName())
                .amount(cosmeticRequest.getAmount())
                .build();
        cosmeticRepo.save(cosmetic);
        return cosmetic;
    }
}
