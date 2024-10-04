package com.umg.analisis_sistemas.dtos;

import com.umg.analisis_sistemas.model.Proyecto;
import com.umg.analisis_sistemas.model.Tarea;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Data
@NoArgsConstructor
public class ProyectosTareas {


   private Proyecto proyecto;
   private  List<Tarea> tareasList;
}
