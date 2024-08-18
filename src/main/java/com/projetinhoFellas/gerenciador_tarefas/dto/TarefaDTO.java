package com.projetinhoFellas.gerenciador_tarefas.dto;

import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaPrioridade;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TarefaDTO {
    private long id;
    private String titulo;
    private String descricao;
    private enumTarefaStatus status;
    private enumTarefaPrioridade prioridade;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAlteracao;
    private LocalDateTime dataConclusao;
    private String responsavel;

    public static TarefaDTO of(Tarefa tarefa) {
        return TarefaDTO.builder()
                .id(tarefa.getId())
                .titulo(tarefa.getTitulo())
                .descricao(tarefa.getDescricao())
                .status(tarefa.getStatus())
                .prioridade(tarefa.getPrioridade())
                .dataCriacao(tarefa.getDataCriacao())
                .dataAlteracao(tarefa.getDataAlteracao())
                .dataConclusao(tarefa.getDataConclusao())
                .responsavel(tarefa.getResponsavel())
                .build();
    }
}
