insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-12', 'JosÃ© da Silva', '(16)3333-3333', 'jose@yahoo.com.br', 'Avenida SÃ£o Carlos', 1313, 'Centro', '13560-000');

insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('462.078.168-11', 'Matheus Turci', '(11)1111-1111', 'turcitheus@gmail.com', 'Avenida 25 de Março', 6666, 'Centro', '45236-699');

insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-21', 'Maria da GraÃ§a', NULL, 'maria@hotmail.com', 'Avenida SÃ£o Carlos', 1515, 'Centro', NULL);

insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)
	values('1', NULL, NULL, to_date('25/12/18 19:00', 'dd/mm/yy hh24:mi'), 'casamento', '123.123.123-21');
    
insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)
	values('5', NULL, 2000.50, to_date('01/01/19 03:00', 'dd/mm/yy hh24:mi'), 'casamento', '462.078.168-11');

insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)
	values('2', NULL, NULL, to_date('31/12/18 14:00', 'dd/mm/yy hh24:mi'), 'aniversario infantil', '123.123.123-21');

insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)
	values('3', NULL, NULL, NULL, 'aniversario infantil', '123.123.123-21');

insert into festa(nro_contrato, pdf_contrato, preco, data, tipo, contratante)
	values('4', NULL, NULL, NULL, 'casamento', '123.123.123-21');

insert into ConvidadosFesta(festa, nome)
	values('2', 'Lucas');

insert into ConvidadosFesta(festa, nome)
	values('2', 'Matheus');
    
insert into ConvidadosFesta(festa, nome)
	values('5', 'Lucas Turci');   
    
insert into ConvidadosFesta(festa, nome)
	values('5', 'Barbara Sobrenome'); 
    
insert into ConvidadosFesta(festa, nome)
	values('5', 'Carol da Barbara');    

insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('Carros Disney', 1000, 0);
    
insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('Princesas Disney', 3, 1);

insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('Transformers', 200, 1);   
    
insert into DecoracaoInfantil(tema, qtde_baloes, pinata)
	values('VIVA a vida é uma festa', 500, 1);    

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'vermelho');

insert into CorBaloes(decoracao, cor)
	values('Transformers', 'preto');

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'branco');

insert into CorBaloes(decoracao, cor)
	values('Princesas Disney', 'Rosa Estranho');

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
    
insert into DecoracaoCasamento(tema, qtde_flores)
	values('Anos 80', 750);

insert into TiposFlores(decoracao, tipo_flor)
	values('Anos 80', 'Rosas Vermelhas');

insert into TiposFlores(decoracao, tipo_flor)
	values('Anos 80', 'Lírios ');    
    
insert into DecoracaoCasamento(tema, qtde_flores)
	values('Jazz', 300); 
    
insert into TiposFlores(decoracao, tipo_flor)
	values('Jazz', 'Rosas Brancas');

insert into TiposFlores(decoracao, tipo_flor)
	values('Jazz', 'Lírios ');        
    
insert into DecoracaoCasamento(tema, qtde_flores)
	values('Rústico', 173);  
    
 insert into TiposFlores(decoracao, tipo_flor)
	values('Rústico', 'Flores do Campo');

insert into TiposFlores(decoracao, tipo_flor)
	values('Rústico', 'Girassois  ');        
       
insert into Casamento(nro_contrato, decoracao)
	values('1', 'Country');

insert into Casamento(nro_contrato, decoracao)
	values('4', 'Retro'); 

insert into Casamento(nro_contrato, decoracao)
	values('5', 'Rústico');
    
/* trocar a expressao regular de animador,banda antes da inserção
insert into Animador(nome, telefone,email)
	values('João Malabarista', '(11)1111-1111','joao@vaicairnaovainao.com'); 
    
insert into Animador(nome, telefone,email)
	values('João Malabarista', '(11)1111-1111','joao@vaicairnaovainao.com');
    
insert into Animador(nome, telefone,email)
	values('João Malabarista', '(11)1111-1111','joao@vaicairnaovainao.com');
    
*/ 

insert into EmpresaCriterio(empresa, tipo) values('28.246.015/0001-53', 'SEGURANCA');  
insert into EmpresaCriterio(empresa, tipo) values('21.245.025/0001-48', 'SEGURANCA'); 
insert into EmpresaCriterio(empresa, tipo) values('43.456.123/0001-58', 'SEGURANCA'); 

insert into EmpresaCriterio(empresa, tipo) values('12.246.015/0001-53', 'FOTOGRAFIA');  
insert into EmpresaCriterio(empresa, tipo) values('34.246.015/0001-53', 'FOTOGRAFIA'); 
insert into EmpresaCriterio(empresa, tipo) values('56.246.015/0001-53', 'FOTOGRAFIA'); 	

insert into EmpresaSeguranca(cnpj, nome) values('28.246.015/0001-53', 'Grupo Souza Lima');
insert into EmpresaSeguranca(cnpj, nome) values('21.245.025/0001-48', 'Grupo Sanchez Proteções');
insert into EmpresaSeguranca(cnpj, nome) values('43.456.123/0001-58', 'Grupo de Proteção contra Terroristas');
    
insert into EmpresaFotografia(cnpj, nome) values('12.246.015/0001-53', 'Carol da B. fotografias e edições');
insert into EmpresaFotografia(cnpj, nome) values('34.246.015/0001-53', 'Momentos Fotógrafos');
insert into EmpresaFotografia(cnpj, nome) values('56.246.015/0001-53', 'Grupo de Proteção contra Terroristas');

insert into FuncionarioCriterio(funcionario, tipo) values('513.731.800-05', 'SEGURANCA');  
insert into FuncionarioCriterio(funcionario, tipo) values('446.823.720-17', 'SEGURANCA');  
insert into FuncionarioCriterio(funcionario, tipo) values('925.050.230-34', 'SEGURANCA');  

insert into FuncionarioCriterio(funcionario, tipo) values('111.878.540-18', 'FOTOGRAFO');  
insert into FuncionarioCriterio(funcionario, tipo) values('805.439.600-72', 'FOTOGRAFO');  
insert into FuncionarioCriterio(funcionario, tipo) values('205.513.460-43', 'FOTOGRAFO'); 	

insert into Seguranca(Cpf, nome) values('513.731.800-05', 'Otávio Costa Barros');  
insert into Seguranca(Cpf, nome) values('446.823.720-17', 'Leonardo Carvalho Rocha');  
insert into Seguranca(Cpf, nome) values('925.050.230-34', 'Diego Azevedo Ferreira'); 

insert into Fotografo(Cpf, nome) values('111.878.540-18', 'Diego Azevedo Rocha');  
insert into Fotografo(Cpf, nome) values('805.439.600-72', 'Otávio Costa Carvalho');  
insert into Fotografo(Cpf, nome) values('205.513.460-43', 'Leonardo Barros Ferreira'); 

insert into ContratoSeguranca(nro_contrato, empresa_seguranca,casamento,preco,pdf_contrato) 
		values('1','28.246.015/0001-53','1',250.02,null);  

insert into ContratoSeguranca(nro_contrato, empresa_seguranca,casamento,preco,pdf_contrato) 
		values('2','21.245.025/0001-48','4',1000.02,null); 

insert into ContratoSeguranca(nro_contrato, empresa_seguranca,casamento,preco,pdf_contrato) 
		values('3','43.456.123/0001-58','5',768.45,null); 

insert into ServicoSeguranca(data, seguranca,contrato_seguranca) values(to_date('24/06/18', 'dd/mm/yy'),'513.731.800-05','1'); 	
insert into ServicoSeguranca(data, seguranca,contrato_seguranca) values(to_date('24/06/18', 'dd/mm/yy'),'446.823.720-17','2');
insert into ServicoSeguranca(data, seguranca,contrato_seguranca) values(to_date('24/06/18', 'dd/mm/yy'),'925.050.230-34','3');	
	
insert into ContratoFotografia(nro_contrato, empresa_fotografia,festa,preco,pdf_contrato,qtde_fotos) values('1','12.246.015/0001-53','1',250.02,null,3);  
insert into ContratoFotografia(nro_contrato, empresa_fotografia,festa,preco,pdf_contrato,qtde_fotos) values('2','34.246.015/0001-53','2',1000.02,null,45); 
insert into ContratoFotografia(nro_contrato, empresa_fotografia,festa,preco,pdf_contrato,qtde_fotos) values('3','56.246.015/0001-53','3',768.45,null,45); 

insert into ServicoFotografo(data,fotografo,contrato_fotografia) values(to_date('15/09/19', 'dd/mm/yy'),'111.878.540-18','1');
insert into ServicoFotografo(data,fotografo,contrato_fotografia) values(to_date('15/09/19', 'dd/mm/yy'),'805.439.600-72','2');	
insert into ServicoFotografo(data,fotografo,contrato_fotografia) values(to_date('15/09/19', 'dd/mm/yy'),'205.513.460-43','3');		
