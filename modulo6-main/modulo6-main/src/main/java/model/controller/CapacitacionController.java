package model.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.entity.Capacitacion;
import model.service.CapacitacionService;

@Controller
public class CapacitacionController {

	@Autowired
	private CapacitacionService cs;
    /**
     * Maneja las solicitudes que se le hacen a la raíz del sitio
     * 
     * @return un objeto {@link ModelAndView} con la respuesta al cliente
     */
    @RequestMapping(path = "/CrearCapacitacion", method = RequestMethod.GET)
    public ModelAndView mostrarCrearCapacitacion() {
        return new ModelAndView("crearCapacitacion");
    }
    
    @RequestMapping(path = "/ListarCapacitaciones", method = RequestMethod.GET)
    public ModelAndView mostrarListarCapacitaciones() {
    	List<Capacitacion> capacitaciones = cs.getCapacitaciones();
        return new ModelAndView("listarCapacitaciones", "capacitaciones", capacitaciones);
    }  
    @RequestMapping(path = "/CrearCapacitacion", method = RequestMethod.POST)
    public ModelAndView crearCapacitacion(Capacitacion capacitacion) {
        try {
            String detalle = capacitacion.mostrarDetalle(); // Obtenemos el detalle utilizando el método mostrarDetalle()
            capacitacion.setDetalle(detalle); // Establecemos el detalle en el objeto Capacitacion
            cs.crearCapacitaciones(capacitacion, detalle); // Guardamos la capacitación en la base de datos (asegúrate de que el método crearCapacitaciones solo reciba la instancia de Capacitacion)
            // Redirigir a la página de listar capacitaciones
            return new ModelAndView("redirect:/ListarCapacitaciones");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error adecuadamente, redirigir a una página de error o mostrar un mensaje de error en la vista.
            return new ModelAndView("error");
        }
    }


    	
    	
    	
    
     
    
    
}


