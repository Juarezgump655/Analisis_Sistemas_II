package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.model.SubTareas;
import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.repositorios.SubTareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.analisis_sistemas.servicios.SubTareaSvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTareaSvcImpl  implements SubTareaSvc {

    @Autowired
    SubTareasRepository subTareasRepository;

    private static  final int  CREADA = 4;
    private static  final int ASIGNADA = 5;
    private static  final int ELIMINADA = 6;
    private static  final int PROCESO = 7;
    private static  final int FINALIZADA = 8;
    @Override
    @Transactional
    public void crearSubTareas(List<SubTareas> subTareas) {
        this.subTareasRepository.saveAll(this.verificarEstado(subTareas));
    }


    private SubTareas verificarEstado(SubTareas tarea) {
        if(!(tarea.getAsignadoA() == null|| tarea.getAsignadoA().isEmpty() )) {
            tarea.setEstado(ASIGNADA);
        }else{
            tarea.setEstado(CREADA);
        }
        return tarea;
    }

    private List<SubTareas> verificarEstado(List<SubTareas> tareas) {
        List<SubTareas> listaTareaEstado = new ArrayList<>();
        for (SubTareas tarea : tareas) {
            listaTareaEstado.add(verificarEstado(tarea));
        }
        return listaTareaEstado;
    }

}
