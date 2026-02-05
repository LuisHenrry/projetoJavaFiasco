package com.fiascojava.projetoFiascoSpring.missoes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missao")
public class MissionController {
    private MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @GetMapping("/listar")
    public ResponseEntity<?> mostrarTodasMissoes(){
        List<MissionModel> missoes = missionService.listarMissoes();
        if(missoes.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(missoes);
        }
    }
    @PostMapping("/adicionar")
    public ResponseEntity<?> criarMissao(@RequestBody MissionModel missionModel){
        MissionModel missionModelCriado = missionService.criarMissao(missionModel);
        return ResponseEntity.ok().body(missionModelCriado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletarMissao(@PathVariable Long id){
        if(missionService.listarMissoesId(id).isPresent()){
            missionService.delete(id);
            return ResponseEntity.ok().body("Item foi deletado com sucesso");
        } else {
            return ResponseEntity.noContent().build();
        }
    }

}
