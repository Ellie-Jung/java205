----2121.06.14
--JOIN & SUBQUERY


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--
--(5) 박지성이구매한
--도서의출판사수

select count(distinct publisher)
from book join orders
using(bookid)
where custid =(select custid from customer where name ='박지성');

select count(distinct publisher)
from book b join orders o
on(b.bookid = o.bookid)
join customer c
on (c.custid = o.custid)
where c.name='박지성';


SELECT COUNT(DISTINCT PUBLISHER)
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTID = O.CUSTID AND O.BOOKID = B.BOOKID
AND C.NAME='박지성';

--박지성이 구매한 도서 ID
SELECT DISTINCT O.BOOKID
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID AND C.NAME = '박지성';

SELECT COUNT( DISTINCT PUBLISHER)
FROM BOOK
WHERE BOOKID IN(SELECT DISTINCT O.BOOKID 
                FROM ORDERS O, CUSTOMER C
                WHERE O.CUSTID  = C.CUSTID AND C.NAME = '박지성');


--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이

select bookname, saleprice, price - saleprice as pricegap
from book  b join orders o
on(b.bookid = o.bookid)
join customer c
on (c.custid = o.custid)
where c.name='박지성'
;

SELECT B.BOOKNAME, B.PRICE, B.PRICE-O.SALEPRICE
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE C.CUSTID = O.CUSTID AND O.BOOKID = B.BOOKID
AND C.NAME ='박지성';

SELECT B.BOOKNAME, B.PRICE, B.PRICE
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
AND CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성');


--(7) 박지성이구매하지않은
--도서의이름


--박지성이 구매한 도서의 BOOKID
SELECT BOOKID 
FROM ORDERS O, CUSTOMER C  
WHERE O.CUSTID = C.CUSTID AND C.NAME ='박지성';

Select bookname
from book 
where bookid not in(SELECT BOOKID 
                    FROM ORDERS O, CUSTOMER C  
                    WHERE O.CUSTID = C.CUSTID AND C.NAME ='박지성');


select bookname
from book 
where bookid not in(select bookid 
                    from orders 
                    where custid =(select custid 
                                   from customer 
                                   where name ='박지성'));
select bookname
from book 
where bookname not in (select bookname 
                       from book natural join orders natural join customer 
                       where name = '박지성');

select distinct bookname
from book left outer join orders
using (bookid)
where custid not in (select custid from customer where name ='박지성')or custid is null;




--2 마당서점의 운영자와 경영자가 요구하는 다음 질문에 대해 SQL 문을 작성하시오.

--(8) 주문하지않은고객의이름(부속질의사용)

select name
from customer
where custid not in(select custid 
                    from orders );

SELECT C.NAME
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID(+) = C.CUSTID
AND O.ORDERID IS NULL;

SELECT NAME
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT DISTINCT CUSTID FROM ORDERS)
;
SELECT DISTINCT CUSTID FROM ORDERS ;




--(9) 주문금액의총액과주문의평균금액

select sum(saleprice)as total, avg(saleprice) as avgsaleprice
from orders;

--(10) 고객의이름과고객별구매액

SELECT C.NAME, SUM(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID
GROUP BY C.NAME
;

select (select name
        from customer c 
        where c.custid = o.custid)as name, sum(saleprice)
from orders o
group by o.custid;




--(11) 고객의이름과고객이구매한도서목록

select c.name, b.bookname
from orders o join customer c
on c.custid = o.custid
join book b 
on b.bookid = o.bookid
order by c.name, b.bookname ;

SELECT C.NAME, B.BOOKNAME
FROM BOOK B, ORDERS O, CUSTOMER C
WHERE B.BOOKID=O.BOOKID AND O.CUSTID=C.CUSTID
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문

select *
from book natural join orders
where price- saleprice = (select max(price -saleprice) 
                            from book join orders
                            using (bookid));

SELECT MAX(B.PRICE-O.SALEPRICE)
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
;
SELECT B.BOOKNAME, B.PRICE-O.SALEPRICE
FROM ORDERS O, BOOK B
WHERE O.BOOKID=B.BOOKID
AND PRICE-SALEPRICE=(
    SELECT MAX(B.PRICE-O.SALEPRICE)
    FROM ORDERS O, BOOK B
    WHERE O.BOOKID=B.BOOKID
)
;


--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
select c.name
from customer c natural join orders o
group by c.name
having avg(saleprice) > (select avg(saleprice) from orders)
; 

SELECT C.NAME, AVG(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID=C.CUSTID
GROUP BY C.NAME
HAVING AVG(SALEPRICE)>(
    SELECT AVG(SALEPRICE) FROM ORDERS
)-- 평균 구매액
;


--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.

--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name
from customer natural join orders natural join book
where name!= '박지성' and publisher in(select publisher 
                                      from book natural join orders 
                                      where custid in(select custid 
                                                      from customer 
                                                      where name = '박지성' ));


--박지성이 구매한 도서의 출판사
SELECT B.PUBLISHER
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE O.CUSTID = C.CUSTID AND O.BOOKID = B.BOOKID
AND C.NAME ='박지성';


SELECT NAME
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE O.CUSTID=C.CUSTID AND O.BOOKID=B.BOOKID
AND B.PUBLISHER IN (
    SELECT DISTINCT B.PUBLISHER
    FROM ORDERS O, CUSTOMER C, BOOK B
    WHERE O.CUSTID=C.CUSTID AND O.BOOKID=B.BOOKID
    AND C.NAME='박지성'
)
AND C.NAME!='박지성'
;




--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name
from customer natural join orders natural join book
group by name
having count(distinct publisher)>=2
;


SELECT C.NAME, COUNT(DISTINCT PUBLISHER)
FROM ORDERS O, CUSTOMER C, BOOK B
WHERE O.CUSTID = C.CUSTID AND O.BOOKID = B.BOOKID
GROUP BY C.NAME
HAVING COUNT (DISTINCT PUBLISHER)>=2;