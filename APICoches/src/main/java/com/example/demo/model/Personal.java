package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@NamedQuery(name="Personal.findAll", query="SELECT p FROM Personal p")
public class Personal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String direccion;
    private String localidad;
    private String cp;
    private String tlf;
    private int activo;
    @JoinColumn(name = "perfil")
    @OneToOne(fetch = FetchType.LAZY)
    private Perfiles perfil;

    @OneToMany(mappedBy="creador")
    private List<Incidencias> incidenciasCreadas;

    @OneToMany(mappedBy="responsable")
    private List<Incidencias> incidenciasResponsable;

    @OneToMany(mappedBy="personal")
    private List<Comentarios> comentarios;
   
	public Personal() {
		super();
	}


	public Personal(int id, String dni, String nombre, String apellido1, String apellido2, String direccion,
			String localidad, String cp, String tlf, int activo, Perfiles perfil,
			List<Incidencias> incidenciasCreadas, List<Incidencias> incidenciasResponsable,
			List<Comentarios> comentarios, Departamentos departamento) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.tlf = tlf;
		this.activo = activo;
		this.perfil = perfil;
		this.incidenciasCreadas = incidenciasCreadas;
		this.incidenciasResponsable = incidenciasResponsable;
		this.comentarios = comentarios;
	
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}


	public Perfiles getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfiles perfil) {
		this.perfil = perfil;
	}


	public List<Incidencias> getIncidenciasCreadas() {
		return incidenciasCreadas;
	}


	public void setIncidenciasCreadas(List<Incidencias> incidenciasCreadas) {
		this.incidenciasCreadas = incidenciasCreadas;
	}


	public List<Incidencias> getIncidenciasResponsable() {
		return incidenciasResponsable;
	}


	public void setIncidenciasResponsable(List<Incidencias> incidenciasResponsable) {
		this.incidenciasResponsable = incidenciasResponsable;
	}


	public List<Comentarios> getComentarios() {
		return comentarios;
	}


	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

    
    
	
}
