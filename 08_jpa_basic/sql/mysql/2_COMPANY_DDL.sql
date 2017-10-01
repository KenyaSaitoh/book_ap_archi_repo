-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID     INT NOT NULL AUTO_INCREMENT, -- 社員番号
EMPLOYEE_NAME   VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_NAME VARCHAR(30),           -- 部署名
ENTRANCE_DATE   DATE NOT NULL,        -- 入社年月日
JOB_NAME        VARCHAR(30) NOT NULL, -- 役職名
SALARY          INT NOT NULL,          -- 月給
PHOTO           BLOB,                   -- 写真
PRIMARY KEY(EMPLOYEE_ID)
);