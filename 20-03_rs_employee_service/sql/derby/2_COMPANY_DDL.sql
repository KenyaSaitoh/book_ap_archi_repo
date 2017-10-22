-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID     INT GENERATED BY DEFAULT AS IDENTITY (START WITH 20001), -- 社員ID
EMPLOYEE_NAME   VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_NAME VARCHAR(30),          -- 部署名
SALARY          INT NOT NULL,         -- 月給
PRIMARY KEY(EMPLOYEE_ID)
);