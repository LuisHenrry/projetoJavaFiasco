package com.fiascojava.projetoFiascoSpring.ninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas")

    public String boasvindas(){
        return "Boas vindas, Sou o Luis Henrique e esse é um projeto de aprendizadoWP";
    }

    @GetMapping("/voltesempre")
    public String voltesempre(){
        return "volte sempre, até mais...";
    }
}
