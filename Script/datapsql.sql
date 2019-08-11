
DROP TABLE seg_opc_perfil;
DROP TABLE seg_opcion;
DROP TABLE seg_perfil;
DROP TABLE seg_sistemas;
DROP TABLE seg_usu_perfil;
DROP TABLE seg_usuario;

DROP SEQUENCE SEQ_SEG_USUARIO;
DROP SEQUENCE SEQ_SEG_USU_PERFIL ;
DROP SEQUENCE SEQ_SEG_SISTEMAS ;
DROP SEQUENCE SEQ_SEG_PERFIL ;
DROP SEQUENCE SEQ_SEG_OPCION ;
DROP SEQUENCE SEQ_SEG_OPCION_PERFIL;

CREATE SEQUENCE SEQ_SEG_USUARIO START 1;
CREATE SEQUENCE SEQ_SEG_USU_PERFIL START 1;
CREATE SEQUENCE SEQ_SEG_SISTEMAS START 1;
CREATE SEQUENCE SEQ_SEG_PERFIL START 1;
CREATE SEQUENCE SEQ_SEG_OPCION START 1;
CREATE SEQUENCE SEQ_SEG_OPCION_PERFIL START 1;

CREATE TABLE seg_opc_perfil
(
  opp_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_OPCION_PERFIL'),
  opc_id integer NOT NULL,
  opp_act_inact integer,
  opp_nuevo integer,
  opp_eliminar integer,
  opp_editar integer,
  opp_imprimir integer,
  per_id integer NOT NULL
);

CREATE TABLE seg_opcion
(
  opc_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_OPCION'),
  seg_opc_id integer,
  opc_nombre character varying(255) NOT NULL,
  opc_nivel integer NOT NULL,
  opc_orden integer NOT NULL,
  opc_url character varying(255) NOT NULL,
  sis_id integer NOT NULL,
  opc_imagen character varying(255),
  opc_icono character varying(125),
  opc_clase character varying(125)
);

CREATE TABLE seg_perfil
(
  per_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_PERFIL'),
  per_nombre character varying(255) NOT NULL,
  sis_id integer NOT NULL
);

CREATE TABLE seg_sistemas
(
  sis_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_SISTEMAS'),
  sis_nombre character varying(255) NOT NULL,
  sis_url_sistema character varying(255) NOT NULL,
  sis_estado integer NOT NULL
);

CREATE TABLE seg_usu_perfil
(
  usp_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_USU_PERFIL'),
  per_id integer NOT NULL,
  usu_id integer NOT NULL,
  usp_fecha_ini date,
  usp_fecha_fin date
);

CREATE TABLE seg_usuario
(
  usu_id integer NOT NULL PRIMARY KEY DEFAULT nextval('SEQ_SEG_USUARIO'), 
  usu_cc character varying(255) NOT NULL,
  usu_clave character varying(255) NOT NULL,
  usu_nombres character varying(255) NOT NULL,
  usu_apellidos character varying(255) NOT NULL,
  usu_email character varying(255) NOT NULL,
  usu_fecharegistro date NOT NULL,
  usu_estado character varying(255),
  usu_mail_sinformul integer,
  usu_mail_incompletos integer,
  spriden_id character varying(120) NOT NULL,
  spriden_pidm integer NOT NULL
);

insert into seg_sistemas values (DEFAULT,'Gestion de Usuarios','gestu.espe.edu.ec',1);
insert into seg_sistemas values (DEFAULT,'Movilidad','mov.espe.edu.ec',1);

insert into seg_perfil values (DEFAULT,'Administrador',1);
insert into seg_perfil values (DEFAULT,'Super Usuario',1);
insert into seg_perfil values (DEFAULT,'Usuario',1);
insert into seg_perfil values (DEFAULT,'Administrador',2);
insert into seg_perfil values (DEFAULT,'Docente',2);

insert into seg_opcion values (DEFAULT,0,'SISTEMAS',1,1,'/sistemas',1,'','apps','nav-pills-info');
insert into seg_opcion values (DEFAULT,0,'PERFILES',1,1,'/perfiles',1,'','format_list_bulleted','');
insert into seg_opcion values (DEFAULT,0,'OPCIONES',1,1,'/opciones',1,'','toc','');
insert into seg_opcion values (DEFAULT,0,'USUARIOS',1,1,'/usuario',1,'','person_add','');
insert into seg_opcion values (DEFAULT,0,'ASIGNACIÓN OPCIONES',1,1,'/opcion_perfil',1,'','playlist_add_check','');
insert into seg_opcion values (DEFAULT,0,'ASIGNACIÓN PERFILES',1,1,'/usuario_perfil',1,'','supervisor_account','');
insert into seg_opcion values (DEFAULT,0,'Convocatoria',1,1,'/convocatoria',2,'','speaker_notes','');
insert into seg_opcion values (DEFAULT,0,'Movilidad',1,1,'/movilidad/planes',2,'','transfer_within_a_station','');
insert into seg_opcion values (DEFAULT,0,'Mantenimiento',1,1,'/mantenimiento',2,'','build','');

insert into seg_usuario values 

(DEFAULT,'1716893316','a6f30815a43f38ec6de95b9a9d74da37','Santiago Daniel','Recalde Gomez','sdr.gomez@espe.edu.ec',now(),'',0,0,'L00123456',4859);

insert into seg_usuario values 

(DEFAULT,'1859628459','aa47f8215c6f30a0dcdb2a36a9f4168e','Diego Andres','Caiza Andrade','sde.caiza@gmail.com',now(),'',0,0,'L00135790',5189);

insert into seg_usuario values 

(DEFAULT,'1722080569','aa47f8215c6f30a0dcdb2a36a9f4168e','Jose Rodolfo','Obando Maldonado','jro.maldonado@espe.edu.ec',now(),'',0,0,'L00324723',3420);

insert into seg_usuario values 

(DEFAULT,'1718552365','aa47f8215c6f30a0dcdb2a36a9f4168e','Rojer Elias','Pozo Sanchez','rep.sanchez@espe.edu.ec',now(),'',0,0,'L00328034',8376);

insert into seg_opc_perfil values (DEFAULT,1,1,1,0,1,0,1);
insert into seg_opc_perfil values (DEFAULT,2,1,1,1,1,0,1);
insert into seg_opc_perfil values (DEFAULT,3,1,1,1,1,0,1);
insert into seg_opc_perfil values (DEFAULT,4,1,1,1,1,0,1);
insert into seg_opc_perfil values (DEFAULT,5,1,1,1,1,0,1);
insert into seg_opc_perfil values (DEFAULT,6,1,1,0,0,0,1);
insert into seg_opc_perfil values (DEFAULT,1,1,0,0,1,0,3);
insert into seg_opc_perfil values (DEFAULT,2,1,0,0,1,0,3);
insert into seg_opc_perfil values (DEFAULT,3,1,0,0,1,0,3);
insert into seg_opc_perfil values (DEFAULT,4,1,0,0,0,0,3);
insert into seg_opc_perfil values (DEFAULT,7,1,1,0,0,0,4);
insert into seg_opc_perfil values (DEFAULT,8,1,0,0,1,0,4);
insert into seg_opc_perfil values (DEFAULT,9,1,0,0,1,0,4);
insert into seg_opc_perfil values (DEFAULT,8,1,0,0,1,0,5);
insert into seg_opc_perfil values (DEFAULT,9,1,0,0,0,0,5);


insert into seg_usu_perfil values (DEFAULT,1,1,now(),now());
insert into seg_usu_perfil values (DEFAULT,3,2,now(),now());
insert into seg_usu_perfil values (DEFAULT,4,3,now(),now());
insert into seg_usu_perfil values (DEFAULT,5,4,now(),now());

