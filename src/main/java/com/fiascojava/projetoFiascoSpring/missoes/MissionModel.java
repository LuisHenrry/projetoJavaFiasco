package com.fiascojava.projetoFiascoSpring.missoes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fiascojava.projetoFiascoSpring.ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MissionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    private String rank;

    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List<NinjaModel> ninjaAtribuido;

}

