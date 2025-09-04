package com.projeto.monitoramento.instituto.dadosAcademicos.relatorio;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "relatorio_aluno")
public class RelatorioAlunoModel {

    // ID do relatório (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Observações do professor sobre o aluno
    @NotNull
    private String observacoes;

    // Dificuldades do aluno relatadas pelo professor
    private String dificuldades;

    // Relatório -> Aluno (N:1) : Cada relatório pertence a um aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

    // Relatório -> Professor (N:1) : Cada relatório é feito por um professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;
}