package model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
@Entity
@Table(name = "usuarios", schema = "rutas_optimas")
@NoArgsConstructor
public class Usuario {
    @Id
    @Column(name= "dpi", nullable = false,unique = true)
    private String dpi;

    @Column(name= "nombre", nullable = false)
    private String nombre;

    @Column(name= "apellidos", nullable = false)
    private String apellidos;

    @Column(name= "correo",unique = true, nullable = false)
    private String correo;

    @Column(name= "estado", nullable = false)
    private Boolean estado;

    @Column(name ="usuariocreo", nullable =false)
    private String usuariocreo;


    @Column(name = "fechacreacion", updatable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechacreacion;

    @Column(name = "fechamodificacion")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Calendar fechamodificacion;

    @Column(name ="usuariomodifico", nullable =false)
    private String usuariomodifico;

    @Column(name="password", nullable = false)
    private String password;

}

