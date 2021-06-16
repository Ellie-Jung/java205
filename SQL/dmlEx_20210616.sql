----2021.06.16

----DML 

--앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.
--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

desc phoneInfo_basic ;
select * from phoneInfo_basic ;

insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( 111,'김씨', '123-456','hab@naver.com','서울시 강남구');
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( 211,'박씨', '223-456','bdab@naver.com','부산시 사하구');
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( 311,'강씨', '571-456','jdskl@naver.com','서울시 마포구');
insert into phoneInfo_basic values( 511,'박씨', '223-456','bdab@naver.com','부산시 사하구','2016/05/05');

update phoneInfo_basic set fr_address = '서울시 강서구' where fr_name='박씨';

delete from phoneInfo_basic where idx= '511';



--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneinfo_univ;
select * from phoneinfo_univ;
select * from phoneInfo_basic pb left outer join phoneinfo_univ pu
on pb.idx=pu.fr_ref;

insert into phoneInfo_univ(idx, fr_u_major,fr_u_year,fr_ref) values( 111,'물리학', '2',111);
insert into phoneInfo_univ(idx, fr_u_major,fr_ref) values( 211,'국문학',111);
insert into phoneInfo_univ(idx, fr_u_major,fr_u_year,fr_ref) values( 511,'영문학', '3',511);

update phoneinfo_univ set fr_u_major='회계학' where idx=511;

delete from phoneinfo_univ where idx=511;
delete from phoneinfo_univ;

--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
select * from phoneinfo_com;
desc phoneinfo_com;
select * from phoneInfo_basic pb left outer join phoneinfo_com pc
on pb.idx=pc.fr_ref;

insert into phoneInfo_com(idx, fr_c_company,fr_ref) values( 111,'삼성', 111);
insert into phoneInfo_com(idx, fr_c_company,fr_ref) values( 511,'현대', 511);

update phoneinfo_com set fr_c_company='현대' where idx=511;

delete from phoneinfo_com where idx=511;

--모든 친구 출력 ( outer join)
select* 
from  phoneInfo_basic pb left outer join phoneinfo_univ pu
on pb.idx=pu.fr_ref
left outer join phoneInfo_com pc
on pb.idx=pc.fr_ref;

--삭제 (자식먼저 삭제)
delete from phoneInfo_com where idx=511; 
delete from phoneInfo_univ where idx=511; 
delete from phoneInfo_basic where idx=511;