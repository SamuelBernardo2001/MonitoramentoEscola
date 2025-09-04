package com.projeto.monitoramento.instituto.aluno;

import com.projeto.monitoramento.instituto.dadosAcademicos.frequencia.FrequenciaModel;
import com.projeto.monitoramento.instituto.dadosAcademicos.notas.NotaModel;
import com.projeto.monitoramento.instituto.dadosAcademicos.relatorio.RelatorioAlunoModel;
import com.projeto.monitoramento.instituto.escola.EscolaModel;
import com.projeto.monitoramento.instituto.professor.ProfessorModel;
import com.projeto.monitoramento.instituto.turma.TurmaModel;
import com.projeto.monitoramento.responsavel.ResponsavelModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table (name = "aluno")
public class AlunoModel {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 3, max = 100)
    private String nome;
    private int idade;

    @NotNull
    private String matricula;
    private int comportamento;
    private int desempenho;

    private String serie;

    // Relacionamentos
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private TurmaModel turma;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private ResponsavelModel responsavel;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorModel professor;

    @ManyToOne
    @JoinColumn(name = "escola_id")
    private EscolaModel escola;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<NotaModel> notas;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<FrequenciaModel> frequencias;

    @OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL)
    private List<RelatorioAlunoModel> relatorios;
}

