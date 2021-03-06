--2021.06.15
--DDL EX

create table phoneInfo_basic ( idx NUMBER(6), 
                              fr_name VARCHAR2(20) NOT NULL,
                              fr_phonenumber VARCHAR2(20) NOT NULL,
                              fr_email VARCHAR2(20),
                              fr_address VARCHAR2(20),
                              fr_regdate DATE DEFAULT SYSDATE,
                         
                              constraint phoneInfo_basic_idx_PK PRIMARY KEY(idx)
                         
                              );
                  
create table phoneInfo_univ ( idx NUMBER(6),---대리키 만들어서 행을 좀 구별하고 검색등 편해짐
                              fr_u_major VARCHAR2(20)DEFAULT 'N' NOT NULL , 
                              fr_u_year NUMBER(1) DEFAULT 1 CHECK (fr_u_year between 0 and 5) NOT NULL,
                              fr_ref NUMBER(6) NOT NULL, --외래키는 같은 값으로 여러개 참조가능함. 유니크 키가 아니다.그래서 기본키를 둬야한다.
                              
                              constraint phoneInfo_univ_idx_PK PRIMARY KEY(idx),
                              constraint phoneInfo_univ_fr_ref_FK FOREIGN KEY (fr_ref)REFERENCES phoneInfo_basic(idx)
                              
                              );
                              
create table phoneInfo_com (  idx NUMBER(6),
                              fr_c_company VARCHAR2(20) DEFAULT 'N' NOT NULL, 
                              fr_ref NUMBER(6) NOT NULL,
                              
                              constraint phoneInfo_com_idx_PK PRIMARY KEY(idx),
                              constraint phoneInfo_com_fr_ref_FK FOREIGN KEY (fr_ref) REFERENCES phoneInfo_basic(idx)
                             
                              );                        
                              

   
                              
                              
                              