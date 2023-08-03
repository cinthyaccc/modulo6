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

    @Autowired
    private RestUsuarioController restUsuarioController; // Inyectar el servicio RestUsuarioController

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
        // Obtener la lista de capacitaciones desde el servicio RestUsuarioController
        List<Capacitacion> capacitaciones = restUsuarioController.getAllCapacitaciones();

        ModelAndView modelAndView = new ModelAndView("listarCapacitaciones", "capacitaciones", capacitaciones);
        return modelAndView;
    }

    @RequestMapping(path = "/CrearCapacitacion", method = RequestMethod.POST)
    public ModelAndView crearCapacitacion(Capacitacion capacitacion) {
        try {
			// Obtenemos el detalle utilizando el método mostrarDetalle()
			String detalle = capacitacion.mostrarDetalle();
			// Establecemos el detalle en el objeto Capacitacion
			capacitacion.setDetalle(detalle);
			// Guardamos la capacitación en la base de datos (asegúrate de que el método crearCapacitaciones solo reciba la instancia de Capacitacion)
			cs.crearCapacitaciones(capacitacion, detalle);

            // Redirigir a la página de listar capacitaciones
            return new ModelAndView("redirect:/ListarCapacitaciones");
        } catch (Exception e) {
            e.printStackTrace();
            // Manejar el error adecuadamente, redirigir a una página de error o mostrar un mensaje de error en la vista.
            return new ModelAndView("error");
        }
    }
}