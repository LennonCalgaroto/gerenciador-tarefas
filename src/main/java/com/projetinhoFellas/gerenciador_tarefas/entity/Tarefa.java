package com.projetinhoFellas.gerenciador_tarefas.entity;

import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaPrioridade;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    private String titulo;

    private String descricao;

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAlteracao;

    private LocalDateTime dataConclusao;

    private enumTarefaStatus status;

    private enumTarefaPrioridade prioridade;

    private String responsavel;

}
