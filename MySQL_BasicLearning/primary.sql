-- 主键使用

-- id	name	email
CREATE TABLE t17
	(id INT PRIMARY KEY, -- 表示id列是主键
	`name` VARCHAR(32),
	email VARCHAR(32));
	
-- 主键列的值是不可以重复
INSERT INTO t17
	VALUES(1, 'jack', 'jack@shou.com');
INSERT INTO t17
	VALUES(2, 'tom', 'tom@shou.com');
	
INSERT INTO t17
	VALUES(1, 'hsp', 'hsp@shou.com');

SELECT * FROM t17

-- 主键使用的细节讨论
-- primary key不能重复而且不能为null.
INSERT INTO t17
	VALUES(NULL, 'hsp', 'hsp@shou.com');
-- 一张表最多只能有一个主键,但可以是复合主键(比如 id+name)
CREATE TABLE t18
	(id INT PRIMARY KEY, -- 表示id列是主键
	`name` VARCHAR(32), PRIMARY KEY  -- 错误的
	email VARCHAR(32));
-- 演示复合主键 (id 和 name 做成复合主键)
CREATE TABLE t18
	(id INT ,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY (id, `name`) -- 这里就是复合主键
	);
INSERT INTO t18
	VALUES(1, 'tom', 'tom@shou.com');
INSERT INTO t18
	VALUES(1, 'jack', 'jack@shou.com');
INSERT INTO t18
	VALUES(1, 'tom', 'xx@shou.com');

-- 主键的指定方式 有两种
-- 1. 直接在字段名后指定: 字段名 primakry key
-- 2. 在表定义最后写 primary key(列名);
CREATE TABLE t19
	(id INT ,
	`name` VARCHAR(32) PRIMARY KEY,
	email VARCHAR(32)
	);
	
CREATE TABLE t20
	(id INT ,
	`name` VARCHAR(32),
	email VARCHAR(32),
	PRIMARY KEY (`name`) -- 在表定义最后写 primary key(列名)
	);
	
-- 使用desc表名, 可以看到 primary key的情况

DESC t20 -- 查看 t20表的结果, 显示约束的情况
DESC t18 

-- 特别注意: 复合主键不是单个主键 是1+2 = 一个主键
-- 例如: t18, id和name并非单个主键, id+name=复合主键