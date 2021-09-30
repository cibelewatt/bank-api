DROP TABLE IF EXISTS TBL_PESSOA;

CREATE TABLE TBL_PESSOA
(
    idPessoa		INT IDENTITY NOT NULL,
    nome			VARCHAR(100) NOT NULL,
    cpf             VARCHAR(12) NOT NULL,
    dataNascimento	DATE NOT NULL,
    CONSTRAINT PK_Pessoa PRIMARY KEY(idPessoa)
);

DROP TABLE IF EXISTS TBL_CONTA;

CREATE TABLE TBL_CONTA
(
    idConta		        INT IDENTITY NOT NULL,
    idPessoa	        INT NOT NULL,
    saldo   	        DECIMAL(15,2) NOT NULL,
    limiteSaqueDiario	DECIMAL(15,2) NOT NULL,
    flagAtivo	        BOOLEAN NOT NULL,
    tipoConta	        INT NOT NULL,
    dataCriacao         DATE NOT NULL,
    CONSTRAINT PK_Conta PRIMARY KEY(idConta),
    CONSTRAINT FK_Pessoa
        FOREIGN KEY (idPessoa)
            REFERENCES TBL_PESSOA(idPessoa)
);

--nessa tabela tem um erro, transacao deveria ter um tipo, mas nao tem
DROP TABLE IF EXISTS TBL_TRANSACAO;

CREATE TABLE TBL_TRANSACAO
(
    idTransacao		INT IDENTITY NOT NULL,
    idConta	        INT NOT NULL,
    valor			DECIMAL(15,2) NOT NULL,
    dataTransacao   DATE NOT NULL,
    CONSTRAINT PK_Transacao PRIMARY KEY(idTransacao),
    CONSTRAINT FK_Conta
        FOREIGN KEY (idConta)
            REFERENCES TBL_CONTA(idConta)
);