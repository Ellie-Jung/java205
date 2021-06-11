--2021.06.10
--function : 단일행 함수, 집합 (다중행) 함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중행(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환

select * from dual ; 

--숫자 함수
select abs (10), abs(-10)
from dual
;

select floor(15.7) --소수점 아래 절사
from dual
;

 -- 1하면 소숫점 첫재짜리에서 반올림  , -1하면 양수쪽으로 (정수방향) 첫째자리 15에서 5에서 반올림, -2면 십의자리에서 반올림
select ROUND(15.193,1), ROUND(15.193,-1), round(15.193,-2)
from dual
;

select TRUNC(15.79,1), trunc(15.79) --소숫점 첫재짜리에서 절사. 자리수 안쓰면 소숫점아래 싹다 절사
from dual;

select MOD(11,4) --11을 4로 나눈 나머지
from dual;


--사원들의 급여, 급여를 4로 나눴을때 나머지값
select sal, mod(sal,4)
from emp
where mod(sal,2)=1; --조건으로 함수값쓸수 있다. 


--문자함수
--concat (문자, 문자) -> 두개의 문자가 합해서 나옴 (문자열)-> ''||''
select concat('abc','efg'), 'abc'||'efg'
from dual;

--substr : 문자열 추출
--substr(문자열, 시작위치, 길이) --첫번째 문자열부터 3개, 여기서는 시작은 1부터 (0아님)
select substr('apple', 1,3) 
from dual;

select substr('apple',-3) --뒤에서 세개 뽑아내기
from dual;

-- replace : 특정 문자열 (패턴) 다른 문자열(패턴)으로 변경
select replace ('JACK and JUE','J','BL')
from dual;

select replace ('JACK and JUE','J','****')
from dual;

select sysdate
from dual;

--이런식으로 사용할수 있다.
select empno, ename , replace(ename, 'A', 'L') ,sal, round(sal,-2)
from emp ;




--------------------------------------------------------------------------------
--2021.06.11


-- 형변환 함수
-- 날짜  -> 문자 , 숫자 -> 문자
-- to_char(날짜 데이터, '패턴'),  to_char(숫자, '패턴')
--현재 날짜 출력 (sysdate)
select sysdate,to_char(sysdate, 'YYYY.MM.DD. HH24:MI:SS')   
from dual;

select ename, hiredate, to_char(hiredate,'YYYY.MM.DD.')
from emp
;

select * from orders;
select orderid, orderdate, to_char(orderdate,'YYYY.MM.DD.')
from orders
;


--숫자 -> 문자 (L은 현지통화)
select to_char(123456, '0,000,000,000'), to_char(123456, 'L9,999,999,999')
from dual
;

select ename, sal, to_char(sal*1100, 'L999,999,999')
from emp
;


-- 문자  -> 숫자,
-- to_number(문자열, 패턴)
select to_number('1,000,000','9,999,999'),to_number('1,000,000','9,999,999')+100000
from dual;


-- 문자 -> 날짜
-- 














