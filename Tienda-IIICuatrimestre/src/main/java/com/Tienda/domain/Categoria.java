package com.Tienda.domain;

import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name="categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String ruta_imagen;
    private boolean activo;
    
    @OneToMany
    @JoinColumn(name="id_categoria")
    List<Producto> productos;

        
}