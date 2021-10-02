-- 创建用户表
CREATE TABLE Users(
	UserName nvarchar(10) PRIMARY KEY,
	PasswordSHA1 char(40) NOT NULL,
	Email nvarchar(32) NOT NULL,
	UserRole char(1) CHECK(UserRole in ('A', 'M', 'T', 'S') )
);

-- 插入用户'admin',密码'admin',权限'系统管理员'
INSERT INTO Users('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'A', 'abc@def.xyz');