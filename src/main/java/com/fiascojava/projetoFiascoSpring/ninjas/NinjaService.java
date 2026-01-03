package com.fiascojava.projetoFiascoSpring.ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {
    private NinjaRespository ninjaRepository;

    public NinjaService(NinjaRespository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> listarTodosNinjas(){
        return ninjaRepository.findAll();
    }
    // pegar ninja por id
    public NinjaModel listarNinjaId(Long id){
        Optional<NinjaModel> usuarioResgatado = ninjaRepository.findById(id);
        return usuarioResgatado.orElse(null);
    }
    //criação de ninja
    public NinjaModel criarNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
    // deletar ninja
    public void deletarNinja(Long id){
        if(ninjaRepository.findById(id).isPresent()){
            ninjaRepository.deleteById(id);
        }
    }
    // atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado){
        if(ninjaRepository.existsById(id)){
            System.out.println("existe esse ID");
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        System.out.println("não existe");
        return null;
    }
}
