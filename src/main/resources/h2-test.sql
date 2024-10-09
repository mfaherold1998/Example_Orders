insert into client(email,name) values ('maria2000@gmail.com','Maria');

insert into product(price,name) values (20.0,'Shampoo');

insert into ordine(total, client_id, date_ordine, id) values (20.0,1,'2020-09-20');

insert into bill(total_amount,date_bill,ordine_id,id) values (20.0,'2020-09-20',1);

INSERT INTO public.order_product(ordine_id, product_id) values (1,1);
