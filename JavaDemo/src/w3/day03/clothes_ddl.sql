-- 쇼핑몰 DDL
create database shop;
use shop;

-- 옷
CREATE TABLE clothes(
    id INT,
    name VARCHAR(25),
    price INT,
    category VARCHAR(25),
    PRIMARY KEY (id)
);

-- 사이즈에 대한 재고
CREATE TABLE stocks(
   id INT,
   size VARCHAR(25),
   stock INT,
   PRIMARY KEY (id, size),
   FOREIGN KEY (id) REFERENCES clothes(id)
       ON DELETE CASCADE
);