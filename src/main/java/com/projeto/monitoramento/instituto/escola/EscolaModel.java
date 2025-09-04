package com.projeto.monitoramento.instituto.escola;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
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
@Table(name = "escola")
public class EscolaModel {

    // ID da escola (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome da escola (obrigatório)
    @NotNull
    private String nome;

    // Endereço da escola (obrigatório)
    @NotNull
    private String endereco;

    // Contato da escola (obrigatório)
    @NotNull
    private String contato;

    // Diretor responsável
    @NotNull
    private String diretor;

    // Escola -> Alunos (1:N) : Uma escola possui vários alunos
    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;

    // Escola -> Professores (1:N) : Uma escola possui vários professores
    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<ProfessorModel> professores;
}
