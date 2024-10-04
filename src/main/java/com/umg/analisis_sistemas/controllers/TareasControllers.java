package com.umg.analisis_sistemas.controllers;

import com.umg.analisis_sistemas.exceptions.ErrorEnum;
import com.umg.analisis_sistemas.exceptions.MSCapiException;
import com.umg.analisis_sistemas.model.Tarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.umg.analisis_sistemas.servicios.TareaSvc;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/Tareas")
public class TareasControllers {

    @Autowired
    private TareaSvc tareaSvc;

    @PostMapping("/crearTareas")
    public void crearTareas(@RequestBody Tarea tareas) {
        try{
            tareaSvc.creaTarea(tareas);
        }catch (Exception e) {
            throw new MSCapiException(ErrorEnum.I_DESCONOCIDO);
        }
    }

}
