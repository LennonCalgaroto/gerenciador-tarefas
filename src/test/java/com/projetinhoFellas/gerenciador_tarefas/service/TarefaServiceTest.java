package com.projetinhoFellas.gerenciador_tarefas.service;

import com.projetinhoFellas.gerenciador_tarefas.dto.TarefaDTO;
import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaPrioridade;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaStatus;
import com.projetinhoFellas.gerenciador_tarefas.repository.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void criarTarefa() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Nova Tarefa");
        tarefa.setDescricao("descricao");
        tarefa.setStatus(enumTarefaStatus.EM_PROGRESSO);
        tarefa.setPrioridade(enumTarefaPrioridade.ALTA);
        tarefa.setResponsavel("Lennon Calgaroto");

        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefaService.criarTarefa(TarefaDTO.of(tarefa));

        assertNotNull(result);
        assertEquals("Nova Tarefa", result.getTitulo());
        verify(tarefaRepository, times(1)).save(any(Tarefa.class));
    }

    @Test
    void atualizarTarefa() {
//        Tarefa tarefa = new Tarefa();
//        tarefa.setId(1L);
//        tarefa.setTitulo("Nova Tarefa");
//        tarefa.setDescricao("descricao");
//        tarefa.setStatus(enumTarefaStatus.EM_PROGRESSO);
//        tarefa.setPrioridade(enumTarefaPrioridade.ALTA);
//        tarefa.setResponsavel("Lennon Calgaroto");
//
//        when(tarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);
//
//        Tarefa result = tarefaService.atualizarTarefa(TarefaDTO.of(tarefa));
//
//        assertNotNull(result);
//        assertEquals("Nova Tarefa", result.getTitulo());
//        verify(tarefaRepository, times(1)).save(any(Tarefa.class));
    }

    @Test
    void buscarTarefasPorId() {
    }

    @Test
    void listarTodasTarefas() {
    }

    @Test
    void deleteById() {
    }
}