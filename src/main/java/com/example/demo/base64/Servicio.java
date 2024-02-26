package com.example.demo.base64;

import com.example.demo.model.Comentarios;
import com.example.demo.model.Incidencias;
import com.example.demo.repository.ComentariosRepository;
import com.example.demo.repository.IncidenciaRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Service
public class Servicio {

    @Autowired
    private final IncidenciaRepository incidenciaRepository;
    @Autowired
    private final ComentariosRepository comentariosRepository;

    @Autowired
    public Servicio(IncidenciaRepository incidenciaRepository, ComentariosRepository comentariosRepository) {
        this.incidenciaRepository = incidenciaRepository;
        this.comentariosRepository = comentariosRepository;
    }

    public void guardarIncidenciaConAdjunto(IncidenciasDTO incidenciasDTO) {
        try {
            String adjuntoBase64 = incidenciasDTO.getCuerpoBase64();
            String extension = incidenciasDTO.getExtension();
            String rutaDestino = "C:\\Users\\Nacho\\OneDrive\\Documentos\\GitHub\\IncidenciasAPI" + UUID.randomUUID().toString() + "." + extension;

            AdjuntoUtil.descodificarAdjunto(adjuntoBase64, extension, rutaDestino);
            incidenciasDTO.setAdjuntoURL(rutaDestino);

            Incidencias incidencias = new Incidencias();
            //Atributos
            incidencias.setTipo(incidenciasDTO.getTipo());
            incidencias.setSubtipo_id(incidenciasDTO.getSubtipoId());
            incidencias.setFecha_creacion(incidenciasDTO.getFechaCreacion());
            incidencias.setFecha_cierre(incidenciasDTO.getFechaCierre());
            incidencias.setDescripcion(incidenciasDTO.getDescripcion());
            incidencias.setEstado(incidenciasDTO.getEstado());
            incidencias.setAdjuntoURL(incidenciasDTO.getAdjuntoURL());
            incidencias.setCreadorId(incidenciasDTO.getCreadorId());
            incidencias.setResponsable_id(incidenciasDTO.getResponsableId());
            incidencias.setEquipoId(incidenciasDTO.getEquipoId());
            incidencias.setTiempo(incidenciasDTO.getTiempo());

            incidenciaRepository.save(incidencias);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarComentarioConAdjunto(ComentariosDTO comentariosDTO) {
        try {
            String adjuntoBase64 = comentariosDTO.getCuerpoBase64();
            String extension = comentariosDTO.getExtension();
            String rutaDestino = "C:\\Users\\Nacho\\OneDrive\\Documentos\\GitHub\\IncidenciasAPI" + UUID.randomUUID().toString() + "." + extension;

            AdjuntoUtil.descodificarAdjunto(adjuntoBase64, extension, rutaDestino);

            comentariosDTO.setAdjuntoURL(rutaDestino);

            Comentarios comentarios = new Comentarios();
            // Atributos
            comentarios.setTexto(comentariosDTO.getTexto());
            comentarios.setFechahora(comentariosDTO.getFechahora());
            comentarios.setIncidencia_num(comentariosDTO.getIncidencia_num());
            comentarios.setPersonal(comentariosDTO.getPersonalId());
            comentarios.setAdjunto_url(comentariosDTO.getAdjuntoURL());

            comentariosRepository.save(comentarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
