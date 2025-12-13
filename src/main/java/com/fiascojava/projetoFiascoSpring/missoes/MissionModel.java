package com.fiascojava.projetoFiascoSpring.missoes;

import com.fiascojava.projetoFiascoSpring.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String rank;

    @ManyToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjaAtribuido;

}

