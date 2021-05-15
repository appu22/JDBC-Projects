create table news.tallestBuilding(
T_ID int not null ,
T_NAME varchar(45) not null ,
T_LENGTH double not null,
T_COOUNTRY  varchar(45) not null,
T_CONSTRUCTEDATE  date not null,
T_CONSTRUCTEDATEBY  varchar(45)not null ,
T_AREA  varchar(45) not null,
primary key (T_ID)
);
delete FROM news.tallestbuilding where T_ID = 5;
SELECT * FROM news.tallestbuilding;
desc news.tallestbuilding;
SELECT distinct T_NAME FROM news.tallestbuilding order by T_LENGTH desc ;
SELECT * FROM news.tallestbuilding;
SELECT * FROM news.tallestbuilding;
update news.tallestbuilding set T_LENGTH=2000  where T_NAME='One World Trade Center';
SELECT distinct T_LENGTH FROM news.tallestbuilding order by T_LENGTH asc limit 5;
 SELECT T_NAME FROM news.tallestbuilding limit 5;
SELECT T_LENGTH FROM news.tallestbuilding order by T_LENGTH desc limit 5;