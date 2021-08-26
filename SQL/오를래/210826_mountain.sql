
-- 셀렉결과로 테이블생성
create table final.mnt (select mountain_info_idx, mNTN_NM, mcode,mNTN_LOCPLC_REGION_NM,t100_FAMMNT_SELECT_DTCONT,mNTN_HG_VL,dETAIL_INFO_DTCONT,tRNSPORT_INFO_DTCONT 
from final.t100_mountain_info t left outer join final.mnt_code m on t.mNTN_NM = m.mname);


-- 아우터 조인으로 셀렉트 결과 (산코드랑 t100테이블 조인)
select mountain_info_idx, mNTN_NM, mcode,mNTN_LOCPLC_REGION_NM,t100_FAMMNT_SELECT_DTCONT,mNTN_HG_VL,dETAIL_INFO_DTCONT,tRNSPORT_INFO_DTCONT 
from final.t100_mountain_info t left outer join final.mnt_code m on t.mNTN_NM = m.mname;


insert into final.mt(infoidx, mname, mcode, address, info, height,detail,transport) select mountain_info_idx, mNTN_NM, mcode,mNTN_LOCPLC_REGION_NM,t100_FAMMNT_SELECT_DTCONT,mNTN_HG_VL,dETAIL_INFO_DTCONT,tRNSPORT_INFO_DTCONT from final.mnt;

select mountain_info_idx, mNTN_NM, mcode,mNTN_LOCPLC_REGION_NM,t100_FAMMNT_SELECT_DTCONT,mNTN_HG_VL,dETAIL_INFO_DTCONT,tRNSPORT_INFO_DTCONT from final.mnt;

select * from final.mt;