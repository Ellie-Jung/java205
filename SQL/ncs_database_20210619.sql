--#1 아래 환경에 맞는 개발환경을 구축하는 절차를 순서대로 작성하시오.
--
--- 환경 =============================================
--1. 운영체제 : MS Windows , 64비트
--2. 데이터베이스 시스템 : Oracle 11g R2
--==================================================
--
--#2 요구사항에 맞는 오브젝트를 생성하는 sql을 작성하시오.
--1. 대리키 IDX, 회원 아이디, 이름, 비밀번호, 사진이름, 가입일 을 저장할 수 있는 이름이 MEMBER인 테이블을 생성하세요. 
--   회원 아이디에는 기본키 제약설정을 하고, 이름과 비밀번호에는 not null,  가입일은 기본 값으로 sysdate가 입력되도록 하시오.

create table MEMBER ( IDX NUMBER(10) CONSTRAINT MEMBER_IDX_PK PRIMARY KEY,
                      id VARCHAR2(10),
                      name VARCHAR2(10) CONSTRAINT MEMBER_NAME_NN NOT NULL,
                      password VARCHAR2(20)CONSTRAINT MEMBER_PASSWORD_NN NOT NULL,
                      picname VARCHAR2(20),
                      joindate DATE DEFAULT SYSDATE
                      );
                      
     
--2. Member 테이블에서 이름 컬럼으로 인덱스 객체를 생성하시오.
CREATE INDEX IDX_MEMBER_NAME ON MEMBER(NAME);

--3. MEMBER 테이블에서 회원 아이디, 이름, 사진 정보만을 출력하는 view 객체를 생성하시오. view의 이름은 member_view 로 생성하시오.
CREATE VIEW MEMBER_VIEW 
AS 
SELECT ID, NAME, PICNAME FROM MEMBER ;