CREATE TABLE tarefa
(
    id             BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    titulo         VARCHAR(255),
    descricao      VARCHAR(255),
    data_criacao   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    data_alteracao TIMESTAMP,
    data_conclusao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status         VARCHAR(50) DEFAULT 'PENDENTE',
    prioridade     VARCHAR(50) DEFAULT 'MEDIA',
    responsavel    VARCHAR(255),
    CONSTRAINT pk_tarefa PRIMARY KEY (id)
);