DROP TABLE products IF EXISTS;
CREATE TABLE IF NOT EXISTS products(id bigserial, title VARCHAR(255), price INTEGER, PRIMARY KEY (id));
INSERT INTO products (title, price) VALUES ('Milk', 10), ('Bread', 20), ('Apple', 30);

DROP TABLE customers IF EXISTS;
CREATE TABLE IF NOT EXISTS customers(id bigserial, name VARCHAR(255), PRIMARY KEY (id));
INSERT INTO customers (name) VALUES ('Bob'), ('John'), ('Jack');

DROP TABLE IF EXISTS customers_products CASCADE;
CREATE TABLE IF NOT EXISTS customers_products (customer_id INTEGER, product_id INTEGER, FOREIGN KEY (customer_id) REFERENCES customers (id), FOREIGN KEY (product_id) REFERENCES products (id));
INSERT INTO customers_products (customer_id, product_id) VALUES (1, 1), (2, 1), (3, 1), (1, 2), (1, 3), (3, 3);
