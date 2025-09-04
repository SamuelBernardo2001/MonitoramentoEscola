package com.projeto.monitoramento.instituto.dadosAcademicos.frequencia;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "frequencia")
public class FrequenciaModel {

    // ID da frequência (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Data da frequência (obrigatória)
    @NotNull
    private LocalDate data;

    // Presença ou ausência do aluno
    @NotNull
    private Boolean presenca;

    // Frequência -> Aluno (N:1) : Cada registro de frequência pertence a um aluno
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;
}
