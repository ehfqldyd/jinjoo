/* 회원 crud : members_dml.sql */

/* 초기화 레코드 
아이디	비밀번호	이름		휴대폰	
user01	pass01	김은경	010-1234-1111	lee@naver.com	2015/03/23	G	800000 
user02	pass02	정유진	010-1234-2222	min@google.com	2015/04/21	G	700000 
user03	pass03	강동원	016-1234-3333	han@nate.com	2014/12/20	G	600000 
user10	pass10	김하린	017-123-4444	jin@naver.com	2013/04/21	S	0 
user11	pass11	이하늘	010-1234-5555	park@naver.com	2015/08/17	S	0 
admin	admin1004	황지은	010-1234-7777	chan@my.com	2013/02/28	A	0 
*/

--1. 회원가입(회원정보객체) : boolean
-- jdbc sql : insert into members values(?,?,?,?,?,?,?,?)

insert into members
values('user01','pass01','김은경','010-1234-1111','lee@naver.com','2015/03/23','G',800000);

insert into members
values('user02','pass02','정유진','010-1234-2222','min@google.com','2015/04/21','G',700000);

insert into members
values('user03','pass03','강동원','016-123-3333','han@nate.com','2014/12/20','G',600000);

insert into members
values('user10','pass10','김하린','017-123-4444','jin@naver.com','2013/04/21','S',0);

insert into members
values('user11','pass11','이하늘','010-1234-5555','park@naver.com','2015/08/17','S',0);

insert into members
values('admin','admin1004','황지은','010-1234-7777','chan@my.co','2013/02/28','A',0);

commit;

--2. 로그인(아이디, 비밀번호) : 등급
-- select grade from members userid=? and userpw=?
select grade from members where userid=? and userpw=?;

--3. 아이디 찾기 (이름, 휴대폰) / (이름, 이메일) : 아이디
--select userid from members where name=? and mobile=?
--select userid from members where name=? and email=?

select userid from members where name='김은경' and mobile='010-1234-1111';
select userid from members where name='김은경' and email='lee@naver.com';

--4. 비밀번호 찾기 (아이디, 휴대폰) / (아이디, 이메일) : 임시발급암호 (Utility)
--select userpw from members where name=? and mobile=?
--select userpw from members where name=? and email=?

select userpw from members where name='김은경' and mobile='010-1234-1111';
select userpw from members where name='김은경' and email='lee@naver.com';

--5. 아이디중복(아이디) : boolean
-- select userid from members where userid=?
select userid from members where userid='user01';

--6. 암호변경(아이디, 기존암호, 변경암호) : boolean
-- update members set userpw=? where userid=? and userpw=?
update members set userpw='임시발급암호' where userid='user01';
update members set userpw='임시발급암호' where userid='user01' and userpw='pass01';

--7. 로그아웃() : void

--8. 내정보조회(로그인아이디 또는 특정아이디) : 회원정보객체
--select * from members where userid=?
select * from members where userid='user01';

--9. 내정보변경(회원정보객체) : boolean
-- update members set userpw=?, name=?, mobile=?, email=? where userid=?
-- update members set userpw=?, name=?, mobile=?, email=?,entry_date=?, grade=?, mileage=? where userid=?

update members set userpw='변경암호', name='변경이름', mobile='010-3333-3333', email='change@naver.com'
where userid='user01';

update members set userpw='변경암호', name='변경이름', mobile='010-3333-3333', email='change@naver.com',
		entry_date='2015/01/01', grade='S', mileage=0
where userid='user01';


--10. 회원탈퇴(로그인아이디 또는 특정아이디): void
-- delete members where userid=?
delete members where userid='user01';

--11. 전체조회기능() : Collection - ArrayList / HashMap / HashSet
select * from members;
select * from members order by userid;

--12. 전화번호 뒷4자리 조회기능 : Collection
-- select * from members where phone like ?
select * from members where phone like '%1111';

--13. 다중조건 조회기능 : 아이디, 전화번호, 이름 : Collection
--select * from members where userid=?
--select * from members where phone like ?
--select * from members where name like ?

select * from members where userid='user02';
select * from members where phone like '%1111%';
select * from members where name like '%진%';

--14. 등급변경() 
-- update members set grade=? where userid=?
update members set grade='S' where userid='user02';

--15. 마일리지변경()
-- update members set mileage=? where userid=?
update members set mileage=1000000 where userid='user02';

