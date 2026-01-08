-- 2. 조인1 - 내부 조인
-- 실습 데이터 준비

-- 데이터베이스가 존재하지 않으면 생성
CREATE DATABASE IF NOT EXISTS my_shop2;
USE my_shop2;

-- 테이블이 존재하면 삭제 (실습을 위해 초기화)
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS sizes;
DROP TABLE IF EXISTS colors;

-- 고객 테이블 생성
CREATE TABLE users (
    user_id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    address VARCHAR(255),
    birth_date DATE,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)
);

-- 상품 테이블 생성
CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price INT NOT NULL,
    stock_quantity INT NOT NULL,
    PRIMARY KEY (product_id)
);

-- 주문 테이블 생성
CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    quantity INT NOT NULL,
    status VARCHAR(50) DEFAULT 'PENDING',
    PRIMARY KEY (order_id),

    CONSTRAINT fk_orders_users FOREIGN KEY (user_id)
        REFERENCES users(user_id),

    CONSTRAINT fk_orders_products FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);

-- 직원 테이블 생성 (SELF JOIN 실습용)
CREATE TABLE employees (
    employee_id BIGINT AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    manager_id BIGINT,
    PRIMARY KEY (employee_id),
    FOREIGN KEY (manager_id) REFERENCES employees(employee_id)
);

-- 사이즈 테이블 (CROSS JOIN 실습용)
CREATE TABLE sizes (
    size VARCHAR(10) PRIMARY KEY
);

-- 색상 테이블 (CROSS JOIN 실습용)
CREATE TABLE colors (
    color VARCHAR(20) PRIMARY KEY
);

-- 고객 데이터 입력
INSERT INTO users(name, email, address, birth_date) VALUES
('션', 'sean@example.com', '서울시 강남구', '1990-01-15'),
('네이트', 'nate@example.com', '경기도 성남시', '1988-05-22'),
('세종대왕', 'sejong@example.com', '서울시 종로구', '1397-05-15'),
('이순신', 'sunsin@example.com', '전라남도 여수시', '1545-04-28'),
('마리 퀴리', 'marie@example.com', '서울시 강남구', '1867-11-07'),
('레오나르도 다빈치', 'vinci@example.com', '이탈리아 피렌체', '1452-04-15');

-- 상품 데이터 입력
INSERT INTO products(name, category, price, stock_quantity) VALUES
('프리미엄 게이밍 마우스', '전자기기', 75000, 50),
('기계식 키보드', '전자기기', 120000, 30),
('4K UHD 모니터', '전자기기', 350000, 20),
('관계형 데이터베이스 입문', '도서', 28000, 100),
('고급 가죽 지갑', '패션', 150000, 15),
('스마트 워치', '전자기기', 280000, 40);

-- 주문 데이터 입력
INSERT INTO orders(user_id, product_id, quantity, status, order_date) VALUES
(1, 1, 1, 'COMPLETED', '2025-06-10 10:00:00'),
(1, 4, 2, 'COMPLETED', '2025-06-10 10:05:00'),
(2, 2, 1, 'SHIPPED', '2025-06-11 14:20:00'),
(3, 4, 1, 'COMPLETED', '2025-06-12 09:00:00'),
(4, 3, 1, 'PENDING', '2025-06-15 11:30:00'),
(5, 1, 1, 'COMPLETED', '2025-06-16 18:00:00'),
(2, 1, 2, 'SHIPPED', '2025-06-17 12:00:00');

-- 직원 데이터 입력
INSERT INTO employees(employee_id, name, manager_id) VALUES
(1, '김회장', NULL),
(2, '박사장', 1),
(3, '이부장', 2),
(4, '최과장', 3),
(5, '정대리', 4),
(6, '홍사원', 4);

-- 사이즈 데이터 입력
INSERT INTO sizes(size) VALUES
('S'), ('M'), ('L'), ('XL');

-- 색상 데이터 입력
INSERT INTO colors(color) VALUES
('Red'), ('Blue'), ('Black');




USE my_shop2;

SELECT * FROM orders;
SELECT * FROM users;

SELECT 
	users.user_id,
    users.name,
    orders.order_date
FROM orders
JOIN users ON orders.user_id = users.user_id
WHERE orders.status = 'COMPLETED';

SELECT
	orders.order_id,
    orders.order_date,
    orders.user_id AS orders_user_id,
    users.user_id AS users_user_id,
    users.name
FROM orders
INNER JOIN users ON orders.user_id = users.user_id
ORDER BY orders.order_id;
SELECT * FROM orders;
SELECT * FROM users;
SELECT * FROM products;


SELECT o.order_id AS 'order_id', p.name AS 'name', o.quantity AS quantity FROM orders o INNER JOIN products p ON o.product_id = p.product_id ORDER BY 1;
SELECT o.order_id AS order_id, u.name AS 'user_name', p.name AS 'product_name', o.order_date AS 'order_date' FROM orders o INNER JOIN users u ON o.user_id = u.user_id INNER JOIN products p ON o.product_id = p.product_id WHERE status = 'SHIPPED';
SELECT u.name, SUM(o.quantity * p.price) AS 'total_purchase_amount' FROM orders o INNER JOIN users u ON o.user_id = u.user_id INNER JOIN products p ON o.product_id = p.product_id GROUP BY u.name ORDER BY 2 DESC;

use my_shop2;
SELECT user_id, name, email FROM users;

SELECT user_id, order_id FROM orders ORDER BY user_id;

SELECT u.user_id, u.name, o.user_id, o.order_id FROM users u JOIN orders o ON u.user_id = o.user_id ORDER BY u.user_id;

SELECT u.user_id, u.name, o.user_id, o.order_id FROM users u LEFT JOIN orders o ON u.user_id = o.user_id ORDER BY u.user_id;


SELECT u.user_id, u.name, u.email FROM users u LEFT JOIN orders o ON u.user_id = o.user_id WHERE o.user_id IS NULL ORDER BY u.user_id;

SELECT u.user_id, u.name, o.user_id, o.order_id 
FROM orders o
LEFT JOIN users u ON u.user_id = o.user_id
WHERE o.order_id IS NULL;

SELECT 
	p.product_id,
    p.name,
    p.price,
    o.product_id,
    o.order_id
FROM orders o
RIGHT JOIN products p ON p.product_id = o.product_id;

USE my_shop2;

SELECT user_id, name, email
FROM users
WHERE user_id = 1;

SELECT  order_id, product_id, user_id
FROM orders
WHERE user_id = 1;

SELECT 
	o.order_id,
	o.product_id,
	o.user_id AS orders_user_id,
	u.user_id AS users_user_id,
	u.name,
	u.email
FROM orders o 
JOIN users u ON o.user_id = u.user_id
WHERE o.user_id = 1;

SELECT 
	o.order_id,
	o.product_id,
	o.user_id AS orders_user_id,
	u.user_id AS users_user_id,
	u.name,
	u.email
FROM users u 
JOIN orders o ON o.user_id = u.user_id
WHERE o.user_id = 1;

SELECT * FROM employees;

SELECT 
	e.name AS employee_name,
    m.name AS manager_name
FROM
	employees e
LEFT JOIN
	employees m ON e.manager_id = m.employee_id;

SELECT * FROM sizes;
SELECT * FROM colors;

SELECT * FROM sizes CROSS JOIN colors;
SELECT CONCAT("기본티셔츠-", c.color, '-', s.size) AS product_name, s.size, c.color FROM sizes s CROSS JOIN colors c;

CREATE TABLE product_options (
	option_id BIGINT AUTO_INCREMENT,
    product_name VARCHAR(255) NOT NULL,
    size VARCHAR(10) NOt NULL,
    color VARCHAR(20) NOT NULL,
    PRIMARY KEY (option_id)
);

INSERT INTO product_options (product_name, size, color)
SELECT
	CONCAT("기본티셔츠-", c.color, "-", s.size) AS product_name,
    s.size,
    c.color
FROM
	sizes AS s 
CROSS JOIN
	colors AS c;


SELECT * FROM products;

SELECT 
	u.name AS '고객 이름',
    u.email AS '고객 이메일',
    o.order_date AS '주문 날짜',
    p.name AS '주문한 상품명',
    p.price AS '상품 가격',
    o.quantity AS '주문 수량'
FROM orders o
JOIN users u ON o.user_id = u.user_id
JOIN products p ON o.product_id = p.product_id
WHERE u.address LIKE '서울%' AND order_date >= 2025-06;

SELECT p.name, p.price 
FROM products p
LEFT JOIN orders o ON p.product_id = o.product_id
WHERE o.order_id IS NULL AND p.category = '전자기기';

SELECT
	u.name,
    COUNT(o.order_id) AS 'order_count'
FROM
	users u
LEFT JOIN orders o ON u.user_id = o.user_id
GROUP BY u.user_id
ORDER BY u.name;

SELECT 
	u.name,
    u.email
FROM orders o
RIGHT JOIN users u ON u.user_id = o.user_id
WHERE o.order_id IS NULL;

SELECT 
	u.name AS 'user_name',
    p.name AS 'product_name'
FROM 
	users u
LEFT JOIN orders o ON u.user_id = o.user_id
LEFT JOIN products p ON o.product_id = p.product_id
ORDER BY user_name, product_name;

SELECT * 
FROM employees e
JOIN employees m ON e.manager_id = m.employee_id
WHERE m.name = "최과장";

CREATE TABLE materials (
	material VARCHAR(20) PRIMARY KEY
);
INSERT INTO materials(material) VALUES('Cotton'), ('Silk');

SELECT
	CONCAT('기본티셔츠-', c.color, '-', s.size, '-', m.material) AS
    product_full_name,
	s.size,
    c.color,
    m.material
FROM
	sizes s
CROSS JOIN
	colors c
CROSS JOIN
	materials m
ORDER BY
	s.size, c.color, m.material;

SELECT
	u.name AS 'customer_name',
    p.name AS 'product_name',
    o.order_date,
    o.quantity
FROM
	users u
LEFT JOIN
	orders o ON o.user_id = u.user_id
LEFT JOIN 
	products p ON p.product_id = o.product_id
WHERE u.name = "네이트"
ORDER BY order_date DESC;


SELECT 
	u.name AS customer_name,
    SUM(p.price * o.quantity) AS total_spent
FROM
	users u
LEFT JOIN orders o ON u.user_id = o.user_id
LEFT JOIN products p ON p.product_id = o.product_id
WHERE u.address LIKE "서울%"
GROUP BY u.user_id
ORDER BY total_spent DESC;

USE my_shop2;

SELECT AVG(price) FROM products;

SELECT name, price
FROM products
WHERE price > 167166.67;

SELECT name, price
FROM products
WHERE price > (SELECT AVG(price) FROM products);

SELECT u.address
FROM users u
JOIN orders o ON u.user_id = o.user_id
WHERE o.order_id = 1;

SELECT name, address
FROM users
WHERE address = '서울시 강남구';

SELECT name, address
FROM users
WHERE address = (
					SELECT u.address
					FROM users u
					JOIN orders o ON u.user_id = o.user_id
					WHERE o.order_id = 1
);

SELECT product_id FROM products WHERE category = '전자기기'
ORDER BY product_id;

SELECT * FROM orders
WHERE product_id IN (SELECT product_id FROM products WHERE category = '전자기기')  
ORDER BY order_id;


SELECT user_id, status FROM orders WHERE order_id = 3;

SELECT order_id, user_id, status, order_date
FROM orders
WHERE (user_id, status) = (
	SELECT user_id, status FROM orders WHERE order_id = 3
) AND order_id != 3;

SELECT
	o.order_id,
    o.user_id,
    o.order_date
FROM orders o
WHERE ( o.user_id, o.order_date) IN (
	SELECT user_id, MIN(order_date)
    FROM orders
    GROUP BY user_id
);

SELECT
	o.order_id,
    o.user_id,
    u.name,
    p.name AS product_name,
    o.order_date
FROM orders o
JOIN users u ON o.user_id = u.user_id
JOIN products p ON o.product_id = p.product_id
WHERE (o.user_id, o.order_date) IN (
SELECT user_id, MIN(order_date)
FROM orders
GROUP BY user_id);


SELECT
	product_id,
    name,
    category,
    price
FROM
	products p1
WHERE
	price >= (
		SELECT AVG(price)
        FROM products p2
        WHERE p2.category = p1.category
);



SELECT product_id, name, price FROM products;
SELECT DISTINCT product_id FROM orders;

SELECT product_id, name, price FROM products
WHERE product_id IN (1,2,3,4);

SELECT product_id, name, price FROM products
WHERE product_id IN (SELECT DISTINCT product_id FROM orders);

SELECT product_id, name, price FROM products p
WHERE NOT EXISTS (SELECT 1 FROM orders o WHERE o.product_id = p.product_id);

SELECT
	name,
    price,
	(SELECT AVG(price) FROM products) AS avg_price
FROM
	products;

SELECT
	p.product_id,
    p.name,
    p.price,
    (SELECT COUNT(*) FROM orders o WHERE o.product_id = p.product_id) AS order_count
FROM products p;

SELECT
	p.product_id, p.name, p.price, COUNT(o.order_id) AS order_count
FROM products p
LEFT JOIN orders o ON p.product_id = o.product_id
GROUP BY p.product_id, p.name, p.price;

SELECT
	p.product_id,
    p.name,
    p.price
FROM
	products p
JOIN (
	SELECT 
		category,
        MAX(price) AS max_price
    FROM
		products
	GROUP BY
		category ) AS cmp
ON p.category = cmp.category AND p.price = cmp.max_price;

SELECT 
	p.product_id AS '상품ID',
    p.name AS '상품명',
    p.price AS '가격'
FROM products p
WHERE p.price = (SELECT MAX(price) FROM products p1);

SELECT
	o.order_id AS '주문ID',
	o.user_id AS '고객ID',
    o.order_date AS '주문일시'
FROM orders o
WHERE o.product_id IN (SELECT product_id FROM orders WHERE order_id = 1)
AND order_id != 1;

SELECT 
	u.name AS "고객명",
    (  	
		SELECT COUNT(*) 
		FROM orders o 
		WHERE u.user_id = o.user_id
    ) AS '총 주문 횟수'
FROM users u
ORDER BY user_id;


-- 본 실습을 위한 탈퇴 고객 테이블 생성
DROP TABLE IF EXISTS retired_users;
CREATE TABLE retired_users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    retired_date DATE NOT NULL
);

-- 탈퇴 고객 데이터 입력
INSERT INTO retired_users (id, name, email, retired_date) VALUES
(1, '션', 'sean@example.com', '2024-12-31'),
(7, '아이작 뉴턴', 'newton@example.com', '2025-01-10');

SELECT name, email FROM users
UNION
SELECT name, email FROM retired_users;

SELECT u.name, u.email
FROM users u
JOIN orders o ON u.user_id = o.user_id
JOIN products p ON o.product_id = p.product_id
WHERE p.category = '전자기기'

UNION

SELECT name, email
FROM users
WHERE address LIKE '서울%';

SELECT name, email FROM users
UNION
SELECT name, email FROM retired_users
ORDER BY name;

SELECT name, email, created_at FROM users
UNION ALL
SELECT name, email, retired_date FROM retired_users
ORDER BY created_at;


SELECT name, email, created_at AS event_date FROM users
UNION ALL
SELECT name, email, retired_date AS event_date FROM retired_users
ORDER BY event_date DESC;

SELECT u.name AS 이름, u.email as 이메일 FROM users u
UNION
SELECT r.name, r.email FROM retired_users r;


SELECT u.name AS 고객명, u.email AS 이메일 FROM users u LEFT JOIN orders o ON o.user_id = u.user_id LEFT JOIN products p ON o.product_id = p.product_id WHERE p.category = '전자기기' GROUP BY u.user_id
UNION ALL
SELECT u.name AS 고객명, u.email AS 이메일 FROM users u LEFT JOIN orders o ON o.user_id = u.user_id GROUP BY u.user_id HAVING COUNT(*) >= 2;



SELECT created_at AS "이벤트 날짜", (SELECT "고객 가입") AS '이벤트 종류', name AS "상세 내용" FROM users
UNION ALL
SELECT order_date AS "이벤트 날짜", (SELECT "상품 주문") AS '이벤트 종류', p.name AS "상세 내용" FROM orders o 
JOIN products p ON p.product_id = o.product_id
ORDER BY `이벤트 날짜` DESC;

SELECT name AS '이름', "직원" AS '역할', concat(name,'@my-shop.com') AS 이메일 FROM employees
UNION ALL
SELECT name AS '이름', "고객" AS '역할', email AS '이메일' FROM users
ORDER BY `이름`;
USE my_shop2;

SELECT
	order_id,
    user_id,
    product_id,
    status,
    CASE status
		WHEN 'PENDING' THEN '주문대기'
		WHEN 'COMPLETED' THEN '결제 완료'
		WHEN 'SHIPPED' THEN '배송'
		WHEN 'CANCELLED' THEN '주문 취소'
        ELSE '알수 없음'
	END AS status_korean
FROM
	orders;

SELECT 
	name,
    price,
    CASE
		WHEN price >= 100000 THEN '고가'
        WHEN price >= 30000 THEN '중가'
        ELSE '저가'
    END AS 'price_label'
FROM
	products;


SELECT
	name,
    price,
    CASE
		WHEN price >= 100000 THEN '고가'
        WHEN price >= 30000 THEN '중가'
        ELSE '저가'
	END AS price_label,
    CASE
		WHEN price >= 100000 THEN 1
        WHEN price >= 30000 THEN 2
        ELSE 3
	END
FROM products
ORDER BY
	CASE
		WHEN price >= 100000 THEN 1
        WHEN price >= 30000 THEN 2
        ELSE 3
	END ASC,
    price DESC;
    
    SELECT 
		name,
        birth_date,
        CASE
			WHEN YEAR(birth_date) >= 1990 THEN '1990년생'
            WHEN YEAR(birth_date) >= 1980 THEN '1980년생'
            ELSE '그 이전 출생'
		END AS birth_decade
	FROM
		users;
        
	SELECT 
        CASE
			WHEN YEAR(birth_date) >= 1990 THEN '1990년생'
            WHEN YEAR(birth_date) >= 1980 THEN '1980년생'
            ELSE '그 이전 출생'
		END AS birth_decade,
        COUNT(*)
	FROM
		users
	GROUP BY
		CASE
			WHEN YEAR(birth_date) >= 1990 THEN '1990년생'
            WHEN YEAR(birth_date) >= 1980 THEN '1980년생'
            ELSE '그 이전 출생'
		END;
		
	SELECT 
        CASE
			WHEN YEAR(birth_date) >= 1990 THEN '1990년생'
            WHEN YEAR(birth_date) >= 1980 THEN '1980년생'
            ELSE '그 이전 출생'
		END AS birth_decade,
        COUNT(*)
	FROM
		users
	GROUP BY
		birth_decade;

SELECT
	order_id,
    status
FROM orders;

SELECT status, COUNT(*) FROM orders
GROUP BY status;

SELECT COUNT(*) AS total_orders FROM orders;

SELECT 'Total' AS caegory, COUNT(*) AS count FROM orders
UNION ALL
SELECT status AS category, COUNT(*) AS count FROM orders GROUP BY status;

SELECT  (SELECT COUNT(*) FROM orders) AS total_orders,
		(SELECT COUNT(*) FROM orders WHERE status = 'COMPLETED') AS completed_count,
		(SELECT COUNT(*) FROM orders WHERE status = 'SHIPPED') AS shipped_count,
		(SELECT COUNT(*) FROM orders WHERE status = 'PENDING') AS pending_count;
        
SELECT
	p.category,
    COUNT(*) AS total_orders,
    SUM(CASE WHEn o.status = 'COMPLETED' THEN 1 ELSE 0 END) AS completed_count,
    SUM(CASE WHEn o.status = 'SHIPPED' THEN 1 ELSE 0 END) AS shipped_count,
    SUM(CASE WHEn o.status = 'PENDING' THEN 1 ELSE 0 END) AS pending_count
FROM
	orders o
JOIN
	products p ON o.product_id = p.product_id
GROUP BY
	p.category;
    
    
SELECT
	name,
    category,
    CASE category
		WHEN '전자기기' THEN 'Electronics'
		WHEN '도서' THEN 'Books'
		WHEN '패션' THEN 'Fashion'
        ELSE 'Unknown'
    END AS categry_english
FROM products;

SELECT 
	order_id,
    quantity,
    CASE
		WHEN quantity > 1 THEN '다량 주문'
        ELSE '단일 주문'
	END AS order_type
FROM orders
ORDER BY `order_type`;

SELECT
	CASE 
		WHEN stock_quantity >= 50 THEN '재고 충분'
		WHEN stock_quantity >= 20 THEN '재고 보통'
        ELSE '재고 부족'
	END AS `stock_level`,
    COUNT(*) AS prodcut_count
FROM products
GROUP BY `stock_level`;

SELECT 
	u.name AS user_name,
    COUNT(o.order_id) AS total_orders,
    SUM( CASE WHEN p.category = '전자기기' THEN 1 ELSE 0 END) AS electronics_orders,
    SUM( CASE WHEN p.category = '도서' THEN 1 ELSE 0 END) AS book_orders,
    SUM( CASE WHEN p.category = '패션' THEN 1 ELSE 0 END) AS fashion_orders
FROM users u
LEFT JOIN orders o ON u.user_id = o.user_id
LEFT JOIN products p ON o.product_id = p.product_id
GROUP BY u.user_id, u.name;

CREATE VIEW v_category_order_status AS
SELECT
	p.category,
    COUNT(*) AS total_orders,
	SUM(CASE WHEn o.status = 'COMPLETED' THEN 1 ELSE 0 END) AS completed_count,
    SUM(CASE WHEn o.status = 'SHIPPED' THEN 1 ELSE 0 END) AS shipped_count,
    SUM(CASE WHEn o.status = 'PENDING' THEN 1 ELSE 0 END) AS pending_count
FROM
	orders o
JOIN products p ON o.product_id = p.product_id
GROUP BY
	p.category;

SELECT * FROM v_category_order_status;
SELECT * FROM v_category_order_status WHERE category = '전자기기';

ALTER VIEW v_category_order_status AS
SELECT
	p.category,
    SUM(p.price * o.quantity) AS total_sales,
    COUNT(*) AS total_orders,
	SUM(CASE WHEn o.status = 'COMPLETED' THEN 1 ELSE 0 END) AS completed_count,
    SUM(CASE WHEn o.status = 'SHIPPED' THEN 1 ELSE 0 END) AS shipped_count,
    SUM(CASE WHEn o.status = 'PENDING' THEN 1 ELSE 0 END) AS pending_count
FROM
	orders o
JOIN products p ON o.product_id = p.product_id
GROUP BY
	p.category;

SELECT * FROM v_category_order_status;

DROP VIEW v_category_order_status;

CREATE VIEW v_customer_email_list AS SELECT user_id, name AS 고객명, email AS 이메일 FROM users;

SELECT * FROM v_customer_email_list;

CREATE VIEW v_order_summary AS SELECT 
	o.order_id,
    u.name AS 고객명,
    p.name AS 상품명,
    o.quantity AS 주문수량,
    o.status AS 주문상태
FROM orders o
JOIN users u ON o.user_id = u.user_id
JOIN products p ON p.product_id = o.product_id;

SELECT * FROM v_order_summary;

CREATE VIEW v_electronics_sales_status AS SELECT 
	p.category,
    COUNT(o.order_id) AS total_orders,
    SUM(p.price * o.quantity) AS total_sales
FROM orders o
JOIN products p ON p.product_id = o.product_id
WHERE category = '전자기기'
GROUP BY p.category;

SELECT * FROM v_electronics_sales_status;

ALTER VIEW v_electronics_sales_status AS SELECT 
	p.category,
    COUNT(o.order_id) AS total_orders,
    SUM(p.price * o.quantity) AS total_sales,
    AVG(p.price * o.quantity) AS average_order_value
FROM orders o
JOIN products p ON p.product_id = o.product_id
WHERE category = '전자기기'
GROUP BY p.category;


-- 데이터베이스가 존재하지 않으면 생성
CREATE DATABASE IF NOT EXISTS my_shop2;
USE my_shop2;

-- 테이블이 존재하면 삭제 (실습을 위해 초기화)
DROP TABLE IF EXISTS items;
DROP TABLE IF EXISTS sellers;

-- 판매자 테이블 생성
CREATE TABLE sellers (
    seller_id INT PRIMARY KEY AUTO_INCREMENT,
    seller_name VARCHAR(100) UNIQUE NOT NULL,
    registered_date DATE NOT NULL
);

-- 상품 테이블 생성
CREATE TABLE items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    seller_id INT NOT NULL,
    item_name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    price INT NOT NULL,
    stock_quantity INT NOT NULL,
    registered_date DATE NOT NULL,
    is_active BOOLEAN NOT NULL,

    CONSTRAINT fk_items_sellers FOREIGN KEY (seller_id)
        REFERENCES sellers(seller_id)

);

-- 판매자 데이터 입력
INSERT INTO sellers (seller_id, seller_name, registered_date) VALUES
(1, '행복쇼핑', '2020-01-15'),
(2, '스마트상점', '2021-03-22'),
(3, '글로벌셀러', '2019-11-01'),
(4, '에코마켓', '2022-07-10'),
(5, '베스트딜', '2020-05-30'),
(6, '패션리더', '2023-01-05'),
(7, '리빙스타', '2021-09-12'),
(8, '테크월드', '2022-04-18'),
(9, '북스토리', '2020-08-25'),
(10, '헬스앤뷰티', '2023-03-01');

-- 상품 데이터 입력
INSERT INTO items (item_id, seller_id, item_name, category, price, stock_quantity, registered_date, is_active) VALUES
(1, 1, '무선 기계식 키보드', '전자기기', 120000, 100, '2022-01-20', TRUE),
(2, 1, '4K UHD 모니터', '전자기기', 450000, 50, '2022-02-15', TRUE),
(3, 2, '프리미엄 게이밍 마우스', '전자기기', 80000, 200, '2021-11-10', TRUE),
(4, 3, '관계형 데이터베이스 입문', '도서', 30000, 500, '2020-05-01', TRUE),
(5, 4, '친환경 세제', '생활용품', 15000, 300, '2023-08-01', FALSE),
(6, 5, '고급 가죽 지갑', '패션', 70000, 120, '2022-06-25', TRUE),
(7, 1, '스마트 워치', '전자기기', 250000, 80, '2023-03-10', TRUE),
(8, 6, '캐시미어 스웨터', '패션', 95000, 70, '2023-10-05', FALSE),
(9, 7, '아로마 디퓨저', '생활용품', 40000, 150, '2022-09-01', TRUE),
(10, 8, '게이밍 노트북', '전자기기', 1500000, 30, '2023-01-30', TRUE),
(11, 9, 'SQL 마스터 가이드', '도서', 35000, 400, '2021-04-12', TRUE),
(12, 10, '유기농 비누 세트', '헬스/뷰티', 20000, 250, '2023-02-20', FALSE),
(13, 1, '노이즈 캔슬링 헤드폰', '전자기기', 300000, 90, '2023-07-01', TRUE),
(14, 2, '인체공학 키보드', '전자기기', 90000, 110, '2022-05-05', TRUE),
(15, 3, '파이썬 프로그래밍 가이드', '도서', 28000, 600, '2021-01-01', FALSE),
(16, 4, '재활용 쇼핑백', '생활용품', 5000, 1000, '2023-09-15', TRUE),
(17, 5, '빈티지 가죽 백팩', '패션', 180000, 60, '2022-08-01', TRUE),
(18, 6, '여름용 린넨 셔츠', '패션', 45000, 180, '2023-04-20', TRUE),
(19, 7, '친환경 주방 세트', '생활용품', 60000, 130, '2022-10-10', FALSE),
(20, 8, '고성능 그래픽 카드', '전자기기', 800000, 40, '2023-06-01', TRUE),
(21, 9, '어린이를 위한 그림책', '도서', 18000, 700, '2022-03-01', TRUE),
(22, 10, '천연 에센셜 오일', '헬스/뷰티', 25000, 200, '2023-05-10', TRUE),
(23, 1, '휴대용 빔 프로젝터', '전자기기', 350000, 70, '2023-02-01', TRUE),
(24, 2, '게이밍 의자', '전자기기', 200000, 90, '2022-07-20', TRUE),
(25, 3, '세계사 탐험', '도서', 22000, 350, '2021-02-28', FALSE);

CREATE INDEX idx_items_name ON items (item_name);

SHOW INDEX FROM items;

DROP INDEX idx_items_price on items;

EXPLAIN SELECT * FROM items WHERE item_name = '게이밍 노트북';

EXPLAIN SELECT * FROM items WHERE price BETWEEN 50000 AND 100000;

SELECT * FROM items WHERE price BETWEEN 50000 AND 100000; 

CREATE INDEX idx_items_price ON items (price);

EXPLAIN SELECT * FROM items WHERE price BETWEEN 50000 AND 100000 ORDER BY price DESC;
SELECT * FROM items WHERE price BETWEEN 50000 AND 100000;


EXPLAIN SELECT * FROM items WHERE price BETWEEN 50000 AND 100000;
EXPLAIN SELECT * FROM items WHERE price BETWEEN 1000 AND 200000;

EXPLAIN SELECT item_id, price, item_name FROM items WHERE price BETWEEN 50000 aND 100000;
EXPLAIN SELECT item_id, price FROM items WHERE price BETWEEN 50000 aND 100000;

DROP INDEX idx_items_price ON items;

CREATE INDEX idx_items_price ON items (price, item_name);
SELECT item_id, price, item_name FROM items WHERE price BETWEEN 50000 aND 100000;
SHOW INDEX FROM items;
DROP INDEX idx_items_price ON items;

CREATE INDEX idx_items_category_price ON items (category, price);
SHOW INDEX FROM items;

EXPLAIN SELECT * FROM items WHERE category = '전자기기';
EXPLAIN SELECT * FROM items WHERE category = '전자기기' AND price = 120000;

EXPLAIN SELECT * FROM items WHERE category = '전자기기' AND price > 100000 ORDER BY item_name;

EXPLAIN SELECT * FROM items WHERE category >= '패션' AND price = 20000;

EXPLAIN SELECT * FROM items WHERE category IN ('패션', '헬스/뷰티') AND price = 20000;

DROP INDEX idx_items_price_category_temp ON items;

SHOW INDEX FROM items;

DROP INDEX idx_items_category_price ON items;

EXPLAIN SELECT s.seller_name, i.item_name, i.price
FROM items i
JOIN sellers s ON i.seller_id = s.seller_id
WHERE s.seller_name = '행복쇼핑';

CREATE INDEX idx_category_items ON items(category, is_active, stock_quantity);
DROP INDEX idx_category_stock_items ON items;

EXPLAIN SELECT * FROM items WHERE category = '전자기기' AND is_active = TRUE;
EXPLAIN SELECT * FROM items WHERE category = '전자기기' AND is_active = TRUE ORDER BY stock_quantity DESC;

EXPLAIN SELECT * FROM items WHERE stock_quantity < 90 AND category = '전자기기' AND is_active = TRUE;
EXPLAIN SELECT * FROM items WHERE stock_quantity < 90 AND category = '전자기기' AND is_active = TRUE ORDER By stock_quantity DESC;

INSERT INTO users (name, email) VALUES ('냐옹이', NULL);

SELECT * FROM users;

INSERT INTO users (name, email, address) VALUES ('가짜 션', 'sean@example.com', '서울시 어딘가');

INSERT INTO users (user_id, name, email) VALUES (1, '누군가', 'someone@example.com'); -- Error Code: 1062. Duplicate entry '1' for key 'users.PRIMARY'

INSERT INTO orders (user_id, product_id, quantity) VALUES (2, 2, 1);

SELECT * FROM orders ORDER BY order_id DESC LIMIT 1;

INSERT INTO orders (user_id, product_id, quantity) VALUES(999, 1, 1);
DELETE FROM users WHERE user_id = 1;
-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`my_shop2`.`orders`, CONSTRAINT `fk_orders_users` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`))


DROP TABLE orders;

CREATE TABLE orders (
    order_id BIGINT AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    quantity INT NOT NULL,
    status VARCHAR(50) DEFAULT 'PENDING',
    PRIMARY KEY (order_id),

    CONSTRAINT fk_orders_users FOREIGN KEY (user_id) 
        REFERENCES users(user_id) ON DELETE CASCADE, -- CASCADE 옵션 추가

    CONSTRAINT fk_orders_products FOREIGN KEY (product_id)
        REFERENCES products(product_id)
);

-- 션 회원 다시 등록
INSERT INTO users(user_id, name, email, address, birth_date) VALUES
(1, '션', 'sean@example.com', '서울시 강남구', '1990-01-15');

-- 주문 데이터 다시 입력
INSERT INTO orders(user_id, product_id, quantity, status) VALUES
(1, 1, 1, 'COMPLETED'),
(1, 4, 2, 'COMPLETED'),
(2, 2, 1, 'SHIPPED');


-- 실습을 위해 기존 테이블들을 삭제한다.
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;

-- CHECK 제약 조건을 추가하여 products 테이블 재생성
CREATE TABLE products (
    product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category VARCHAR(100),
    price INT NOT NULL CHECK (price >= 0),
    stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
    discount_rate DECIMAL(5, 2) DEFAULT 0.00 CHECK (discount_rate BETWEEN 0.00 AND 100.00)
);

INSERT INTO products (name, category, price, stock_quantity, discount_rate) VALUES ('초특가상품', '패션', -50000, -5000, 120.00);

DROP TABLE IF EXISTS accounts;
CREATE TABLE accounts (
    id INT PRIMARY KEY,
    owner_name VARCHAR(255) NOT NULL,
    balance INT NOT NULL
);

-- 초기 데이터 입력
INSERT INTO accounts (id, owner_name, balance) VALUES
(1, 'A고객', 50000),
(2, 'B고객', 20000);
SELECT * FROM accounts;
START TRANSACTION;

UPDATE accounts SET balance = balance - 10000 WHERE id = 1;
UPDATE accounts SET balance = balance + 10000 WHERE id = 2;

COMMIT;

START TRANSACTION;

UPDATE accounts SET balance = balance - 5000 WHERE id = 1;
SELECT * FROM accounts;
ROLLBACK;

SELECT @@transaction_isolation;


DROP TABLE IF EXISTS logs;
CREATE TABLE logs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);



-- 프로시저 생성 (CREATE PROCEDURE)

-- 구분자를 // 로 변경
DELIMITER //

CREATE PROCEDURE sp_change_user_address(
    IN user_id_param INT,
    IN new_address_param VARCHAR(255)
)
BEGIN
    -- 1. users 테이블의 주소 업데이트
    UPDATE users SET address = new_address_param WHERE user_id = user_id_param;
    
    -- 2. logs 테이블에 변경 이력 기록
    INSERT INTO logs (description) 
    VALUES (CONCAT('User ID ', user_id_param, ' 주소 변경 ', new_address_param));
END //

-- 구분자를 다시 ; 로 원상 복구
DELIMITER ;



SELECT * FROM users WHERE user_id = 2;
CALL sp_change_user_address(2,'경기도 성남시2');

DROP PROCEDURE sp_change_user_address;


DROP TABLE IF EXISTS stored_items;

CREATE TABLE stored_items (
    item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    discount_rate DECIMAL(5, 2)
);

INSERT INTO stored_items (name, price, discount_rate) VALUES
('고성능 노트북', 1500000, 10.00),
('무선 마우스', 25000, 20.00),
('기계식 키보드', 120000, 30.00),
('4K 모니터', 450000, 40.00),
('전동 높이조절 책상', 800000, 50.00);



-- 함수 생성 (CREATE FUNCTION)

DELIMITER //

CREATE FUNCTION fn_get_final_price(
    price_param INT,
    discount_rate_param DECIMAL(5, 2)
)
RETURNS DECIMAL(10, 2)
DETERMINISTIC
BEGIN
    -- 최종 가격을 계산 (가격 * (1 - 할인율/100))
    RETURN price_param * (1 - discount_rate_param / 100);
END //

DELIMITER ;

SELECT name,
price,
discount_rate,
	fn_get_final_price(price,discount_rate) as final_price

 FROM stored_items;
DROP FUNCTION fn_get_final_price;


-- 본 실습을 위한 탈퇴 고객 테이블 생성
DROP TABLE IF EXISTS retired_users;
CREATE TABLE retired_users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    retired_date DATE NOT NULL
);

-- 탈퇴 고객 데이터 입력
INSERT INTO retired_users (id, name, email, retired_date) VALUES
(1, '션', 'sean@example.com', '2024-12-31'),
(7, '아이작 뉴턴', 'newton@example.com', '2025-01-10');



-- 트리거 생성 (CREATE TRIGGER)
DELIMITER //

CREATE TRIGGER trg_backup_user
BEFORE DELETE ON users
FOR EACH ROW
BEGIN
    INSERT INTO retired_users (id, name, email, retired_date)
    VALUES (OLD.user_id, OLD.name, OLD.email, CURDATE());
END //

DELIMITER ;

SELECT * FROM users WHERE user_id = 5;

DELETE FROM users WHERE user_id = 5;

SELECT * FROM retired_users;

DROP TRIGGER trg_backup_user;




