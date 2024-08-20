package com.projetinhoFellas.gerenciador_tarefas.repository;

import com.projetinhoFellas.gerenciador_tarefas.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITarefaRepository extends JpaRepository<Tarefa, Long>, TarefaRepository {

}
