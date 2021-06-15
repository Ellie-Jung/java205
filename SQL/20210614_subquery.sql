--2021.06.14

--subquery

-- 스칼라 부속 질의 : select절 이후에 사용
-- 단일 행 & 단일 열 값이 사용된다. 
select o.custid, (
        select c.name
        from customer c
        where o.custid = c.custid
        ) as name
from orders o
;


--emp 테이블만 사용해서 사원 이름, 부서이름 출력
select e.ename, (
        select  d.dname 
        from dept d
        where e.deptno = d.deptno
        ) as dname
from emp e
;


select ename, dname
from emp, dept
where emp.deptno = dept.deptno
;


-- 마당서점의
-- 고객별
-- 판매액을 출력하세요
-- (결과는 고객 이름과 고객별 판매액을 출력)
select c.custid, c.name, sum(o.saleprice)
from orders o, customer c
where o.custid = c.custid
group by c.custid, c.name
;


select * from orders;

-- 스칼라 부속질의 이용
select custid, (
        select name
        from customer c
        where o.custid = c.custid
        ) as name,
        sum(o.saleprice) as "구매액"
from orders o
group by custid
;






--인라인 뷰 : from절 뒤에 사용되는 부속질의, 가상 테이블처럼 사용


--고객 번호가 2이하인  ->customer테이블
--고객의 판매액을 보이시오 -> orders 테이블
--(결과는 고객이름과 고객별 판매액 출력)
select o.custid, c.name, sum(o.saleprice)
from (select *from customer where custid <=2) c, orders o
where c.custid = o.custid
group by o.custid, c.name
;




--중첩 질의 : where절 뒤에 사용하는 부속질의
-- 비교연산자를 이용할 때는 단일행 단일열의 결과를 갖는 부속질의를 사용
-- > < >= <= !=
-- 평균 급여보다 더 많은 급여를 받는 사원을 검색

select  *
from emp
where sal > (select avg(sal) from emp)
order by sal
;

--평균 주문금액 이하의 주문에 대해서 주문번호와 금액을 보이시오 -->orders  ->메인쿼리부터 만들어놓고 하세요
select *
from orders
where saleprice <=(select avg(saleprice) from orders)
;
--평균 주문금액
select avg(saleprice) from orders;

--각 고객의 평균 주문금액보다 큰 금액의 주문 내역에 대해서 주문번호, 고객번호, 금액을 보이시오
select orderid, custid, saleprice
from orders o1
where saleprice > (select avg(saleprice) from orders o2 where o1.custid= o2.custid)
;
--각 고객의 평균 주문금액
select avg(saleprice) from orders where custid =1;




--다중행 연산자 IN
-- 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 동일한 부서에서 근무하는 사원 list
select distinct deptno
from emp
where sal >=3000
;

select * from emp where deptno in(10,20);

select * from emp where deptno in(select distinct deptno from emp where sal >=3000);




--대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오. 

select sum(saleprice)
from orders
where custid in(select custid from customer  where address like '%대한민국%')
;


--3번 고객이 주문한 도서의 최고 금액보다 더 비싼 도서를 구입한 주문의 주문번호와 금액을 보이시오
--ALL  and조건. 모두 만족해야함
--ANY는 or조건. 최소 하나라도 만족

select custid, saleprice
from orders
where saleprice > (select max(saleprice) from orders where custid =3 );

select custid, saleprice
from orders
where saleprice > all(select saleprice from orders where custid =3 );


SELECT * FROM EMP
WHERE SAL > ANY (SELECT SAL FROM EMP WHERE DEPTNO=30); -- 하나라도 참이면 참

SELECT * FROM EMP
WHERE SAL > ALL (SELECT SAL FROM EMP WHERE DEPTNO =30);


--EXISTS 연산자로 대한민국에 거주하는 고객에게 판매한 도서의 총 판매액을 구하시오.

select sum(saleprice)
from orders o
where exists(select * from customer c where address like '%대한민국%' and o.custid =c.custid );










