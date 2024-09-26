package com.umg.analisis_sistemas.servicios.impl;

import com.umg.analisis_sistemas.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.umg.analisis_sistemas.repositorios.UsuarioRepository;
import com.umg.analisis_sistemas.servicios.UsuarioSvc;

import java.util.Optional;
@Service
public class UsuarioSvcImpl implements UsuarioSvc {
    @Autowired
    private UsuarioRepository repositorio;


    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return repositorio.findByCorreo(correo);
    }

}
