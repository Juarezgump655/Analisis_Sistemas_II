package com.umg.analisis_sistemas.dtos;

import com.umg.analisis_sistemas.model.SubTareas;
import com.umg.analisis_sistemas.model.Tarea;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TareasConSub {

    private Tarea tareas;
    private List<SubTareas> subTareas;
}
