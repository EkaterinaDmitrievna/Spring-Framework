create table categories (id bigserial primary key , name varchar(255));
insert into categories (name) values
('фрукты'),
('овощи'),
('снеки'),
('молочная продукция'),
('мясо,колбасы'),
('хлеб,выпечка'),
('прочее');
create table products (id bigserial primary key, title varchar(255), price int, category_id bigserial REFERENCES categories (id));
insert into products (title, price, category_id) values
('молоко', 80, 4),
('хлеб', 50, 6),
('кофе', 200, 7),
('творог', 100, 4),
('сметана', 50, 4),
('масло', 280, 4),
('яйца', 90, 4),
('шоколад', 140, 3),
('сыр', 290, 4),
('колбаса', 255, 5),
('чипсы', 80, 3),
('морковка', 45, 2),
('кабачок', 150, 2),
('капуста', 40, 2),
('картошка', 45, 2),
('апельсин', 350, 1),
('яблоко', 138, 1),
('перец', 250, 2),
('салат', 50, 2),
('помидоры', 150, 2);