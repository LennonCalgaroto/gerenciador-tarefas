package com.projetinhoFellas.gerenciador_tarefas.controller;

import com.projetinhoFellas.gerenciador_tarefas.dto.TarefaDTO;
import com.projetinhoFellas.gerenciador_tarefas.service.TarefaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<AlteracaoStatus> create(@RequestBody TarefaDTO tarefaDTO) {
        log.debug("Salvando Tarefa [{}]", tarefaDTO);

        this.tarefaService.criarTarefa(tarefaDTO);
        return new ResponseEntity<>(new AlteracaoStatus(HttpStatus.CREATED.value(), "Tarefa criada com sucesso!"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlteracaoStatus> update(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
        log.debug("Editando Tarefa [{}]", tarefaDTO);

        this.tarefaService.atualizarTarefa(id, tarefaDTO);
        return new ResponseEntity<>(new AlteracaoStatus(HttpStatus.OK.value(), "Tarefa atualizado com sucesso!"), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> FindAll() {
        List<TarefaDTO> tarefas = tarefaService.listarTodasTarefas();
        return new ResponseEntity<>(tarefas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaDTO> findById(@PathVariable Long id) {
        TarefaDTO tarefaDTO = tarefaService.buscarTarefasPorId(id);
        return new ResponseEntity<>(tarefaDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AlteracaoStatus> delete(@PathVariable Long id) {
        log.debug("Deletando Tarefa [{}]", id);

        this.tarefaService.deleteById(id);
        return new ResponseEntity<>(new AlteracaoStatus(HttpStatus.OK.value(), "Tarefa deletada com sucesso!"), HttpStatus.OK);
    }
}
