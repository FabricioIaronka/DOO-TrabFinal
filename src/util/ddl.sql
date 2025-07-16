drop database estoque_vendas;
-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS estoque_vendas DEFAULT CHARACTER SET utf8mb4;
USE estoque_vendas;

-- Tabela de usuários (login)
CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    nivel ENUM('administrador', 'vendedor', 'estoque') NOT NULL
);

-- Tabela de clientes
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100),
    telefone VARCHAR(20),
    endereco VARCHAR(200),
    cpf VARCHAR(14) UNIQUE
);

-- Tabela de produtos
CREATE TABLE produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao_curta VARCHAR(255),
    preco DECIMAL(10, 2) NOT NULL,
    quantidade INT NOT NULL
);

-- Tabela de vendas (inclui dados da venda e os itens vendidos)
CREATE TABLE venda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_venda INT NOT NULL,
    id_cliente INT,
    id_usuario INT NOT NULL,
    id_produto INT ,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL,
    data DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    FOREIGN KEY (id_cliente) REFERENCES cliente(id),
    FOREIGN KEY (id_usuario) REFERENCES usuario(id),
    FOREIGN KEY (id_produto) REFERENCES produto(id)
);

insert into usuario (nome_usuario, senha, nivel) Values ('admin', 123,'administrador');
SELECT * FROM venda;
