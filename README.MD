# 数据库实验三



## 创建数据库和数据表

- 创建数据库

  ```mysql
  create database student_score_system CHARACTER set utf8;
  ```

- 创建数据表

  ```mysql
  # 老师表
  create table teacher(
  	t_no varchar(10) primary key,
  	t_name varchar(20) not null,
  	t_position varchar(10) not null default '讲师',
  	t_birthday date not null,
  	t_sex int not null default 0,
  	t_password varchar(16) not null 
  );
  
  # 课程
  create table course(
  	c_no int PRIMARY key auto_increment,
  	t_no varchar(10) not null,
  	c_name varchar(20) not null,
  	c_type varchar(20) not null,
  	c_credit int not null default 0,
  	foreign key(t_no) REFERENCES teacher(t_no)
  );
  
  # 学生
  create table student(
  	s_no varchar(10) primary key,
  	s_name varchar(20) not null,
  	s_birthday date not null,
  	s_sex int not null default 0,
  	s_password varchar(16) not null 
  );
  
  # 选课
  create table sc(
  	c_no int not null,
  	s_no varchar(10) not null,
  	score int not null default -1,
  	foreign key(c_no) REFERENCES course(c_no),
  	foreign key(s_no) REFERENCES student(s_no)
  );
  
  # 管理员
  create table admin(
  	a_no varchar(10) PRIMARY key,
  	a_password varchar(16) not null
  );
  ```

- 导入数据

  ```mysql
  insert into admin values('10086','123456');
  
  insert into student values('1906300101','大哥','2001-04-06',1,'123456');
  insert into student values('1906300102','大海','2000-10-04',1,'123456');
  insert into student values('1906300103','小伦','2000-12-18',1,'123456');
  insert into student values('1906300104','坤坤酱','2000-06-14',1,'123456');
  
  insert into teacher values('1008611','小汤','副院长','1956-12-13',1,'123456');
  insert into teacher values('1008612','小张','副院长','1956-12-13',2,'123456');
  
  insert into course values(null,'1008611','程序设计基础','专业必修课程',3);
  insert into course values(null,'1008611','离散数学','专业必修课程',3);
  insert into course values(null,'1008612','数据结构','专业必修课程',2);
  
  insert into sc values(1,'1906300101',100);
  insert into sc values(2,'1906300101',100);
  insert into sc values(3,'1906300101',100);
  ```

  