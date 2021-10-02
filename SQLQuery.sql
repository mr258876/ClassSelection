-- 创建用户表
CREATE TABLE Users(
	UserName nvarchar(10) PRIMARY KEY,
	PasswordSHA1 char(40) NOT NULL,
	Email nvarchar(32) NOT NULL,
	UserRole char(6) NOT NULL,
	CONSTRAINT check_role CHECK(UserRole in ('ROLE_A', 'ROLE_M', 'ROLE_T', 'ROLE_S') )
);

-- 插入用户'admin',密码'admin',权限'系统管理员'
INSERT INTO Users VALUES ('admin', 'd033e22ae348aeb5660fc2140aec35850c4da997', 'abc@def.xyz', 'ROLE_A');