create database materials_management;

use materials_management;

create table materials (
	material_id varchar(20) primary key,
    material_name varchar(100) not null
);

create table delivery_notes (
	delivery_note_number varchar(20) primary key,
    delivery_date date not null
);

create table delivery_note_details (
	delivery_note_number varchar(20),
    material_id varchar(20),
    delivery_price decimal(20,2) not null,
    delivery_amount int not null check(delivery_amount > 0),
    primary key (delivery_note_number, material_id),
    foreign key (delivery_note_number) references delivery_notes(delivery_note_number),
    foreign key (material_id) references materials(material_id)
);

create table received_notes (
	received_note_number varchar(20) primary key,
    received_date date not null
);

create table received_note_details (
	material_id varchar(20),
    received_note_number varchar(20),
    received_price decimal(20,2) not null,
    received_amount int not null check(received_amount > 0),
    primary key (material_id, received_note_number),
    foreign key (material_id) references materials(material_id),
    foreign key (received_note_number) references received_notes(received_note_number)
);

create table providers (
	provider_id varchar(20) primary key,
    provider_name varchar(100) not null,
    address varchar(200)
);

create table provider_phone_numbers (
	provider_id varchar(20),
    phone_number varchar(20),
    primary key (provider_id, phone_number),
    foreign key (provider_id) references providers(provider_id)
);

create table purchase_orders (
	purchase_order_number varchar(20) primary key,
    purchase_date date not null,
    provider_id varchar(20),
    foreign key (provider_id) references providers(provider_id)
);

create table purchase_order_details (
	purchase_order_number varchar(20),
    material_id varchar(20),
    primary key (purchase_order_number, material_id),
    foreign key (purchase_order_number) references purchase_orders(purchase_order_number),
    foreign key (material_id) references materials(material_id)
);