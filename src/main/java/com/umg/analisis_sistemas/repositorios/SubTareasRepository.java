package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.SubTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubTareasRepository extends JpaRepository<SubTareas, Long> {
}
