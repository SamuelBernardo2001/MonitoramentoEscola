package com.projeto.monitoramento.instituto.turma;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import com.projeto.monitoramento.instituto.professor.ProfessorModel;
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
@Table(name = "turma")
public class TurmaModel {

    // ID da turma (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da turma (obrigatório)
    @NotNull
    private String nome;

    // Ano da turma (obrigatório)
    @NotNull
    private String ano;

    // Turno da turma (obrigatório)
    @NotNull
    private String turno;

    // Turma -> Professor (N:1) : Cada turma tem um professor responsável
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    // Turma -> Alunos (1:N) : Uma turma possui vários alunos
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;

    // Turma -> Disciplinas (1:N) : Uma turma possui várias disciplinas
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;
}
