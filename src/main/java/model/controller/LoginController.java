package model.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @RequestMapping(path = "/loginH", method = RequestMethod.GET)
    public ModelAndView mostrarHome() {
    	return new ModelAndView("inicio");
    }
    @RequestMapping(value="/login")
    public ModelAndView login() {
    	return new ModelAndView("login");
    }
    @RequestMapping(value="/error")
    public ModelAndView errorLogin() {
    	return new ModelAndView("login", "error", "true");
    }
    
    @RequestMapping(value="/logout")
    public ModelAndView logout() {
        // Realiza el proceso de cierre de sesión si es necesario, por ejemplo, eliminar la autenticación actual
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            SecurityContextHolder.clearContext(); // Esto limpiará la autenticación actual
        }
        
        // Redirige a una vista que muestre un mensaje de confirmación de que el usuario ha cerrado sesión
        ModelAndView modelAndView = new ModelAndView("logoutConfirmation");
        modelAndView.addObject("message", "Has cerrado sesión exitosamente.");
        return modelAndView;
    }
   

    }
    
    









