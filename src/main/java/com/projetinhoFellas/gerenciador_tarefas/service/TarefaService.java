package com.projetinhoFellas.gerenciador_tarefas.service;

import com.projetinhoFellas.gerenciador_tarefas.dto.TarefaDTO;
import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import com.projetinhoFellas.gerenciador_tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = converterDTOParaEntidade(tarefaDTO);
        tarefa = tarefaRepository.save(tarefa);
        TarefaDTO.of(tarefa);
        return tarefa;
    }

    public Tarefa atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Tarefa tarefaExistente = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));

        tarefaExistente.setTitulo(tarefaDTO.getTitulo());
        tarefaExistente.setDescricao(tarefaDTO.getDescricao());
        tarefaExistente.setStatus(tarefaDTO.getStatus());
        tarefaExistente.setPrioridade(tarefaDTO.getPrioridade());
        tarefaExistente.setDataAlteracao(tarefaDTO.getDataAlteracao());

        Tarefa tarefaAtualizada = tarefaRepository.save(tarefaExistente);
        TarefaDTO.of(tarefaAtualizada);
        return tarefaExistente;
    }

    public TarefaDTO buscarTarefasPorId(Long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));
        TarefaDTO.of(tarefa);
        return converterEntidadeParaDTO(tarefa);
    }

    public List<TarefaDTO> listarTodasTarefas() {
        List<Tarefa> tarefas = tarefaRepository.findAll();
        return tarefas.stream()
                .map(this::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        tarefaRepository.deleteById(id);
    }

    private TarefaDTO converterEntidadeParaDTO(Tarefa tarefa) {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setId(tarefa.getId());
        tarefaDTO.setTitulo(tarefa.getTitulo());
        tarefaDTO.setDescricao(tarefa.getDescricao());
        tarefaDTO.setStatus(tarefa.getStatus());
        tarefaDTO.setPrioridade(tarefa.getPrioridade());
        tarefaDTO.setDataCriacao(tarefa.getDataCriacao());
        tarefaDTO.setDataAlteracao(tarefa.getDataAlteracao());
        tarefaDTO.setDataConclusao(tarefa.getDataConclusao());
        return tarefaDTO;
    }

    private Tarefa converterDTOParaEntidade(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setId(tarefaDTO.getId());
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setPrioridade(tarefaDTO.getPrioridade());
        tarefa.setDataCriacao(tarefaDTO.getDataCriacao());
        tarefa.setDataAlteracao(tarefaDTO.getDataAlteracao());
        tarefa.setDataConclusao(tarefaDTO.getDataConclusao());
        return tarefa;
    }

}
