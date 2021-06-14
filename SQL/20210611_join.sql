--2021.06.11

--join

--cross join
--스키마의 합 : 집합의 곱 연산과 같다

select *  --모든 경우의수. (4 *14 = 56개)
from emp,dept;

--equi join
select *
from emp,dept
where emp.deptno = dept.deptno; --공통컬럼 (equi join) -- 외래키와 참조하는 릴레이션의 기본키와 같다.
                                                    -- 참조 테이블 기본키 도메인과 외래키의 도메인이 같다.

--마당서적
select * from orders;
select * from customer;
select * from book;
--구매 내역 출력(10개) -> 구매자 이름(5개), 책이름 (10)
--  orders              customer(custId통해)    book(bookid통해)

select * from orders, customer, book ; -- cross join 10*5*10 (총 500개)

select o.orderid, c.name, b.bookname
from orders o, customer c, book b 
where o.custid = c.custid and o.bookid = b.bookid
;

--ansi -> inner join
--오라클 EQUI JOIN
select *
from emp,dept
where emp.deptno = dept.deptno;

select * from emp e inner join dept d
on e.deptno = d.deptno;




-- 이름이 scott인 사람의  where e.ename = 'SCOTT' --겹치지 않는 컬럼은 앞에 테이블명생략가능
--부서명을 출력
--출력해야하는 컬럼을 가지는 테이블을 확인해보자
-- 이름 : emp, 부서명 : dept
select ename,dname,e.deptno  --deptno라고 하면 오류
from emp e, dept d
where e.deptno = d.deptno and ename = 'SCOTT'
order by d.dname, e.ename
;

--ansi join ( inner join)
select ename,dname,e.deptno
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename = 'SCOTT';

--비교하는 컬럼의 이름이 같을때
--on 절을 생략하고 ->using을 이용하면 조건식을 간략하게 처리
select e.ename,d.dname,deptno
from emp e inner join dept d
using (deptno)
where e.ename = 'SCOTT';

-- natural join (비교하는 컬럼의 이름이 같을때)
select *
from emp natural join dept;






--self JOIN : 자기 자신을 조인 (참조)
-- emp -> mgr 컬럼이 emp.empno 참조
select e.ename,e.empno, e.mgr , m.ename
from emp e,emp m
where e.mgr = m.empno (+) --  필요한 쪽에 (+) 붙이면 null표현가능. (아우터조인) - 오라클방식
;

--[ left | right | full ] outer join
select e.ename, e.mgr, m.ename as "관리자"
--from emp e left outer join emp m
from emp m right outer join emp e --위와 같은 결과
on e.mgr = m.empno
;


--outer join
select e.ename,e.empno, e.mgr , m.ename
from emp e,emp m
where e.mgr = m.empno (+); --표현하고자 하는 컬럼이 테이블의 반대쪽, null 값을 가지는 위치에 (+) 



--non equi join
--동등 비교가 아닌 크다 작다와 같은 비교로 조인의 조건을 작성

select * from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
--where e.sal>= s.losal and e.sal<= s.hisal
where sal between s.losal and s.hisal
order by e.ename
;

--ansi cross join
select *
from emp cross join dept
;



-- 마당서적 회원별 구매내역 출력
select c.name, o.orderid
from orders o, customer c
where o.custid = c.custid    --박세리는 출력이 안됨 (null)
order by c.name
;

select c.name, o.orderid
from orders o, customer c
where o.custid(+) = c.custid -- 박세리 출력하려고하면 custid쪽에 (+)
order by c.name
;

select c.name, count(o.orderid) as "구매횟수" , round(avg(saleprice))   --- 구매횟수를 카운트
from orders o, customer c
where o.custid(+) = c.custid -- 박세리 출력하려고하면 custid쪽에 (+) , 없으면 구매한 사람 이름만 출력 가능
group by c.name
order by c.name
;









