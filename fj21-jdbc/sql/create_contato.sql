CREATE TABLE Contato (
    ContatoID int  NOT NULL AUTO_INCREMENT,
    Nome varchar(255) NOT NULL,
    Email varchar(255) NOT NULL,
    Endereco varchar(255)NOT NULL,
    DataNascimento DATE NOT NULL,
    PRIMARY KEY (ContatoID) 
);
