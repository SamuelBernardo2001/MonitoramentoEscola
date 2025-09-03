package com.projeto.monitoramento.instituto.aluno;

import com.projeto.monitoramento.instituto.turma.TurmaModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class AlunoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String matricula;
    private int comportamento;
    private int desempenho;

    // Aluno -> Turma (N:1)
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;
}

