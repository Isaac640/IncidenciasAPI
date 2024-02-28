package com.example.demo.controller;


import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import com.example.demo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class PersonalControllerTests {

	private AulasController p;
	
	@BeforeAll
	void inicializar() {
		p=new AulasController();
	}
	@Test 
	void fromMarca() {
	List<Aulas> a=	p.findByCodigo("DAM1");
		for (Aulas aula : a) {
			System.out.println(aula.toString());
		}
	}

}
