-- 멤버
ALTER TABLE final.Member
	DROP PRIMARY KEY; -- 멤버 기본키

-- 멤버
DROP TABLE IF EXISTS final.Member;

DELETE FROM _cub_schema_comments WHERE table_name = final.Member;

-- 멤버
CREATE TABLE final.Member (
	`memberIdx` INTEGER NOT NULL AUTO_INCREMENT,
	`memberId`VARCHAR(50) NOT NULL, 
	`memberPw` VARCHAR(50) NOT NULL ,
	`memberName` VARCHAR(50) NOT NULL ,
	`memberEmail` VARCHAR(40) NOT NULL,
	`memberProfile` VARCHAR(100) NULL,
	`memberNickname` VARCHAR(50) NOT NULL ,
	`memberRegdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	`memberBirth` TIMESTAMP NULL ,
    PRIMARY KEY (`memberIdx`),
    UNIQUE KEY `member_memberid_uq` (`memberId`),
	UNIQUE KEY `member_memberNickname_uq` (`memberNickname`)
);

-- 멤버
ALTER TABLE Member
	ADD CONSTRAINT PK_Member -- 멤버 기본키
	PRIMARY KEY (
		memberIdx -- 멤버대리키
	);

ALTER TABLE Member
	MODIFY COLUMN memberIdx INTEGER NOT NULL AUTO_INCREMENT;

-- ALTER TABLE Member
--	MODIFY COLUMN memberIdx INTEGER NOT NULL AUTO_INCREMENT(1,1);

-- --------------------------------------------------------------------------------------------------------
-- 사진게시판
ALTER TABLE fianl.PhotoBoard
	DROP FOREIGN KEY FK_Member_TO_PhotoBoard; -- 멤버 -> 사진게시판

-- 사진게시판
ALTER TABLE final.PhotoBoard
	DROP PRIMARY KEY; -- 사진게시판 기본키

-- 사진게시판
DROP TABLE IF EXISTS final.PhotoBoard;

-- 사진게시판
CREATE TABLE final.PhotoBoard (
	`boardIdx` INTEGER NOT NULL AUTO_INCREMENT ,
	`boardPhoto` VARCHAR(100) NOT NULL ,
	`boardDiscription` text NULL ,
	`boardDate` TIMESTAMP  NULL DEFAULT CURRENT_TIMESTAMP,
	`hashtag` varchar(200) NULL ,
	`memberIdx` INTEGER NULL ,
    PRIMARY KEY (`boardIdx`),
	CONSTRAINT `FK_memberIdx` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);

-- 사진게시판
ALTER TABLE PhotoBoard
	ADD CONSTRAINT PK_PhotoBoard -- 사진게시판 기본키
	PRIMARY KEY (
		boardIdx -- 사진게시판대리키
	);

ALTER TABLE PhotoBoard
	MODIFY COLUMN boardIdx INTEGER NOT NULL AUTO_INCREMENT;

-- ALTER TABLE PhotoBoard
--	MODIFY COLUMN boardIdx INTEGER NOT NULL AUTO_INCREMENT(1,1);



-- 사진게시판
ALTER TABLE PhotoBoard
	ADD CONSTRAINT FK_Member_TO_PhotoBoard -- 멤버 -> 사진게시판
	FOREIGN KEY (
		memberIdx -- 게시글작성자
	)
	REFERENCES MY_SCHEMA.Member ( -- 멤버
		memberIdx -- 멤버대리키
	);
    
-- ---------------------------------------------------------------------------------------------------------------------

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	DROP FOREIGN KEY FK_PhotoBoard_TO_PhotoBoardComment; -- 사진게시판 -> 사진게시판-댓글

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	DROP FOREIGN KEY FK_Member_TO_PhotoBoardComment; -- 멤버 -> 사진게시판-댓글

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	DROP PRIMARY KEY; -- 사진게시판-댓글 기본키

-- 사진게시판-댓글
DROP TABLE IF EXISTS final.PhotoBoardComment;

-- 사진게시판-댓글
CREATE TABLE final.PhotoBoardComment (
	boardCommnetIdx INTEGER NOT NULL AUTO_INCREMENT ,
	comment text NOT NULL,
	commentDate TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	boardIdx INTEGER NULL ,
	memberIdx INTEGER NULL ,
    
    PRIMARY KEY (`boardCommnetIdx`),
    CONSTRAINT `FK_boardIdx` FOREIGN KEY (`boardIdx`) REFERENCES final.PhotoBoard(`boardIdx`),
    CONSTRAINT `FK_memberIdx` FOREIGN KEY (`memberIdx`) REFERENCES final.member(`memberIdx`)
);
--  KEY `boardIdx` (`boardIdx`),
 --   CONSTRAINT `FK_boardIdx` FOREIGN KEY (`boardIdx`) REFERENCES `PhotoBoard`(`boardIdx`),
 --    KEY `memberIdx` (`memberIdx`),
 --   CONSTRAINT `FK_memberIdx` FOREIGN KEY (`memberIdx`) REFERENCES `member` (`memberIdx`)
 
insert into final.PhotoBoardComment(comment,boardIdx,memberIdx) values( '안녕',1,1);

select * from final.PhotoBoardComment;

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	ADD CONSTRAINT PK_PhotoBoardComment -- 사진게시판-댓글 기본키
	PRIMARY KEY (
		boardCommnetIdx -- 댓글대리키
	);

ALTER TABLE PhotoBoardComment
	MODIFY COLUMN boardCommnetIdx INTEGER NOT NULL AUTO_INCREMENT;

-- ALTER TABLE PhotoBoardComment
--	MODIFY COLUMN boardCommnetIdx INTEGER NOT NULL AUTO_INCREMENT(1,1);

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	ADD CONSTRAINT FK_PhotoBoard_TO_PhotoBoardComment -- 사진게시판 -> 사진게시판-댓글
	FOREIGN KEY (
		boardIdx -- 사진게시판대리키
	)
	REFERENCES MY_SCHEMA.PhotoBoard ( -- 사진게시판
		boardIdx -- 사진게시판대리키
	);

-- 사진게시판-댓글
ALTER TABLE PhotoBoardComment
	ADD CONSTRAINT FK_Member_TO_PhotoBoardComment -- 멤버 -> 사진게시판-댓글
	FOREIGN KEY (
		memberIdx -- 댓글작성자
	)
	REFERENCES MY_SCHEMA.Member ( -- 멤버
		memberIdx -- 멤버대리키
	);