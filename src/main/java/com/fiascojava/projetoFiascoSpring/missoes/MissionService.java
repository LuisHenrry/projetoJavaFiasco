package com.fiascojava.projetoFiascoSpring.missoes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {
    private MissionRepository missionRepository;

    // Constructor injection (recommended)
    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionModel> listarMissoes(){
        return missionRepository.findAll();
    }
    public Optional<MissionModel> listarMissoesId(Long id){
        Optional<MissionModel> missao = missionRepository.findById(id);
        return missao;
    }
    public MissionModel criarMissao(MissionModel missionModel){
        return missionRepository.save(missionModel);
    }
    public void delete(Long id){
        missionRepository.deleteById(id);
    }
}
