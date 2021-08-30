select infoidx, mname, mcode,address,x,y,info,height,detail,transport,img
from final.mt left outer join final.topadd on mname=name;

create table final.m(select infoidx, mname, mcode,address,x,y,info,height,detail,transport,img
from final.mt left outer join final.topadd on mname=name);

select * from final.m;

SELECT * FROM final.mountain;

insert into final.mountain(infoidx, mname, mcode,address,x,y,info,height,detail,transport,img) 
select infoidx, mname, mcode,address,x,y,info,height,detail,transport,img from final.m;

drop table final.m;