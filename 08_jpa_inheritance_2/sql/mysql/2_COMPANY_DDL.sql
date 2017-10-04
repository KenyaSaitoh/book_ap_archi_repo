-- InheritanceType.JOINED

-- 部署テーブル
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID   INT PRIMARY KEY,      -- 部署番号
DEPARTMENT_NAME VARCHAR(30) NOT NULL, -- 部署名
BUILDING_NAME   VARCHAR(30) NOT NULL, -- ビル名
FLOOR           INT                   -- 階数
);

-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID   INT PRIMARY KEY,      -- 社員番号
EMPLOYEE_NAME VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_ID INT,                  -- 部署番号
EMPLOYEE_TYPE CHAR NOT NULL,        -- 社員種別
ENTRANCE_DATE DATE NOT NULL,        -- 入社年月日
CONSTRAINT FK_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID)
    REFERENCES DEPARTMENT(DEPARTMENT_ID)
);

-- 社員テーブル
CREATE TABLE FULLTIMER (		
EMPLOYEE_ID    INT PRIMARY KEY,      -- 社員番号
JOB_NAME       VARCHAR(30) NOT NULL, -- 役職名
MONTHLY_SALARY INT NOT NULL          -- 月給
);

-- パートタイマーテーブル
CREATE TABLE PARTTIMER (		
EMPLOYEE_ID       INT PRIMARY KEY, -- 社員番号
PARTTIMER_PAYMENT INT NOT NULL     -- 時給
);