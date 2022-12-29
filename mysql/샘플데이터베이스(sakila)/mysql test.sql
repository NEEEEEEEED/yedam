insert into dev.customers( name, email, phone, address)
/*등록*/
values ('john Doe1', 'john@mail.com','010-0000-0000','');
/*수정*/
update customers set name = '김신' where id=1;
/*조회*/
select * from customers;
/*삭제*/
delete from customers where id =2;


create user '사용자ID'@'%' identified with mysql_native_password by '2214';
grant all privileges on dev.* to '사용자ID'@'%' with grant option;
flush privileges;

