package com.umg.analisis_sistemas.servicios;

import com.umg.analisis_sistemas.dtos.TareasConSub;
import com.umg.analisis_sistemas.model.Tarea;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaSvc {


    public void crearTareas(List<Tarea> tareas);

    public void creaTarea(TareasConSub tarea);

    public void updateEstado(String estado, Long idTarea);

    public void updateAsignado(String asignado, Long idTarea);
}
