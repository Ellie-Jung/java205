drop table project.member;

CREATE TABLE project.`member` (
  `idx` int AUTO_INCREMENT,
  `id` varchar(20) COLLATE utf8_bin NOT NULL,
  `pw` varchar(20) COLLATE utf8_bin NOT NULL,
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `joinDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  CONSTRAINT member_idx_pk PRIMARY KEY (`idx`),
  CONSTRAINT member_memberid_uq UNIQUE KEY `id_UNIQUE` (`id`)
) ;

alter table project.member auto_increment = 1;

commit;

insert into project.member(id,pw,name) values('10','1234','길동');