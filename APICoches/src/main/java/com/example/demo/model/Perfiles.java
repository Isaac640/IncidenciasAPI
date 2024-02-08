package com.example.demo.model;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;


import jakarta.persistence.Entity;

import jakarta.persistence.Id;
;

@Entity
@NamedQuery(name="Perfiles.findAll", query="SELECT p FROM Perfiles p")
public class Perfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int personal_id;
    
    
    private String dominio;
    private String educantabria;
    private String password;
    private String perfil;
    
    private Personal persona;

	public Perfiles() {
		super();
	}

	

	public Perfiles(String dominio, String educantabria, String password, String perfil, Personal persona) {
		super();
		this.dominio = dominio;
		this.educantabria = educantabria;
		this.password = password;
		this.perfil = perfil;
		this.persona = persona;
	}



	public Personal getPersonal() {
		return persona;
	}



	public void setPersonal(Personal personal) {
		this.persona = personal;
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
