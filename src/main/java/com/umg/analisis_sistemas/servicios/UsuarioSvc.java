package com.umg.analisis_sistemas.servicios;

import com.umg.analisis_sistemas.model.Usuario;

import java.util.Optional;

public interface UsuarioSvc {

    public Optional<Usuario> findByCorreo(String correo);
}
