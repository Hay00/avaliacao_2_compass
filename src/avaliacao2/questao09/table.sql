USE teste;

DROP TABLE IF EXISTS produtos;

CREATE TABLE produtos (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    desconto NUMERIC(9, 2),
    dataInicio DATE,
    PRIMARY KEY (id)
);