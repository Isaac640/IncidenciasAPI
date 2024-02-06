package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perfiles {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personalId;
    private String dominio;
    private String educantabria;
    private String password;
    private String perfil;
    
	public Perfiles() {
		super();
	}

	public Perfiles(Long personalId, String dominio, String educantabria, String password, String perfil) {
		super();
		this.personalId = personalId;
		this.dominio = dominio;
		this.educantabria = educantabria;
		this.password = password;
		this.perfil = perfil;
	}

	public Long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Long personalId) {
		this.personalId = personalId;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getEducantabria() {
		return educantabria;
	}

	public void setEducantabria(String educantabria) {
		this.educantabria = educantabria;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
    
    
	
}
