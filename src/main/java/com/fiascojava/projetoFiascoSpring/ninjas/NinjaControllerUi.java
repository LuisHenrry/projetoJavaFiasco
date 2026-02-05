package com.fiascojava.projetoFiascoSpring.ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ninja/ui")
public class NinjaControllerUi {

    private final NinjaService ninjaService;

    public NinjaControllerUi(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/mostrar")
    public String mostrar(Model model) {
        List<NinjaDTO> ninjas = ninjaService.listarTodosNinjas();
        model.addAttribute("ninjas", ninjas);
        return "templateNinja";
    }

    @GetMapping("/delete/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "redirect:/ninja/ui/mostrar";
    }

    @GetMapping("/mostrar/{id}")
    public String mostrarNinjaPorId(@PathVariable Long id, Model model) {
        NinjaDTO ninja = ninjaService.listarNinjaId(id);
        if (ninja != null) {
            model.addAttribute("ninjaEncontradoId", ninja);
            return "detalhesNinja";
        } else {
            model.addAttribute("MenssagemNinjaId", "Ninja não foi encontrado.");
            return "templateNinja";
        }
    }

    @GetMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, Model model) {
        model.addAttribute("ninja", ninjaService.listarNinjaId(id));
        return "atualizarNinja";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizarNinja(@PathVariable Long id, @ModelAttribute NinjaDTO ninja) {
        NinjaDTO ninjaDTO = ninjaService.atualizarNinja(id, ninja);
        return "redirect:/ninja/ui/mostrar";
    }
    @GetMapping("/criar")
    public String criarNinja(){ // --- requestBody ta pegando o corpo como nome, idade e tal (formato json)
        return "criarNinja";
        }

    @PostMapping("/criar")
    public String criarNinja(@ModelAttribute NinjaDTO ninja){
        NinjaDTO ninjaDTO = ninjaService.criarNinja(ninja);
        return "redirect:/ninja/ui/mostrar";
    }
}
