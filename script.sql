begin

drop table if exists student;
create table student(id bigint PRIMARY KEY, name varchar(100), mark int );
insert into student(id, name, mark) values
(1, 'Dave', 2),
(2, 'Ann', 4),
(3, 'Bill', 5);

commit;