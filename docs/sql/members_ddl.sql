/* ȸ�����̺� : members_ddl.sql 
 * 
 * 1. ���̵� : pk 
 * 2. ��й�ȣ : nn
 * 3. �̸� : nn
 * 4. ����ó : nn
 * 5. �̸��� : nn
 * 6. ������ : ������
 * 7. ��� : G, S, A
 * 8. ���ϸ���
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
