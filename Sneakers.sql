set character set sjis;

Drop database if exists sneakers;
create database sneakers;
grant all on sneakers.* to 'user01'@'localhost' Identified by 'password';

Use sneakers

set session foreign_key_checks = 0;

drop table if exists product;
drop table if exists order_product;
drop table if exists orders;
drop table if exists category;

create table product(
product_no varchar(9) not null,
size varchar(2) not null,
picture_file varchar(100) not null,
product_name varchar(20) not null,
product_description varchar(100) not null,
inventory int not null,
unit_price int not null,
color char(2) not null,
handling_status char(1) not null,
category_no char(2) not null,
primary key (product_no, size)
);

create table category(
category_no char(2),
category_name varchar(20) not null,
primary key(category_no)
);

create table order_product(
order_no char(16),
product_no char(9),
size varchar(2),
quantity int not null,
primary key (order_no, product_no, size)
);

create table orders(
order_no char(16),
order_date char(11) not null,
delivery_date char(11) not null,
customer_name varchar(40) not null,
customer_kana varchar(40) not null,
customer_zip char(7) not null,
customer_address varchar(255) not null,
customer_address_kana varchar(255) not null,
customer_tel varchar(11) not null,
reciever_name varchar(40) not null,
reciever_kana varchar(40) not null,
reciever_zip char(7) not null,
reciever_address varchar(255) not null,
reciever_address_kana varchar(255) not null,
reciever_tel varchar(11) not null,
credit_brand varchar(10) not null,
credit_no varchar(16) not null,
cresit_limit varchar(4) not null,
credit_name varchar(40) not null,
primary key(order_no)
);

alter table product 
add foreign key (category_no) 
references category(category_no) 
on update restrict 
on delete restrict
;

alter table order_product 
add foreign key (product_no) 
references product(product_no) 
on update restrict 
on delete restrict
;
/*
alter table order_product 
add foreign key (size) 
references product (size) 
on update restrict 
on delete restrict
;
*/
alter table order_product 
add foreign key (order_no) 
references orders(order_no) 
on update restrict 
on delete restrict
;

insert into product values(
'ST-0001-R', 'S', 'red_sneaker.gif', '赤スニーカー', '赤いスニーカーです', 30,15000,'赤',0,'ST');
insert into product values(
'ST-0001-R', 'M', 'red_sneaker.gif', '赤スニーカー', '赤いスニーカーです', 30,15000,'赤',0,'ST');
insert into product values(
'ST-0001-G', 'M', 'green_sneaker.gif', '緑スニーカー', '緑のスニーカーです', 30,15000,'緑',0,'ST');
insert into product values(
'ST-0001-B', 'LL', 'blue_sneaker.gif', '青スニーカー', '青いスニーカーです', 30,15000,'青',0,'ST');

insert into category values('ST', 'スタンダードスニーカー');
insert into category values('LE', 'レザースニーカー');
insert into category values('DE', 'デザインスニーカー');
insert into category values('OT', 'その他備品');

insert into orders values('S001-2016-000001', '2016/07/07', '2016/07/07', '多摩川', 'タマガワ' , '2110000' , '適当', 'テキトウ' , '09011112222', '多摩川', 'タマガワ' , '2110000' , '適当', 'テキトウ' , '09011112222', 'Mastercard', '0000111122223333', '2007', 'TAMAGAWA');

insert into order_product values('S001-2016-000001','ST-0001-R', 'S', 2);
insert into order_product values('S001-2016-000001','ST-0001-R', 'L', 2);

