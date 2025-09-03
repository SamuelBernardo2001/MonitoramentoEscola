package com.projeto.monitoramento.instituto.dadosAcademicos.relatorio;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "relatorio_aluno")
public class RelatorioAlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacoes;

    private String dificuldades;

    // Relatório -> Aluno (N:1)
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    // Relatório -> Professor (N:1)
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

}
