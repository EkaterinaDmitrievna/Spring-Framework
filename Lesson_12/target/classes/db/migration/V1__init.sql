create table products (id bigserial primary key, title varchar(255), price int);
insert into products (title, price) values
('молоко', 80),
('хлеб', 50),
('кофе', 200),
('творог', 100),
('сметана', 50),
('масло', 280),
('яйца', 90),
('шоколад', 140),
('сыр', 290),
('колбаса', 255),
('чипсы', 80),
('морковка', 45),
('кабачок', 150),
('капуста', 40),
('картошка', 45),
('апельсин', 350),
('яблоко', 138),
('перец', 250),
('салат', 50),
('помидоры', 150);

create table items (id bigserial primary key,product_id bigserial, title varchar(255),quantity int,price int,total_price int);
create table users (
    id bigserial primary key not null,
    name varchar not null,
    password varchar not null,
    email varchar not null
);
create table roles(
    id bigserial primary key not null,
    name varchar not null
);
create table users_roles(
    user_id bigserial not null,
    role_id bigserial not null,
    foreign key (user_id) references users(id),
    foreign key (role_id) references roles(id)
);
insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (name, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com');

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2);