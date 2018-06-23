create table Contratante(
	CPF char(14) not null,
	nome varchar2(50),
	telefone varchar2(14),
	email varchar2(25), 
	rua varchar2(50),
	numero number(5),
	bairro varchar2(25),
	cep char(9),

	constraint pk_contratante primary key (CPF),
	-- checando a mascara do cpf
	constraint ck_CPF check(regexp_like(CPF, '[0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}')),
	-- checando a mascara do telefone
	constraint ck_telefone check(regexp_like(telefone, '\([0-9]{2}\)[0-9]{4,5}\-[0-9]{4}')),
	-- checando a mascara do cep
	constraint ck_cep check(regexp_like(cep, '[0-9]{5}\-[0-9]{3}'))
);

create table Festa(
	nro_contrato varchar2(25) not null,
	PDF_contrato varchar2(50),
	preco number(7, 2),
	data date,
	tipo varchar2(20) not null,
	contratante char(14) not null,

	constraint pk_festa primary key (nro_contrato),
	constraint fk_festa foreign key (contratante)
		references Contratante(cpf)
		on delete set null,
	-- checando se o tipo eh valido
	constraint ck_tipo check (upper(tipo) in ('CASAMENTO', 'ANIVERSARIO INFANTIL'))
);

create table ConvidadosFesta(
	festa varchar2(25) not null,
	nome varchar2(50) not null,

	constraint pk_ConvidadosFesta primary key (festa, nome),
	constraint fk_ConvidadosFesta foreign key (festa)
		references Festa(nro_contrato)
		on delete cascade
);

create table DecoracaoInfantil(
	tema varchar2(50) not null,
	qtde_baloes number(5),
	pinata number(1),

	constraint pk_DecoracaoInfantil primary key (tema),
	-- pinata eh um bool
	constraint ck_pinata check (pinata in (0, 1))
);

create table CorBaloes(
	decoracao varchar2(50),
	cor varchar2(25),

	constraint pk_CorBaloes primary key (decoracao, cor),
	constraint fk_CorBaloes foreign key (decoracao)
		references DecoracaoInfantil(tema)
		on delete cascade
);

create table AniversarioInfantil(
	nro_contrato varchar2(25) not null,
	decoracao varchar2(50),

	constraint pk_AniversarioInfantil primary key (nro_contrato),
	constraint fk_AniversarioInfantil1 foreign key (nro_contrato)
		references Festa(nro_contrato)
		on delete cascade,
	constraint fk_AniversarioInfantil2 foreign key (decoracao)
		references DecoracaoInfantil(tema)
		on delete set null
);

create table DecoracaoCasamento(
	tema varchar2(50) not null,
	qtde_flores number(5),

	constraint pk_DecoracaoCasamento primary key (tema)
);

create table TiposFlores(
	decoracao varchar2(50),
	tipo_flor varchar2(25),

	constraint pk_TiposFlores primary key (decoracao, tipo_flor),
	constraint fk_TiposFlores foreign key (decoracao)
		references DecoracaoCasamento(tema)
		on delete cascade
);

create table Casamento(
	nro_contrato varchar2(25) not null,
	decoracao varchar2(50),

	constraint pk_Casamento primary key (nro_contrato),
	constraint fk_Casamento1 foreign key (nro_contrato)
		references Festa(nro_contrato)
		on delete cascade,
	constraint fk_Casamento2 foreign key (decoracao)
		references DecoracaoCasamento(tema)
		on delete set null
);

create table EmpresaCriterio(
	empresa char(18) not null,
	tipo varchar2(10) not null,

	constraint pk_EmpresaCriterio primary key (empresa),
	-- checando se o tipo da empresa eh valido
	constraint ck_EmpresaCriterio check (upper(tipo) in ('SEGURANCA', 'FOTOGRAFIA')),
	-- checando a mascara do cnpj
	constraint ck_empresa check (regexp_like(empresa, '[0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}\-[0-9]{2}'))
);

create table EmpresaSeguranca(
	CNPJ char(18) not null,
	nome varchar2(50),

	constraint pk_EmpresaSeguranca primary key (CNPJ),
	constraint fk_EmpresaSeguranca foreign key (CNPJ)
		references EmpresaCriterio(empresa)
		on delete cascade
);

create table ContratoSeguranca(
	nro_contrato varchar2(25) not null,
	empresa_seguranca char(18) not null,
	casamento varchar2(25) not null,
	preco number(7, 2),
	PDF_contrato varchar2(50),

	constraint pk_ContratoSeguranca primary key (nro_contrato),
	constraint uk_ContratoSeguranca unique (casamento),
	constraint fk_ContratoSeguranca1 foreign key (empresa_seguranca)
		references EmpresaSeguranca(CNPJ)
		on delete cascade,
	constraint fk_ContratoSeguranca2 foreign key (casamento)
		references Casamento(nro_contrato)
		on delete cascade
);

create table FuncionarioCriterio(
	funcionario char(14) not null,
	tipo char(9) not null,

	constraint pk_FuncionarioCriterio primary key (funcionario),
	-- checando se o tipo do funcionario eh valido
	constraint ck_tipo2 check (upper(tipo) in ('SEGURANCA', 'FOTOGRAFO')),
	-- checando a mascara do cpf
	constraint ck_funcionario check(regexp_like(funcionario, '[0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}'))
);

create table Seguranca(
	CPF char(14) not null,
	nome varchar2(50),

	constraint pk_Seguranca primary key (CPF),
	constraint fk_Seguranca foreign key (CPF)
		references FuncionarioCriterio(funcionario)
		on delete cascade
);

create table ServicoSeguranca(
	data date not null,
	seguranca char(14) not null, 
	contrato_seguranca varchar2(25) not null,

	constraint pk_ServicoSeguranca primary key (data, seguranca),
	constraint fk_ServicoSeguranca1 foreign key (seguranca)
		references Seguranca(CPF)
		on delete cascade,
	constraint fk_ServicoSeguranca2 foreign key (contrato_seguranca)
		references ContratoSeguranca(nro_contrato)
		on delete cascade
);

create table EmpresaFotografia(
	CNPJ char(18) not null,
	nome varchar2(50),

	constraint pk_EmpresaFotografia primary key (CNPJ),
	constraint fk_EmpresaFotografia foreign key (CNPJ)
		references EmpresaCriterio(empresa)
		on delete cascade
);

create table ContratoFotografia(
	nro_contrato varchar2(25) not null,
	empresa_fotografia char(18) not null,
	festa varchar2(25) not null,
	preco number(7, 2),
	PDF_contrato varchar2(50),
	qtde_fotos number(4),

	constraint pk_ContratoFotografo primary key (nro_contrato),
	constraint uk_ContratoFotografo unique (festa),
	constraint fk_ContratoFotografia1 foreign key (empresa_fotografia)
		references EmpresaFotografia(CNPJ)
		on delete cascade,
	constraint fk_ContratoFotografia2 foreign key (festa)
		references Festa(nro_contrato)
		on delete cascade
);

create table Fotografo(
	CPF char(14) not null,
	nome varchar2(50),

	constraint pk_Fotografo primary key (CPF),
	constraint fk_Fotografo foreign key (CPF)
		references FuncionarioCriterio(funcionario)
		on delete cascade
);

create table ServicoFotografo(
	data date not null,
	fotografo char(14) not null, 
	contrato_fotografia varchar2(25) not null,

	constraint pk_ServicoFotografia primary key (data, fotografo),
	constraint fk_ServicoFotografia1 foreign key (fotografo)
		references fotografo(CPF)
		on delete cascade,
	constraint fk_ServicoFotografia2 foreign key (contrato_fotografia)
		references ContratoFotografia(nro_contrato)
		on delete cascade
);

CREATE TABLE ATRACAOCRITERIO (
	ATRACAO VARCHAR2(50) NOT NULL,
	TIPO VARCHAR2(8),

	CONSTRAINT PK_ATRACAOCRITERIO PRIMARY KEY (ATRACAO),
	-- checando se o tipo da atracao eh valido
	CONSTRAINT CK_TIPO3 CHECK (upper(TIPO) IN ('ANIMADOR', 'BANDA'))
);

CREATE TABLE ANIMADOR (
	NOME VARCHAR2(50) NOT NULL,
	TELEFONE VARCHAR2(14),
	EMAIL VARCHAR2(50),
	TIPO_ANIMACAO VARCHAR2(50),

	CONSTRAINT PK_ANIMADOR PRIMARY KEY (NOME),
	CONSTRAINT FK_ANIMADOR FOREIGN KEY (NOME) 
		REFERENCES ATRACAOCRITERIO(ATRACAO) 
		ON DELETE CASCADE,
	-- checando a mascara do telefone
	CONSTRAINT CK_ANIMADOR_TELEFONE CHECK(REGEXP_LIKE(TELEFONE, '\([0-9]{2}\)[0-9]{4,5}\-[0-9]{4}'))
);

CREATE TABLE BANDA (
	NOME VARCHAR2(50) NOT NULL,
	TELEFONE VARCHAR2(14),
	EMAIL VARCHAR2(50),

	CONSTRAINT PK_BANDA PRIMARY KEY (NOME),
	CONSTRAINT FK_BANDA FOREIGN KEY (NOME) 
		REFERENCES ATRACAOCRITERIO(ATRACAO) 
		ON DELETE CASCADE,
	-- checando a mascara do telefone
	CONSTRAINT CK_BANDA_TELEFONE CHECK(REGEXP_LIKE(TELEFONE, '\([0-9]{2}\)[0-9]{4,5}\-[0-9]{4}'))
);

CREATE TABLE GENEROSMUSICAIS (
	BANDA VARCHAR2(50) NOT NULL,
	GENERO VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_GENEROSMUSICAIS PRIMARY KEY (BANDA, GENERO),
	CONSTRAINT FK_GENEROSMUSICAIS FOREIGN KEY (BANDA)
		REFERENCES BANDA(NOME)
		ON DELETE CASCADE
);

CREATE TABLE INTEGRANTES (
	BANDA VARCHAR2(50) NOT NULL,
	INTEGRANTE VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_INTEGRANTES PRIMARY KEY (BANDA, INTEGRANTE),
	CONSTRAINT FK_INTEGRANTES FOREIGN KEY (BANDA)
		REFERENCES BANDA(NOME)
		ON DELETE CASCADE
);

CREATE TABLE CONTRATOANIMADOR (
	DATA DATE NOT NULL,
	ANIMADOR VARCHAR2(50) NOT NULL,
	ANIVERSARIO_INFANTIL VARCHAR2(25) NOT NULL,

	CONSTRAINT PK_CONTRATOANIMADOR PRIMARY KEY (DATA, ANIMADOR),
	CONSTRAINT FK_CONTRATOANIMADOR1 FOREIGN KEY (ANIMADOR)
		REFERENCES ANIMADOR(NOME)
		ON DELETE CASCADE,
	CONSTRAINT FK_CONTRATOANIMADOR2 FOREIGN KEY (ANIVERSARIO_INFANTIL)
		REFERENCES ANIVERSARIOINFANTIL(NRO_CONTRATO)
		ON DELETE CASCADE,
	-- um aniversario so aparece uma vez na tabela de contrato
	CONSTRAINT UN_ANIVERSARIOINFANTIL UNIQUE(ANIVERSARIO_INFANTIL)
);

CREATE TABLE CONTRATOBANDA (
	DATA DATE NOT NULL,
	BANDA VARCHAR2(50) NOT NULL,
	CASAMENTO VARCHAR2(25) NOT NULL,

	CONSTRAINT PK_CONTRATOBANDA PRIMARY KEY (DATA, BANDA),
	CONSTRAINT FK_CONTRATOBANDA1 FOREIGN KEY (BANDA)
		REFERENCES BANDA(NOME)
		ON DELETE CASCADE,
	CONSTRAINT FK_CONTRATOBANDA2 FOREIGN KEY (CASAMENTO)
		REFERENCES CASAMENTO(NRO_CONTRATO)
		ON DELETE CASCADE,
	-- um casamento so aparece uma vez na tabela de contrato
	CONSTRAINT UN_CONTRATOBANDA UNIQUE (CASAMENTO)
);

CREATE TABLE LINEUP (
	DATA DATE NOT NULL,
	BANDA VARCHAR2(50) NOT NULL,
	MUSICA VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_LINEUP PRIMARY KEY (DATA, BANDA, MUSICA),
	CONSTRAINT FK_LINEUP FOREIGN KEY (DATA, BANDA)
		REFERENCES CONTRATOBANDA(DATA, BANDA)
		ON DELETE CASCADE
);

CREATE TABLE EQUIPAMENTOS (
	DATA DATE NOT NULL,
	BANDA VARCHAR2(50) NOT NULL,
	EQUIPAMENTO VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_EQUIPAMENTOS PRIMARY KEY (DATA, BANDA, EQUIPAMENTO),
	CONSTRAINT FK_EQUIPAMENTOS FOREIGN KEY (DATA, BANDA)
		REFERENCES CONTRATOBANDA(DATA, BANDA)
		ON DELETE CASCADE
);

CREATE TABLE BUFFETCRITERIO (
	BUFFET CHAR(18) NOT NULL,
	TIPO VARCHAR2(9) NOT NULL,

	CONSTRAINT PK_BUFFETCRITERIO PRIMARY KEY (BUFFET),
	-- checando a mascara do cpnj
	CONSTRAINT CK_BUFFET CHECK (REGEXP_LIKE(BUFFET, '[0-9]{2}\.[0-9]{3}\.[0-9]{3}\/[0-9]{4}\-[0-9]{2}')),
	-- checando se o tipo do buffet eh valido
	CONSTRAINT CK_BUFFETCRITERIO CHECK (upper(TIPO) IN ('INFANTIL', 'CASAMENTO'))
);

CREATE TABLE BUFFETINFANTIL (
	CNPJ CHAR(18) NOT NULL,
	NOME VARCHAR2(50),
	RUA VARCHAR2(50),
	NUMERO NUMBER(5),
	CEP CHAR(9),
	CAPACIDADE NUMBER(4),

	CONSTRAINT PK_BUFFETINFANTIL PRIMARY KEY (CNPJ),
	CONSTRAINT FK_BUFFETINFANTIL FOREIGN KEY (CNPJ)
		REFERENCES BUFFETCRITERIO (BUFFET)
		ON DELETE CASCADE,
	-- capacidade deve ser positiva
	CONSTRAINT CK_BUFFETINFANTIL_CAPACIDADE CHECK (CAPACIDADE > 0),
	-- checando a masara do cep
	CONSTRAINT CK_CEP2 CHECK (REGEXP_LIKE(CEP, '[0-9]{5}\-[0-9]{3}'))
);

CREATE TABLE BRINQUEDOS (
	BUFFET_INFANTIL CHAR(18) NOT NULL,
	BRINQUEDO VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_BRINQUEDOS PRIMARY KEY (BUFFET_INFANTIL, BRINQUEDO),
	CONSTRAINT FK_BRINQUEDOS FOREIGN KEY (BUFFET_INFANTIL)
		REFERENCES BUFFETINFANTIL(CNPJ)
		ON DELETE CASCADE
);

CREATE TABLE BUFFETCASAMENTO (
	CNPJ CHAR(18) NOT NULL,
	NOME VARCHAR2(50),
	RUA VARCHAR2(50),
	NUMERO NUMBER(5),
	CEP CHAR(9),
	CAPACIDADE NUMBER(4),

	CONSTRAINT PK_BUFFETCASAMENTO PRIMARY KEY (CNPJ),
	CONSTRAINT FK_BUFFETCASAMENTO FOREIGN KEY (CNPJ)
		REFERENCES BUFFETCRITERIO(BUFFET) 
		ON DELETE CASCADE,
	-- checando a masara do cep
	CONSTRAINT CK_BUFFETCASAMENTO_CEP CHECK(REGEXP_LIKE(CEP, '[0-9]{5}\-[0-9]{3}')),
	-- capacidade deve ser positiva
	CONSTRAINT CK_BUFFETCASAMENTO_CAPACIDADE CHECK (CAPACIDADE > 0)
);

CREATE TABLE CONTRATOBUFFETINFANTIL (
	DATA DATE NOT NULL,
	BUFFET_INFANTIL CHAR(18) NOT NULL,
	ANIVERSARIO_INFANTIL VARCHAR2(25) NOT NULL,
	PRECO NUMBER(4),

	CONSTRAINT PK_CONTRATOBUFFETINFANTIL PRIMARY KEY (DATA, BUFFET_INFANTIL),
	CONSTRAINT FK_CONTRATOBUFFETINFANTIL FOREIGN KEY (BUFFET_INFANTIL)
		REFERENCES BUFFETINFANTIL(CNPJ)
		ON DELETE CASCADE,
	-- aniversario infantil so pode aparecer uma vez contratando um buffet
	CONSTRAINT UN_CONTRATOBI_AI UNIQUE(ANIVERSARIO_INFANTIL),
	-- preco deve ser positivo
	CONSTRAINT CK_CONTRATOBI_PRECO CHECK (PRECO > 0)
);

CREATE TABLE CARDAPIOINFANTIL (
	DATA DATE NOT NULL,
	BUFFET_INFANTIL CHAR(18) NOT NULL,
	PRATO VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_CARDAPIOINFANTIL PRIMARY KEY (DATA, BUFFET_INFANTIL, PRATO),
	CONSTRAINT FK_CARDAPIOINFANTIL FOREIGN KEY (DATA, BUFFET_INFANTIL)
		REFERENCES CONTRATOBUFFETINFANTIL(DATA, BUFFET_INFANTIL)
		ON DELETE CASCADE
);

CREATE TABLE CONTRATOBUFFETCASAMENTO (
	DATA DATE NOT NULL,
	BUFFET_CASAMENTO CHAR(18) NOT NULL,
	CASAMENTO VARCHAR2(25) NOT NULL,
	PRECO NUMBER(4),

	CONSTRAINT PK_CONTRATOBUFFETCASAMENTO PRIMARY KEY (DATA, BUFFET_CASAMENTO),
	CONSTRAINT FK_CONTRATOBUFFETCASAMENTO FOREIGN KEY (BUFFET_CASAMENTO)
		REFERENCES BUFFETCASAMENTO(CNPJ)
		ON DELETE CASCADE,
	-- casamento so pode aparecer uma vez contratando um buffet
	CONSTRAINT UN_CASAMENTO UNIQUE(CASAMENTO),
	-- preco deve ser positivo
	CONSTRAINT CK_PRECO CHECK (PRECO > 0)
);

CREATE TABLE CARDAPIOCASAMENTO (
	DATA DATE NOT NULL,
	BUFFET_CASAMENTO CHAR(18) NOT NULL,
	PRATO VARCHAR2(50) NOT NULL,

	CONSTRAINT PK_CARDAPIOCASAMENTO PRIMARY KEY (DATA, BUFFET_CASAMENTO, PRATO),
	CONSTRAINT FK_CARDAPIOCASAMENTO FOREIGN KEY (DATA, BUFFET_CASAMENTO)
		REFERENCES CONTRATOBUFFETCASAMENTO(DATA, BUFFET_CASAMENTO)
		ON DELETE CASCADE
);