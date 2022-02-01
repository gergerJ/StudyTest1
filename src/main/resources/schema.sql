create table HYTest(
    seq int not null AUTO_INCREMENT,
    name varchar(50) not null,
    addr varchar(50) not null,
    phonenumber varchar(30) not null,
    lastorder datetime not null default NOW(),
    constraint HYTest_PK primary Key(seq),
    constraint unq_HYTest unique (phonenumber)
);

insert into HYTest(name, addr, phonenumber, lastorder) values('연우', '인천', '111-1111-1111', now());
insert into HYTest(name, addr, phonenumber, lastorder) values('영은', '서울', '222-2222-2222', SYSDATE );
insert into HYTest(name, addr, phonenumber, lastorder) values('한영', '인천', '333-3333-3333', now());
insert into HYTest(name, addr, phonenumber, lastorder) values('히진', '서울', '444-4444-4444', SYSDATE );
insert into HYTest(name, addr, phonenumber, lastorder) values('재성', '인천', '555-5555-5555', SYSDATE);



CREATE TABLE users
(
    seq           bigint      NOT NULL AUTO_INCREMENT,
    email         varchar(50) NOT NULL,
    passwd        varchar(80) NOT NULL,
    login_count   int         NOT NULL DEFAULT 0,
    last_login_at datetime             DEFAULT NULL,
    create_at     datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP(),
    PRIMARY KEY (seq),
    CONSTRAINT unq_user_email UNIQUE (email)
);


INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES ('liu.a@aa.com','1234',0,now(),now() );
INSERT INTO users(email, passwd, login_count, last_login_at, create_at) VALUES ('liu.b@aa.com','12345',0,now(),now() );

CREATE TABLE TEST
(
    ID   INT PRIMARY KEY,
    NAME VARCHAR(255)
);

INSERT INTO TEST
VALUES (1, 'Hello');
INSERT INTO TEST
VALUES (2, 'World');