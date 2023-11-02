--create comments table
CREATE SEQUENCE comments_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE IF NOT EXISTS comments(
id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('comments_sequence'), text VARCHAR(255),
rating NUMERIC CHECK(rating > 0 AND rating < 6)
);

-- create product sequence and table
CREATE SEQUENCE product_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE IF NOT EXISTS products (
    id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('product_sequence'),
    product_name VARCHAR(50) NOT NULL,
    product_description VARCHAR(255),
    product_category VARCHAR(50) NOT NULL,
    unit_price NUMERIC NOT NULL,
    comment_id BIGINT,
    in_stock BOOLEAN,
    FOREIGN KEY (comment_id) REFERENCES comments(id)
);
--create order_items sequence and table
CREATE SEQUENCE items_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE IF NOT EXISTS order_items(
id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('items_sequence'), quantity INT,
product_id BIGINT,
FOREIGN KEY (product_id) REFERENCES products(id)
);

--create order table
CREATE SEQUENCE order_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE IF NOT EXISTS orders(id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('order_sequence'),
order_date DATE NOT NULL, total_amount NUMERIC, payment_method VARCHAR(50), order_items_id BIGINT,
FOREIGN KEY (order_items_id) REFERENCES order_items(id)
);
--create comments table
CREATE SEQUENCE cart_sequence INCREMENT BY 1 MINVALUE 1;

CREATE TABLE IF NOT EXISTS cart_items(
id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('cart_sequence'), quantity INT, sub_amount NUMERIC,
product_id BIGINT,
FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE IF NOT EXISTS shopping_cart(
id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('cart_sequence'), total_amount NUMERIC,
cart_items_id BIGINT,
FOREIGN KEY (cart_items_id) REFERENCES cart_items(id)
);
CREATE SEQUENCE authority_sequence INCREMENT BY 1 MINVALUE 1;
CREATE TABLE IF NOT EXISTS authority(id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('authority_sequence'),
 name VARCHAR(50));

--create users table and sequence, users is a super class to customers and admin

CREATE SEQUENCE user_sequence INCREMENT BY 1 MINVALUE 1;

--create comments table
CREATE TABLE IF NOT EXISTS customers(id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('user_sequence'),
                                     first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL,
                                     email VARCHAR(50) UNIQUE NOT NULL,
                                     username VARCHAR(50) NOT NULL UNIQUE,
                                     password VARCHAR(255) NOT NULL, customer_since DATE,
                                     order_id BIGINT, shopping_cart_id BIGINT,
FOREIGN KEY (order_id) REFERENCES orders(id), FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id) );
--create comments table

CREATE TABLE IF NOT EXISTS admin(id BIGINT NOT NULL PRIMARY KEY DEFAULT NEXTVAL('user_sequence'),
                                 first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL,
                                 email VARCHAR(50) UNIQUE NOT NULL,
                                 username VARCHAR(50) NOT NULL UNIQUE, password VARCHAR(255) NOT NULL,
                                 authority_id BIGINT, FOREIGN KEY (authority_id) REFERENCES authority(id));

-- creation of relationships and foreign keys

ALTER TABLE order_items ADD order_id BIGINT;
ALTER TABLE order_items ADD FOREIGN KEY (order_id) REFERENCES orders(id);

ALTER TABLE cart_items ADD shopping_cart_id BIGINT;
ALTER TABLE cart_items ADD FOREIGN KEY (shopping_cart_id) REFERENCES shopping_cart(id);