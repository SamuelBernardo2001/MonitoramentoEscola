package com.projeto.monitoramento.instituto.dadosAcademicos.frequencia;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
import jakarta.persistence.*;
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

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;

    private Boolean presenca;

    // Frequência -> Aluno (N:1)
    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoModel aluno;

}
