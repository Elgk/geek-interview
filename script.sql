begin;

drop table if exists student;
create table student(id bigserial PRIMARY KEY, name varchar(100), mark int );
insert into student( name, mark) values
( 'Dave', 2),
( 'Ann', 4),
( 'Bill', 5);

commit;