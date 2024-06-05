-- Script de criação do banco de dados e tabelas

-- Criar o banco de dados
CREATE DATABASE IF NOT EXISTS livros;
USE meu_banco_de_dados;

-- Criar tabela livro_genero
CREATE TABLE IF NOT EXISTS livro_genero (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            descricao TEXT NOT NULL
);

-- Criar tabela livro
CREATE TABLE IF NOT EXISTS livro (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     titulo TEXT NOT NULL,
                                     autor TEXT NOT NULL,
                                     isbn TEXT NOT NULL,
                                     genero INT NOT NULL,
                                     FOREIGN KEY (genero) REFERENCES livro_genero(id)
);

-- Criar tabela usuario_grupo
CREATE TABLE IF NOT EXISTS usuario_grupo (
                                             id INT AUTO_INCREMENT PRIMARY KEY,
                                             descricao TEXT NOT NULL
);

-- Criar tabela usuario
CREATE TABLE IF NOT EXISTS usuario (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       cpf TEXT NOT NULL,
                                       email TEXT NOT NULL,
                                       grupo INT NOT NULL,
                                       FOREIGN KEY (grupo) REFERENCES usuario_grupo(id)
);

-- Criar tabela usuario_livro_avaliacao
CREATE TABLE IF NOT EXISTS usuario_livro_avaliacao (
                                                       id INT AUTO_INCREMENT,
                                                       usuario INT NOT NULL,
                                                       livro INT NOT NULL,
                                                       comentario TEXT NOT NULL,
                                                       nota DECIMAL(3,2) NOT NULL,
                                                       PRIMARY KEY (id, usuario, livro),
                                                       FOREIGN KEY (usuario) REFERENCES usuario(id),
                                                       FOREIGN KEY (livro) REFERENCES livro(id)
);

-- Criar tabela usuario_livro_comentario
CREATE TABLE IF NOT EXISTS usuario_livro_comentario (
                                                        id INT AUTO_INCREMENT,
                                                        id_usuario_livro_avaliacao INT NOT NULL,
                                                        usuario INT NOT NULL,
                                                        comentario TEXT NOT NULL,
                                                        PRIMARY KEY (id, usuario, id_usuario_livro_avaliacao),
                                                        FOREIGN KEY (id_usuario_livro_avaliacao) REFERENCES usuario_livro_avaliacao(id),
                                                        FOREIGN KEY (usuario) REFERENCES usuario(id)
);
