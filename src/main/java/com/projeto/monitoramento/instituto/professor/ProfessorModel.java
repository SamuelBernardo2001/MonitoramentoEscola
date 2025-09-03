package com.projeto.monitoramento.instituto.professor;

import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ProfessorModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String especialidade;

    // Professor -> Turmas (1:N)
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<TurmaModel> turmas;

    // Professor -> Disciplinas (1:N)
    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
    private List<DisciplinaModel> disciplinas;
}
