
package com.Tienda.controller;

import com.Tienda.service.ReporteService;
import java.io.IOException;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author rjesu
 */

@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    @Autowired
    
    private ReporteService reporteService;
    
    @GetMapping("/principal")
    
    public String listado(Model model){
        
        return null;
    }
    
    @GetMapping("/usuarios")
    
    public ResponseEntity<Resource> reporteUsuario (@RequestParam String tipo) throws IOException{
        
        return reporteService.generarReporte("usuarios", null, tipo);
        
    }
    
}
