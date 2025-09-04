package com.projeto.monitoramento.responsavel;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
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
@Table(name = "responsavel")
public class ResponsavelModel {

    // ID do responsável (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do responsável (obrigatório)
    @NotNull
    private String nome;

    // Telefone de contato (obrigatório)
    @NotNull
    private String telefone;

    // E-mail do responsável
    private String email;

    // Relação com o aluno (Pai, Mãe, Tio, Avó, etc.) (obrigatório)
    @NotNull
    private String relacao;

    // Responsável -> Alunos (1:N) : Um responsável pode ter vários alunos
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;
}
