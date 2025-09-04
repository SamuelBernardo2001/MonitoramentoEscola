package com.projeto.monitoramento.instituto.aluno;

import com.projeto.monitoramento.instituto.dadosAcademicos.frequencia.FrequenciaModel;
import com.projeto.monitoramento.instituto.dadosAcademicos.notas.NotaModel;
import com.projeto.monitoramento.instituto.dadosAcademicos.relatorio.RelatorioAlunoModel;
import com.projeto.monitoramento.instituto.escola.EscolaModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import com.projeto.monitoramento.responsavel.ResponsavelModel;
import com.projeto.monitoramento.instituto.disciplina.DisciplinaModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "aluno")
public class AlunoModel {

    // ID do aluno (PK)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do aluno (obrigatório, entre 3 e 100 caracteres)
    @NotNull
    @Size(min = 3, max = 100)
    private String nome;

    // Idade do aluno
    private int idade;

    // Matrícula do aluno (obrigatória)
    @NotNull
    private String matricula;

    // Nota de comportamento do aluno
    private int comportamento;

    // Nota de desempenho do aluno
    private int desempenho;

    // Série do aluno
    private String serie;

    // ---------------- RELACIONAMENTOS ----------------

    // Aluno -> Turma (N:1) : Cada aluno pertence a uma turma
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    // Aluno -> Responsável (N:1) : Cada aluno tem um responsável
    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private ResponsavelModel responsavel;

    // Aluno -> Escola (N:1) : Cada aluno está vinculado a uma escola
    @ManyToOne
    @JoinColumn(name = "escola_id")
    private EscolaModel escola;

    // Aluno -> Notas (1:N) : Um aluno pode ter várias notas
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<NotaModel> notas;

    // Aluno -> Frequências (1:N) : Um aluno pode ter várias frequências registradas
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<FrequenciaModel> frequencias;

    // Aluno -> Relatórios (1:N) : Um aluno pode ter vários relatórios de professores
    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<RelatorioAlunoModel> relatorios;

    // Aluno -> Disciplinas (N:M) : Um aluno pode cursar várias disciplinas
    @ManyToMany
    @JoinTable(
            name = "aluno_disciplina",
            joinColumns = @JoinColumn(name = "aluno_id"),
            inverseJoinColumns = @JoinColumn(name = "disciplina_id")
    )
    private Set<DisciplinaModel> disciplinas;
}
