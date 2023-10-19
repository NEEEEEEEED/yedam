insert into dev.customers( name, email, phone, address)
/*등록*/
values ('john Doe1', 'john@mail.com','010-0000-0000','');
/*수정*/
update customers set name = '김신' where id=1;
/*조회*/
select * from customers;
/*삭제*/
delete from customers where id =2;