package com.projeto.monitoramento.instituto.aluno;

import com.projeto.monitoramento.instituto.turma.TurmaModel;
import com.projeto.monitoramento.responsavel.ResponsavelModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (name = "aluno")
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

    // Aluno -> Responsável (N:1)
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private ResponsavelModel responsavel;
}

