package ciclo3.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class IndexController {
    private final Logger log = Logger.getLogger(""+IndexController.class);

    @GetMapping("/")
    public String index(Model model){
        log.log(Level.INFO, "index");
        var mensaje = "Bienvenidos al sistema de gestion de usuarios";
        model.addAttribute("mensaje",mensaje);
        return "index";
    }
}
