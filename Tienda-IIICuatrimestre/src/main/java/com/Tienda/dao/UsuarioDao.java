
package com.Tienda.dao;

import com.Tienda.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rjesu
 */
public interface UsuarioDao extends JpaRepository<Usuario, Long>{
    
    Usuario findByUsername(String username);
    
}
