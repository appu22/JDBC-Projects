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

