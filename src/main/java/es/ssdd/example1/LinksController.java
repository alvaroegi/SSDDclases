package es.ssdd.example1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

//EJERCICIO 2
@Controller
public class LinksController {

    //este nuevo controlador no sale de index.html, por lo que como sale de 4links.html, hay que escribir en el navegador
    //localhost:8080/4links.html
    @GetMapping("/enlace")
    public String links(Model model, @RequestParam int num){
        model.addAttribute("numero",num);
        return "enlace_template";

    }

    //EJERCICIO 3
    //Para poder usar /enlace/6 y me abre la pagina como /enlace?num=6
    @GetMapping("/enlace/{num}")
    public String links2(Model model, @PathVariable int num){
        model.addAttribute("numero",num);
        return "enlace_template";

    }


}
