-- 반복문 돌면서 데이터 insert 할 수 있는 저장 프로시저(Stored Procedure)
-- MySQL WorkBench -> Stored Procedure -> Create New Procedure 이용하면 기본 틀을 만들어줘 쉽게 작성 가능

-- PROCEDURE '프로시저 이름' (IN [매개변수 이름] [자료형], ... OUT [매개변수 이름] [자료형])
-- DECLARE [내부에서 사용할 변수 선언...] [자료형] DEFAULT [기본값]

CREATE DEFINER=`javauser`@`%` PROCEDURE `user_insert_procedure`(IN count int, IN new_town_id bigint) -- new_town_id 마을에 count개 데이터를 insert
BEGIN
	DECLARE i, last_id, new_id INT DEFAULT 1; -- 내부에서 사용할 변수 및 자료형, 기본값 설정
	SET last_id = (select user_account_id from user_account order by user_account_id desc limit 1); -- 테이블 가장 마지막에 저장된 ID값 조회
        WHILE i <= count DO
		SET new_id = (last_id + i); -- 새로 insert될 레코드의 ID (Auto_increment 대신 사용)
		INSERT INTO user_account (dtype, created_at, modified_at, login_id, login_pw, name, tel)
		VALUES ("User", now(), now(), concat("testUser_", new_id), concat("{noop}", new_id), concat("테스트_마을주민_", new_id), concat("222-2222-", (9999 - new_id)));

		INSERT INTO user (address, birth, info, user_account_id, town_id)
		VALUES (concat("테스트_주소_", new_id), "2022-12-12", concat("마을주민_정보_", new_id), new_id, new_town_id);

		SET i = i + 1;
	END WHILE;
END
