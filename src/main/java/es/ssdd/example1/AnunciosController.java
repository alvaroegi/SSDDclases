package es.ssdd.example1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//EJERCICIO 4
@Controller
public class AnunciosController {
    public class ListaAnuncio{
        String name;
        String asunt;
        String contenido;
    }
    List<ListaAnuncio> list = new ArrayList<>();

    @GetMapping("/tablon")
    public String tablon(Model model){

        model.addAttribute("anuncios", list);

        return "tablon";
    }
    @GetMapping("/nuevoanuncio")
    public String recAnnoun(Model model){
        return "nuevoanuncio_template";
    }
    @GetMapping("/anuncioreco")
    public String announc(Model model, @RequestParam String nombre, @RequestParam String asunto, @RequestParam String contenido){
        ListaAnuncio aux = new ListaAnuncio();
        aux.name = nombre;
        aux.asunt = asunto;
        aux.contenido = contenido;
        list.add(aux);


        return "anunciorecog_template";
    }

    @GetMapping("/tablon/{num}")
    public String pag(Model model, @PathVariable int num){
        ListaAnuncio anuncio= list.get(num - 1);
        model.addAttribute("anuncio",anuncio);
        return "ver_anuncio";
    }
}
