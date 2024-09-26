package com.umg.analisis_sistemas.controllers;

import com.umg.analisis_sistemas.servicios.ProyectoSvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/proyecto")
public class ProyectoControllers {

    @Autowired
    private ProyectoSvc proyectoSvc;

}
