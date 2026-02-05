package com.fiascojava.projetoFiascoSpring.ninjas;

import org.springframework.stereotype.Component;

@Component
public class NinjaMAPPER {

    public static NinjaModel map (NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();
        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setNome(ninjaDTO.getNome());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setIdade(ninjaDTO.getIdade());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setMissoes(ninjaDTO.getMissoes());
        return ninjaModel;
    }
    public static NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();
        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setNome(ninjaModel.getNome());
        ninjaDTO.setIdade(ninjaModel.getIdade());
        ninjaDTO.setMissoes(ninjaModel.getMissoes());
        return ninjaDTO;
    }
}
