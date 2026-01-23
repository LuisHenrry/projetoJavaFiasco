package com.fiascojava.projetoFiascoSpring.ninjas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){ // --- requestBody ta pegando o corpo como nome, idade e tal (formato json)
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario criado com sucesso : "+ novoNinja.getNome());
    }

    // READ: Show all ninjas
    @GetMapping("/mostrar")
    public ResponseEntity<?> mostrarNinja(){
        List<NinjaDTO> ninjas = ninjaService.listarTodosNinjas();
        if(ninjas != null){
            return ResponseEntity.ok().body(ninjas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum usuario foi encontrado");
        }
    }

    // READ: Show ninjas by ID
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> mostrarNinjaPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        if(ninja != null){
            return ResponseEntity.ok().body(ninja);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado por esse id :"+ id);
        }
    }

    // UPDATE: Alter data of ninajs
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?> atualizarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDto = ninjaService.atualizarNinja(id, ninja);
        if(ninjaDto != null){
            return ResponseEntity.status(HttpStatus.OK).body("Ninja atualizado para : "+ninjaDto.getNome());
        } else {
            return ResponseEntity.badRequest().body("Ninja não encontrado para fazer o UPDATE");
        }
    }

    // DELETE: remove ninjas
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if(ninjaService.listarNinjaId(id) != null){
            ninjaService.deletarNinja(id);
            return ResponseEntity.ok("Usuario deletado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado!");
        }
    }
}
