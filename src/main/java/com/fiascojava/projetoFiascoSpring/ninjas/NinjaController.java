package com.fiascojava.projetoFiascoSpring.ninjas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ninja")
public class NinjaController {

    private static final Logger log = LoggerFactory.getLogger(NinjaController.class);
    private NinjaDTO ninjaDTO;
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
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninja){ // --- requestBody ta pegando o corpo como nome, idade e tal (formato json)
        return ninjaService.criarNinja(ninja);
    }

    // READ: Show all ninjas
    @GetMapping("/mostrar")
    public List<NinjaDTO> mostrarNinja(){
        return ninjaService.listarTodosNinjas();
    }

    // READ: Show ninjas by ID
    @GetMapping("/mostrar/{id}")
    public NinjaDTO mostrarNinjaPorId(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);
    }

    // UPDATE: Alter data of ninajs
    @PutMapping("/atualizar/{id}")
    public NinjaDTO atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        return ninjaService.atualizarNinja(id, ninja);
    }

    // DELETE: remove ninjas
    @DeleteMapping("/delete/{id}")
    public String deletarNinja(@PathVariable Long id){
        return ninjaService.deletarNinja(id);
    }
}
