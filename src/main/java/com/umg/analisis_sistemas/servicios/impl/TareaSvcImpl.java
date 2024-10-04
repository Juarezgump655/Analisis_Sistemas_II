package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.dtos.TareasConSub;
import com.umg.analisis_sistemas.model.SubTareas;
import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.repositorios.TareaRepository;
import com.umg.analisis_sistemas.servicios.SubTareaSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.analisis_sistemas.servicios.TareaSvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class TareaSvcImpl implements TareaSvc {


    @Autowired
    TareaRepository tareaRepository;

    @Autowired
    SubTareaSvc subTareaSvc;

    private static  final int  CREADA = 4;
    private static  final int ASIGNADA = 5;
    private static  final int ELIMINADA = 6;
    private static  final int PROCESO = 7;
    private static  final int FINALIZADA = 8;


    private static Logger logger
            = Logger.getLogger(
            TareaSvcImpl.class.getName());
    @Override
    @Transactional
    public void crearTareas(List<Tarea> tareas) {
        logger.info("Creando tareas");
        tareaRepository.saveAll(this.verificarEstado(tareas));
    }

    @Override
    @Transactional
    public void creaTarea(TareasConSub tarea) {
        logger.info("Creando tarea");
        Tarea tarea1=  tareaRepository.save(this.verificarEstado(tarea.getTareas()));
        if (tarea.getSubTareas() != null) {
            for (SubTareas subTareas : tarea.getSubTareas()) {
                logger.info("Creando sub tarea, para la tarea creada  " + tarea1.getIdTarea());
                subTareas.setIdTarea(tarea1.getIdTarea());
                subTareas.setUsuarioCreo(tarea1.getUsuarioCreo());
            }
            subTareaSvc.crearSubTareas(tarea.getSubTareas());
        }
    }

    @Override
    @Transactional
    public void updateEstado(String estado, Long idTarea) {
        logger.info("Actualizando estado de tarea");
        tareaRepository.updateEstado(estado, idTarea);
    }


    private Tarea verificarEstado(Tarea tarea) {
        if(!(tarea.getAsignadoA() == null|| tarea.getAsignadoA().isEmpty() )) {
           tarea.setEstado(ASIGNADA);
        }else{
            tarea.setEstado(CREADA);
        }
        return tarea;
    }

    private List<Tarea> verificarEstado(List<Tarea> tareas) {
        List<Tarea> listaTareaEstado = new ArrayList<>();
        for (Tarea tarea : tareas) {
           listaTareaEstado.add(verificarEstado(tarea));
        }
        return listaTareaEstado;
    }

    @Override
    @Transactional
    public void updateAsignado(String asignado, Long idTarea) {
        logger.info("Actualizando asignado de tarea");
        tareaRepository.updateAsignado(asignado, idTarea);
    }


}
