package com.umg.analisis_sistemas.controllers;

import com.umg.analisis_sistemas.exceptions.ErrorEnum;
import com.umg.analisis_sistemas.exceptions.MSCapiException;
import com.umg.analisis_sistemas.model.SubTareas;
import com.umg.analisis_sistemas.servicios.SubTareaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/SubProyecto")
public class SubTareasController {

    @Autowired
    private SubTareaSvc subTareaSvc;

    private static Logger logger
            = Logger.getLogger(
            SubTareasController.class.getName());

    @PostMapping("/crearSubTarea")
    public void crearSubTareas(@RequestBody SubTareas subTarea) {
        try{
            subTareaSvc.crearTarea(subTarea);
        }catch (Exception e) {
            logger.info("Error al crear la tarea"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

    @PutMapping("/asignarTarea/{asignadoA}/{idTarea}")
    public void asignarTarea(@PathVariable("asignadoA") String asignadoA, @PathVariable("idTarea")  Long idTarea) {
        try{
            subTareaSvc.asignarTarea(asignadoA, idTarea);
        }catch (Exception e) {
            logger.info("Error al asignar la tarea"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

}
