SELECT * FROM news.news_channel;

SELECT * FROM `xworkz.db`.matrimony;
create table `xworkz.db`.matrimony(
M_ID INT NOT NULL,
M_REG_NAME varchar(45) NOT NULL,
M_GENDER VARCHAR(45)NOT NULL ,
M_LOOKING_FOR VARCHAR(45) NOT NULL,
M_QUALIFICATION VARCHAR(45),
M_HABITS VARCHAR(45) NOT NULL
);
ALTER table `xworkz.db`.matrimony modify M_ID INT NOT NULL primary KEY;

select * from `xworkz.db`.matrimony;
update `xworkz.db`.matrimony set M_HABITS='Reading' where M_REG_NAME='Rakesh';
update customer_order set CUSTOMER_ID=3 where customer_order_ID=4;
select M_REG_NAME='Kiran', M_QUALIFICATION='Msc CS'  from `xworkz.db`.matrimony;
delete from `xworkz.db`.matrimony where M_REG_NAME='' and M_GENDER='' and M_QUALIFICATION='' ;
select count(M_ID) from `xworkz.db`.matrimony;
-- 