insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-12', 'José da Silva', '(16)3333-3333', 'jose@yahoo.com.br', 'Avenida São Carlos', 1313, 'Centro', '13560-000');

insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-21', 'Maria da Graça', NULL, 'maria@hotmail.com', 'Avenida São Carlos', 1515, 'Centro', NULL);

insert into festa(nro_contrato, pdf_contrato, preco, inicio, fim, tipo, contratante)
	values('1', NULL, NULL, to_date('25/12/18 19:00', 'dd/mm/yy hh24:mi'), to_date('26/12/18 02:00', 'dd/mm/yy hh24:mi'), 'casamento', '123.123.123-21');

insert into festa(nro_contrato, pdf_contrato, preco, inicio, fim, tipo, contratante)
	values('2', NULL, NULL, to_date('31/12/18 14:00', 'dd/mm/yy hh24:mi'), to_date('31/12/18 19:00', 'dd/mm/yy hh24:mi'), 'aniversario infantil', '123.123.123-21');

insert into festa(nro_contrato, pdf_contrato, preco, inicio, fim, tipo, contratante)
	values('3', NULL, NULL, NULL, NULL, 'aniversario infantil', '123.123.123-21');

insert into festa(nro_contrato, pdf_contrato, preco, inicio, fim, tipo, contratante)
	values('4', NULL, NULL, NULL, NULL, 'casamento', '123.123.123-21');

insert into ConvidadosFesta(festa, nome)
	values('2', 'Lucas');

insert into ConvidadosFesta(festa, nome)
	values('2', 'Matheus');

insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('Carros Disney', 1000, 0);

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'vermelho');

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'preto');

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'branco');

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'amarelo');

insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('VIVA a vida é uma festa', 500, 1);

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida é uma festa', 'vermelho');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida é uma festa', 'amarelo');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida é uma festa', 'rosa');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida é uma festa', 'azul');

insert into AniversarioInfantil(nro_contrato, decoracao)
	values('2', 'Carros Disney');

insert into AniversarioInfantil(nro_contrato, decoracao)
	values('3', 'VIVA a vida é uma festa');

insert into DecoracaoCasamento(tema, qtde_flores)
	values('Country', NULL);

insert into DecoracaoCasamento(tema, qtde_flores)
	values('Retro', 200);

insert into TiposFlores(decoracao, tipo_flor)
	values('Retro', 'girassol vermelho');

insert into TiposFlores(decoracao, tipo_flor)
	values('Retro', 'girassol branco');

insert into Casamento(nro_contrato, decoracao)
	values('1', 'Country');

insert into Casamento(nro_contrato, decoracao)
	values('4', 'Retro'); 