package ciclo3.mvc.controller;

import ciclo3.mvc.entities.Rol;
import ciclo3.mvc.entities.TipoDocumento;
import ciclo3.mvc.entities.Usuario;
import ciclo3.mvc.service.IRolService;
import ciclo3.mvc.service.ITipoDocumentoService;
import ciclo3.mvc.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private IRolService rolService;
    @Autowired
    private ITipoDocumentoService tipoDocumentoService;
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

    @GetMapping("/usuarios/modificar")
    public String createUsuario(Model model){
        log.log(Level.INFO, "modificarUsuarios");
        Usuario usuario = new Usuario();
        List<TipoDocumento> tipoDoc = tipoDocumentoService.findAll();
        List<Rol> roles = rolService.findAll();
        model.addAttribute("usuario",usuario);
        model.addAttribute("roles",roles);
        model.addAttribute("tipodoc",tipoDoc);
        return "usuarios/modificar";
    }

    @PostMapping("/usuarios/guardar")
    public String saveUsuario(Model model){
        log.log(Level.INFO, "saveUsuarios");

        return "usuarios/modificar";
    }
}
