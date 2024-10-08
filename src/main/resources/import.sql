insert into client(id,email,name) values (1,'maria2000@gmail.com','Maria');
insert into client(id,email,name) values (2,'federico2000@gmail.com','Federico');
insert into client(id,email,name) values (3,'carlos2000@gmail.com','Carlos');
insert into client(id,email,name) values (4,'camila2000@gmail.com','Camila');

insert into product(id,price,name) values (1,20.0,'Shampoo');
insert into product(id,price,name) values (2,15.4,'Soap');
insert into product(id,price,name) values (3,10.0,'Oil');
insert into product(id,price,name) values (4,13.20,'toothbrush');

insert into ordine(total, client_id, "date", id) values (20.0,1,'2020-09-20',1);
insert into ordine(total, client_id, "date", id) values (15.4,2,'2020-09-19',2);
insert into ordine(total, client_id, "date", id) values (10.0,3,'2020-09-19',3);
insert into ordine(total, client_id, "date", id) values (13.20,4,'2020-09-17',4);

insert into bill(total_amount,date,ordine_id,id) values (20.0,'2020-09-20',1,1);
insert into bill(total_amount,date,ordine_id,id) values (15.4,'2020-09-19',2,2);
insert into bill(total_amount,date,ordine_id,id) values (10.0,'2020-09-19',3,3);
insert into bill(total_amount,date,ordine_id,id) values (13.20,'2020-09-17',4,4);

INSERT INTO public.order_product(ordine_id, product_id) values (1,1);
INSERT INTO public.order_product(ordine_id, product_id) values (1,2);
INSERT INTO public.order_product(ordine_id, product_id) values (2,2);
INSERT INTO public.order_product(ordine_id, product_id) values (2,3);
INSERT INTO public.order_product(ordine_id, product_id) values (3,1);
INSERT INTO public.order_product(ordine_id, product_id) values (3,4);
INSERT INTO public.order_product(ordine_id, product_id) values (4,1);
INSERT INTO public.order_product(ordine_id, product_id) values (4,4);

ALTER SEQUENCE public.client_id_seq INCREMENT BY 1 START 5 RESTART 5;
ALTER SEQUENCE public.ordine_id_seq INCREMENT BY 1 START 5	RESTART 5;
ALTER SEQUENCE public.product_id_seq INCREMENT BY 1 START 5 RESTART 5;
ALTER SEQUENCE public.bill_id_seq INCREMENT BY 1 START 5 RESTART 5;

commit;