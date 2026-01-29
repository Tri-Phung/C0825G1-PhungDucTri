create database sales_management;

use sales_management;

create table customers (
	customer_id int primary key auto_increment,
    customer_name varchar(100) not null,
    customer_age int check (customer_age > 0)
);

create table products (
	product_id int primary key auto_increment,
    product_name varchar(100) not null,
    product_price decimal(20,2) not null
);

create table orders (
	order_id int primary key auto_increment,
    customer_id int not null,
    order_date date not null,
    order_total_price decimal(20,2),
    foreign key (customer_id) references customers(customer_id)
);

create table order_details (
	order_id int,
    product_id int,
    order_QTY int not null check (order_QTY > 0),
    primary key (order_id, product_id),
    foreign key (order_id) references orders(order_id),
    foreign key (product_id) references products(product_id)
);