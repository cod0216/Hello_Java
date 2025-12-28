USE my_shop;

CREATE TABLE customers (
	customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
	address VARCHAR(500) NOT NULL,
    join_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE products (
	product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    description TEXT,
    price INT NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0
);

CREATE TABLE orders (
	order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status VARCHAR(20) NOT NULL DEFAULT '주문접수',
    
    CONSTRAINT fk_orders_customers FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
    CONSTRAINT fk_orders_products FOREIGN KEY(product_id) REFERENCES products(product_id)
);

ALTER TABLE customers ADD COLUMN point INT NOT NULL DEFAULT 0;

ALTER TABLE customers ADD COLUMN address VARCHAR(500) NOT NULL;
DESC customers;

DROP TABLE products;
TRUNCATE products;

SET FOREIGN_KEY_CHECKS = 0;
DROP table customers;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO customers VALUES (NULL, '강감찬', 'kang@example.com', 'hashed_password_123', '서울시 관악구', '2025-06-11 10:30:00');
INSERT INTO customers VALUES (NULL, '이순신', 'lee@example.com', 'hashed_password_123', '서울시 관악구', '2025-06-11 10:30:00');

INSERT INTO customers (name, email, password, address)VALUES ('세종대왕sejong', '왕@example.com', 'hashed_password_123', '서울시 관악구');

INSERT INTO products (name, price, stock_quantity) VALUES ('베이직 반팔 티셔츠', 19900, 200);
INSERT INTO products (name, price, stock_quantity) VALUES ('초록색 긴팔 티셔츠', 30000, 50);


INSERT INTO products (name, price, stock_quantity) VALUES 
('검정 양말', 5000, 100),
('갈색 양말', 5000, 100),
('흰색 양말', 5000, 100);

SELECT * FROM products;

SELECT * FROM products
WHERE product_id = 1;

UPDATE products
SET price = 9800, stock_quantity = 500
WHERE product_id = 1;

DELETE FROM products WHERE product_id = 1;
SELECT * FROM products;



CREATE DATABASE my_test;
use my_test;
DROP TABLE members;
CREATE TABLE members(
	id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    join_data DATE
);
DESC members;

INSERT INTO members VALUES(1, '션', '2025-01-10');
INSERT INTO members VALUES(2, '네이트', '2025-02-15');

SELECT * FROM members;

UPDATE members
SET name = '네이트2'
WHERE id = 2;

DELETE FROM members
WHERE id = 1;
DROP TABLE products;
ALTER TABLE products MODIFY product_name VARCHAR(99) NOT NULL;

DESC products;

CREATE TABLE customers (
	customer_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE orders (
	order_id INT PRIMARY KEY AUTO_INCREMENT,
    cutomers_id INT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    
    CONSTRAINT fk_orders_customers FOREIGN KEY (cutomers_id) REFERENCES customers(customer_id)
);

INSERT INTO customers VALUE (1, '홍길통');
SELECT * FROM customers;

INSERT INTO orders(cutomers_id) VALUES (1);
SELECT * FROM orders;


USE my_shop;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE products;
TRUNCATE TABLE customers;
TRUNCATE TABLE orders;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO customers (name, email, password, address, join_date) VALUES 
('이순신', 'yisunsin@example.com', 'password123', '서울특별시 중구 세종대로', '2023-05-01'), 
('세종대왕', 'sejong@example.com', 'password456', '서울특별시 종로구 사직로', '2024-05-01'), 
('장영실', 'youngsil@example.com', 'password789', '부산광역시 동래구 복천동', '2025-05-01');


INSERT INTO products (name, description, price, stock_quantity) VALUES
('갤럭시', '최신 AI 기능이 탑재된 고성능 스마트폰', 10000, 55),
('LG 그램', '초경량 디자인과 강력한 성능을 자랑하는 노트북', 20000, 35),
('아이폰', '직관적인 사용자 경험을 제공하는 스마트폰', 5000, 55),
('에어팟', '편리한 사용성의 무선 이어폰', 3000, 110),
('보급형 스마트폰', NULL, 5000, 100);

INSERT INTO orders (customer_id, product_id, quantity) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 1),
(1, 4, 2),
(2, 2, 1);

SELECT * FROM customers WHERE email = 'yisunsin@example.com';

SELECT * FROM products WHERE price >= 10000;

SELECT * FROM products WHERE price <> 20000;

SELECT * FROM products WHERE price = 20000 OR stock_quantity >= 100;

SELECT * FROM products WHERE price BETWEEN 5000 AND 15000;

SELECT * FROM products WHERE price < 5000 OR 15000;
SELECT * FROM products WHERE price NOT BETWEEN 5000 AND 15000;

SELECT * FROM products WHERE name = '갤럭시' OR name = '아이폰' OR name ='에어팟';
SELECT * FROM products WHERE name IN ('갤럭시',  '아이폰', '에어팟');
SELECT * FROM products WHERE name NOT IN ('갤럭시',  '아이폰', '에어팟');

SELECT * FROM customers WHERE email LIKE 'sejon%';

SELECT * FROM customers WHERE address NOT LIKE '서울특별시%';
use My_shop;

SELECT * FROM products ORDER BY price DESC LIMIT 2;
SELECT * FROM products ORDER BY price DESC LIMIT 4, 2;

SELECT DISTINCT customer_id FROM orders;

SELECT customer_id, product_id FROM orders ORDER BY customer_id;

SELECT * FROM products;

SELECT * FROM products ORDER BY description DESC;

SELECT product_id, name, description FROM products ORDER BY description IS NULL DESC, description DESC;

SELECT * FROM products;

SELECT name AS '상품명', price AS '판매가' FROM products;

SELECT * FROM customers WHERE name = '장영실';

SELECT * FROM products WHERE price >= 10000 AND stock_quantity < 50;

SELECT name, price FROM products WHERE product_id IN (2, 3, 4);


SELECT name, address FROM customers WHERE address LIKE '서울특별시%';

SELECT * FROM products WHERE description IS NOT NULL;

SELECT * FROM products ORDER BY price DESC;

SELECT * FROM products ORDER BY price, stock_quantity DESC;

SELECT * FROM customers ORDER BY join_date DESC LIMIT 2;

SELECT DISTINCT customer_id, product_id FROM orders;

SELECT name AS '재품명', stock_quantity AS '남은 수량' FROM products WHERE price > 3000 AND stock_quantity <= 100 ORDER BY stock_quantity DESC LIMIT 3;

SELECT 
	name, 
    price, 
    stock_quantity, 
    price*stock_quantity AS 'total_stock_value'
FROM products;


SELECT 
	name, 
    price, 
    stock_quantity, 
    price + 3000 AS 'expect_price'
FROM products;


SELECT 
	name, 
    price, 
    stock_quantity, 
    price - 1000 AS 'discount_price'
FROM products;

SELECT CONCAT(name, ' (', address, ')') FROM customers;
SELECT CONCAT_WS(' - ' , name, address, email)FROM customers;

SELECT email, UPPER(email) as '대문자' FROM customers;


SELECT name, CHAR_LENGTH(name) as 'char_length', LENGTH(name) as 'byte' FROM customers;

SELECT name, IFNULL(description, '상품 설명 없음') AS description FROM products;

SELECT name, COALESCE(description, '상품 설명 없음') AS description FROM products;

SELECT name, price, price - 0.15*price AS sale_price FROM products;

SELECT CONCAT_WS(' - ', name, address) AS customer_info FROM customers;

SELECT name, COALESCE(description, name) AS product_display_info FROM products;

SELECT name, description, COALESCE(description, name, '정보 없음') AS display_text FROM products;

SELECT email, SUBSTRING_INDEX(email, '@', 1) AS user_id, CHAR_LENGTH(SUBSTRING_INDEX(email, '@', 1)) AS id_length FROM customers;

USE my_shop;

CREATE TABLE order_stat (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    customer_name VARCHAR(50),
    category VARCHAR(50),
    product_name VARCHAR(100),
    price INT,
    quantity INT,
    order_date DATE
);

INSERT INTO order_stat (customer_name, category, product_name, price, quantity, order_date) VALUES
('이순신', '전자기기', '프리미엄 기계식 키보드', 150000, 1, '2025-05-10'),
('세종대왕', '도서', 'SQL 마스터링', 35000, 2, '2025-05-10'),
('신사임당', '가구', '인체공학 사무용 의자', 250000, 1, '2025-05-11'),
('이순신', '전자기기', '고성능 게이밍 마우스', 80000, 1, '2025-05-12'),
('세종대왕', '전자기기', '4K 모니터', 450000, 1, '2025-05-12'),
('장영실', '도서', '파이썬 데이터 분석', 40000, 3, '2025-05-13'),
('이순신', '문구', '고급 만년필 세트', 200000, 1, '2025-05-14'),
('세종대왕', '가구', '높이조절 스탠딩 데스크', 320000, 1, '2025-05-15'),
('신사임당', '전자기기', '노이즈캔슬링 블루투스 이어폰', 180000, 1, '2025-05-15'),
('장영실', '전자기기', '보조배터리 20000mAh', 50000, 2, '2025-05-16'),
('홍길동', NULL, 'USB-C 허브', 65000, 1, '2025-05-17');

select * from order_stat;

select count(*) from order_stat;

select count(category) from order_stat;

SELECT count(*) AS '전체 주문 건수', COUNT(category) AS '카테고리 등록 건수' FROM order_stat;

SELECT SUM(price * quantity) AS '총 매출액', AVG(price * quantity) AS '평균 주문 금액' FROM order_stat;
SELECT SUM(quantity) AS '총 판매 수량', AVG(quantity) AS '주문당 평균 수량' FROM order_stat;
SELECT SUM(price * quantity) AS '총 매출액', AVG(price * quantity) AS '평균 주문 금액' FROM order_stat;

SELECT MIN(price) AS 최저가, MAX(price) AS 최고가 FROM order_stat;

SELECT MIN(order_date) AS '최초 주문일', MAX(order_date) AS '최근 주문일' FROM order_stat;

SELECT * FROM order_stat;

SELECT COUNT(customer_name) AS '총 주문 수', COUNT(DISTINCT customer_name) AS '순수 고객 수' FROM order_stat;
