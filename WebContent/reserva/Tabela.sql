CONNECT struts01/struts01

DROP TABLE RESERVA;

DROP SEQUENCE RESERVA_SEQ;

CREATE SEQUENCE RESERVA_SEQ;

CREATE TABLE RESERVA
(NUMERO                    NUMBER(4) PRIMARY KEY,
 ENDERECO_EMAIL            VARCHAR2(30),
 COR                       VARCHAR2(08),
 TETO_SOLAR                CHAR(2),
 VIDRO_ELETRICO            CHAR(2),
 PORTAS                    CHAR(1),
 AGENCIA                   VARCHAR2(10));

DROP TABLE COR;

DROP SEQUENCE COR_SEQ;

CREATE SEQUENCE COR_SEQ;

CREATE TABLE COR
(ID                        NUMBER(4) PRIMARY KEY,
 LABEL                     VARCHAR2(15),
 VALOR                     VARCHAR2(15));

INSERT INTO COR
VALUES(COR_SEQ.NEXTVAL, 'Azul', 'azul');

INSERT INTO COR
VALUES(COR_SEQ.NEXTVAL, 'Vermelho', 'vermelho');

INSERT INTO COR
VALUES(COR_SEQ.NEXTVAL, 'Verde', 'verde');

COMMIT;