--2021.06.17

-- INDEX : 검색을 빠르게 하기위한 객체
-- 물리적인 저장 공간이 필요
-- 생성 시간이 필요
-- 너무 많은 인덱스는 DML작업이 많은 경우 성능 저하가 온다.



--인덱스가 아닌 컬럼으로 검색하기
--EMP01 테이블을 복사 -> 로우들을 계속 복사
DROP TABLE  EMP01;
create table emp01
as select *from emp;
SELECT * FROM EMP01;

insert into emp01 select * from emp01;
insert into emp01 (empno, ename) values (7777, 'KING');

select * from emp01 where ename ='KING';


--emp01 테이블에 ename 컬럼을 index설정
create index index_emp01_ename
on emp01(ename);

