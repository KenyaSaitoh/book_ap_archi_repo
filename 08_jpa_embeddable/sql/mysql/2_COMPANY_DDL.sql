-- 部署テーブル
CREATE TABLE DEPARTMENT (
DEPARTMENT_ID   INT PRIMARY KEY,      -- 部署ID
DEPARTMENT_NAME VARCHAR(30) NOT NULL, -- 部署名
LOCATION        VARCHAR(30) NOT NULL, -- ビル名
POSTAL_CODE     VARCHAR(10),          -- 郵便番号
TOWN            VARCHAR(10),          -- 市町村
STREET          VARCHAR(20)           -- 番地
);

-- 社員テーブル
CREATE TABLE EMPLOYEE (
EMPLOYEE_ID    INT AUTO_INCREMENT,     -- 社員ID
EMPLOYEE_NAME  VARCHAR(30) NOT NULL, -- 社員名
DEPARTMENT_ID  INT,                  -- 部署ID
JOB_ID        INT NOT NULL,         -- 役職ID
SALARY         INT NOT NULL,         -- 月給
ZIP_CODE       VARCHAR(10),          -- 郵便番号
CITY           VARCHAR(10),          -- 市町村
STREET         VARCHAR(20),          -- 番地
PRIMARY KEY(EMPLOYEE_ID),
CONSTRAINT FK_DEPARTMENT FOREIGN KEY(DEPARTMENT_ID)
    REFERENCES DEPARTMENT(DEPARTMENT_ID)
);