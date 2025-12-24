package com.fiascojava.projetoFiascoSpring.ninjas;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private static final Logger log = LoggerFactory.getLogger(NinjaController.class);

    @GetMapping("/boasvindas")
    public String boasvindas(){
        log.info("Passou pelo boas vindas");
        return "Boas vindas, Sou o Luis Henrique e esse é um projeto de aprendizado!";
    }

    // CREATE:  Create ninjas
    @PostMapping("/criarninja")
    public String criarNinja(){
        return "Ninja Criado";
    }
    // READ: Show all ninjas
    @GetMapping("/mostrarninja")
    public String mostrarNinja(){
        return "mostrar ninja";
    }
    // READ: Show ninjas by ID
    @GetMapping("/mostrarninjaid")
    public String mostrarNinjaPorId(){
        return "mostrar ninja por ID";
    }
    // UPDATE: Alter data of ninajs
    @PostMapping("/atualizarninjaid")
    public String atualizarNinja(){
        return "atualizarNinja";
    }
    // DELETE: remove ninjas
    @DeleteMapping("/deleteId")
    public String deletarNinja(){
        return "apagar por ID";
    }
}
