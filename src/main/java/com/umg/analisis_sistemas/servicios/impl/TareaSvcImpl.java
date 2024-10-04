package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.repositorios.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.analisis_sistemas.servicios.TareaSvc;

import java.util.List;

@Service
public class TareaSvcImpl implements TareaSvc {


    @Autowired
    TareaRepository tareaRepository;


    @Override
    public void crearTareas(List<Tarea> tareas) {
        tareaRepository.saveAll(tareas);
    }

    @Override
    public void creaTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

}
