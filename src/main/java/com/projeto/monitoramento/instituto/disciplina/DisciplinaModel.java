package com.projeto.monitoramento.instituto.disciplina;

import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class DisciplinaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Disciplina -> Professor (N:1)
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    // Disciplina -> Turma (N:1)
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;
}
