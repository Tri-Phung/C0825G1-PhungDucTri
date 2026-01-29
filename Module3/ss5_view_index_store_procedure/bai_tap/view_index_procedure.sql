create database demo;

use demo;

create table products (
	id int auto_increment primary key,
    product_code varchar(50) not null,
    product_name varchar(50) not null,
    product_price decimal(18,2) not null,
    product_amount int check(product_amount >= 0) not null,
    product_description longtext,
    product_status varchar(50) not null
);

INSERT INTO products (product_code, product_name, product_price, product_amount, product_description, product_status)
VALUES
('P001', 'Apple iPhone 13', 999.99, 50, 'The iPhone 13 is a premium smartphone with a sleek design, improved camera, and powerful performance.', 'Available'),
('P002', 'Samsung Galaxy S21', 799.99, 30, 'Samsung Galaxy S21 offers flagship features, 5G connectivity, and a stunning display.', 'Available'),
('P003', 'Sony WH-1000XM4', 349.99, 100, 'Industry-leading noise cancellation headphones, comfortable fit, long battery life.', 'Available'),
('P004', 'Dell XPS 13', 1199.99, 20, 'Powerful ultrabook with a premium design, excellent display, and long battery life.', 'Available'),
('P005', 'Bose QuietComfort 35 II', 299.99, 80, 'Wireless headphones with superior sound and noise cancellation technology.', 'Available'),
('P006', 'Apple MacBook Pro 16', 2399.99, 10, 'Apple MacBook Pro 16 offers incredible performance with an immersive display and long battery life.', 'Available'),
('P007', 'Google Pixel 6', 699.99, 50, 'The Google Pixel 6 has a clean design, superb camera, and excellent software integration.', 'Available'),
('P008', 'Fitbit Charge 5', 179.99, 150, 'A fitness tracker with heart-rate monitoring, built-in GPS, and a sleek design.', 'Available'),
('P009', 'Nintendo Switch OLED', 349.99, 75, 'Portable gaming console with vibrant display and exclusive Nintendo games.', 'Available'),
('P010', 'Sony PlayStation 5', 499.99, 25, 'Next-generation gaming console with ultra-fast load times and high-quality graphics.', 'Out of Stock'),
('P011', 'Microsoft Surface Pro 7', 799.99, 40, 'A 2-in-1 laptop/tablet hybrid with great performance and versatile functionality.', 'Available'),
('P012', 'HP Spectre x360', 1299.99, 15, 'Premium convertible laptop with impressive performance and sleek design.', 'Available'),
('P013', 'Logitech MX Master 3', 99.99, 200, 'Ergonomic mouse designed for productivity with customizable buttons and long battery life.', 'Available'),
('P014', 'Canon EOS R5', 3899.99, 5, 'High-end mirrorless camera with 8K video recording and exceptional autofocus.', 'Available'),
('P015', 'GoPro HERO10 Black', 499.99, 60, 'Action camera with 5.3K video recording, advanced stabilization, and waterproof capabilities.', 'Available'),
('P016', 'Apple AirPods Pro', 249.99, 100, 'Premium noise-canceling earbuds with great sound and seamless integration with Apple devices.', 'Available'),
('P017', 'Samsung 65" QLED TV', 1499.99, 30, '4K UHD QLED TV with stunning picture quality and vibrant colors for home entertainment.', 'Available'),
('P018', 'Dyson V11 Vacuum', 599.99, 40, 'Cordless vacuum with intelligent cleaning modes and strong suction power for deep cleaning.', 'Available'),
('P019', 'KitchenAid Stand Mixer', 379.99, 90, 'Iconic stand mixer with multiple attachments for baking, mixing, and more.', 'Available'),
('P020', 'Bose SoundLink Revolve+', 299.99, 120, 'Portable Bluetooth speaker with 360-degree sound and rugged, waterproof design.', 'Available'),
('P021', 'Acer Predator Helios 300', 1399.99, 35, 'High-performance gaming laptop with a 144Hz display and powerful NVIDIA GPU.', 'Available'),
('P022', 'Razer DeathAdder V2', 69.99, 250, 'Ergonomic gaming mouse with fast response time, high precision, and customizable lighting.', 'Available'),
('P023', 'JBL Charge 5', 179.99, 110, 'Portable Bluetooth speaker with deep bass and waterproof durability for outdoor use.', 'Available'),
('P024', 'Sony A7 III', 1999.99, 8, 'Full-frame mirrorless camera with excellent low-light performance and stunning image quality.', 'Available'),
('P025', 'Apple iPad Pro 12.9"', 1099.99, 45, 'Large-screen tablet with high performance, perfect for creative professionals and entertainment.', 'Available'),
('P026', 'Anker PowerCore 10000', 29.99, 300, 'Compact portable charger with a 10000mAh battery, ideal for quick charging on the go.', 'Available'),
('P027', 'Oculus Quest 2', 299.99, 75, 'Standalone VR headset with immersive virtual reality gaming and apps.', 'Available'),
('P028', 'Sennheiser Momentum 3', 399.99, 60, 'Premium wireless headphones with excellent sound, noise cancellation, and comfortable fit.', 'Available'),
('P029', 'Ring Video Doorbell 4', 199.99, 50, 'Video doorbell with HD video, two-way audio, and motion detection for home security.', 'Available'),
('P030', 'TP-Link Deco X60', 249.99, 70, 'Mesh Wi-Fi system that provides seamless internet coverage throughout your home.', 'Available');


-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
-- So sánh câu truy vấn trước và sau khi tạo index
alter table products add unique product_code_idx(product_code);
create index name_price_idx on products(product_name, product_code);

explain select product_name, product_price, product_amount
from products
where product_name like 'Apple%';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
-- Tiến hành sửa đổi view
-- Tiến hành xoá view

create view product_info as
select product_code, product_name, product_price, product_status
from products;
select * from product_info;

alter view product_info as
select product_code, product_name, product_price, product_status, product_amount, product_description
from products;

insert into product_info values
('P031', 'TP-Link Deco X60', 249.99, 'Available', 70, 'Mesh Wi-Fi system that provides seamless internet coverage throughout your home.');

drop view product_info;

-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
-- Tạo store procedure thêm một sản phẩm mới
-- Tạo store procedure sửa thông tin sản phẩm theo id
-- Tạo store procedure xoá sản phẩm theo id

delimiter //
create procedure get_products_info()
begin
	select * from products;
end //
delimiter ;

call get_products_info;

delimiter //
create procedure add_product(in i_product_code varchar(50),
    in i_product_name varchar(50),
    in i_product_price decimal(18,2),
    in i_product_amount int,
    in i_product_description longtext,
    in i_product_status varchar(50))
begin
	insert into products(product_code,product_name, product_price, product_amount, product_description, product_status) values 
    (i_product_code,i_product_name, i_product_price, i_product_amount, i_product_description, i_product_status);
end //
delimiter ;

call add_product('P032', 'TP-Link Deco X60', 249.99, 70, 'Mesh Wi-Fi system that provides seamless internet coverage throughout your home.','Available');

delimiter //
create procedure update_product_by_id(in i_id int,in i_product_code varchar(50),
    in i_product_name varchar(50),
    in i_product_price decimal(18,2),
    in i_product_amount int,
    in i_product_description longtext,
    in i_product_status varchar(50))
begin
	update products
    set product_code = i_product_code,
    product_name = i_product_name,
    product_price = i_product_price,
    product_amount = i_product_amount, 
    product_description = i_product_description, 
    product_status = i_product_status
    where id = i_id;
end //
delimiter ;

call update_product_by_id(32,'P123', 'TP-Link Deco X60', 249.99, 70, 'Mesh Wi-Fi system that provides seamless internet coverage throughout your home.','Available');

delimiter //
create procedure delete_product_by_id (in i_id int)
begin
	delete from products
    where id = i_id;
end //
delimiter ;

call delete_product_by_id(32);