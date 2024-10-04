package com.umg.analisis_sistemas.servicios;

import com.umg.analisis_sistemas.model.Tarea;

import java.util.List;

public interface TareaSvc {


    public void crearTareas(List<Tarea> tareas);

    public void creaTarea(Tarea tarea);
}
