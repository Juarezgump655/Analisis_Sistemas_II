package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.controllers.ProyectoControllers;
import com.umg.analisis_sistemas.dtos.ProyectosTareas;
import com.umg.analisis_sistemas.model.Proyecto;
import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.repositorios.ProyectoRepository;
import com.umg.analisis_sistemas.servicios.ProyectoSvc;
import com.umg.analisis_sistemas.servicios.TareaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Service
public class ProyectoSvcImpl implements ProyectoSvc {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Autowired
    TareaSvc tareaSvc;

    private static Logger logger
            = Logger.getLogger(
            ProyectoSvcImpl.class.getName());


    @Override
    @Transactional
    public void crearProyecto(ProyectosTareas proyectosTareas) {
      Proyecto proyecto ;
      logger.info("Creando proyecto: " + proyectosTareas.getProyecto().getNombre());
        proyecto =  this.proyectoRepository.save(proyectosTareas.getProyecto());
        if (proyectosTareas.getTareasList() != null) {
            logger.info("Creando tareas para el proyecto: " + proyecto.getNombre());
            for (Tarea tarea: proyectosTareas.getTareasList()) {
                tarea.setUsuarioCreo(proyecto.getIdAdmin());
                tarea.setIdProyectos(proyecto.getIdProyecto());
            }
            tareaSvc.crearTareas(proyectosTareas.getTareasList());
        }
    }


    @Transactional
    public void crearProyectoUni(Proyecto proyecto) {
        this.proyectoRepository.save(proyecto);
    }

}
