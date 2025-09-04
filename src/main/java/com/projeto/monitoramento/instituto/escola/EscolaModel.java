package com.projeto.monitoramento.instituto.escola;

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
@Table (name = "escola")
public class EscolaModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String contato;
    private String diretor;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<AlunoModel> alunos;

    @OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
    private List<ProfessorModel> professores;


}
