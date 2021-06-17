--2021.06.17

--  시퀀스 : 숫자를 생성하는 객체
-- 설정을 통해 일련번호를 생성 -> 기본키가 대리키인경우 입력되는 값으로 사용

--sequence :번호 재생기
create sequence pi_idx_pk;

select pi_idx_pk.nextval --기본정보 값 insert할때 이 값을 넣어준다. (기본키로 설정할때)
from dual; --할때마다 1씩 증가

select pi_idx_pk.currval
from dual; --현재 시퀀스가 가진 값을 확인



--dept 테이블 복사 -> deptno에 들어갈 데이터 시퀀스 생성 -> insert 테스트
drop table dept03;
create table dept03
as select * from dept where 1=0;   --구조만 복사
select *from dept03;


--시퀀스 생성
create sequence dept_deptno_seq
start with 10   --10부터 시작한다 부서
increment by 10  --10씩 증가
;

--dept03에 저장
--insert into dept03 values (10,'dev', 'seoul');  --이런식으로 기본키인 부서번호를 각각 넣어줘야함. 실수생길수있다. 
insert into dept03 values (dept_deptno_seq.nextval,'dev', 'seoul');  --기본키를 시퀀스 이용하여 생성, 10들어감
insert into dept03 values (dept_deptno_seq.nextval,'dev', 'seoul');  -- 10증가된 20이 입력됨









