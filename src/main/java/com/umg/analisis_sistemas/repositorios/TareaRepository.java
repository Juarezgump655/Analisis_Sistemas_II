package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.Tarea;
import com.umg.analisis_sistemas.projection.TableroTareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {


    @Modifying
    @Query("update Tarea t set t.estado = :estado where t.idTarea = :idTarea")
    public void updateEstado(@Param("estado") String estado, @Param("idTarea") Long idTarea);

    @Modifying
    @Query("update Tarea t set t.asignadoA = :asignado where t.idTarea = :idTarea")
    public void updateAsignado(@Param("asignado") String asignado, @Param("idTarea") Long idTarea);

    @Query(value = "select t.nombre,\n" +
            "       t.descripcion, \n" +
            "       t.fecha_inicio as fechaInicio, \n" +
            "       t.fecha_fin as fechaFin, \n" +
            "       u.nombre || ' ' || u.apellidos as nombreUser,\n" +
            "       c.descripcion as estado\n" +
            "from analisis_sistemas.tareas t \n" +
            "inner join analisis_sistemas.usuarios u on t.asignado_a = u.dpi \n" +
            "inner join analisis_sistemas.catalogos c on t.estado = c.id_catalogo \n" +
            "where t.id_proyectos = :idProyectos\n" +
            "and t.estado != 6 ", nativeQuery = true)
    public List<TableroTareas> getTableroPorProyecto(@Param("idProyectos") Long idProyectos);

    @Query(value ="select t.nombre,\n" +
            "       t.descripcion, \n" +
            "       t.fecha_inicio as fechaInicio, \n" +
            "       t.fecha_fin as fechaFin, \n" +
            "       u.nombre || ' ' || u.apellidos as nombreUser,\n" +
            "       c.descripcion as estado\n" +
            "from analisis_sistemas.tareas t \n" +
            "inner join analisis_sistemas.usuarios u on t.asignado_a = u.dpi \n" +
            "inner join analisis_sistemas.catalogos c on t.estado = c.id_catalogo \n" +
            "where t.asignado_a = :asignadoA\n" +
            "and t.estado != 6  \n", nativeQuery = true)
    public List<TableroTareas> getTableroPorUsuario(@Param("asignadoA") String asignadoA);

}
