package com.projetinhoFellas.gerenciador_tarefas.entity;

import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaPrioridade;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private LocalDateTime dataCriacao;

    @Column
    private LocalDateTime dataAlteracao;

    @Column
    private LocalDateTime dataConclusao;

    @Column
    private enumTarefaStatus status;

    @Column
    private enumTarefaPrioridade prioridade;

    @Column
    private String responsavel;

}
