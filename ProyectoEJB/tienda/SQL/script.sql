CREATE USER almacen IDENTIFIED BY almacen;
GRANT DBA TO almacen;

CREATE TABLE ALMACEN.TIPO_TRABAJADOR(
    ID NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR2(20) NOT NULL
);

CREATE TABLE ALMACEN.TRABAJADOR(
    ID NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR2(50) NOT NULL,
    APELLIDO1 VARCHAR2(100) NOT NULL,
    APELLIDO2 VARCHAR2(100) NOT NULL,
    FECHA_NACIMIENTO DATE,
    FECHA_INCORPORACION DATE DEFAULT SYSDATE,
    TIPO_TRABAJADOR NUMBER(5) NOT NULL,
    CONSTRAINT FK_TIPO_TRABAJADOR FOREIGN KEY (TIPO_TRABAJADOR) REFERENCES ALMACEN.TIPO_TRABAJADOR(ID)
);

CREATE SEQUENCE ALMACEN.TRABAJADOR_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE ALMACEN.USUARIO(
    USUARIO VARCHAR(25),
    CLAVE VARCHAR(25) NOT NULL,
    ID_TRABAJADOR NUMBER(5),
    activo NUMBER(1) DEFAULT 1, 
    CONSTRAINT PK_USUARIO PRIMARY KEY(USUARIO),
    CONSTRAINT FK_TRABAJADOR_USUARIO FOREIGN KEY(ID_TRABAJADOR) REFERENCES ALMACEN.TRABAJADOR(ID)
);

CREATE TABLE ALMACEN.PRODUCTO(
    ID NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR2(200) NOT NULL,
    PRECIO NUMBER(5,2) NOT NULL,
    STOCK NUMBER(5) DEFAULT 0
);

CREATE SEQUENCE ALMACEN.PRODUCTO_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE ALMACEN.CLIENTE(
    ID NUMBER(5) PRIMARY KEY,
    NOMBRE VARCHAR(200) NOT NULL, 
    CIF VARCHAR(9) NOT NULL,
    ID_TRABAJADOR NUMBER(5) NOT NULL,
    COMISION NUMBER(5,2) NOT NULL,
    CONSTRAINT FK_CLIENTE_TRABJADOR FOREIGN KEY(ID_TRABAJADOR) REFERENCES ALMACEN.TRABAJADOR(ID)
);

CREATE SEQUENCE ALMACEN.CLIENTE_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE ALMACEN.FACTURA(
    NUM_FACTURA NUMBER(10),
    ID_CLIENTE NUMBER(5) NOT NULL,
    FECHA_FACTURA DATE NOT NULL,
    PROCESADO NUMBER(1) DEFAULT 0,
    FECHA_PROCESADO DATE,
    CONSTRAINT PK_FACTURA PRIMARY KEY(NUM_FACTURA),
    CONSTRAINT FK_CLIENTE FOREIGN KEY(ID_CLIENTE) REFERENCES ALMACEN.CLIENTE(ID)
);

CREATE SEQUENCE ALMACEN.FACTURA_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE ALMACEN.DETALLE(
    ID NUMBER(5) PRIMARY KEY,
    NUM_DETALLE NUMBER(3),
    NUM_FACTURA NUMBER(10),
    ID_PRODUCTO NUMBER(5) NOT NULL,
    CANTIDAD NUMBER(5) NOT NULL,
    PRECIO NUMBER(5,2) NOT NULL,
    CONSTRAINT FK_FACTURA FOREIGN KEY(NUM_FACTURA) REFERENCES ALMACEN.FACTURA(NUM_FACTURA),
    CONSTRAINT FK_PRODUCTO FOREIGN KEY(ID_PRODUCTO) REFERENCES ALMACEN.PRODUCTO(ID)
);

CREATE SEQUENCE ALMACEN.DETALLE_SEQ
INCREMENT BY 1
START WITH 1;

CREATE TABLE ALMACEN.MENSAJES(
    ID NUMBER(5) PRIMARY KEY,
    ASUNTO VARCHAR2(100) NOT NULL,
    MENSAJE VARCHAR2(2000) NOT NULL,
    LEIDO NUMBER(1) DEFAULT 0 NOT NULL,
    FECHA_RECIBIDO DATE NOT NULL
);

CREATE SEQUENCE ALMACEN.MENSAJES_SEQ
INCREMENT BY 1
START WITH 1;

INSERT INTO ALMACEN.TIPO_TRABAJADOR VALUES (1, 'ADMIN');
INSERT INTO ALMACEN.TIPO_TRABAJADOR VALUES (2, 'COMERCIAL');
INSERT INTO ALMACEN.TIPO_TRABAJADOR VALUES (3, 'MOZO ALMACEN');

INSERT INTO ALMACEN.TRABAJADOR VALUES (ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'XAVIER', 'ROIG', 'MARTIN', TO_DATE('17/06/1986', 'DD/MM/YYYY'), TO_DATE('22/08/2000','DD/MM/YYYY'), 1);
INSERT INTO ALMACEN.USUARIO VALUES('xroig', 'xroig', ALMACEN.TRABAJADOR_SEQ.CURRVAL,1);

INSERT INTO ALMACEN.TRABAJADOR VALUES(ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'ADMIN', 'ADMIN', 'ADMIN', TO_DATE('17/06/1986', 'DD/MM/YYYY'), SYSDATE, 1);
INSERT INTO ALMACEN.USUARIO VALUES('admin', 'admin', ALMACEN.TRABAJADOR_SEQ.CURRVAL, 1);

INSERT INTO ALMACEN.TRABAJADOR VALUES(ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'COMERCIAL', 'COMERCIAL', 'COMERCIAL', SYSDATE, SYSDATE, 2);
INSERT INTO ALMACEN.USUARIO VALUES('comercial', 'comercial', ALMACEN.TRABAJADOR_SEQ.CURRVAL, 1);
INSERT INTO ALMACEN.CLIENTE VALUES(ALMACEN.CLIENTE_SEQ.NEXTVAL, 'CLIENTE1', 'H04845715', ALMACEN.TRABAJADOR_SEQ.CURRVAL,10);

INSERT INTO ALMACEN.TRABAJADOR VALUES (ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'JOSE ANTONIO', 'FERNANDEZ', 'GIMENEZ', TO_DATE('25/04/1990', 'DD/MM/YYYY'), SYSDATE, 2);
INSERT INTO ALMACEN.USUARIO VALUES('jfernandez', 'jfernandez', ALMACEN.TRABAJADOR_SEQ.CURRVAL,1);
INSERT INTO ALMACEN.CLIENTE VALUES(ALMACEN.CLIENTE_SEQ.NEXTVAL, 'CLIENTE2', 'G78547851', ALMACEN.TRABAJADOR_SEQ.CURRVAL, 10);

INSERT INTO ALMACEN.TRABAJADOR VALUES (ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'OSCAR', 'MENENDEZ', 'GIL', NULL, SYSDATE, 2);
INSERT INTO ALMACEN.USUARIO VALUES('omenendez', 'omenendez', ALMACEN.TRABAJADOR_SEQ.CURRVAL,1);

INSERT INTO ALMACEN.TRABAJADOR VALUES (ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'DAVID', 'GONZALEZ', 'BUJALANCE', NULL, SYSDATE, 3);
INSERT INTO ALMACEN.USUARIO VALUES('dgonzalez', 'dgonzalez', ALMACEN.TRABAJADOR_SEQ.CURRVAL,1);

INSERT INTO ALMACEN.TRABAJADOR VALUES(ALMACEN.TRABAJADOR_SEQ.NEXTVAL, 'MOZO', 'MOZO', 'MOZO', SYSDATE, SYSDATE, 3);
INSERT INTO ALMACEN.USUARIO VALUES('mozo', 'mozo', ALMACEN.TRABAJADOR_SEQ.CURRVAL, 1);

INSERT INTO ALMACEN.PRODUCTO VALUES(ALMACEN.PRODUCTO_SEQ.NEXTVAL, 'Producto1', 9.95, 100);
INSERT INTO ALMACEN.PRODUCTO VALUES(ALMACEN.PRODUCTO_SEQ.NEXTVAL, 'Producto2', 2.50, 100);
INSERT INTO ALMACEN.PRODUCTO VALUES(ALMACEN.PRODUCTO_SEQ.NEXTVAL, 'Producto3', 5.00, 3);

INSERT INTO ALMACEN.FACTURA VALUES(ALMACEN.FACTURA_SEQ.NEXTVAL, (SELECT ID FROM ALMACEN.CLIENTE WHERE NOMBRE = 'CLIENTE1'), SYSDATE, '0', null);

INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 12, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 2, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'), 5, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 3, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto3'), 1, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto3'));

insert into ALMACEN.FACTURA values(ALMACEN.FACTURA_SEQ.NEXTVAL, 2, TO_DATE('01/12/2017', 'dd/mm/yyyy'), 1, TO_DATE('02/12/2017', 'dd/mm/yyyy'));
insert into ALMACEN.DETALLE values(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 10, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));

INSERT INTO ALMACEN.FACTURA VALUES(ALMACEN.FACTURA_SEQ.NEXTVAL, (SELECT ID FROM ALMACEN.CLIENTE WHERE NOMBRE = 'CLIENTE1'), TO_DATE('10/01/2018', 'DD/MM/YYYY'), '0', null);

INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 12, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 2, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'), 5, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'));

INSERT INTO ALMACEN.FACTURA VALUES(ALMACEN.FACTURA_SEQ.NEXTVAL, (SELECT ID FROM ALMACEN.CLIENTE WHERE NOMBRE = 'CLIENTE1'), TO_DATE('11/01/2018', 'DD/MM/YYYY'), '0', null);

INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 1, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 2, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'), 1, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'));

INSERT INTO ALMACEN.FACTURA VALUES(ALMACEN.FACTURA_SEQ.NEXTVAL, (SELECT ID FROM ALMACEN.CLIENTE WHERE NOMBRE = 'CLIENTE1'), TO_DATE('30/12/2017', 'DD/MM/YYYY'), '0', null);

INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 2, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 2, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'), 2, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'));

INSERT INTO ALMACEN.FACTURA VALUES(ALMACEN.FACTURA_SEQ.NEXTVAL, (SELECT ID FROM ALMACEN.CLIENTE WHERE NOMBRE = 'CLIENTE1'), TO_DATE('30/01/2017', 'DD/MM/YYYY'), '1', TO_DATE('31/01/2017', 'DD/MM/YYYY'));

INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 1, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'), 2, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto1'));
INSERT INTO ALMACEN.DETALLE VALUES(ALMACEN.DETALLE_SEQ.NEXTVAL, 2, ALMACEN.FACTURA_SEQ.CURRVAL, (SELECT ID FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'), 2, (SELECT PRECIO FROM ALMACEN.PRODUCTO WHERE NOMBRE = 'Producto2'));
COMMIT;