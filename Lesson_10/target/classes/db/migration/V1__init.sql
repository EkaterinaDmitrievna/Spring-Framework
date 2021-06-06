create table categories (id bigserial primary key , name varchar(255));
insert into categories (name) values
('фрукты'),
('овощи'),
('снеки'),
('молочная продукция'),
('мясо,колбасы'),
('хлеб,выпечка'),
('прочее');
create table products (id bigserial primary key, title varchar(255), price int);
insert into products (title, price) values
('молоко', 80),
('хлеб', 50),
('кофе', 200),
('творог', 10),
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
