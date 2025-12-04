use classicmodels;
EXPLAIN SELECT * FROM customers WHERE customerName = 'Land of Toys Inc.';
create index customer_name_idx on customers(customerName);

delimiter //
create procedure find_all_customers()
begin
	select * from customers;
end //
delimiter ;

call find_all_customers();

delimiter //
create procedure get_cus_by_id(in cus_num int(11))
begin
	select * from customers where customerNumber = cus_num;
end //
delimiter ;

call get_cus_by_id(175);

delimiter //
create procedure get_customers_count_by_city(in in_city varchar(50), out total int)
begin
	select count(customerNumber)
    into total
    from customers
    where city = in_city;
end //
delimiter ;

call get_customers_count_by_city('Lyon',@total);
select @total;

delimiter //
create procedure setCounter(inout counter int, in inc int)
begin
	set counter = counter + inc;
end //
delimiter ;

set @counter = 1;
call setCounter(@counter,1);
call setCounter(@counter,2);
select @counter;

create view customer_views as
select customerNumber, customerName, phone
from customers;

select * from customer_views;

create or replace view customer_views as
select customerNumber, customerName, contactFirstName, contactLastName, phone
from customers
where city = 'Nantes';

drop view customer_views;

