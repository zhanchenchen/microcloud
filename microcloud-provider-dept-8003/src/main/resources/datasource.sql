drop database if exists dept8003;
create database dept8003 character set utf8;
use dept8003;
create table dept(
 deptno bigint auto_increment,
 dname varchar(50),
 loc varchar(50),
 constraint pk_deptno primary key(deptno)
)engine=innodb;
insert into dept(dname,loc) values('开发部',database()),('财务部',database()),('市场部',database())
,('后勤部',database()),('公关部',database());