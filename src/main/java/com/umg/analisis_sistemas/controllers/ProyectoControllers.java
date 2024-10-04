package com.umg.analisis_sistemas.controllers;

import com.umg.analisis_sistemas.dtos.ProyectosTareas;
import com.umg.analisis_sistemas.exceptions.ErrorEnum;
import com.umg.analisis_sistemas.exceptions.MSCapiException;
import com.umg.analisis_sistemas.model.Proyecto;
import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.servicios.ProyectoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/proyecto")
public class ProyectoControllers {

    @Autowired
    private ProyectoSvc proyectoSvc;

    private static Logger logger
            = Logger.getLogger(
            ProyectoControllers.class.getName());

    @PostMapping("/crearProyecto")
    public void crearProyecto(@RequestBody ProyectosTareas proyectosTareas) {
        try {
            proyectoSvc.crearProyecto(proyectosTareas);
        } catch (Exception e) {
            logger.info("Error al crear el proyecto"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

}
