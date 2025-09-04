package com.projeto.monitoramento.instituto.professor;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.dadosAcademicos.relatorio.RelatorioAlunoModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import com.projeto.monitoramento.instituto.escola.EscolaModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "professor")
public class ProfessorModel {

    // ID do professor (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do professor (obrigatório)
    @NotNull
    private String nome;

    // E-mail do professor (obrigatório)
    @NotNull
    private String email;

    // Telefone de contato
    @NotNull
    private String telefone;

    // Especialidade do professor
    private String especialidade;

    // Professor -> Turmas (1:N) : Um professor pode lecionar várias turmas
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<TurmaModel> turmas;

    // Professor -> Disciplinas (1:N) : Um professor pode lecionar várias disciplinas
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;

    // Professor -> Alunos (1:N) : Um professor pode ser tutor de vários alunos
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;

    // Professor -> Escola (N:1) : Cada professor pertence a uma escola
    @ManyToOne
    @JoinColumn(name = "escola_id")
    private EscolaModel escola;

    // Professor -> Relatórios (1:N) : Um professor pode criar vários relatórios de alunos
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<RelatorioAlunoModel> relatorios;
}
