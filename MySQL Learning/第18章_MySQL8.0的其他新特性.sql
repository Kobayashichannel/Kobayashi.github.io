
#第18章_MySQL8.0的其他新特性

CREATE DATABASE dbtest18;

USE dbtest18;

#1.窗口函数

#1.1 演示窗口函数的效果
CREATE TABLE sales(
id INT PRIMARY KEY AUTO_INCREMENT,
city VARCHAR(15),
county VARCHAR(15),
sales_value DECIMAL
);

INSERT INTO sales(city,county,sales_value)
VALUES
('北京','海淀',10.00),
('北京','朝阳',20.00),
('上海','黄埔',30.00),
('上海','长宁',10.00);

SELECT * FROM sales;

#需求：现在计算这个网站在每个城市的销售总额、在全国的销售总额、每个区的销售额占所在城市销售
#额中的比率，以及占总销售额中的比率。

CREATE TEMPORARY TABLE a  -- 创建临时表
SELECT SUM(sales_value) AS sales_value  -- 计算总金额
FROM sales;

SELECT * FROM a;

CREATE TEMPORARY TABLE b -- 创建临时表
SELECT city,SUM(sales_value) AS sales_value -- 计算总计金额
FROM sales
GROUP BY city;

SELECT * FROM b;

#方式1:
SELECT s.city AS 城市,s.county AS 区,s.sales_value AS 区销售额,
b.sales_value AS 市销售额,s.sales_value/b.sales_value AS 市比率,
a.sales_value AS 总销售额,s.sales_value/a.sales_value AS 总比率
FROM sales s
JOIN b ON (s.city=b.city) -- 连接市统计结果临时表
JOIN a -- 连接总计金额临时表
ORDER BY s.city,s.county;

#方式2:
SELECT city AS 城市,county AS 区,sales_value AS 区销售额,
SUM(sales_value) OVER(PARTITION BY city) AS 市销售额, -- 计算市销售额
sales_value/SUM(sales_value) OVER(PARTITION BY city) AS 市比率,
SUM(sales_value) OVER() AS 总销售额, -- 计算总销售额
sales_value/SUM(sales_value) OVER() AS 总比率
FROM sales
ORDER BY city,county;

#2. 介绍窗口函数

CREATE TABLE employees
AS
SELECT * FROM atguigudb.`employees`;

SELECT * FROM employees;


#准备工作
CREATE TABLE goods(
id INT PRIMARY KEY AUTO_INCREMENT,
category_id INT,
category VARCHAR(15),
NAME VARCHAR(30),
price DECIMAL(10,2),
stock INT,
upper_time DATETIME
);

INSERT INTO goods(category_id,category,NAME,price,stock,upper_time)
VALUES
(1, '女装/女士精品', 'T恤', 39.90, 1000, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '连衣裙', 79.90, 2500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '卫衣', 89.90, 1500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '牛仔裤', 89.90, 3500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '百褶裙', 29.90, 500, '2020-11-10 00:00:00'),
(1, '女装/女士精品', '呢绒外套', 399.90, 1200, '2020-11-10 00:00:00'),
(2, '户外运动', '自行车', 399.90, 1000, '2020-11-10 00:00:00'),
(2, '户外运动', '山地自行车', 1399.90, 2500, '2020-11-10 00:00:00'),
(2, '户外运动', '登山杖', 59.90, 1500, '2020-11-10 00:00:00'),
(2, '户外运动', '骑行装备', 399.90, 3500, '2020-11-10 00:00:00'),
(2, '户外运动', '运动外套', 799.90, 500, '2020-11-10 00:00:00'),	
(2, '户外运动', '滑板', 499.90, 1200, '2020-11-10 00:00:00');

SELECT * FROM goods;


#1. 序号函数

#1.1 ROW_NUMBER()函数
#举例: 查询 goods 数据表中每个商品分类下价格降序排列的各个商品信息。

SELECT ROW_NUMBER() OVER(PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, NAME, price, stock
FROM goods;

#举例：查询 goods 数据表中每个商品分类下价格最高的3种商品信息。
SELECT *
FROM (
SELECT ROW_NUMBER() OVER(PARTITION BY category_id ORDER BY price DESC) AS
row_num,
id, category_id, category, NAME, price, stock
FROM goods) t
WHERE row_num <= 3;


#1.2 RANK()函数
#举例: 使用RANK()函数获取 goods 数据表中各类别的价格从高到低排序的各商品信息

SELECT RANK() OVER(PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, NAME, price, stock
FROM goods;


#1.3 DENSE_RANK()函数

#举例：使用DENSE_RANK()函数获取 goods 数据表中各类别的价格从高到低排序的各商品信息。

SELECT DENSE_RANK() OVER(PARTITION BY category_id ORDER BY price DESC) AS row_num,
id, category_id, category, NAME, price, stock
FROM goods;

#方式1:
SELECT RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS r,
PERCENT_RANK() OVER (PARTITION BY category_id ORDER BY price DESC) AS pr,
id, category_id, category, NAME, price, stock
FROM goods
WHERE category_id = 1;

#方式2:
SELECT RANK() OVER w AS r,
PERCENT_RANK() OVER w AS pr,
id, category_id, category, NAME, price, stock
FROM goods
WHERE category_id = 1 WINDOW w AS (PARTITION BY category_id ORDER BY price DESC);

#2.2 CUME_DIST()函数
#举例: 查询goods数据表中小于或等于当前价格的比例
SELECT CUME_DIST() OVER(PARTITION BY category_id ORDER BY price ASC) AS cd,
id, category, NAME, price
FROM goods;

#3.前后函数
#3.1 LAG(expr,n)函数

#举例: 查询goods数据表中前一个商品价格与当前商品价格的差值
SELECT id, category, NAME, price, pre_price, price - pre_price AS diff_price
FROM (
	SELECT id, category, NAME, price,LAG(price,1) OVER w AS pre_price
	FROM goods
	WINDOW w AS (PARTITION BY category_id ORDER BY price)) t;

#其中,子查询如下:
SELECT id, category, NAME, price,LAG(price,1) OVER (PARTITION BY category_id ORDER BY price) AS pre_price
FROM goods


#3.2 LEAD(expr,n)函数
#举例: 查询goods数据表中后一个商品价格与当前商品价格的差
SELECT id, category, NAME, behind_price, price,behind_price - price AS diff_price
FROM(
	SELECT id, category, NAME, price,LEAD(price, 1) OVER w AS behind_price
	FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price)) t;

#其中,子查询为:
SELECT id, category, NAME, price,LEAD(price, 1) OVER w AS behind_price
FROM goods WINDOW w AS (PARTITION BY category_id ORDER BY price)


#4.首尾函数
#4.1 FIRST_VALUE(expr)函数
#举例: 按照价格排序,查询第1个商品的价格信息。

SELECT id, category, NAME, price, stock,FIRST_VALUE(price) OVER (PARTITION BY category_id ORDER BY price) AS first_price
FROM goods ;

#4.2 LAST_VALUE(expr)函数

#5. 其他函数
#5.1. MTH_VALUE(expr,n)函数

#举例: 查询goods数据表中排名第3和第4的价格信息
SELECT id, category, NAME, price,
NTH_VALUE(price,2) OVER(PARTITION BY category_id ORDER BY price) AS second_price,
NTH_VALUE(price,3) OVER (PARTITION BY category_id ORDER BY price) AS third_price
FROM goods;

#5.2 NTILE(n)函数
#举例: 将goods表中的商品按照价格分为3组
SELECT NTILE(3) OVER (PARTITION BY category_id ORDER BY price) AS nt,id, category, NAME, price
FROM goods;

#二、新特性2: 公用表达式

#2.1 普通公用表达式
#举例: 查询员工所在的部门的详细信息.
#准备工作
CREATE TABLE departments
AS
SELECT * FROM atguigudb.`departments`;

#子查询实现
SELECT * FROM departments
WHERE department_id IN (
			SELECT DISTINCT department_id
			FROM employees
			);
			
#CTE实现
WITH cte_emp
AS (SELECT DISTINCT department_id FROM employees)

SELECT *
FROM departments d JOIN cte_emp e
ON d.department_id = e.department_id;

#2.2 递归公用表表达式

#举例: 找出公司employees表中所有的下下属
WITH RECURSIVE cte
AS
(
SELECT employee_id,last_name,manager_id,1 AS n FROM employees WHERE employee_id = 100 -- 种子查询，找到第一代领导
UNION ALL
SELECT a.employee_id,a.last_name,a.manager_id,n+1 FROM employees AS a JOIN cte
ON (a.manager_id = cte.employee_id) -- 递归查询，找出以递归公用表表达式的人为领导的人
)
SELECT employee_id,last_name FROM cte WHERE n >= 3;
