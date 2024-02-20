package com.exaple.demo.security.controller;

import java.util.List;
import java.util.Arrays;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.response.Product;


@RestController
public class ProductsController {
	@GetMapping(path = "/products")
	public List<Product> listProducts() {
		return Arrays.asList(new Product("001", "Resma", 100D));
	}
}
