package com.projetinhoFellas.gerenciador_tarefas.repository;

import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TarefaRepository {

    @Autowired
    private ITarefaRepository IrepositoryTarefa;

    public Tarefa save(Tarefa tarefa) {
        return IrepositoryTarefa.save(tarefa);
    }

    public Optional<Tarefa> findbyId(Long id) {
        return IrepositoryTarefa.findById(id);
    }

    public List<Tarefa> findAll() {
        return IrepositoryTarefa.findAll();
    }

    public void deleteById(Long id) {
        IrepositoryTarefa.deleteById(id);
    }
}
