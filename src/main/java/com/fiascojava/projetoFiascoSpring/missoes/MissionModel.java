package com.fiascojava.projetoFiascoSpring.missoes;

import com.fiascojava.projetoFiascoSpring.ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;
    private String rank;

    @OneToMany(mappedBy = "missao")
    private List<NinjaModel> ninjaAtribuido;

    public MissionModel(String rank, String nome, NinjaModel n) {
        this.rank = rank;
        this.nome = nome;
        this.ninjaAtribuido.add(n);
    }
}
