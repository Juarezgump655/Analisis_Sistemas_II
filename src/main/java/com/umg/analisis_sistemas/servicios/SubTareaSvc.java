package com.umg.analisis_sistemas.servicios;

import com.umg.analisis_sistemas.model.SubTareas;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubTareaSvc {

    public  void crearSubTareas(List<SubTareas> subTareas);

    public void crearTarea(SubTareas subTarea);

    void asignarTarea( String asignadaA, Long idTarea);
}
