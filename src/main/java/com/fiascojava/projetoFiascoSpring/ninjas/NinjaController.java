package com.fiascojava.projetoFiascoSpring.ninjas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private static final Logger log = LoggerFactory.getLogger(NinjaController.class);

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas(){
        log.info("Passou pelo boas vindas");
        return "Boas vindas, Sou o Luis Henrique e esse é um projeto de aprendizado!";
    }

    // CREATE:  Create ninjas
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){ // --- requestBody ta pegando o corpo como nome, idade e tal (formato json)
        return ninjaService.criarNinja(ninja);
    }

    // READ: Show all ninjas
    @GetMapping("/mostrar")
    public List<NinjaModel> mostrarNinja(){
        return ninjaService.listarTodosNinjas();
    }

    // READ: Show ninjas by ID
    @GetMapping("/mostrar/{id}")
    public NinjaModel mostrarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);
    }

    // UPDATE: Alter data of ninajs
    @PutMapping("/atualizar/{id}")
    public NinjaModel atualizarNinja(@PathVariable Long id, @RequestBody NinjaModel ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    // DELETE: remove ninjas
    @DeleteMapping("/delete/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }
}
