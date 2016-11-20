/* 회원테이블 : members_ddl.sql 
 * 
 * 1. 아이디 : pk 
 * 2. 비밀번호 : nn
 * 3. 이름 : nn
 * 4. 연락처 : nn
 * 5. 이메일 : nn
 * 6. 가입일 : 현재일
 * 7. 등급 : G, S, A
 * 8. 마일리지
 * */

drop table members cascade constraint;

create table members(
	userid varchar2(12),
	userpw varchar2(16) not null,
	name varchar2(20) not null,
	mobile varchar2(13) not null,
	email varchar2(30) not null,
	entry_date varchar2(10),
	grade char(1),
	mileage number(6)
);

alter table members
add constraint PK_MEMBERS_USERID primary key (userid);
