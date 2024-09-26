package com.umg.analisis_sistemas.repositorios;

import com.umg.analisis_sistemas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByCorreo(String correo);
}
