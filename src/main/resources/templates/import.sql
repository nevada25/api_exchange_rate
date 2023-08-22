insert into coins (code_coin,name_coin) values ('USD','Dolares americanos');
insert into coins (code_coin,name_coin) values ('PEN','Nuevo sol Peruano');

insert into countries (code_country,name_country,id) values ('USA','Estados unidos de america');
insert into countries (code_country,name_country,id) values ('PERU','Peru');

insert into exchange_rates (amount,amount_purchase,amount_sale,coin_id,country_id,date_change,id) values (1,3.0,3.5,1,1,'2023-08-21');
insert into exchange_rates (amount,amount_purchase,amount_sale,coin_id,country_id,date_change,id) values (1,4.0,4.5,2,2,'2023-08-21');