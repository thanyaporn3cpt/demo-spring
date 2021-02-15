package com.example.demo.repository;

import com.example.demo.model.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CosmeticRepo extends JpaRepository<Cosmetic, String> {
}
