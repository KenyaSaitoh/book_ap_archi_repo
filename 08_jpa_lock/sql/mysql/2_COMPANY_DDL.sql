-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID     INT NOT NULL AUTO_INCREMENT, -- 社員ID
EMPLOYEE_NAME   VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_NAME VARCHAR(30),           -- 部署名
SALARY          INT NOT NULL,          -- 月給
VERSION         INT,                   -- バージョン
PRIMARY KEY(EMPLOYEE_ID)
);