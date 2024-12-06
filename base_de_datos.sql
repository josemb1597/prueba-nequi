CREATE DATABASE franchise_management;

USE franchise_management;

CREATE TABLE franchises (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_franchise VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE branches (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_branch VARCHAR(100) NOT NULL,
    franchise_id BIGINT NOT NULL,
    CONSTRAINT fk_branches_franchises FOREIGN KEY (franchise_id) REFERENCES franchises(id) ON DELETE CASCADE
);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name_product VARCHAR(100) NOT NULL,
    stock INT UNSIGNED NOT NULL DEFAULT 0,
    branch_id BIGINT NOT NULL,
    CONSTRAINT fk_products_branches FOREIGN KEY (branch_id) REFERENCES branches(id) ON DELETE CASCADE
);