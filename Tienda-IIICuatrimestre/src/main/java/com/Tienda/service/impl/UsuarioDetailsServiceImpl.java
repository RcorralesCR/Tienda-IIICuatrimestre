package com.Tienda.service.impl;

import com.Tienda.dao.UsuarioDao;
import com.Tienda.domain.Rol;
import com.Tienda.domain.Usuario;
import com.Tienda.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService, UserDetailsService {

    @Autowired
    private UsuarioDao UsuarioDao;

    @Autowired
    private HttpSession session;

    @Override
    @Transactional(readOnly = true)

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = UsuarioDao.findByUsername(username);
        //Se valida si se recuperó un usuario, sino lanza un error
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        //Si pasón la validación entonces recuperamos la información del usuario
        session.removeAttribute("usuaruiImagen");
        session.setAttribute("usuarioImageen", usuario.getRuta_imagen());
        //Se van a recuperar los roles de usuarios y se cean los roles ya como seguridad spring
        var roles = new ArrayList<GrantedAuthority>();
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));

        }
        //retornamos un User (de tipo UserDetails
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }

}
