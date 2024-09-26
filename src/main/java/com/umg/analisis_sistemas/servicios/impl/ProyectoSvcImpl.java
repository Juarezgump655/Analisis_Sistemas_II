package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.model.Proyecto;
import com.umg.analisis_sistemas.repositorios.ProyectoRepository;
import com.umg.analisis_sistemas.servicios.ProyectoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProyectoSvcImpl implements ProyectoSvc {

    @Autowired
    ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public void crearProyecto(Proyecto proyecto) {
       this.proyectoRepository.save(proyecto);
    }
}
