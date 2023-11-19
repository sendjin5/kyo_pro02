CREATE DATABASE team42;
USE team42;

-- member
CREATE TABLE MEMBER(
id VARCHAR(16) NOT NULL,   -- (아이디)
pw VARCHAR(300) NOT NULL,   -- (비밀번호)
NAME VARCHAR(100) NOT NULL,   -- (이름)
email VARCHAR(100) NOT NULL,   -- (이메일)
tel VARCHAR(13),   -- (전화번호)
birth DATE, -- 생년월일
address VARCHAR(300), -- 주소
postcode VARCHAR(10),
regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- (가입일)
POINT INT DEFAULT 0,   -- (포인트)
grade VARCHAR(4) DEFAULT 'F',
state BOOLEAN DEFAULT TRUE,
PRIMARY KEY (id)
);

-- 이미 생성한 테이블에서 member column 추가
-- ALTER TABLE member ADD state BOOLEAN DEFAULT TRUE;

-- qna
CREATE TABLE qna(
	qno INT PRIMARY KEY AUTO_INCREMENT,   -- (문의번호) 자동발생
	title VARCHAR(100) NOT NULL,   -- (문의 제목)
	content VARCHAR(1000) NOT NULL,   -- (문의 내용)
	author VARCHAR(16),   -- (문의 작성자)
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),   -- (문의 등록일)
	visited INT DEFAULT 0,   -- (조회수)
	lev INT DEFAULT 0, -- 질문(0), 답변(1)
	par INT,	-- 부모 글번호 -> 질문(자신 레코드의 qno), 답변(질문의 글번호)
	secret BOOLEAN DEFAULT 0,	-- 비밀글 유무
	FOREIGN KEY(author) REFERENCES member(id) ON DELETE CASCADE
);

-- faq
CREATE TABLE faq(
	fno INT PRIMARY KEY AUTO_INCREMENT,   -- (문의번호) 자동발생
	title VARCHAR(100) NOT NULL,   -- (문의 제목)
	content VARCHAR(1000) NOT NULL,   -- (문의 내용)
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP()   -- (문의 등록일)
);

-- 공지 테이블
create table notice(
no INT primary KEY AUTO_INCREMENT, 
title varchar(200) not NULL, 
content varchar(1000),
regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
visited INTEGER DEFAULT 0
);

-- 카테고리 테이블
-- A:초등교과서, B:초등참고서, C:초등문제집, D:초등기타, E:중등교과서,
-- F:중등참고서, G:중등문제집, H:중등기타, I:고등교과서, J:고등참고서,
-- K:고등문제집, L:고등기타, M:일반교과서, N:일반참고서, O:일반문제집,
-- P:일반기타, Q:유아콘텐츠, R:유아놀이, S:유아기타, T:해외서적,  U:해외콘텐츠
create table category(
	categoryId VARCHAR(4) PRIMARY KEY,
	categoryName varchar(100) not NULL
);

-- 상품 테이블 생성
create table product(
	proNo INT PRIMARY KEY AUTO_INCREMENT,
	categoryId VARCHAR(4) NOT NULL,
	procategory VARCHAR(100), -- 상품번호와 카테고리 아이디 결합
	price INT DEFAULT 0, -- 상품 가격
	title VARCHAR(100) NOT NULL,
	author VARCHAR(100), -- 저자
	content VARCHAR(2000), -- 상품 설명
	img VARCHAR(5000) default 0, -- 상품 썸네일
	regdate timestamp default CURRENT_TIMESTAMP(),
    video VARCHAR(5000) default 0 -- 상품 썸네일      //0828 추가 황교진 - product와 book 테이블을 하나로 합치기 위함
);
-- ALTER table product CHANGE thumbnail img VARCHAR(5000) DEFAULT 0;
-- ALTER TABLE product ADD video VARCHAR(5000) DEFAULT 0;
-- ALTER table product CHANGE description author VARCHAR(100) DEFAULT 0;

-- 도서 상품 추가 테이블 생성 - 사용안함
CREATE TABLE book(
	proNo INT, -- 상품 테이블 번호
	bookNo INT PRIMARY KEY AUTO_INCREMENT, -- 도서 고유번호
	publish VARCHAR(100), -- 출판사
	author VARCHAR(100), -- 저자
	title VARCHAR(100) NOT NULL,
	content VARCHAR(5000), -- 상품 설명
	img VARCHAR(5000) DEFAULT 'no_img.jpg', -- 이미지 리스트
	video VARCHAR(5000) DEFAULT 'no_video.mp4' -- 맛보기 동영상
);
	
-- 입고 테이블 생성
create table instock(
	inNo INT PRIMARY KEY AUTO_INCREMENT, -- 입고 번호
	proNo INT NOT NULL, -- 상품 번호
	amount INT NOT NULL DEFAULT 0, -- 입고 수량
	inPrice INT DEFAULT 0, -- 입고가
	regdate timestamp default CURRENT_TIMESTAMP -- 입고일
);

-- 출고 테이블 생성
create table outstock(
	outNo INT PRIMARY KEY AUTO_INCREMENT, -- 출고 번호
	proNo INT NOT NULL, -- 상품 번호
	amount INT NOT NULL DEFAULT 0, -- 출고량
	outPrice INT DEFAULT 0, -- 출고가
	regdate timestamp default CURRENT_TIMESTAMP -- 출고일
); 

-- 배송 테이블 생성
create table delivery(
	dno INT PRIMARY KEY AUTO_INCREMENT, -- 배송 번호
	payNo INT NOT NULL, -- 결제 번호
	memId VARCHAR(16) NOT NULL, -- 회원 아이디
	NAME VARCHAR(30) NOT NULL, -- 수신인 이름
	tel VARCHAR(13) NOT NULL, -- 수신인 연락처
	address VARCHAR(300) NOT NULL, -- 수신인 배송지
	dcom varchar(100), -- 배송 회사
	dtel varchar(13), -- 배송 기사 전화번호
	state integer default 0, -- 배송 상태(0: 배송 전, 1: 배송 중, 2: 도착, 3: 구매 결정)
	etd timestamp default CURRENT_TIMESTAMP, -- 예상 출발일
	eta DATE, -- 예상 도착일
	dcode varchar(30) -- 화물 코드
);

-- 결제 테이블 생성
create table payment(
	payNo INT PRIMARY KEY AUTO_INCREMENT, -- 결제 번호
	memId VARCHAR(16) not NULL, -- 회원 아이디
	proNo INT not NULL, -- 상품 번호
	payPrice INTEGER NOT NULL, -- 결제 금액
	amount integer default 1, -- 결제 수량
	method varchar(100), -- 결제 수단
	pcom varchar(100), -- 결제 회사(대행사)
	paccount VARCHAR(100), -- 결제 계좌/카드 번호
	dno INT -- 배송 번호
);


-- 카트 테이블 생성
create table cart(
	cartNo INT PRIMARY KEY AUTO_INCREMENT, -- 카트 번호
	memId VARCHAR(16) not NULL, -- 회원 아이디
	proNo integer not NULL, -- 상품 번호
	amount integer NOT NULL, -- 제품 수량
	price INTEGER DEFAULT 100,
	imgsrc1 VARCHAR(5000) DEFAULT 'no_img.jpg'
);


-- 리뷰 테이블
CREATE TABLE review(
	rno INT PRIMARY KEY AUTO_INCREMENT, -- 리뷰 번호
	memId VARCHAR(16) NOT NULL, -- 회원 아이디
	payNo INT NOT NULL, -- 결제 번호
	star INT DEFAULT 5, -- 별점
	content VARCHAR(1000), -- 리뷰 내용
	regdate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	proNo INT NOT NULL   -- 리뷰 대상 상품 번호
);

-- 재고 VIEW 생성
CREATE VIEW instockInventory AS (SELECT proNo, sum(amount) AS amount FROM instock GROUP BY proNo);
CREATE VIEW outstockInventory AS (SELECT proNo, sum(amount) AS amount FROM outstock GROUP BY proNo);
CREATE VIEW inventory AS (SELECT a.proNo, (a.amount-b.amount) AS amount FROM instockInventory a, outstockInventory b  WHERE a.proNo = b.proNo);

-- 재고는 페이지에서 알아서 계산하기
-- 재고 보정은 일단은 생각하지 말기~
-- select a.proNo as proNo, (sum(a.amount)-sum(b.amount)) as amount from instock a, outstock b where a.proNo=b.proNo group by a.proNo, b.proNo;
-- CREATE VIEW instockInventory AS(SELECT proNo, SUM(amount) AS amount FROM instock GROUP BY proNo);
-- CREATE VIEW outstockInventory AS(SELECT proNo, SUM(amount) as amount FROM outstock GROUP BY proNo);
-- SELECT a.proNo, a.amount AS inAmount, b.amount AS outAmount, (a.amount-b.amount) AS totalAmount FROM instockinventory a LEFT OUTER JOIN outstockInventory b ON a.proNo=b.proNo; 
-- SELECT a.proNo, (a.amount-b.amount) AS totalAmount FROM instockInventory a, outstockInventory b GROUP BY a.proNo, b.proNo;
-- select a.proNo as proNo, (sum(a.amount)-sum(b.amount)) as amount from instock a, outstock b where a.proNo=b.proNo group by a.proNo, b.proNo
-- create view inventory as (select a.proNo as proNo, (sum(a.amount)-sum(b.amount)) as amount from instock a, outstock b where a.proNo=b.proNo group by a.proNo, b.proNo);
-- SELECT * FROM inventory;

-- 전체 이익 통계 뷰 작성
create view profit as (select outNo, sum(outPrice*amount) as tot from outstock group by outNo EXCEPT select inNo, sum(inPrice*amount) as tot from instock group by inNo);

create table fileboard(
	no INT primary KEY AUTO_INCREMENT,
	title varchar(300),
	content varchar(1000),
	regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
	visited INTEGER DEFAULT 0,
	filename1 varchar(500),
	filename2 varchar(500),
	filename3 varchar(500)
);
