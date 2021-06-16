--2021.06.16

--DML



-- 데이터 입력 : 행 단위 입력
-- INSERT INTO 테이블명 (컬럼명, ... , ...) VALUES (데이터 , 데이터,...)
-- 입력하고자 하는 컬럼과 입력 데이터의 개수는 일치
-- 컬럼의 도메인과 입력데이터의 타입이 일치해야함
-- 기본키와 같이 NOT NULL인 경우 컬럼을 생략하면 안됨.
-- 모든 컬럼의 데이터를 입력시에는 컬럼명을 생략할 수 있다. 


-- 테스트 테이블 생성
CREATE TABLE dept01
AS
SELECT *FROM dept where 1=0;  --detp 테이블의 구조만 가지고 온다 


desc dept01; --컬럼의 순서,타입 확인
select * from dept01;

--10번부서 개발팀 서울 위치
insert into dept01 (deptno, dname, loc) 
            values (10, '개발팀', '서울');

 -- commit 해줘야 물리적으로 반영된다.
 
-- insert into dept ( dname, loc)  values ('개발팀', '서울'); -- 오류 . 기본키 컬럼은 생략불가

--데이터 저장할 컬럼 기술 생략 가능 : 모든 컬럼의 데이터를 입력 할 때
--values 절의 데이터의 순서 -> 테이블이 생성될때 정의된 컬럼의 순서 -> desc 컬럼명 (으로 확인한다)

insert into dept01 values (20, '디자인팀', '서울');

desc emp;

insert into emp (empno, deptno) values (7777,60);
select *from emp;
rollback;


desc orders;

insert into orders (orderid, custid, bookid) values (11, 6,11);



--서브쿼리를 이용해서 데이터 삽입하기
drop table dept02;

create table dept02
as
select * from dept where 1=0;

select * from dept02;

--데이터입력
insert into dept02
select*from dept;

insert into dept02
select*from dept02; --자기자신도 입력가능


-- 테이블 수정(변경) : 행 단위로 선택하고 변경하고자 하는 컬럼을 기술
--UPDATE 테이블명 SET 컬럼이름 = 새로운 데이터, 컬럼이름 = 새로운 데이터 WHERE 행을 선택하는 조건

CREATE TABLE dept03
as
select * from dept;

select * from dept03;

--모든 부서의 위치를 서울로 이동한다.
update dept03
set loc = 'SEOUL'  --모든 행을 대상으로하기 때문에 where조건이 필요없음
;

--10번 부서의 위치를 부산으로 이동, 부서명도  DEV로 바꾼다.
update dept03
set loc = 'BUSAN' , dname='DEV' -- not null제약조건이 없다면 null도 가능하다.
where deptno=10
;



--emp01 새롭게 생성하고, update
drop table emp01;
create table emp01
as select * from emp;
select *from emp01;


--모든 사원의 부서번호를 30번으로 수정
update emp01
set deptno =30;

--이번엔 모든 사원의 급여를 10% 인상
update emp01
set sal =sal*1.1;

--모든 사원의 입사일을 오늘로 수정
update emp01
set hiredate = sysdate;

rollback;

--부서번호가 10번인 사원의 부서번호를 30번으로 수정
update emp01
set deptno =30
where deptno =10;

--급여가 3000 이상인 사원만 급여를 10% 인상
update emp01
set sal = sal*1.1
where sal >=3000;


--1981년에 입사한 사원의 입사일이 오늘로 수정
update emp01
set hiredate = sysdate
where substr(hiredate,1,2) = '81';


--SCOTT 사원의 부서번호는 30번으로, 직급은 MANAGER로 한꺼번에 수정
update emp01
set job = 'MANAGER' , deptno=30
where ename ='SCOTT';

--SCOTT 사원의 입사일자는 오늘로, 급여를 50 으로 커미션을 4000 으로 수정
update emp01
set hiredate = sysdate , sal = 50, comm=4000
where ename = 'SCOTT';



--20번 부서의 지역명을 40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용
insert into dept01 select * from dept;
select * from dept01;
select loc from dept01 where deptno=40;

update dept01
set loc =(select loc from dept01 where deptno =40)
where deptno=20;


--서브 쿼리를 이용해서 부서번호가 20인 부서의 부서명과 지역명을 부서 번호가 10번인 부서와 동일하게 변경하
--set절의 서브쿼리 값이 단일 행이 나와야함.
--컬럼의 순서가 중요하다 ( set절과 서브쿼리 셀렉트 순서 동일하게 해야함)
update dept01
set (dname, loc) = (select dname, loc from dept01 where deptno=10)
where deptno=20;

select * from dept01 ;

--테이블에 불필요한 행을 삭제하기 위한 DELETE문
--데이터의 삭제 : 행단위 삭제
--deledte from 테이블이름 where 조건;

-- dept01 테이블의 모든 행을 삭제
delete from dept01;

--부서 테이블에서 이름이 SCOTT인 사원 삭제
delete from emp01 
where ename='SCOTT';

select * from emp01;

--사원 테이블에서 부서명이 SALES인 사원을 모두 삭제
delete from emp01
where deptno =(select deptno from dept where dname='SALES');



