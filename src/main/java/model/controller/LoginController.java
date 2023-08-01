package model.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping(path = "/inicioH", method = RequestMethod.GET)
    public ModelAndView mostrarHome() {
        return new ModelAndView("inicio");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/error")
    public ModelAndView errorLogin() {
        return new ModelAndView("login", "error", "true");
    }

    @RequestMapping(value = "/logout")
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

    // Método para obtener el nombre de usuario y sus roles
    private String getUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getName();
        }
        return null;
    }

    // Método para verificar si el usuario tiene el rol "cliente"
    private boolean isCliente() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_CLIENTE"));
        }
        return false;
    }

    // Método para verificar si el usuario tiene el rol "administrativo"
    private boolean isAdministrativo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMINISTRATIVO"));
        }
        return false;
    }
}
