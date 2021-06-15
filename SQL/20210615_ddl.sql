--21.06.15

--DDL : 데이터 정의어

-- 테이블 생성 : create table
-- 테이블 수정 : alter table
-- 테이블 삭제 :  drop table

-- create table ( 컬럼이름 타입 (사이즈) 제약조건 정의, ...  )


-- create table ( 
--        컬럼이름 타입 (사이즈),           --컬럼. 타입 정의 도메인 정의
--         ..... , 
--        제약조건 정의,
--          ... 
--          )


--사원 테이블과 유사한 구조의 
--사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 
--EMP01 테이블을 생성해 봅시다.

 create table emp01 ( 
    empno number(4),     --사원번호
    ename varchar2(20),  --사원이름
    sal number(6,2)      --급여. 6자리에 소숫점 2자리
 );
 
 
 
 --서브 쿼리를 이용해서 기존 테이블의 구조를 복사하고 해당 튜플도 복사
 create table emp02
 as 
 select * from emp                --서브쿼리 결과를 emp02라는 새로운 테이블을 생성
 ;                                --내용은 다 가져오나, 제약조건은 가져오지 않는다.별도로 설정해줘야함 (데이터 백업용으로 사용)
 
 
 select * from emp02;
 
 --서브쿼리를 이용해서 기존의 테이블의 특정 컬럼만 지정해서 복사한후 새로운 테이블 생성
 create table emp03
 as
 select empno, ename, sal from emp;  
 
 select * from emp03;
 
 
 create table emp04 
 as
 select *from emp where deptno =30
 ;
 
 select * from emp04;
 
 
 --서브쿼리 이용해서 기존의 테이블의 구조만 복사해오는 오는 경우
 create table emp05      
 as
 select *from emp where 1=2;   --값은 무조건 false  , 행에있는 모든 튜플들은 복사되지않는다.
 
 select * from emp05;
 
 
 

 -- 테이블의 변경 :  alter table
 -- alter table 테이블이름  add 
 -- alter table 테이블이름  modify
 -- alter table 테이블이름  drop
 
 
  --EMP01 테이블에 문자 타입의 직급(JOB) 칼럼을 추가해 봅시다.
alter table emp01
add ( job varchar2(9) )
;
 
 desc emp01 ;   -- 테이블의 구조 보기
 
 
 --emp01 테이블의 job컬럼의 사이즈를 변경시
 alter table emp01
 modify ( job varchar(30)not null );                --해당 컬럼을 다시 정의하면 된다 (제약조건까지)
                                                    --해당 컬럼이 원래 테이블에 있건 없건, 다시 새롭게 정의한다고생각.
 
 --emp01 테이블의 job  컬럼을 삭제
 alter table emp01
 drop column job
 ;
 
 --테이블 삭제
 drop table emp03;
 
 
 SELECT * FROM EMP02;
 
--모든 행을 삭제하는 trucate : 롤백이 안된다.
TRUNCATE TABLE emp02;

 

 --테이블의 이름 변경 -> rename 현재이름 to 새로운 이름
rename emp01 to test;
desc test;
 
 
drop table emp02;

create table emp02
as
select empno, ename, sal, job from emp where 1= 0;    -- emp 테이블의 구조만 가져온다
 
 desc emp02;
 
insert into emp02 (empno, ename,sal,job) values(1000,'SON',3000,'MANAGER');
insert into emp02 (empno, ename,sal) values(1000,'SON',3000); -- job에  디폴트 제약조건넣을때 job 컬럼 생략가능하다.
insert into emp02 (empno, ename,sal,job) values(4000,'SON',3000,'MANAGER');
insert into emp02 values(2000,'SON',1000,'MANAGER'); --모든 항목 다 넣을때 앞에 칼럼이름 생략가능하다.
insert into emp02 (empno, ename,sal,job,deptno) values(1000,'SON',3000,'MANAGER',40);  --외래키지정시 데이터 넣기


SELECT *FROM EMP02; 
 
 
 
 create table emp02(
    empno number(4) not null unique,
    ename varchar2(20) not null,
    sal number(6,2),
    job varchar2(20)
    );


  create table emp02(
    empno number(4) primary key,   --기본키는 not null , unique조건 가짐
    ename varchar2(20) not null,
    sal number(6,2) check (sal >500 and sal <5000),
    job varchar2(20) default '미지정' --문자열의 디폴트 값 설정 , job 값 안적으면 '미지정' 들어감
    );
 
 
 
 --외래키 지정
 
  create table emp02(
    empno number(4) primary key,   --기본키는 not null , unique조건 가짐
    ename varchar2(20) not null,
    sal number(6,2) check (sal >500 and sal <5000),
    job varchar2(20) default '미지정', --문자열의 디폴트 값 설정 , job 값 안적으면 '미지정' 들어감
    deptno number(2) references dept(deptno)    --외래키 지정. --dept테이블의 deptno값은 10,20,30,40 임 (그 이외 값 넣으면 에러남)
    );

desc dept;
 
 
 
 
 
 --컬럼레벨에서 제약조건명 명시해서 제약조건 설정하기
 -- 제약조건명 설정하기 : [테이블명]_[칼럼명]_[제약조건유형]
 create table emp02(
    empno number(4) constraint emp02_empno_pk primary key,   --기본키는 not null , unique조건 가짐
    ename varchar2(20) constraint emp02_ename_nn not null,
    sal number(6,2) constraint emp02_sal_ck check (sal >500 and sal <5000),
    job varchar2(20) default '미지정', --문자열의 디폴트 값 설정 , job 값 안적으면 '미지정' 들어감  --제약이라기보다는 옵션임
    deptno number(2) constraint emp02_deptno_fk references dept(deptno)    --외래키 지정. --dept테이블의 deptno값은 10,20,30,40 임 (그 이외 값 넣으면 에러남)
    );

 
 
drop table emp03;
 --테이블 레벨에서 제약사항 정의
 create table emp03(
    empno number(4),---- constraint emp02_empno_pk primary key,   --기본키는 not null , unique조건 가짐
    ename varchar2(20) constraint emp03_ename_nn not null,  --not null 제약은은 컬럼레벨에서만 정의가능 (여기서만가능)
    sal number(6,2) constraint emp03_sal_ck check (sal >500 and sal <5000),
    job varchar2(20),---- default '미지정', --문자열의 디폴트 값 설정 , job 값 안적으면 '미지정' 들어감  --제약이라기보다는 옵션임
    deptno number(2),----constraint emp02_deptno_fk references dept(deptno)    --외래키 지정. --dept테이블의 deptno값은 10,20,30,40 임 (그 이외 값 넣으면 에러남)
  ----------------------------------------------------------------------
  ----제약 정의
  constraint emp03_empno_pk primary key(empno), -- 컬럼을 괄호안에 지정해줘야한다. --pk제약
  constraint emp03_deptno FOREIGN key (deptno) references dept (deptno)
  
  
  
  
    );
 
 
 
 
 
 
 
 
 
 
 