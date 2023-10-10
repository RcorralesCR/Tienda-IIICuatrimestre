package com.Tienda.domain;

import java.io.Serializable;
import lombok.Data;
import jakarta.persistence.*;

/**
 *
 * @author rjesu
 */

@Data
@Entity
@Table(name = "id_categoria")
public class Categoria implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_categoria")
    private Long idCategoria;
    private String descripcion;
    private String ruta_imagen;
    private boolean activo;

    public Categoria() {
        
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    
}
