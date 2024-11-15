

-- SCHEDULE 테이블 생성
CREATE TABLE `SCHEDULE` (
                            `id`	bigint	NOT NULL,
                            `user_id`	bigint	NOT NULL,
                            `title`	varchar(50)	NOT NULL,
                            `contents`	varchar(200)	NOT NULL,
                            `created_at`	datetime	NOT NULL	DEFAULT current_timestamp,
                            `updated_at`	datetime	NOT NULL	DEFAULT current_timestamp
);

-- USER 테이블 생성
CREATE TABLE `USER` (
                        `id`	bigint	NOT NULL,
                        `username`	varchar(10)	NOT NULL,
                        `email`	varchar(50)	NOT NULL,
                        `password`	varchar(255)	NOT NULL,
                        `created_at`	datetime	NOT NULL	DEFAULT current_timestamp,
                        `updated_at`	datetime	NOT NULL	DEFAULT current_timestamp
);

-- 제약조건 설정
--SCHEDULE 테이블 PK 설정
ALTER TABLE `SCHEDULE` ADD CONSTRAINT `PK_SCHEDULE` PRIMARY KEY (
                                                                 `id`
    );

--USER 테이블 PK 설정
ALTER TABLE `USER` ADD CONSTRAINT `PK_USER` PRIMARY KEY (
                                                         `id`
    );

--SCHEDULE 테이블 FK 설정
ALTER TABLE `SCHEDULE` ADD CONSTRAINT `FK_USER_TO_SCHEDULE_1` FOREIGN KEY (
                                                                           `user_id`
    )
    REFERENCES `USER` (
                       `id`
        );

-- 일정 생성 쿼리
INSERT INTO SCHEDULE(id,
                     title,
                     contents,
                     created_at,
                     updated_at)
VALUES (1,
        "일정 제목",
        "일정 내용",
         current_timestamp,
         current_timestamp
       );

-- 일정 목록 조회 쿼리
SELECT *
FROM SCHEDULE
ORDER BY updated_at DESC; --수정일 기준 내림차순 정렬

-- 일정 상세 조회 쿼리
SELECT *
FROM SCHEDULE
WHERE id = 1;

-- 일정 수정 쿼리
UPDATE SCHEDULE
SET title     = "오늘의 일정 수정",
    updated_at = current_timestamp
WHERE id = 1;

-- 일정 삭제 쿼리
DELETE
FROM SCHEDULE
WHERE id = 1;

-- 사용자 생성 쿼리
INSERT INTO USER(id,
                 username,
                 email,
                 password,
                 created_at,
                 updated_at
                )
VALUES (1,
        "유저이름",
        "abcd@gmail.com",
        12345,
        current_timestamp,
        current_timestamp
        );

-- 사용자 정보 조회 쿼리
SELECT *
FROM USER
WHERE id = 1;

-- 사용자 정보 수정 쿼리
UPDATE USER
SET username = "유저 이름 수정",
    updated_at = current_timestamp
WHERE id = 1;

-- 사용자 삭제 쿼리
DELETE
FROM USER
WHERE id = 1;