package com.example.demo.sevices;

import com.example.demo.model.Cosmetic;
import com.example.demo.repository.CosmeticRepo;
import com.example.demo.request.CosmeticRequest;
import org.jvnet.hk2.annotations.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CosmeticService {

    private CosmeticRepo cosmeticRepo;

    @Autowired
    public CosmeticService(CosmeticRepo cosmeticRepo){
        this.cosmeticRepo = cosmeticRepo;
    }

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
