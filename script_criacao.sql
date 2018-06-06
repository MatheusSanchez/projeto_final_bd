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
	constraint ck_CPF check(regexp_like(CPF, '[0-9]{3}\.[0-9]{3}\.[0-9]{3}\-[0-9]{2}')),
	constraint ck_telefone check(regexp_like(telefone, '\([0-9]{2}\)[0-9]{4,5}\-[0-9]{4}')),
	constraint ck_cep check(regexp_like(cep, '[0-9]{5}\-[0-9]{3}'))
);

create table Festa(
	nro_contrato varchar2(25) not null,
	PDF_contrato varchar2(50),
	preco number(7, 2),
	inicio date, 
	fim date,
	tipo varchar2(20) not null,
	contratante char(14) not null,

	constraint pk_festa primary key (nro_contrato),
	constraint fk_festa foreign key (contratante)
		references Contratante(cpf)
		on delete set null,
	constraint ck_tipo check (upper(tipo) in ('CASAMENTO', 'ANIVERSARIO INFANTIL')),
	constraint ck_data check (inicio < fim)
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