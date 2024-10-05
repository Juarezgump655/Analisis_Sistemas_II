package com.umg.analisis_sistemas.controllers;

import com.umg.analisis_sistemas.dtos.TareasConSub;
import com.umg.analisis_sistemas.exceptions.ErrorEnum;
import com.umg.analisis_sistemas.exceptions.MSCapiException;
import com.umg.analisis_sistemas.projection.TableroTareas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.umg.analisis_sistemas.servicios.TareaSvc;

import java.util.List;
import java.util.logging.Logger;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/Tareas")
public class TareasControllers {

    @Autowired
    private TareaSvc tareaSvc;

    private static Logger logger
            = Logger.getLogger(
            TareasControllers.class.getName());

    @PostMapping("/crearTareas")
    public void crearTareas(@RequestBody TareasConSub tareasConSub) {
        try{
            tareaSvc.creaTarea(tareasConSub);
        }catch (Exception e) {
            logger.info("Error al crear la tarea"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

    @PutMapping("/updateEstado/{idTarea}/{estado}")
    public void updateEstado(@PathVariable("estado") String estado, @PathVariable("idTarea")  Long idTarea) {
        try{
            tareaSvc.updateEstado(estado, idTarea);
        }catch (Exception e) {
            logger.info("Error al actualizar el estado de la tarea"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

    @PutMapping("/updateAsignado/{idTarea}/{asignado}")
    public void updateAsignado(@PathVariable("asignado") String asignado, @PathVariable("idTarea")  Long idTarea) {
        try{
            tareaSvc.updateAsignado(asignado, idTarea);
        }catch (Exception e) {
            logger.info("Error al actualizar el asignado de la tarea"+ e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

    @GetMapping("/getTableroPorProyecto/{idProyectos}")
    public List<TableroTareas> getTableroPorProyecto(@PathVariable("idProyectos") Long idProyectos) {
        try{
           return tareaSvc.getTableroPorProyecto(idProyectos);
        }catch (MSCapiException e) {
            logger.info("Error específico al obtener el tablero por proyecto: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.info("Error desconocido al obtener el tablero por proyecto: " + e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

    @GetMapping("/getTableroPorUsuario/{asignadoA}")
    public List<TableroTareas> getTableroPorUsuario(@PathVariable("asignadoA") String asignadoA) {
        try{
           return tareaSvc.getTableroPorUsuario(asignadoA);
        }catch (MSCapiException e) {
            logger.info("Error específico al obtener el tablero por usuario: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.info("Error desconocido al obtener el tablero por usuario: " + e.getMessage());
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }




}
