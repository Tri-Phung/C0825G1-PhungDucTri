use sales_management;

insert into customers(customer_name, customer_age) values 
('Minh Quan',10),
('Ngoc Oanh',20),
('Hong Ha',50);

insert into orders(customer_id, order_date, order_total_price) values
(1,'2006-3-21',null),
(2,'2006-3-23',null),
(1,'2006-3-16',null);

insert into products(product_name, product_price) values
('May Giat',3),
('Tu Lanh',5),
('Dieu Hoa',7),
('Quat',1),
('Bep Dien',2);

insert into order_details values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select order_id, order_date, order_total_price
from orders

-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.customer_name, p.product_name
from customers c
join orders o on c.customer_id=o.customer_id
join order_details od on o.order_id=od.order_id
join products p on od.product_id=p.product_id


-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select c.customer_name
from customers c
left join orders o on c.customer_id=o.customer_id
where o.order_id is null
group by c.customer_name;


-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn 
-- (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. 
-- Giá bán của từng loại được tính = odQTY*pPrice)
select o.order_id, o.order_date, sum(od.order_QTY * p.product_price) as total_price
from orders o
join order_details od on o.order_id=od.order_id
join products p on od.product_id=p.product_id
group by o.order_id;