/* ȸ�� crud : members_dml.sql */

/* �ʱ�ȭ ���ڵ� 
���̵�	��й�ȣ	�̸�		�޴���	
user01	pass01	������	010-1234-1111	lee@naver.com	2015/03/23	G	800000 
user02	pass02	������	010-1234-2222	min@google.com	2015/04/21	G	700000 
user03	pass03	������	016-1234-3333	han@nate.com	2014/12/20	G	600000 
user10	pass10	���ϸ�	017-123-4444	jin@naver.com	2013/04/21	S	0 
user11	pass11	���ϴ�	010-1234-5555	park@naver.com	2015/08/17	S	0 
admin	admin1004	Ȳ����	010-1234-7777	chan@my.com	2013/02/28	A	0 
*/

--1. ȸ������(ȸ��������ü) : boolean
-- jdbc sql : insert into members values(?,?,?,?,?,?,?,?)

insert into members
values('user01','pass01','������','010-1234-1111','lee@naver.com','2015/03/23','G',800000);

insert into members
values('user02','pass02','������','010-1234-2222','min@google.com','2015/04/21','G',700000);

insert into members
values('user03','pass03','������','016-123-3333','han@nate.com','2014/12/20','G',600000);

insert into members
values('user10','pass10','���ϸ�','017-123-4444','jin@naver.com','2013/04/21','S',0);

insert into members
values('user11','pass11','���ϴ�','010-1234-5555','park@naver.com','2015/08/17','S',0);

insert into members
values('admin','admin1004','Ȳ����','010-1234-7777','chan@my.co','2013/02/28','A',0);

commit;

--2. �α���(���̵�, ��й�ȣ) : ���
-- select grade from members userid=? and userpw=?
select grade from members where userid=? and userpw=?;

--3. ���̵� ã�� (�̸�, �޴���) / (�̸�, �̸���) : ���̵�
--select userid from members where name=? and mobile=?
--select userid from members where name=? and email=?

select userid from members where name='������' and mobile='010-1234-1111';
select userid from members where name='������' and email='lee@naver.com';

--4. ��й�ȣ ã�� (���̵�, �޴���) / (���̵�, �̸���) : �ӽù߱޾�ȣ (Utility)
--select userpw from members where name=? and mobile=?
--select userpw from members where name=? and email=?

select userpw from members where name='������' and mobile='010-1234-1111';
select userpw from members where name='������' and email='lee@naver.com';

--5. ���̵��ߺ�(���̵�) : boolean
-- select userid from members where userid=?
select userid from members where userid='user01';

--6. ��ȣ����(���̵�, ������ȣ, �����ȣ) : boolean
-- update members set userpw=? where userid=? and userpw=?
update members set userpw='�ӽù߱޾�ȣ' where userid='user01';
update members set userpw='�ӽù߱޾�ȣ' where userid='user01' and userpw='pass01';

--7. �α׾ƿ�() : void

--8. ��������ȸ(�α��ξ��̵� �Ǵ� Ư�����̵�) : ȸ��������ü
--select * from members where userid=?
select * from members where userid='user01';

--9. ����������(ȸ��������ü) : boolean
-- update members set userpw=?, name=?, mobile=?, email=? where userid=?
-- update members set userpw=?, name=?, mobile=?, email=?,entry_date=?, grade=?, mileage=? where userid=?

update members set userpw='�����ȣ', name='�����̸�', mobile='010-3333-3333', email='change@naver.com'
where userid='user01';

update members set userpw='�����ȣ', name='�����̸�', mobile='010-3333-3333', email='change@naver.com',
		entry_date='2015/01/01', grade='S', mileage=0
where userid='user01';


--10. ȸ��Ż��(�α��ξ��̵� �Ǵ� Ư�����̵�): void
-- delete members where userid=?
delete members where userid='user01';

--11. ��ü��ȸ���() : Collection - ArrayList / HashMap / HashSet
select * from members;
select * from members order by userid;

--12. ��ȭ��ȣ ��4�ڸ� ��ȸ��� : Collection
-- select * from members where phone like ?
select * from members where phone like '%1111';

--13. �������� ��ȸ��� : ���̵�, ��ȭ��ȣ, �̸� : Collection
--select * from members where userid=?
--select * from members where phone like ?
--select * from members where name like ?

select * from members where userid='user02';
select * from members where phone like '%1111%';
select * from members where name like '%��%';

--14. ��޺���() 
-- update members set grade=? where userid=?
update members set grade='S' where userid='user02';

--15. ���ϸ�������()
-- update members set mileage=? where userid=?
update members set mileage=1000000 where userid='user02';

