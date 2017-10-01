-- 部署テーブル
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID   INT PRIMARY KEY,      -- 部署ID
DEPARTMENT_NAME VARCHAR(30) NOT NULL, -- 部署名
LOCATION        VARCHAR(30) NOT NULL, -- 所在地
VERSION         INT                    -- バージョン
);

-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID    INT PRIMARY KEY,      -- 社員ID
EMPLOYEE_NAME  VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_ID  INT,                  -- 部署ID
ENTRANCE_DATE  DATE NOT NULL,        -- 入社年月日
JOB_ID         INT NOT NULL,         -- 役職ID
SALARY         INT NOT NULL,         -- 月給
PHOTO          BLOB,                 -- 写真
VERSION        INT                   -- バージョン
);
