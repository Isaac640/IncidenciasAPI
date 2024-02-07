package com.example.demo.model;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name="Perfiles.findAll", query="SELECT p FROM Perfiles p")
public class Perfiles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String dominio;
    private String educantabria;
    private String password;
    private String perfil;
    @OneToOne
    @JoinColumn(name="personal_id")
    private Personal personal;
	public Perfiles() {
		super();
	}

	

	public Perfiles(String dominio, String educantabria, String password, String perfil, Personal personal) {
		super();
		this.dominio = dominio;
		this.educantabria = educantabria;
		this.password = password;
		this.perfil = perfil;
		this.personal = personal;
	}



	public Personal getPersonal() {
		return personal;
	}



	public void setPersonal(Personal personal) {
		this.personal = personal;
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
