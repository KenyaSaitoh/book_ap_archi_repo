-- 部署テーブル
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID   INT PRIMARY KEY,      -- 部署番号
DEPARTMENT_NAME VARCHAR(30) NOT NULL, -- 部署名
BUILDING_NAME   VARCHAR(30) NOT NULL, -- ビル名
FLOOR           INT,                  -- 階数
VERSION         INT                   -- バージョン
);

-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID    INT PRIMARY KEY,      -- 社員番号
EMPLOYEE_NAME  VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_ID  INT,                  -- 部署番号
ENTRANCE_DATE  DATE NOT NULL,        -- 入社年月日
JOB_ID         INT NOT NULL,         -- 役職番号
MONTHLY_SALARY INT NOT NULL,         -- 月給
PHOTO          BLOB,                 -- 写真
VERSION        INT                   -- バージョン
);
