package com.example.demo.model;

import java.io.Serializable;
import java.sql.Time;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


	@Entity
	@Table(name="incidencias")
	@NamedQuery(name="Incidenciassin.findAll", query="SELECT i FROM Incidencias i")
	public class IncidenciasSin implements Serializable {
	    private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private Long num;

	    private String tipo;
	    private String descripcion;
	    private String estado;
	   @Column(name="equipo_id")
	    private Long equipoId;
	    

	   @Column(name="creador_id")
	    private Long creadorId;

	    @Column(name="responsable_id")
	    private Long responsable_id;
	    @Column(name="subtipo_id")
	    private Long subtipo_id;

	    @Column(name="tiempo")
	    private Time tiempo;
	    
		public IncidenciasSin() {
			super();
		}

		

		public IncidenciasSin(Long num, String tipo, String descripcion, String estado, Long equipoId, Long creadorId,
				Long responsable_id, Long subtipo_id, Time tiempoDe) {
			super();
			this.num = num;
			this.tipo = tipo;
			this.descripcion = descripcion;
			this.estado = estado;
			this.equipoId = equipoId;
			this.creadorId = creadorId;
			this.responsable_id = responsable_id;
			this.subtipo_id = subtipo_id;
			this.tiempo = tiempoDe;
		}



		public Long getNum() {
			return num;
		}

		public void setNum(Long num) {
			this.num = num;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public Long getEquipoId() {
			return equipoId;
		}

		public void setEquipoId(Long equipoId) {
			this.equipoId = equipoId;
		}

		public Long getCreador_id() {
			return creadorId;
		}

		public void setCreador_id(Long creador_id) {
			this.creadorId = creador_id;
		}

		public Long getResponsable_id() {
			return responsable_id;
		}

		public void setResponsable_id(Long responsable_id) {
			this.responsable_id = responsable_id;
		}

		public Long getSubtipo_id() {
			return subtipo_id;
		}

		public void setSubtipo_id(Long subtipo_id) {
			this.subtipo_id = subtipo_id;
		}

		public Long getCreadorId() {
			return creadorId;
		}

		public void setCreadorId(Long creadorId) {
			this.creadorId = creadorId;
		}

		public Time getTiempo() {
			return tiempo;
		}

		public void setTiempo(Time tiempoDe) {
			this.tiempo = tiempoDe;
		}
		
		
}