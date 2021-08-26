select * from final.mountain_code;

load data infile 'C:\Users\xhdnt\OneDrive\문서\카카오톡 받은 파일\MNT_CODE.csv' into table final.mountain_code FIELDS TERMINATED BY ',';

LOAD LOCAL DATA INFILE 'C:\Work\MNT_CODE.csv' INTO TABLE final.mountain_code FIELDS TERMINATED BY ',';

Query OK, 5 rows affected (0.28 sec)

Records: 5  Deleted: 0  Skipped: 0  Warnings: 0



