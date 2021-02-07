--  Data Definition Language 

-- If you are having Class annotated with @Entity then no need of create table class
-- Insert data for Person Table

INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10001,  'Ranga', 'Hyderabad',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10002,  'James', 'New York',sysdate());
INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(10003,  'Pieter', 'Amsterdam',sysdate()); 


---- Insert data for Student Table

insert into student(id,name,passport_id) values(20001,'Baburao',40001);
insert into student(id,name,passport_id) values(20002,'Ajay',40002);
insert into student(id,name,passport_id) values(20003,'Adarsh',40003);


---- Insert data for Passport Table

insert into passport(id,number) values(40001,'E123456');
insert into passport(id,number) values(40002,'N123457');
insert into passport(id,number) values(40003,'L123890');


---- Insert data for Review Table

insert into review(id,rating,description) values(50001,'FIVE', 'Great Course');
insert into review(id,rating,description) values(50002,'FOUR', 'Wonderful Course');
insert into review(id,rating,description) values(50003,'FIVE', 'Awesome Course');