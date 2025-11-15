package pe.gob.devida.geodais.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SpaController {


	@GetMapping({
        "/", 
        "/{path:[^\\.]*}", 
        "/{path:.*}/{path2:[^\\.]*}" 
    })
    public String forward() {
        
        return "forward:/index.html";
    }

}