package com.fiascojava.projetoFiascoSpring.missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missao")
public class MissionController {

    @GetMapping("/listar")
    public String mostrartodasmissoes(){
        return "retornando todas missoes";
    }
    @PostMapping("/adicionar")
    public String adicionarMissao(){
        return "adicionando....";
    }
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "alterando...";
    }
    @DeleteMapping("/delete")
    public String deletarMissao(){
        return "deletando...";
    }

}
