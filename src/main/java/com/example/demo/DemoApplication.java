package com.example.demo;

import com.example.demo.model.Cosmetic;
import com.example.demo.repository.CosmeticRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private CosmeticRepo cosmeticRepo;
	private static Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("EXECUTING : command line runner");
		Cosmetic cosmetic = Cosmetic.builder()
				.id("xxxx")
				.name("XOXO Lipstick")
				.amount(1000000)
				.build();
		cosmeticRepo.save(cosmetic);
		System.out.println(cosmetic);
	}
}
