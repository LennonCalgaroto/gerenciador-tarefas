package com.projetinhoFellas.gerenciador_tarefas.service;

import com.projetinhoFellas.gerenciador_tarefas.dto.TarefaDTO;
import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import com.projetinhoFellas.gerenciador_tarefas.repository.ITarefaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TarefaService {

    private ITarefaRepository iTarefaRepository;

    public Tarefa criarTarefa(TarefaDTO tarefaDTO) {
        Tarefa tarefa = converterDTOParaEntidade(tarefaDTO);
        tarefa = iTarefaRepository.save(tarefa);
        TarefaDTO.of(tarefa);
        return tarefa;
    }

    public Tarefa atualizarTarefa(Long id, TarefaDTO tarefaDTO) {
        Tarefa tarefaExistente = iTarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));

        tarefaExistente.setCodigo(tarefaDTO.getCodigo());
        tarefaExistente.setTitulo(tarefaDTO.getTitulo());
        tarefaExistente.setDescricao(tarefaDTO.getDescricao());
        tarefaExistente.setStatus(tarefaDTO.getStatus());
        tarefaExistente.setPrioridade(tarefaDTO.getPrioridade());
        tarefaExistente.setDataAlteracao(tarefaDTO.getDataAlteracao());
        tarefaExistente.setResponsavel(tarefaDTO.getResponsavel());
        tarefaExistente.setDataConclusao(tarefaDTO.getDataConclusao());

        Tarefa tarefaAtualizada = iTarefaRepository.save(tarefaExistente);
        TarefaDTO.of(tarefaAtualizada);
        return tarefaExistente;
    }

    public TarefaDTO buscarTarefasPorId(Long id) {
        Tarefa tarefa = iTarefaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Tarefa não encontrada"));
        TarefaDTO.of(tarefa);
        return converterEntidadeParaDTO(tarefa);
    }

    public List<TarefaDTO> listarTodasTarefas() {
        List<Tarefa> tarefas = iTarefaRepository.findAll();
        return tarefas.stream()
                .map(this::converterEntidadeParaDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        iTarefaRepository.deleteById(id);
    }

    private TarefaDTO converterEntidadeParaDTO(Tarefa tarefa) {
        TarefaDTO tarefaDTO = new TarefaDTO();
        tarefaDTO.setCodigo(tarefa.getCodigo());
        tarefaDTO.setId(tarefa.getId());
        tarefaDTO.setTitulo(tarefa.getTitulo());
        tarefaDTO.setDescricao(tarefa.getDescricao());
        tarefaDTO.setStatus(tarefa.getStatus());
        tarefaDTO.setPrioridade(tarefa.getPrioridade());
        tarefaDTO.setDataCriacao(tarefa.getDataCriacao());
        tarefaDTO.setDataAlteracao(tarefa.getDataAlteracao());
        tarefaDTO.setDataConclusao(tarefa.getDataConclusao());
        tarefaDTO.setDataConclusao(tarefa.getDataConclusao());
        tarefaDTO.setResponsavel(tarefa.getResponsavel());
        return tarefaDTO;
    }

    private Tarefa converterDTOParaEntidade(TarefaDTO tarefaDTO) {
        Tarefa tarefa = new Tarefa();
        tarefa.setCodigo(tarefaDTO.getCodigo());
        tarefa.setId(tarefaDTO.getId());
        tarefa.setTitulo(tarefaDTO.getTitulo());
        tarefa.setDescricao(tarefaDTO.getDescricao());
        tarefa.setStatus(tarefaDTO.getStatus());
        tarefa.setPrioridade(tarefaDTO.getPrioridade());
        tarefa.setDataCriacao(tarefaDTO.getDataCriacao());
        tarefa.setDataAlteracao(tarefaDTO.getDataAlteracao());
        tarefa.setDataConclusao(tarefaDTO.getDataConclusao());
        tarefa.setResponsavel(tarefaDTO.getResponsavel());
        return tarefa;
    }

}
