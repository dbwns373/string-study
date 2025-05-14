package com.pear.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		System.out.println("실행됨!");




		//연습
		//		Age age = new Age();
//
//		age.agePlus();
//
//		System.out.println(age.getAge());
//
//		age.ageSetting(12);
//
//		System.out.println(age.getAge());
//
//		age.ageSetting(101);
//		age.ageSetting(-1);
//		age.ageSetting(99);
//		age.agePlus();
//		age.agePlus();
	}

}
