package model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retorna el nombre de la vista (página JSP) del formulario de inicio de sesión
    }
  
    }









