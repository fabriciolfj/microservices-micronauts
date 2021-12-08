CREATE TABLE category(
    id serial,
    name varchar(255) not null,
    code varchar(255) not null,
    constraint pk_category primary key (id)
);

CREATE TABLE product(
    id serial,
    name varchar(255) not null,
    code varchar(255) not null,
    price numeric(15,4) not null,
    category_id integer not null,
    foreign key (category_id) references category (id),
    constraint pk_product primary key (id)
);