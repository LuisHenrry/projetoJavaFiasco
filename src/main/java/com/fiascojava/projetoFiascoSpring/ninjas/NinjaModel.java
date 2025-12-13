package com.fiascojava.projetoFiascoSpring.ninjas;


import com.fiascojava.projetoFiascoSpring.missoes.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_PK")
    private Long id;

    @Column(name = "nameNinja")
    private String nome;

    @Column(name = "age")
    private int idade;

    @Column(unique = true)
    private String email;

    @ManyToMany
    @JoinTable(
            name = "tb_ninja_missoes",
            joinColumns = @JoinColumn(name = "ninja_id"),
            inverseJoinColumns = @JoinColumn(name = "missao_id")
    )
    private List<MissionModel> missoes;
}

