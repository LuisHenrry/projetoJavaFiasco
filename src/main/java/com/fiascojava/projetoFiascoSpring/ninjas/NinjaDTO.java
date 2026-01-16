package com.fiascojava.projetoFiascoSpring.ninjas;

import com.fiascojava.projetoFiascoSpring.missoes.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class NinjaDTO {

    private String nome;
    private int idade;
    private String email;
    private MissionModel missoes;
    private String rank;

}

