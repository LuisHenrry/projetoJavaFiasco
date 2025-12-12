package com.fiascojava.projetoFiascoSpring.ninjas;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Slf4j
public class NinjaController {

    private static final Logger log = LoggerFactory.getLogger(NinjaController.class);

    @GetMapping("/boasvindas")

    public String boasvindas(){
        log.info("Passou pelo boas vindas");
        return "Boas vindas, Sou o Luis Henrique e esse é um projeto de aprendizadoWP";
    }

    @GetMapping("/voltesempre")
    public String voltesempre(){
        return "volte sempre, até mais...";
    }
}
