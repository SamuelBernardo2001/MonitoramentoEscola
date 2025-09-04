package com.projeto.monitoramento.responsavel;

import com.projeto.monitoramento.instituto.aluno.AlunoModel;
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
@Table(name = "responsavel")
public class ResponsavelModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String email;
    private String relacao; // Ex: Pai, Mãe, Tio, Avó etc.

    // Relacionamento: Responsável -> Aluno (1:N)
    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;
}
