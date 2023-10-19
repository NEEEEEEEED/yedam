 /*게시판 글번호(int) 작성자 제목 내용(longvarchar) 작성일자(date) 조회수(int)*/
 create table board(
 no		int				not null primary key,
 writer	varchar(10) 	not null,
 title	varchar(20)		not null,
 a		long varchar	not null,
 wdate	date			not null,
 count	int				not null
 );
 /*게시글 등록*/
insert into board (no,writer,title,a,wdate,count)
			values(1,'me','title','aaaa','2022-12-23',12);
 /*게시글에서 내용 수정*/
update board set a = 'bbbb' where no = 1;
 /*게시글 삭제*/
delete from board where no = 1;
select*
 from board;