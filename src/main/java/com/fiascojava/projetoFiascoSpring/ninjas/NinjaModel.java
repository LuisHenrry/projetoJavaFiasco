package com.fiascojava.projetoFiascoSpring.ninjas;


import com.fiascojava.projetoFiascoSpring.missoes.missionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


// Entity transforma uma classe em uma entidade como uma tabela com colunas e tal
@Entity
// Cria o nome da tabela
@Table(name = "tb_cadastro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    @ManyToOne
    @JoinColumn(name = "missao_id")
    private List<missionModel> missoes ;

}
