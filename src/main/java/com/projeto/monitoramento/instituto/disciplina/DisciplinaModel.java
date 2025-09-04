package com.projeto.monitoramento.instituto.disciplina;

import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "disciplina")
public class DisciplinaModel {

    // ID da disciplina (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da disciplina (obrigatório)
    @NotNull
    private String nome;

    // Disciplina -> Professor (N:1) : Cada disciplina é lecionada por um professor
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    // Disciplina -> Turma (N:1) : Cada disciplina pertence a uma turma
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    // Disciplina -> Alunos (N:M) : Uma disciplina pode ter vários alunos
    @ManyToMany(mappedBy = "disciplinas")
    private Set<AlunoModel> alunos;
}
