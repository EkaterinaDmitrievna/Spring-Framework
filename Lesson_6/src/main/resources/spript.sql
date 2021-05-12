BEGIN;
DROP TABLE IF EXISTS person CASCADE;
CREATE TABLE person (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO person (name) VALUES
('Петр'),
('Марк'),
('Женя'),
('Оля');

DROP TABLE IF EXISTS product CASCADE;
CREATE TABLE product (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO product (title, price) VALUES
('кофе', 250),
('хлеб', 50),
('макароны', 60),
('молоко', 90);

DROP TABLE IF EXISTS orderlist CASCADE;
CREATE TABLE orderlist  (person_id bigint, product_id bigint, FOREIGN KEY (person_id ) REFERENCES person (id), FOREIGN KEY (product_id) REFERENCES product (id));
INSERT INTO orderlist  (person_id, product_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(2, 2),
(2, 3),
(2, 4),
(3, 2),
(4, 4);


COMMIT;