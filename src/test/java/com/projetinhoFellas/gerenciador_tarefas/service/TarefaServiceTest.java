package com.projetinhoFellas.gerenciador_tarefas.service;

import com.projetinhoFellas.gerenciador_tarefas.dto.TarefaDTO;
import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaPrioridade;
import com.projetinhoFellas.gerenciador_tarefas.enumTarefa.enumTarefaStatus;
import com.projetinhoFellas.gerenciador_tarefas.repository.ITarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class TarefaServiceTest {

    @Mock
    private ITarefaRepository iTarefaRepository;

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

        when(iTarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefaService.criarTarefa(TarefaDTO.of(tarefa));

        assertNotNull(result);
        assertEquals("Nova Tarefa", result.getTitulo());
        verify(iTarefaRepository, times(1)).save(any(Tarefa.class));
    }

    @Test
    void atualizarTarefa() {
        Long tarefaId = 1L;
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setTitulo("Tarefa Atualizada");
        tarefaDTO.setDescricao("Descricao Atualizada");
        tarefaDTO.setStatus(enumTarefaStatus.CONCLUIDO);
        tarefaDTO.setPrioridade(enumTarefaPrioridade.BAIXA);
        tarefaDTO.setResponsavel("Lennon Calgaroto");

        Tarefa tarefa = new Tarefa();
        tarefa.setId(tarefaId);
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setPrioridade(tarefaDTO.getPrioridade());
        tarefa.setResponsavel(tarefaDTO.getResponsavel());

        when(iTarefaRepository.findById(tarefaId)).thenReturn(Optional.of(tarefa));
        when(iTarefaRepository.save(any(Tarefa.class))).thenReturn(tarefa);

        Tarefa result = tarefaService.atualizarTarefa(tarefaId, tarefaDTO);

        assertNotNull(result);
        assertEquals(tarefaId, result.getId());
        assertEquals("Tarefa Atualizada", result.getTitulo());
        assertEquals(enumTarefaStatus.CONCLUIDO, result.getStatus());
        verify(iTarefaRepository, times(1)).findById(tarefaId);
        verify(iTarefaRepository, times(1)).save(any(Tarefa.class));
    }

    @Test
    void buscarTarefasPorId() {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(1L);
        tarefa.setTitulo("Tarefa 1");

        when(iTarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa));

        TarefaDTO result = tarefaService.buscarTarefasPorId(1L);

        assertNotNull(result);
        assertEquals("Tarefa 1", result.getTitulo());
        verify(iTarefaRepository, times(1)).findById(1L);
    }

    @Test
    void listarTodasTarefas() {
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setId(1L);
        tarefa1.setTitulo("Tarefa 1");

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setId(2L);
        tarefa2.setTitulo("Tarefa 2");

        List<Tarefa> tarefas = Arrays.asList(tarefa1, tarefa2);

        when(iTarefaRepository.findAll()).thenReturn(tarefas);

        List<TarefaDTO> result = tarefaService.listarTodasTarefas();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Tarefa 1", result.get(0).getTitulo());
        assertEquals("Tarefa 2", result.get(1).getTitulo());
        verify(iTarefaRepository, times(1)).findAll();
    }

    @Test
    void deleteById() {
        Long tarefaId = 1L;

        doNothing().when(iTarefaRepository).deleteById(tarefaId);

        tarefaService.deleteById(tarefaId);

        verify(iTarefaRepository, times(1)).deleteById(tarefaId);
    }
}