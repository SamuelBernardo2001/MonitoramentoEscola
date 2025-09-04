package com.projeto.monitoramento.instituto.dadosAcademicos.notas;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "notas")
public class NotaModel {

    // ID da nota (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Valor da nota (obrigatório)
    @NotNull
    private Double valor;

    // Bimestre referente à nota (obrigatório)
    @NotNull
    private Integer bimestre;

    // Nota -> Disciplina (N:1) : Cada nota pertence a uma disciplina
    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaModel disciplina;

    // Nota -> Aluno (N:1) : Cada nota pertence a um aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;
}