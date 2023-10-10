
package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

/**
 *
 * @author rjesu
 */
public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
}
