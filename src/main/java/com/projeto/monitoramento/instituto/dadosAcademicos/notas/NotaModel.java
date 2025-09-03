package com.projeto.monitoramento.instituto.dadosAcademicos.notas;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "notas")
public class NotaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valor;

    private Integer bimestre;

    // Nota -> Disciplina (N:1)
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;

    // Nota -> Aluno (N:1)
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

}
