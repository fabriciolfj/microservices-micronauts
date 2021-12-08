CREATE TABLE inventory(
    id serial,
    code varchar(255) not null,
    balance int not null,
    date_mov datetime not null,
    exit int not null,
    entrance int not null,
    constraint pk_category primary key (id)
);