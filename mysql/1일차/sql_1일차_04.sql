create table tbl_member (
no int not null primary key,
name varchar(10),
tel varchar(14)
);
insert into tbl_member(no, name, tel) values (100, '홍길동', '010-1111-1111');
insert into tbl_member(no, name, tel) values (200, '이순신', '010-2222-2222');

create table tbl_board(
board_no 	int not null primary key,
title 		varchar(100),
member_no 	int,
wdate 		date);
insert into tbl_board ( board_no, title, member_no, wdate) 
				values(1,'자바',100,'2022-12-01');
insert into tbl_board ( board_no, title, member_no, wdate) 
				values(2,'스프링',100,'2022-12-02');
insert into tbl_board ( board_no, title, member_no, wdate) 
				values(3,'SQL',200,'2022-12-02');
                
select count(*) from tbl_member;
select count(*) from tbl_board;
select m.*, b.* 
  from tbl_member m, tbl_board b
  where b.member_no = m.no
  order by no;
