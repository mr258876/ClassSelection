-- 创建用户表
-- 限制：用户角色四选一，SHA1长度固定40
CREATE TABLE Users(
	UserName nvarchar(10) PRIMARY KEY,
	PasswordSHA1 char(40) NOT NULL,
	Email nvarchar(32),
	UserRole char(6) NOT NULL,
	CONSTRAINT check_user CHECK(UserRole in ('ROLE_A', 'ROLE_M', 'ROLE_T', 'ROLE_S') AND LEN(PasswordSHA1) = 40 )
);

-- 插入用户'admin',密码'admin',权限'系统管理员'
INSERT INTO Users VALUES ('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'abc@def.xyz', 'ROLE_A');


-- 创建学生表
CREATE TABLE Student(
	StudentID char(8) PRIMARY KEY,
	UserName nvarchar(10) UNIQUE NOT NULL,
	StudentName nvarchar(10) NOT NULL,
	CONSTRAINT fk_student_username FOREIGN KEY (UserName) REFERENCES Users(UserName) ON DELETE CASCADE ON UPDATE CASCADE
);

-- 插入学生'12222222',密码'123456',权限'学生'
INSERT INTO Users VALUES ('12222222', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'stud0@def.xyz', 'ROLE_S');
INSERT INTO Student VALUES ('12222222', '12222222', '小明');


-- 创建部门表
CREATE TABLE Department(
	DepartmentID char(3) PRIMARY KEY,
	UserName nvarchar(10) UNIQUE NOT NULL,
	DepartmentName nvarchar(32) NOT NULL,
	CONSTRAINT fk_department_username FOREIGN KEY (UserName) REFERENCES Users(UserName) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- 插入部门'isme',密码'123456',权限'管理员'
INSERT INTO Users VALUES ('isme', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'isme@def.xyz', 'ROLE_M');
INSERT INTO Department VALUES ('MIS', 'isme', '信息系统与管理工程系');


-- 创建教师表
CREATE TABLE Teacher(
	TeacherID char(8) PRIMARY KEY,
	UserName nvarchar(10) UNIQUE NOT NULL,
	DepartmentID char(3) NOT NULL,
	TeacherName nvarchar(32) NOT NULL
	CONSTRAINT fk_teacher_username FOREIGN KEY (UserName) REFERENCES Users(UserName) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT fk_teacher_department FOREIGN KEY (UserName) REFERENCES Department(DepartmentID) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- 插入教师'31111111',密码'123456',权限'管理员'
INSERT INTO Users VALUES ('31111111', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'teach0@def.xyz', 'ROLE_M');
INSERT INTO Department VALUES ('31111111', '31111111', '张三');


-- 创建课程表
CREATE TABLE Class(
	ClassID char(6) PRIMARY KEY,
	UserName nvarchar(10) UNIQUE NOT NULL,
	DepartmentID char(3) NOT NULL,
	TeacherName nvarchar(32) NOT NULL
	CONSTRAINT fk_teacher_username FOREIGN KEY (UserName) REFERENCES Users(UserName) ON DELETE NO ACTION ON UPDATE CASCADE,
	CONSTRAINT fk_teacher_department FOREIGN KEY (UserName) REFERENCES Department(DepartmentID) ON DELETE NO ACTION ON UPDATE CASCADE
);

-- 插入教师'31111111',密码'123456',权限'管理员'
INSERT INTO Users VALUES ('31111111', '7c4a8d09ca3762af61e59520943dc26494f8941b', 'teach0@def.xyz', 'ROLE_M');
INSERT INTO Department VALUES ('31111111', '31111111', '张三');