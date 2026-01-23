package com.fiascojava.projetoFiascoSpring.ninjas;


import com.fiascojava.projetoFiascoSpring.missoes.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "missoes")
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_PK")
    private Long id;

    @Column(name = "nameNinja")
    private String nome;

    @Column(name = "age")
    private int idade;

    @Column(name = "rank")
    private String rank;

    @Column(unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "missoes_id")
    private MissionModel missoes;
}

