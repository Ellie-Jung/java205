----2021.06.16

----DML 
            --INSERT : CREATE
            --SELECT : READ
            --UPDATE : UPDATE
            --DELETE : DELETE 
                     --C R U D 라고 함.
                     
----앞에서 생성한 전화번호부 테이블을 기준으로 DML 을 작성해봅시다.

--1. phoneInfo_basic 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
desc phoneInfo_basic ;

----INSERT (CREATE)
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( pi_idx_pk.nextval,'김씨', '123-456','hab@naver.com','서울시 강남구');
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( pi_idx_pk.nextval,'박씨', '223-456','bdab@naver.com','부산시 사하구');
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber, fr_email, fr_address) values( pi_idx_pk.nextval,'강씨', '571-456','jdskl@naver.com','서울시 마포구');
insert into phoneInfo_basic(idx, fr_name, fr_phonenumber) values( pi_idx_pk.nextval,'정씨', '643-456');


----SELECT (READ)
select * from phoneInfo_basic ;

----UPDATE
update phoneInfo_basic set fr_address = '서울시 강서구' where IDX= 211; --기본키를 이용해서 수정하는게 좋다.

--DELETE 
delete from phoneInfo_basic where idx= '511';
delete from phoneInfo_basic;  --모든 행 삭제


--2. phoneinfo_univ 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL
--BASIC 정보가 존재한 이후에 UNIV정보가 존재해야한다. ( UNIV 정보만 있으면 소용없음) --두개다 입력되어야 입력됬다고봄.(하나의 트랜잭션)

desc phoneinfo_univ;


---- INSERT (CREATE)
insert into phoneInfo_basic values( pi_idx_pk.nextval,'박씨', '223-456','bdab@naver.com','부산시 사하구','2016/05/05');
insert into phoneInfo_univ(idx, fr_u_major,fr_u_year,fr_ref) values( pi_u_idx_pk.nextval,'물리학', '2',pi_idx_pk.currval);
insert into phoneInfo_univ(idx, fr_u_major,fr_ref) values( pi_u_idx_pk.nextval,'국문학',pi_idx_pk.cuurval);
insert into phoneInfo_univ(idx, fr_u_major,fr_u_year,fr_ref) values( pi_u_idx_pk.nextval,'영문학', '3',pi_idx_pk.currval);


----SELECT (READ)
select * from phoneinfo_univ;
select * from phoneInfo_basic pb left outer join phoneinfo_univ pu
on pb.idx=pu.fr_ref;


----UPDATE 
update phoneinfo_univ set fr_u_major='회계학' where idx=5; --IDX를 기준 또는 외래키로 구분해서 수정
update phoneinfo_univ set fr_u_major='정치학' where fr_ref=111;

----DELETE
delete from phoneinfo_univ where idx=5;        --자식먼저 지우고
delete from phophoneinfo_basic where idx= 511; --부모 지워야 완전히 삭제된다. 

--3. phoneinfo_com 테이블의 SELECT, UPDATE, DELETE, INSERT 하는 SQL

---- INSERT (CREATE)
insert into phoneInfo_basic values( pi_idx_pk.nextval,'박씨', '223-456','bdab@naver.com','부산시 사하구','2016/05/05');
insert into phoneInfo_com values( pi_c_idx_pk.nextval,'삼성', pi_idx_pk.currval);
insert into phoneInfo_com(idx, fr_c_company,fr_ref) values( pi_c_idx_pk.nextval,'현대', 511);

----SELECT (READ)
select * from phoneinfo_com;
desc phoneinfo_com;
select * from phoneInfo_basic pb left outer join phoneinfo_com pc
on pb.idx=pc.fr_ref;

----UPDATE
update phoneinfo_com set fr_c_company='현대' where idx=5;

----DELETE
delete from phoneinfo_com where idx=5;             --자식먼저 지우고
delete from phophoneinfo_basic where idx= 511;     --부모 지우기

--모든 친구 출력 ( outer join)
select* 
from  phoneInfo_basic pb left outer join phoneinfo_univ pu
on pb.idx=pu.fr_ref
left outer join phoneInfo_com pc
on pb.idx=pc.fr_ref;

select*
from phoneInfo_basic pb,phoneinfo_univ pu, phoneInfo_com pc
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+);


--삭제 (자식먼저 삭제하고 부모 삭제)
delete from phoneInfo_com where idx=1; 
delete from phoneInfo_univ where idx=1; 
delete from phoneInfo_basic where idx=111;



---대학친구, 회사 친구 테이블 -> 기본키 (대리키)  -> sequence 생성 ->insert 개선 

--sequence :번호 재생기
create sequence pi_idx_pk;
create sequence pi_u_idx_pk start with 7 increment by 1;  --중복되지 않는 위치에서 시작하는게 좋다
create sequence pi_c_idx_pk start with 7 increment by 1;

drop sequence pi_c_idx_pk;

