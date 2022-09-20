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
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UsuarioController {
    private String titulo;

    //esto es inyectar una interface//
    @Autowired
    private IUsuarioService usuarioService;
    @Autowired
    private ITipoDocumentoService tipoDocumentoService;
    @Autowired
    private IRolService rolService;

    private final Logger LOG = Logger.getLogger("" + IndexController.class);

    @GetMapping("/usuarios/list")
    public String getListUsuarios(Model model){
        LOG.log(Level.INFO, "getListUsuarios");
        List<Usuario> usuarios = usuarioService.findAll();
        for (Usuario user : usuarios)
            System.out.println(user.toString());
        model.addAttribute("usuarios", usuarios);
        return "usuarios/list";
    }

    @GetMapping("/usuarios/modificar")
    public String createUsuario(Model model){
        LOG.log(Level.INFO, "createUsuario");
        Usuario usuario = new Usuario();
        List<TipoDocumento> tipoDocumento = tipoDocumentoService.findAll();
        List<Rol> roles = rolService.findAll();
        titulo = "Datos de Usuario";
        model.addAttribute("titulo", titulo);
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", roles);
        model.addAttribute("tipo_documento", tipoDocumento);
        return "usuarios/modificar";
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@Valid Usuario user, BindingResult error, Model model){
        LOG.log(Level.INFO, "guardarUsuario");
        if(error.hasErrors()){
            System.out.println("SI hay errrores");
            //List<Rol> roles = rolService.findAll();
            //model.addAttribute("roles", roles);
            //List<TipoDocumento> tipoDocumentos = tipoDocumentoService.findAll();
            //model.addAttribute("tipo_documento", tipoDocumentos);
            return "usuarios/modificar";}
        user.setEstado(true);
        user = usuarioService.createUser(user);
        return "redirect:/usuarios/list";
    }

    @RequestMapping(value ="/editar/{id}", method = RequestMethod.GET)
    public String editUsuario(@PathVariable("id") int id, Model modelo){
        LOG.log(Level.INFO, "editUsuario");
        Usuario usuario = usuarioService.findById(id);
        List<TipoDocumento> tipoDocumento = tipoDocumentoService.findAll();
        List<Rol> roles = rolService.findAll();
        System.out.println(tipoDocumento);
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("tipo_documento", tipoDocumento);
        modelo.addAttribute("roles", roles);
        return "usuarios/modificar";
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminarUsuario(@PathVariable("id") int id){
        LOG.log(Level.INFO, "eliminarUsuario");
        Usuario usuario = usuarioService.findById(id);
        usuarioService.deleteUser(id);
        return "redirect:/usuarios/list";
    }

}
