-- joint table  primary key
--  5 types inner join
alter table customer_order add constraint foreign key (CUSTOMER_ID) references customer_details(CUSTOMER_ID);
update customer_order set CUSTOMER_ID=1 where customer_order_ID=1; 
update customer_order set CUSTOMER_ID=3 where customer_order_ID=4; 
insert into customer_order values (5,'IronBox',1050,4);
--  -------------------------------------------------------------------------------------------
select c.CUSTOMER_ID,c.CUSTOMER_Name,c.CUSTOMER_Address, o.customer_order_ID, o.customer_order_Name from 
customer_details c inner join customer_order o on c.CUSTOMER_ID=o.customer_order_ID;
