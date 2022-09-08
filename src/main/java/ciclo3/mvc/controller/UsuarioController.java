package ciclo3.mvc.controller;

import ciclo3.mvc.entities.Usuario;
import ciclo3.mvc.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    private final Logger log = Logger.getLogger(""+UsuarioController.class);

    @GetMapping("/usuarios/list")
    public String getListUsuario(Model model){
        log.log(Level.INFO, "getListUsuarios");
        var mensaje = "Este es el listado de usuarios";
        List<Usuario> usuarios = usuarioService.findAll();

        model.addAttribute("mensaje",mensaje);
        model.addAttribute("usuarios",usuarios);
        return "usuarios/list";
    }
}
