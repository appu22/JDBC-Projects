create table `xworkz.db`.river(
R_ID int ,
R_NAME varchar(15),
R_POLLUTED int ,
R_DAM_NO int ,
R_LENGTH int 
);
alter table `xworkz.db`.river modify R_ID int primary key;
desc `xworkz.db`.river;
alter table `xworkz.db`.river add R_ORIGIN varchar(15);
insert into `xworkz.db`.river values (1,'Ganga',1,5,2525,'Gongotri Glacier');
INSERT INTO river VALUES(1,'KAVERI',805,0,'KODAGU');
update river set R_POLLUTED=2 where R_ID=1;
SELECT * FROM `xworkz.db`.river;
desc  `xworkz.db`.river;
select * from  `xworkz.db`.river where R_NAME='Kaveri';
SELECT R_ID,R_LENGTH,R_POLLUTED FROM `xworkz.db`.RIVER WHERE R_NAME='Kaveri' AND R_ORIGIN='tala kaveri'