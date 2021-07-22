drop table if exists project.member;

CREATE TABLE project.`member` (
  `idx` int AUTO_INCREMENT,
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `pw` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `joinDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT member_idx_pk PRIMARY KEY (`idx`),
  CONSTRAINT member_memberid_uq UNIQUE KEY `id_UNIQUE` (`id`)
) ;

-- idx값을 1부터 다시 시작
alter table project.member auto_increment = 1;

commit;

-- select
select * from project.member;

-- insert
insert into project.member(id,pw,name) values('bit','1234','홍길동');
insert into project.member(id,pw,name) values('camp','0000','김길동');
insert into project.member(id,pw,name) values('star','1004','이길동');

-- update
update project.member 
set
pw = '1111', name ='tester'
where idx=1;

-- delete
delete from project.member where idx=1;
