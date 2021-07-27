create table project.guestbook_message(
	messageid int not null auto_increment primary key,
    guestname varchar(20) not null,
    password varchar(20) not null,
    message text not null,
    regdate timestamp default current_timestamp 
);

-- select
select *from project.guestbook_message order by regdate desc;
select *from project.guestbook_message order by regdate desc limit 0,3;
	-- limit index, count : 페이징 처리. 게시물 가장 첫번째부터 몇개씩 카운트. 게시물 10개일때 1번페이지에 세개, 2번 페이지 세개 보여지도록( 0부터3개, 3부터3개,이런식) ->오라클엔이게없어서 로우넘으로 top3 뽑기.  
select count(*) from project.guestbook_message ;
   
   
-- insert
insert into project.guestbook_message (guestname, password, message) values ('king', '1111', 'Hello');

-- update
update project.guestbook_message set guestname='scott', password='0000', message='안녕하세요' where messageid=1;

-- delete
delete from project.guestbook_message where messageid=1;


commit;

