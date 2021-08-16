--CREACIÓN DE LA BASE DE DATOS
create table bd_lavanderia
use bd_lavanderia

--TABLA USUARIOS
drop table tb_usuarios
create table tb_usuarios
(
	idusuario int identity(1,1),
	usuario varchar(20) not null,
	contraseña varchar(20) not null,
	nombres varchar(20) not null,
	apellidos varchar(20) not null
)
    --Clave Primaria
    alter table tb_usuarios
    add constraint pk_usuarios
    primary key clustered (idusuario)

insert into tb_usuarios(usuario,contraseña,nombres,apellidos)
values('jesch','123','Jeremy Enrique','Soto Chavarri')

select * from tb_usuarios

--TABLA CLIENTES
drop table tb_clientes
create table tb_clientes
(
	dni char(08) not null,
	nomcli varchar(20) not null,
	apecli varchar(20) not null,
	dircli varchar(50) not null,
	emailcli varchar(50) not null,
	telcli char(09) not null
)
    --Clave Primaria
    alter table tb_clientes
    add constraint pk_clientes
    primary key clustered (dni)

insert into tb_clientes(dni,nomcli,apecli,dircli,emailcli,telcli)
values(12345678,'Juan Carlos','Altamirano Zula','Mz. R-10 Lt. 01 La Fragata','juancarlos@hotmail.com',147258369)

--TABLA PEDIDOS
drop table tb_pedidos
create table tb_pedidos
(
       
    codped varchar(05) not null,
    fecrecped datetime not null,
    fecentped datetime not null,
    estped varchar(10) not null,
    dni char(08) not null
)
    --Clave Primaria
    alter table tb_pedidos
    add constraint pk_pedidos
    primary key clustered (codped)
    --Clave Foránea
    alter table tb_pedidos
    add constraint fk_pedidos
    foreign key(dni)
    references tb_clientes(dni)

insert into tb_pedidos(codped,fecrecped,fecentped,estped,dni) values ('P0001',12-07-20,15-07-20,'EN CURSO',12345678)

select * from tb_pedidos

--PROCEDIMIENTO PARA GENERAR CÓDIGO DE PEDIDO
create procedure generar_codped
as begin
declare @codped varchar(05)
set @codped=(select MAX(codped) from tb_pedidos)
set @codped='P'+right('000'+LTRIM(right(isnull(@codped,'000'),4)+1),4)
select @codped as codped
end

--TABLA ARTÍCULOS
drop table tb_articulos
create table tb_articulos
(
    codart int identity(1,1) not null,
    desart varchar(20) not null,
    cantart int not null,
    preart dec(9,2) not null,
    subtotal dec(9,2) not null,
    codped varchar(05) not null
)
    --Clave Primaria
    alter table tb_articulos
    add constraint pk_articulos
    primary key clustered (codart)
    --Clave Foránea
    alter table tb_articulos
    add constraint fk_articulos
    foreign key(codped)
    references tb_pedidos(codped)

    --Suma de subtotales
    select sum(subtotal) from tb_articulos where codped='P0002'

insert into tb_articulos(desart,cantart,preart,subtotal,codped) values ('Kg de ropa',5,7.00,35.00,'P0001')
insert into tb_articulos(desart,cantart,preart,subtotal,codped) values ('Alfombra',1,18.00,18.00,'P0001')

select * from tb_articulos

--TABLA DETALLE-ARTÍCULOS
drop table tb_detarti
create table tb_detarti(
desart varchar(20) not null,
preart dec(9,2) not null
)

insert into tb_detarti values('Polo',10.00);
insert into tb_detarti values('Kg de Ropa',7.00);
insert into tb_detarti values('Terno',15.00);
insert into tb_detarti values('Alfombra',18.00);

select * from tb_detarti

--TABLA BOLETA
drop table tb_boletas
create table tb_boletas
(
    codbol varchar(10) not null,
    fecemi datetime not null,
    pretotal dec(9,2) not null,
    idusuario int not null,
    codped varchar(05) not null    
)
    --Clave Primaria
    alter table tb_boletas
    add constraint pk_boletas
    primary key clustered (codbol)
    --Clave Foránea 1
    alter table tb_boletas
    add constraint fk_boletas
    foreign key(idusuario)
    references tb_usuarios(idusuario)
    --Clave Foránea 2
    alter table tb_boletas
    add constraint fk_boletas1
    foreign key(codped)
    references tb_pedidos(codped)

insert into tb_boletas(codbol,fecemi,pretotal,idusuario,codped) values('B000000001','20-06-2020',53.00,1,'P0001')    

select * from tb_boletas

--PROCEDIMIENTO PARA GENERAR CÓDIGO DE BOLETA
drop procedure generar_codbol

create procedure generar_codbol
as begin
declare @codbol varchar(10)
set @codbol=(select MAX(codbol) from tb_boletas)
set @codbol='B'+right('000000000'+LTRIM(right(isnull(@codbol,'000000000'),9)+1),9)
select @codbol as codbol
end