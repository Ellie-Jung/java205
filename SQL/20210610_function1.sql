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



