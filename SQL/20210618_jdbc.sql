--20210618

--JDBC

select * from dept01;
select * from dept;

insert into dept01  values (dept01_deptno_seq.nextval,'dev','seoul');


--dept01  테이블에 deptno에 입력할 일련번호  -> 시퀀스로 만들어보자
create sequence dept01_deptno_seq
start with 10
increment by 10 ;


delete from dept01 where deptno = ?;

--20210618

--JDBC

select * from dept01;

insert into dept01  values (10,'dev','seoul');


--dept01  �뀒�씠釉붿뿉 deptno�뿉 �엯�젰�븷 �씪�젴踰덊샇  -> �떆���뒪濡� 留뚮뱾�뼱蹂댁옄
create sequence dept01_deptno_seq
start with 10
increment by 10 ;                         

update dept01 set dname =?, loc = ? where deptno = ?;







