package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "incidencias")
public class Incidencias {
	
	@Id
	private Long num;
	
	@Enumerated(EnumType.STRING)
    private TipoIncidencias tipo;
	@Column(name = "subtipo_id", insertable = false, updatable = false)
    private Long subtipoId;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_cierre;
    private String descripcion;
    private Estado estado;
    private String adjunto_url;
   
    @Column(name = "creador_id", insertable = false, updatable = false)
    private Long creadorId;
    @Column(name = "responsable_id", insertable = false, updatable = false)
    private Long responsableId;
    @Column(name = "equipo_id")
    private Long equipoId;
    
    @OneToMany
    @JoinColumn(name="incidencia_id")
    private List<Comentarios> comentarios;

    @ManyToOne
    @JoinColumn(name="creador_id")
    private Personal creador;

    @ManyToOne
    @JoinColumn(name="responsable_id")
    private Personal responsable;

    @ManyToOne
    @JoinColumn(name="subtipo_id")
    private IncidenciasSubtipos subtipo;
    
	public Incidencias() {
		super();
	}

	public Incidencias(Long num, TipoIncidencias tipo, Long subtipoId, LocalDateTime fecha_creacion,
			LocalDateTime fecha_cierre, String descripcion, Estado estado, String adjuntURL, Long creadorId,
			Long responsableId, Long equipoId) {
		super();
		this.num = num;
		this.tipo = tipo;
		this.subtipoId = subtipoId;
		this.fecha_creacion = fecha_creacion;
		this.fecha_cierre = fecha_cierre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.adjunto_url = adjuntURL;
		this.creadorId = creadorId;
		this.responsableId = responsableId;
		this.equipoId = equipoId;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public TipoIncidencias getTipo() {
		return tipo;
	}

	public void setTipo(TipoIncidencias tipo) {
		this.tipo = tipo;
	}

	public Long getSubtipoId() {
		return subtipoId;
	}

	public void setSubtipoId(Long subtipoId) {
		this.subtipoId = subtipoId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Long getCreadorId() {
		return creadorId;
	}

	public void setCreadorId(Long creadorId) {
		this.creadorId = creadorId;
	}

	public Long getResponsableId() {
		return responsableId;
	}

	public void setResponsableId(Long responsableId) {
		this.responsableId = responsableId;
	}

	public Long getEquipoId() {
		return equipoId;
	}

	public void setEquipoId(Long equipoId) {
		this.equipoId = equipoId;
	}

	public LocalDateTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalDateTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public LocalDateTime getFecha_cierre() {
		return fecha_cierre;
	}

	public void setFecha_cierre(LocalDateTime fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

	public String getAdjuntURL() {
		return adjunto_url;
	}

	public void setAdjuntURL(String adjuntURL) {
		this.adjunto_url = adjuntURL;
	}
    
    
	
}
