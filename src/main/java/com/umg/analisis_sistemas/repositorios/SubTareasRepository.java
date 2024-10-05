package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.SubTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SubTareasRepository extends JpaRepository<SubTareas, Long> {

    @Modifying
    @Query("update SubTareas set estado = 5 , asignadoA = :asignadaA where idSubTareas = :idTarea")
    void asignarTarea(@Param("asignadaA") String asignadaA, @Param("idTarea") Long idTarea);
}
