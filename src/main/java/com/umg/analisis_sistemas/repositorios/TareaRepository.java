package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TareaRepository extends JpaRepository<Tarea, Long> {


    @Modifying
    @Query("update Tarea t set t.estado = :estado where t.idTarea = :idTarea")
    public void updateEstado(@Param("estado") String estado, @Param("idTarea") Long idTarea);

    @Modifying
    @Query("update Tarea t set t.asignadoA = :asignado where t.idTarea = :idTarea")
    public void updateAsignado(@Param("asignado") String asignado, @Param("idTarea") Long idTarea);

}
