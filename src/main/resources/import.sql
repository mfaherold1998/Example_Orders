insert into client(email,name) values ('maria2000@gmail.com','Maria');
insert into client(email,name) values ('federico2000@gmail.com','Federico');
insert into client(email,name) values ('carlos2000@gmail.com','Carlos');
insert into client(email,name) values ('camila2000@gmail.com','Camila');

insert into product(price,name) values (20.0,'Shampoo');
insert into product(price,name) values (15.4,'Soap');
insert into product(price,name) values (10.0,'Oil');
insert into product(price,name) values (13.20,'toothbrush');

insert into ordine(total,client_id,date) values (20.0,1,'2020-09-20');
insert into ordine(total,client_id,date) values (15.4,2,'2020-09-19');
insert into ordine(total,client_id,date) values (10.0,3,'2020-09-19');
insert into ordine(total,client_id,date) values (13.20,4,'2020-09-17');
insert into ordine(total,client_id,date) values (13.20,4,'2020-09-17');

insert into bill(total_amount,date,ordine_id) values (20.0,'2020-09-20',1);
insert into bill(total_amount,date,ordine_id) values (15.4,'2020-09-19',2);
insert into bill(total_amount,date,ordine_id) values (10.0,'2020-09-19',3);
insert into bill(total_amount,date,ordine_id) values (13.20,'2020-09-17',4);

insert into order_product (ordine_id,product_id) values (1,1);
insert into order_product (ordine_id,product_id) values (1,2);
insert into order_product (ordine_id,product_id) values (1,3);
insert into order_product (ordine_id,product_id) values (1,4);
insert into order_product (ordine_id,product_id) values (2,1);
insert into order_product (ordine_id,product_id) values (2,2);
insert into order_product (ordine_id,product_id) values (2,3);
insert into order_product (ordine_id,product_id) values (2,4);

--commit;

--ALTER SEQUENCE public.bill_id_seq RESTART 4;
--ALTER SEQUENCE public.client_id_seq RESTART 4;
--ALTER SEQUENCE public.ordine_id_seq RESTART 5;
--ALTER SEQUENCE public.product_id_seq RESTART 4;

--commit;

--DROP SEQUENCE IF EXISTS bill_id_seq;
--CREATE SEQUENCE bill_id_seq START WITH 5 INCREMENT BY 1;

--DROP SEQUENCE IF EXISTS client_id_seq;
--CREATE SEQUENCE client_id_seq START WITH 5 INCREMENT BY 1;

--DROP SEQUENCE IF EXISTS ordine_id_seq;
--CREATE SEQUENCE ordine_id_seq START WITH 6 INCREMENT BY 1;

--DROP SEQUENCE IF EXISTS product_id_seq;
--CREATE SEQUENCE product_id_seq START WITH 5 INCREMENT BY 1;