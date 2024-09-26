package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
