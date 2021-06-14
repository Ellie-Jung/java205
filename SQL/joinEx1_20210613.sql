--2021.06.13


--32. EQUI 조인을 사용하여 SCOTT 사원의 부서번호와 부서 이름을 출력하시오.
select emp.deptno, dept.dname
from emp, dept
where emp.deptno = dept.deptno and emp.ename = 'SCOTT';

--ANSI join
select emp.deptno, dept.dname
from emp join dept
on emp.deptno = dept.deptno --조인의 조건
--using(deptno)
where emp.ename = 'SCOTT'; --행을 선택하는 조건

--33. INNER JOIN과 ON 연산자를 사용하여 사원 이름과 함께 그 사원이 소속된 부서이름과 지역 명을 출력하시오.
select e.ename, d.dname, d.loc
from emp e inner join dept d
on e.deptno = d.deptno;

--equi join
select e.ename, d.dname, d.loc
from emp e ,dept d
where e.deptno = d.deptno;

--36. 조인과 WildCARD를 사용하여 이름에 ‘A’가 포함된 모든 사원의 이름과 부서명을 출력하시오.
--natural join
select e.ename, d.dname
from emp e natural join dept d
where ename like '%A%';

--using 
select e.ename, d.dname
from emp e  join dept d
using(deptno)
where ename like '%A%';

--equi join
select e.ename, d.dname
from emp e,dept d
where e.deptno = d.deptno and ename like '%A%';

--37. JOIN을 이용하여 NEW YORK에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오.
select e.ename, e.job, e.deptno, d.dname
from emp e inner join dept d
on e.deptno = d.deptno
where d.loc ='NEW YORK';

-- equi join
select e.ename, e.job, e.deptno, d.dname
from emp e , dept d
where e.deptno = d.deptno and d.loc ='NEW YORK';

--38. SELF JOIN을 사용하여 사원의 이름 및 사원번호, 관리자 이름을 출력하시오.
select e.ename, e.empno,d.ename as mgrname
from emp e, emp d
where e.mgr= d.empno;

--ANSI join
select e.ename, e.empno,d.ename as mgrname
from emp e join emp d
on e.mgr= d.empno;

--39. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 출력하시오.
select e.ename, e.empno , d.ename 
from emp e, emp d
where e.mgr = d.empno(+)
order by empno desc;

--ANSI join
select e.ename, e.empno , d.ename 
from emp e left join emp d
on e.mgr = d.empno
order by empno desc;

--40. SELF JOIN을 사용하여 지정한 사원의 이름, 부서번호, 지정한 사원과 동일한 부서에서 근무하는 사원을 출력하시오. ( SCOTT )
select e.ename, e.deptno, d.ename
from emp e, emp d
where e.deptno = d.deptno and e.ename ='SCOTT' and d.ename!= 'SCOTT';

--ANSI join
select e.ename, deptno, d.ename
from emp e join emp d
using(deptno)
where e.ename ='SCOTT' and d.ename!= 'SCOTT';


--41. SELF JOIN을 사용하여 WARD 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하시오.
select d.ename, d.hiredate
from emp e , emp d
where e.hiredate < d.hiredate and e.ename = 'WARD'
order by d.hiredate
;

--ANSI join
select d.ename, d.hiredate
from emp e join emp d
on e.hiredate < d.hiredate and e.ename = 'WARD'
order by d.hiredate
;

--42. SELF JOIN 을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 관리자의 이름 및 입사일과 함께 출력하시오.
select e.ename, e.hiredate,d.ename,d.hiredate
from emp e, emp d
where e.hiredate < d.hiredate and e.mgr = d.empno
;

--ANSI join
select e.ename, e.hiredate,d.ename,d.hiredate
from emp e join emp d
on e.hiredate < d.hiredate and e.mgr = d.empno
;
