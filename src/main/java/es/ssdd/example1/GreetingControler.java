package es.ssdd.example1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class GreetingControler {

    //Modifica una variable del html
    @GetMapping("/greeting")
    public String greeting(Model model){
        model.addAttribute("name","World");

        return "greeting_template";
    }

    //Solo se muestra lo que hay entre la variable silent si lo de la derecha es cierto
    @GetMapping("/basic")
    public String basic(Model model){
        model.addAttribute( "silent",true);
        return "basic_template";
    }

    //Modifica la lista
    @GetMapping("/list")
    public String iteration(Model model) {
        List<String> colors = Arrays.asList("Red","Blue","Green");
        model.addAttribute("colors", colors);
        return "list_template";
    }

    //Envia los datos del formulario a otra pagina
    @GetMapping("/greeting2")
    public String greeting2(Model model, @RequestParam String nombre){
        //tiene que coincidir el nombre de esta variable con el nombre de la derecha de name del html
        model.addAttribute("name",nombre);

        return "greeting_template";

    }

    //EJERCICIO 1
    //puedo crear distintos controladores para esto, aunque este hecho todo aqui
    //postmapping para poder usar un post en el form
    @PostMapping("/formulario")
    public String form(Model model, @RequestParam String nombre, @RequestParam String asunto, @RequestParam String comments){
        //parte izquierda se llama igual que en el html que va a salir (form template), parte derecha igual que en
        //el index.html donde se van a recoger las variables
        model.addAttribute("name", nombre);
        model.addAttribute("asunto", asunto);
        model.addAttribute("comments", comments);

        return "form_template";
    }



}
