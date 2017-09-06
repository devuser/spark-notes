-- Database: testdb

-- DROP DATABASE testdb;

-- CREATE DATABASE testdb
--  WITH OWNER = postgres
--       ENCODING = 'UTF8'
--       TABLESPACE = pg_default
--       LC_COLLATE = 'C'
--       LC_CTYPE = 'C'
--       CONNECTION LIMIT = -1;


drop table if exists users ;

create table if not exists users(
  id text,
  name text
  );

drop table if exists favorites;

 create table if not exists favorites(
 id text,
 userid integer,
 flag integer
 );

insert into users(id, name)
values('21341231231', 'Bob');


insert into users(id, name)
values('31231242322', 'Samantha');

select * from users;

select * from users where id = '21341231231';
 

   