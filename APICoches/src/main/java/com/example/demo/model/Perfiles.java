package com.example.demo.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.lang.Arrays;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Perfiles {
	
	@Id
    private Long personal_Id;
    private String dominio;
    private String educantabria;
    private String password;
    @Enumerated(EnumType.STRING)
    private TipoPerfil perfil;
    //private Map<String, Object> attributes = new HashMap<>();
   
    
	public Perfiles() {
		super();
	}

	

	public Perfiles(Long personal_Id, String dominio, String educantabria, String password, TipoPerfil perfil) {
		super();
		this.personal_Id = personal_Id;
		this.dominio = dominio;
		this.educantabria = educantabria;
		this.password = password;
		this.perfil = perfil;
	}



	public Long getPersonalId() {
		return personal_Id;
	}

	public void setPersonalId(Long personalId) {
		this.personal_Id = personalId;
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

	public TipoPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(TipoPerfil perfil) {
		this.perfil = perfil;
	}




	
}
