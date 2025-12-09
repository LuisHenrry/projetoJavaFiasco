package com.fiascojava.projetoFiascoSpring.missoes;

import com.fiascojava.projetoFiascoSpring.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class missionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String rank;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjaAtribuido;

    public missionModel(String rank, String nome, NinjaModel n) {
        this.rank = rank;
        this.nome = nome;
        this.ninjaAtribuido.add(n);
    }
}
