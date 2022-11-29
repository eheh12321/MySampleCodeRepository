-- MySQL에서 auto_increment 값 가져오는 방법

-- 1. Information_schema 이용
-- ** Information_schema는 auto_increment 값이 즉시 변경되지 않는다 (= 딱히 쓸데 없다)
select auto_increment from information_schema.tables where table_name = [테이블] and table_schema=database();


-- 2. last_insert_id() 이용
-- 가장 마지막에 insert 된 테이블의 insert_id를 조회할 수 있다.
-- insert 직후 해당 ID 값이 필요할 때 사용
select last_insert_id();


--  3. 제일 맨 뒤에 있는 데이터의 auto_increment 값을 직접 select 해서 사용하는 방법..?
select [auto_increment ID] from [테이블] order by [auto_increment ID] desc limit 1;


-- 테이블의 auto_increment 값 세팅
alter table [테이블] auto_increment=[번호];

