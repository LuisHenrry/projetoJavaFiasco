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

    public List<NinjaDTO> listarTodosNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream().map(NinjaMAPPER::map).toList();
    }
    // pegar ninja por id
    public NinjaDTO listarNinjaId(Long id){
        Optional<NinjaModel> usuarioResgatado = ninjaRepository.findById(id);
        return usuarioResgatado.map(NinjaMAPPER::map).orElse(null);
    }
    //criação de ninja
    public NinjaDTO criarNinja(NinjaDTO ninja){
        NinjaModel ninjaModel = NinjaMAPPER.map(ninja);
        ninjaModel = ninjaRepository.save(ninjaModel);
        return NinjaMAPPER.map(ninjaModel);
    }
    // deletar ninja
    public String deletarNinja(Long id){
        if(ninjaRepository.findById(id).isPresent()){
            NinjaModel ninja = ninjaRepository.getById(id);
            ninjaRepository.deleteById(id);
            return "Usuario : "+ninja.getNome()+" foi deletado";
        }
        return "Nenhum usuario encontrado...";
    }
    // atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel ninjamodel = NinjaMAPPER.map(ninjaDTO);
            ninjamodel.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjamodel);
            return NinjaMAPPER.map(ninjaSalvo);
        }
        return null;
    }
}
