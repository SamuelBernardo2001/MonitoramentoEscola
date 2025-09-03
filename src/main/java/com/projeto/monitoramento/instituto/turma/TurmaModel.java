package com.projeto.monitoramento.instituto.turma;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (name = "turma")
public class TurmaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ano;
    private String turno;

    // Turma -> Professor (N:1)
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    // Turma -> Alunos (1:N)
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;

    // Turma -> Disciplinas (1:N)
    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;
}
