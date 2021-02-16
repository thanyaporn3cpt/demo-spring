package com.example.demo.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CosmeticRequest {
    private String id;
    private String name;
    private int amount;
    private String promotion;
}
