--2021.06.16


--view


--자주사용되는 
--30번 부서에 소속된 사원들의 사번과 이름과 부서번호를 출력하기 위한 
--SELECT문을 하나의 뷰로 정의해 봅시다.
create or replace view emp_view30
as
select empno, ename,deptno
from emp
where deptno =30;


select * from emp_view30;

SELECT VIEW_NAME, TEXT
FROM USER_VIEWS;

-- 뷰 삭제
drop view emp_view30;




--사원 중에서 입사일이 빠른 사람 5명(TOP-5)만을 얻어 오는 질의문을 작성해 봅시다.

--인라인 뷰를 이용한 top3 구하기.
select rownum, ename
from emp
order by hiredate
;


select rownum, ename
from (select * from emp order by ename);  --인라인뷰 생성할때 먼저 정렬. 


--입사일이 빠른 사람 5명만(TOP-N)을 얻어오기
--일련의 출력 데이터를 일단 임의의 순서로 정렬한 후에 그 중 일부의 데이터만 출력할 수 있도록 해야 하므로 
--ORDER BY 절을 사용하여 입사일을 기준으로 오름차순 정렬해 봅시다.
select rownum, ename, hiredate
from (select * from emp order by hiredate desc)
where rownum <6
;



select rownum, ename
from emp
order by hiredate
;

-- 입사일을 기준으로 정렬된 뷰 생성
create or replace view view_HIR
as
select *from emp order by hiredate
;

-- 해당 뷰에 ROWNUM 추가해서 정렬
select rownum, ename, hiredate from view_hir;

-- 정렬된 뷰에서 상위 5개 검색하기
select rownum, ename, hiredate
from view_hir
where rownum<6
order by ename
;








