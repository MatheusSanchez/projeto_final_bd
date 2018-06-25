insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-12', 'José da Silva', '(16)3333-3333', 'jose@yahoo.com.br', 'Avenida São Carlos', 1313, 'Centro', '13560-000');

insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('462.078.168-11', 'Matheus Turci', '(11)1111-1111', 'turcitheus@gmail.com', 'Avenida 25 de Mar�o', 6666, 'Centro', '45236-699');

insert into Contratante(CPF, nome, telefone, email, rua, numero, bairro, cep)
	values('123.123.123-21', 'Maria da Graça', NULL, 'maria@hotmail.com', 'Avenida São Carlos', 1515, 'Centro', NULL);

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
	values('VIVA a vida � uma festa', 500, 1);    

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'vermelho');

insert into CorBaloes(decoracao, cor)
	values('Transformers', 'preto');

insert into CorBaloes(decoracao, cor)
	values('Carros Disney', 'branco');

insert into CorBaloes(decoracao, cor)
	values('Princesas Disney', 'Rosa Estranho');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida � uma festa', 'vermelho');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida � uma festa', 'amarelo');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida � uma festa', 'rosa');

insert into CorBaloes(decoracao, cor)
	values('VIVA a vida � uma festa', 'azul');
    
insert into AniversarioInfantil(nro_contrato, decoracao)
	values('2', 'Carros Disney');

insert into AniversarioInfantil(nro_contrato, decoracao)
	values('3', 'VIVA a vida � uma festa');

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
	values('Anos 80', 'L�rios ');    
    
insert into DecoracaoCasamento(tema, qtde_flores)
	values('Jazz', 300); 
    
insert into TiposFlores(decoracao, tipo_flor)
	values('Jazz', 'Rosas Brancas');

insert into TiposFlores(decoracao, tipo_flor)
	values('Jazz', 'L�rios ');        
    
insert into DecoracaoCasamento(tema, qtde_flores)
	values('R�stico', 173);  
    
 insert into TiposFlores(decoracao, tipo_flor)
	values('R�stico', 'Flores do Campo');

insert into TiposFlores(decoracao, tipo_flor)
	values('R�stico', 'Girassois  ');        
       
insert into Casamento(nro_contrato, decoracao)
	values('1', 'Country');

insert into Casamento(nro_contrato, decoracao)
	values('4', 'Retro'); 

insert into Casamento(nro_contrato, decoracao)
	values('5', 'R�stico');
	
insert into atracaoCriterio(atracao,tipo)values('Bande Ó','BANDA');
insert into atracaoCriterio(atracao,tipo)values('Guns n Rosas','BANDA');
insert into atracaoCriterio(atracao,tipo)values('MetalzãoPesadão','BANDA');

insert into Banda(nome, telefone,email)
	values('Bande Ó', '(11)1111-1111','banda@o.com'); 
	
insert into Banda(nome, telefone,email)
	values('Guns n Rosas', '(11)1111-5566','patience@hotmail.com'); 
	
insert into Banda(nome, telefone,email)
	values('MetalzãoPesadão', '(11)4566-5454','one@naoseioutra.com'); 	
	
insert into generosMusicais (banda,genero) values ('MetalzãoPesadão','Funk');
insert into generosMusicais (banda,genero) values ('MetalzãoPesadão','Forró');	
insert into generosMusicais (banda,genero) values ('Guns n Rosas','Rock');
insert into generosMusicais (banda,genero) values ('Guns n Rosas','Brega');	

insert into atracaoCriterio(atracao,tipo)values('Patati Patata','ANIMADOR');
insert into atracaoCriterio(atracao,tipo)values('Palhaços Malucos de NovaYork','ANIMADOR');
insert into atracaoCriterio(atracao,tipo)values('Silvio dos Santos','ANIMADOR');

insert into integrantes(banda,integrante) values ('Guns n Rosas','Matheus Sanchez');
insert into integrantes(banda,integrante) values ('Guns n Rosas','Turci Sanchez');
insert into integrantes(banda,integrante) values ('Guns n Rosas','Carol Sanchez');
insert into integrantes(banda,integrante) values ('Guns n Rosas','Barbara Sanchez');

insert into Animador(nome, telefone,email)
	values('Patati Patata', '(11)1111-1111','patata@patati.com'); 
	
insert into Animador(nome, telefone,email)
	values('Palhaços Malucos de NovaYork', '(11)1234-1234','crazy@patati.com');
	
insert into Animador(nome, telefone,email)
	values('Silvio dos Santos', '(11)5555-6666','maoe@aviaozinho.com');
    
insert into contratoAnimador(DATA,animador,aniversario_infantil) values(to_date('24/06/18', 'dd/mm/yy'),'Patati Patata','3');	
insert into contratoAnimador(DATA,animador,aniversario_infantil) values(to_date('23/06/18', 'dd/mm/yy'),'Silvio dos Santos','2');

insert into contratoBanda(DATA,banda,casamento) values(to_date('24/06/18', 'dd/mm/yy'),'Guns n Rosas','1');	
insert into contratoBanda(DATA,banda,casamento) values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','4');

insert into lineup(DATA,banda,musica) values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Patience');
insert into lineup(DATA,banda,musica) values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Faroeste Cabloco');
insert into lineup(DATA,banda,musica) values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Vai Malandra');
insert into lineup(DATA,banda,musica) values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','More Patience');

insert into equipamentos(data,banda,equipamento)  values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Microfone');
insert into equipamentos(data,banda,equipamento)  values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Violão');
insert into equipamentos(data,banda,equipamento)  values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Bateria');
insert into equipamentos(data,banda,equipamento)  values(to_date('23/06/18', 'dd/mm/yy'),'Guns n Rosas','Fone');

insert into EmpresaCriterio(empresa, tipo) values('28.246.015/0001-53', 'SEGURANCA');  
insert into EmpresaCriterio(empresa, tipo) values('21.245.025/0001-48', 'SEGURANCA'); 
insert into EmpresaCriterio(empresa, tipo) values('43.456.123/0001-58', 'SEGURANCA'); 

insert into EmpresaCriterio(empresa, tipo) values('12.246.015/0001-53', 'FOTOGRAFIA');  
insert into EmpresaCriterio(empresa, tipo) values('34.246.015/0001-53', 'FOTOGRAFIA'); 
insert into EmpresaCriterio(empresa, tipo) values('56.246.015/0001-53', 'FOTOGRAFIA'); 	

insert into EmpresaSeguranca(cnpj, nome) values('28.246.015/0001-53', 'Grupo Souza Lima');
insert into EmpresaSeguranca(cnpj, nome) values('21.245.025/0001-48', 'Grupo Sanchez Prote��es');
insert into EmpresaSeguranca(cnpj, nome) values('43.456.123/0001-58', 'Grupo de Prote��o contra Terroristas');
    
insert into EmpresaFotografia(cnpj, nome) values('12.246.015/0001-53', 'Carol da B. fotografias e edi��es');
insert into EmpresaFotografia(cnpj, nome) values('34.246.015/0001-53', 'Momentos Fot�grafos');
insert into EmpresaFotografia(cnpj, nome) values('56.246.015/0001-53', 'Grupo de Prote��o contra Terroristas');

insert into FuncionarioCriterio(funcionario, tipo) values('513.731.800-05', 'SEGURANCA');  
insert into FuncionarioCriterio(funcionario, tipo) values('446.823.720-17', 'SEGURANCA');  
insert into FuncionarioCriterio(funcionario, tipo) values('925.050.230-34', 'SEGURANCA');  

insert into FuncionarioCriterio(funcionario, tipo) values('111.878.540-18', 'FOTOGRAFO');  
insert into FuncionarioCriterio(funcionario, tipo) values('805.439.600-72', 'FOTOGRAFO');  
insert into FuncionarioCriterio(funcionario, tipo) values('205.513.460-43', 'FOTOGRAFO'); 	

insert into Seguranca(Cpf, nome) values('513.731.800-05', 'Ot�vio Costa Barros');  
insert into Seguranca(Cpf, nome) values('446.823.720-17', 'Leonardo Carvalho Rocha');  
insert into Seguranca(Cpf, nome) values('925.050.230-34', 'Diego Azevedo Ferreira'); 

insert into Fotografo(Cpf, nome) values('111.878.540-18', 'Diego Azevedo Rocha');  
insert into Fotografo(Cpf, nome) values('805.439.600-72', 'Ot�vio Costa Carvalho');  
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

insert into BUFFETCRITERIO(buffet,tipo) values('34.094.463/0001-81','CASAMENTO');
insert into BUFFETCRITERIO(buffet,tipo) values('96.349.406/0001-53','CASAMENTO');
insert into BUFFETCRITERIO(buffet,tipo) values('05.737.186/0001-80','CASAMENTO');

insert into BUFFETCRITERIO(buffet,tipo) values('55.527.287/0001-02','INFANTIL');
insert into BUFFETCRITERIO(buffet,tipo) values('94.017.088/0001-06','INFANTIL');
insert into BUFFETCRITERIO(buffet,tipo) values('82.069.306/0001-69','INFANTIL');

insert into BUFFETCASAMENTO(cnpj,nome,rua,numero,cep,capacidade) values('34.094.463/0001-81','Maria Casamenteira','Rua das Flores',45,'68927-302',40);
insert into BUFFETCASAMENTO(cnpj,nome,rua,numero,cep,capacidade) values('96.349.406/0001-53','Game Over Casamentos','Rua José Pavesi',8,'88356-102',30);
insert into BUFFETCASAMENTO(cnpj,nome,rua,numero,cep,capacidade) values('05.737.186/0001-80','Buffet das Rosas','Rua C',81,'49008-590',25);

insert into BUFFETINFANTIL(cnpj,nome,rua,numero,cep,capacidade) values('55.527.287/0001-02','Buffet Infantil Do Ben 10','Rua das Flores',45,'68927-302',40);
insert into BUFFETINFANTIL(cnpj,nome,rua,numero,cep,capacidade) values('94.017.088/0001-06','Play Games Buffet','Rua José Pavesi',8,'88356-102',30);
insert into BUFFETINFANTIL(cnpj,nome,rua,numero,cep,capacidade) values('82.069.306/0001-69','Alegria e Samba Buffet','Rua C',81,'49008-590',25);

insert into BRINQUEDOS (BUFFET_INFANTIL,brinquedo) values ('55.527.287/0001-02','Pula Pula Gigante');
insert into BRINQUEDOS (BUFFET_INFANTIL,brinquedo) values ('94.017.088/0001-06','Futbol de sabão');
insert into BRINQUEDOS (BUFFET_INFANTIL,brinquedo) values ('82.069.306/0001-69','Grande Megazord que solta fogo');

insert into CONTRATOBUFFETINFANTIL (data,BUFFET_INFANTIL,aniversario_infantil,preco) values (to_date('15/09/19', 'dd/mm/yy'),'55.527.287/0001-02','2',250);	
insert into CONTRATOBUFFETINFANTIL (data,BUFFET_INFANTIL,aniversario_infantil,preco) values (to_date('13/03/19', 'dd/mm/yy'),'94.017.088/0001-06','3',250);	

insert into CONTRATOBUFFETCASAMENTO (data,BUFFET_CASAMENTO,CASAMENTO,preco) values (to_date('15/09/19', 'dd/mm/yy'),'05.737.186/0001-80','1',14500);	
insert into CONTRATOBUFFETCASAMENTO (data,BUFFET_CASAMENTO,CASAMENTO,preco) values (to_date('13/03/19', 'dd/mm/yy'),'96.349.406/0001-53','4',2500);	
		
insert into CARDAPIOINFANTIL (data,BUFFET_INFANTIL,prato) values (to_date('13/03/19', 'dd/mm/yy'),'94.017.088/0001-06','ovo frito');
insert into CARDAPIOINFANTIL (data,BUFFET_INFANTIL,prato) values (to_date('13/03/19', 'dd/mm/yy'),'94.017.088/0001-06','Lasanha Vegetariana');	
insert into CARDAPIOINFANTIL (data,BUFFET_INFANTIL,prato) values (to_date('13/03/19', 'dd/mm/yy'),'94.017.088/0001-06','Pizza');	
insert into CARDAPIOINFANTIL (data,BUFFET_INFANTIL,prato) values (to_date('13/03/19', 'dd/mm/yy'),'94.017.088/0001-06','Miojo');		
				