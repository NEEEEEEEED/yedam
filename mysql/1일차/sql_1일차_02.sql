create table test2(
id   int         not null primary key,
col1 int         null,
col2 float       null,
col3 varchar(45) null
);

/*번호, 이름(*), 전화번호, 가입일자, 나이

*/
drop table member;

create table member (
no 		int 		not null primary key,
name 	varchar(10) not null,
tel 	varchar(14),
rdate	date,
age 	int			
);
insert into member (no,name,tel) values(101,'이순신','010-1111-2222');
insert into member (no,name) values(100,'홍길동');
delete from member where no = 100;
update member set tel = '010-3333-4444' where no = 101;

select*
 from member;
 
 

 
