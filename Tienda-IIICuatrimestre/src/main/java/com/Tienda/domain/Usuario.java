package com.Tienda.domain;

import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;
    private String ruta_imagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_usuario")
    List<Rol> roles;

}
