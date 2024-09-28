insert into client(client_id,email,name) values (1,'maria2000@gmail.com','Maria');
insert into client(client_id,email,name) values (2,'federico2000@gmail.com','Federico');
insert into client(client_id,email,name) values (3,'carlos2000@gmail.com','Carlos');
insert into client(client_id,email,name) values (4,'camila2000@gmail.com','Camila');

insert into product(product_id,price,name) values (1,20.0,'Shampoo');
insert into product(product_id,price,name) values (2,15.4,'Soap');
insert into product(product_id,price,name) values (3,10.0,'Oil');
insert into product(product_id,price,name) values (4,13.20,'toothbrush');

insert into pedidos(pedidosid,total,client_id,date) values (1,20.0,1,'2020-09-20');
insert into pedidos(pedidosid,total,client_id,date) values (2,15.4,2,'2020-09-19');
insert into pedidos(pedidosid,total,client_id,date) values (3,10.0,3,'2020-09-19');
insert into pedidos(pedidosid,total,client_id,date) values (4,13.20,4,'2020-09-17');

insert into bill(bill_id,total_amount,date,pedidoid) values (1,20.0,'2020-09-20',1);
insert into bill(bill_id,total_amount,date,pedidoid) values (2,15.4,'2020-09-19',2);
insert into bill(bill_id,total_amount,date,pedidoid) values (3,10.0,'2020-09-19',3);
insert into bill(bill_id,total_amount,date,pedidoid) values (4,13.20,'2020-09-17',4);

insert into bill_product (bill_id,product_id) values (1,1);
insert into bill_product (bill_id,product_id) values (1,2);
insert into bill_product (bill_id,product_id) values (1,3);
insert into bill_product (bill_id,product_id) values (1,4);
insert into bill_product (bill_id,product_id) values (2,1);
insert into bill_product (bill_id,product_id) values (2,2);
insert into bill_product (bill_id,product_id) values (2,3);
insert into bill_product (bill_id,product_id) values (2,4);