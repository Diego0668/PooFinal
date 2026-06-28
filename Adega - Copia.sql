CREATE database Adega;

USE Adega;

CREATE TABLE Produto(
	Id_Produto int NOT NULL PRIMARY KEY,
    DataValidade varchar(50),
    nomeProd varchar(50),
    quantidade int, 
    preco double 
    
);

CREATE TABLE Pessoa (
    Id_Pessoa INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Nome VARCHAR(50),
    CPF VARCHAR(14) UNIQUE
);

CREATE TABLE Funcionario (
    Id_Func INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Cargo VARCHAR(50),
    Senha VARCHAR(50),
    Id_Pessoa INT,
    FOREIGN KEY (Id_Pessoa) REFERENCES Pessoa(Id_Pessoa)
);

CREATE TABLE Cliente (
    Id_Cliente INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Telefone VARCHAR(20),
    Id_Pessoa INT,
    FOREIGN KEY (Id_Pessoa) REFERENCES Pessoa(Id_Pessoa)
);

CREATE TABLE Venda (
    Id_Venda INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    PrecoTotal DOUBLE,
    Id_Cliente INT, 
    Id_Produto INT,
    FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente),
    FOREIGN KEY (Id_Produto) REFERENCES Produto(Id_Produto) 
);

