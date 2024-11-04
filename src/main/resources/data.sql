
insert into ordine(total, client_id, date_ordine, id) values (13.20,4,'2020-09-17',5);
insert into bill(total_amount,date_bill,ordine_id,id) values (13.20,'2020-09-17',5,5);
INSERT INTO public.order_product(ordine_id, product_id) values (5,2);

ALTER SEQUENCE public.ordine_id_seq INCREMENT BY 1 START 6	RESTART 6;
ALTER SEQUENCE public.bill_id_seq INCREMENT BY 1 START 6 RESTART 6;

commit;