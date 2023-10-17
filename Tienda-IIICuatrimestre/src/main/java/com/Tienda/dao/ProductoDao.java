
package com.Tienda.dao;

import com.Tienda.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rjesu
 */
public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    
    
}
