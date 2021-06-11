--2021.06.11

--join

--cross join
--스키마의 합 : 집합의 곱 연산과 같다

select *  --모든 경우의수. (4 *14 = 56개)
from emp,dept;

select *
from emp,dept
where emp.deptno = dept.deptno;


-- 이름이 scott인 사람의  where e.ename = 'SCOTT' --겹치지 않는 컬럼은 앞에 테이블명생략가능
--부서명을 출력
--출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름 : emp, 부서명 : dept
select ename,dname,e.deptno  --deptno라고 하면 오류
from emp e, dept d
where e.deptno = d.deptno --and ename = 'SCOTT'
order by d.dname, e.ename
;


--self JOIN : 자기 자신을 조인 (참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.ename,e.empno, e.mgr , m.ename
from emp e,emp m
where e.mgr = m.empno (+) --  필요한 쪽에 (+) 붙이면 null표현가능. (아우터조인)
;
