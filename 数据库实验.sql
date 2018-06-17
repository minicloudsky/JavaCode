/*ѧ����*/
create table student(
sno Char(4) primary key,
sname Char(8) not null,
ssex Char(2) not null,
sage smallint,
sdept Char(10) not null,
);


/*�γ̱�*/
create table course(
cno Char(4) primary key,
cname Char(10) not null,
);

alter table course drop credit ;
/*ѡ�α�*/
create table sc(
sno Char(4) not null,
cno Char(4) not null,
cname Char(10) not null,
grade smallint not null check(grade >=0 and grade <=100),
primary key(sno,cno),
foreign key(sno) references student(sno),
foreign key(cno) references course(cno),
);

/*�ڿγ̱�������һ��credit�ֶ�*/
alter table course add credit smallint;

/*��ѡ�α���ɾ��cname*/
alter table sc drop column cname;

alter table sc add cname char(10) not null;

/*�������ݱ�*/

create table data
(
sname char(10) not null,
snumber char(15) not null primary key,
ssex char(2) not null,
sdept char(10) not null,
scourse char(6) not null,
);
drop table data;

/*ʵ��2*/
insert 
into student(sno,sname,ssex,sage,sdept)
values('1100','СС��','Ů','21','�����'),
('1101','������','Ů','21','ҽѧ����'),
('1102','�½��','��','22','��ҽ����'),
('1103','������','Ů','21','����'),
('1104','����ٻ','Ů','20','԰��'),
('1105','�����','Ů','21','ʦ��')
;

insert into course(cno,cname,credit)
values('1','���ݿ����','8'),
('2','���ݿ����','7'),
('3','���ݽṹ','6'),
('4','����','3');

insert into sc(sno,cno,grade,cname)
values('1100','1','90','Ӣ��'),
('1101','1','87','Ӣ��'),
('1102','2','45','���ݿ����'),
('1102','3','67','���ݽṹ'),
('1102','1','15','Ӣ��'),
('1103','1','99','Ӣ��'),
('1103','2','76','���ݿ����'),
('1103','3','66','���ݽṹ'),
('1104','4','55','����'),
('1105','2','81','���ݿ����');

/*������¼�޸�*/

update student set sage = 25 where sno ='1101';
update student set sage  = 34 where sno = '1102';
update student set sdept = 'CS' where sno = '1101';
update student set sdept = 'CS' where sno ='1102';
/*������¼�޸�*/
update student 
set sage = sage+1;
/*������¼����*/
insert into student(sno,sname,ssex,sage,sdept)
values('1107','������','��','20','����ҽѧ');

/*������¼����*/
insert into student(sno,sname,ssex,sage,sdept)
values('1108','����','��','19','����ѧԺ'),
('1109','����','��','23','���﹤��'),
('1110','����','Ů','21','����ѧԺ');

/*������¼ɾ��*/
delete from student where sname = '����';

/*���Ӳ�ѯ�Ķ�����¼ɾ��*/
delete from student  where sdept = '���﹤��';

/*��sc��������,��sno�������ٰ�cno����*/

create unique index scno on sc(sno asc,cno desc);
/*ɾ����������*/
drop index scno on sc;

/*��sc��������ֶ�sname*/
alter table sc add sname char(8);

drop table sc;

create table sc
(
sno char(4) not null,
cno char(4) not null,
cname char(10) not null,
sname char(10) not null,
grade smallint check(grade >=0 and grade <=100)
primary key(sno,cno),
foreign key(sno) references student(sno),
foreign key(cno) references course(cno),
);

select * from student;

/*��sc�����10����¼course : Ӣ�����ݿ����ݽṹ����*/
insert into sc(sno,cno,grade,cname,sname)
values('1100','1','45','Ӣ��','СС��'),
('1105','2','67','���ݿ�','�����'),
('1107','3','78','���ݽṹ','������'),
('1101','1','67','Ӣ��','������'),
('1101','2','89','���ݿ�','������'),
('1101','4','77','����','������'),
('1102','1','89','Ӣ��','�½��'),
('1108','2','65','���ݿ�','����'),
('1103','4','87','����','������'),
('1104','3','71','���ݽṹ','����');

update student 
set sname = 'С��'
where sno = '1108';
/*������ͼview1��Ҫ����sno��sname,cname,grade�ĸ��ֶ�*/
create view view1
as select sno,sname,cname,grade
from sc;
/*������ͼview2,Ҫ����sno,ssex,sage�����ֶ�*/
create view view2
as
select sno,ssex,sage
from student

/*(1)��ѯȫ��ѧ����ѧ�ź�������*/
select sno,sname from student;
/*(2)��ѯȫ��ѧ������ϸ��¼��*/
select * from student;
/*(3)��ѯȫ��ѧ���������ͳ�����ݡ�*/
select sname,2017-sage from student;
/*(4)��ѯѡ���˿γ̵�ѧ����ѧ�š�*/
select sno from student;
/*(5)��ѯ�����ϵ��ѧ����������*/
select sname from student where sdept in ('CS');
/*(6)��ѯ������20�����µļ����ϵ��ѧ����ѧ�ź����䡣*/
select sno,sage from student where sage<20 ; 
/*(7)��ѯ������20��22���ѧ����ѧ�š�*/
select sno from student where sage>=20 and sage <=22;
/*(8)��ѯ��Ϣϵ�������ϵ������ϵ��ѧ������Ϣ��*/
select * from student where sdept ='CS' or sdept='�����';

select * from student;
/*(9)��ѯ�ա�������ѧ������Ϣ��*/
insert into student(sno,sname,ssex,sage,sdept) 
values('1110','����','Ů','24','����');
select * from student where sname like '��%';
/*(10)��ѯѡ����3�ſγ̵�ѧ����ѧ�ż��ɼ�������������Ľ������С�*/
select sno,grade 
from sc
where cno='3'
order by grade desc;

/*(11)��ѯѧ����������*/
select count(*) from student;

/*(12)��ѯѡ��1�ſγ̵�ѧ������߷֡�*/
select max(grade)
from sc 
where cno = '1';

/*(13)��ѯѡ����3�����Ͽγ̵�ѧ����ѧ�š�*/
insert into sc(sno,cno,cname,sname,grade)
values('1101','3','���ݽṹ','������','99');
select sno from student where sno in
(select sno
from sc 
group by sc.sno
having count(*) >3);

/*(14)��ѯÿ��ѧ������ѡ�޿γ̵������*/
select sno,sname,cno,cname
from sc;
/*(15)��ѯѡ��2�ſγ��ҷ�����90�����ϵ�����ѧ����*/
select * from student,sc
where student.sno = sc.sno and sc.grade>90;
/*(16)��ѯÿ��ѧ����ѧ�š�������ѡ�������ɼ���*/
select sno,sname,cname,grade
from sc;
/*(17) ��ѯ�롰��������ͬһϵ��ѧ����*/
insert into student(sno,sname,ssex,sage,sdept)
values('1111','����','��','23','CS');
select * from student
where sdept in
(select sdept
from student where sname='����');

/*(18) ��ѯѡ���˿γ���Ϊ�����ݿ⡱��ѧ��ѧ�ź�������*/
select sno,sname 
from student where sno in
(select sno 
from sc 
where sc.cname='���ݿ�'
);

/*
(19) ��ѯû��ѡ��1�ſγ̵�ѧ����������*/
select sname from student 
where not exists
(select * from sc where sc.sno=student.sno and sc.cno='1');

/*(20) ��ѯѡ�������пγ̵�ѧ����������*/

select sname from student where sno in
(select sno from sc where
sno = '1' and cno ='2' and cno='3' and cno = '4');

insert into sc(sno,cno,grade,cname,sname)
values('1103','2','91','���ݿ�','������');

select sname from student 
where not exists
(select * from course
where not exists
( select * from sc 
where sc.sno = student.sno and sc.cno = course.cno));

select sname from student where sno in 
(select sno
from sc
where sc.sno = student.sno
group by sno having count(*) =
(select count(*) from course));