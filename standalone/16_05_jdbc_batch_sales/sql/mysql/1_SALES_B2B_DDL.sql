USE DB_S;

-- 一括ドロップ
DROP TABLE IF EXISTS HISTORICAL_SALES_BY_CUSTOMER;
DROP TABLE IF EXISTS HISTORICAL_SALES_BY_PRODUCT_TYPE;
DROP TABLE IF EXISTS HISTORICAL_SALES_BY_PRODUCT;
DROP TABLE IF EXISTS SALES_AMOUNT_BY_CUSTOMER;
DROP TABLE IF EXISTS SALES_AMOUNT_BY_BRANCH;
DROP TABLE IF EXISTS SALES_DETAIL;
DROP TABLE IF EXISTS SALES_TRAN;
DROP TABLE IF EXISTS CUSTOMER;
DROP TABLE IF EXISTS STAFF;
DROP TABLE IF EXISTS BRANCH;
DROP TABLE IF EXISTS STOCK_PRODUCT;
DROP TABLE IF EXISTS PRODUCT_NEW_PRICE;
DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS PRODUCT_TYPE;

CREATE TABLE PRODUCT_TYPE (
PRODUCT_TYPE_ID   INT PRIMARY KEY,     -- 商品分類ID
PRODUCT_TYPE_NAME VARCHAR(30) NOT NULL -- 商品分類名
);

CREATE TABLE PRODUCT (
PRODUCT_ID      INT PRIMARY KEY,      -- 商品ID
PRODUCT_TYPE_ID INT NOT NULL,         -- 商品分類ID
PRODUCT_NAME    VARCHAR(80) NOT NULL, -- 商品名
PRICE           INT NOT NULL,         -- 価格
CONSTRAINT FK_PRODUCT_TYPE_ID FOREIGN KEY(PRODUCT_TYPE_ID)
    REFERENCES PRODUCT_TYPE(PRODUCT_TYPE_ID)
);

CREATE TABLE PRODUCT_NEW_PRICE (
PRODUCT_ID INT PRIMARY KEY, -- 商品ID
NEW_PRICE  INT NOT NULL     -- 新商品価格
);

CREATE TABLE STOCK_PRODUCT (
PRODUCT_ID INT PRIMARY KEY, -- 商品ID
QUANTITY   INT,             -- 残り個数
CONSTRAINT FK_PRODUCT_ID FOREIGN KEY(PRODUCT_ID)
    REFERENCES PRODUCT(PRODUCT_ID)
);

CREATE TABLE BRANCH (
BRANCH_ID   INT PRIMARY KEY,     -- 支店ID
BRANCH_NAME VARCHAR(20) NOT NULL -- 支店名
);

CREATE TABLE STAFF (
STAFF_ID   INT PRIMARY KEY,      -- 社員ID
STAFF_NAME VARCHAR(30) NOT NULL, -- 社員名
BRANCH_ID  INT NOT NULL,         -- 支店ID
CONSTRAINT FK_BRANCH_ID_1 FOREIGN KEY(BRANCH_ID)
    REFERENCES BRANCH(BRANCH_ID)
);

CREATE TABLE CUSTOMER (
BRANCH_ID     INT NOT NULL,         -- 支店ID
CUSTOMER_ID   INT NOT NULL,         -- 取引先ID
CUSTOMER_NAME VARCHAR(30) NOT NULL, -- 取引先名
EMAIL_ADDRESS VARCHAR(50),          -- 電子メールアドレス
POSTAL_CODE   VARCHAR(10),          -- 郵便ID
ADDRESS1      VARCHAR(50),          -- 住所1
ADDRESS2      VARCHAR(50),          -- 住所2
CONSTRAINT PK_CUSTOMER
    PRIMARY KEY(BRANCH_ID, CUSTOMER_ID),
CONSTRAINT FK_BRANCH_ID_2 FOREIGN KEY(BRANCH_ID)
    REFERENCES BRANCH(BRANCH_ID)
);

CREATE TABLE SALES_TRAN (
SALES_ID          INT PRIMARY KEY, -- 売上ID
SALES_DATE        DATE NOT NULL,   -- 売上日付
DUE_DATE          DATE NOT NULL,   -- 支払期日
BRANCH_ID         INT NOT NULL,    -- 支店ID
CUSTOMER_ID       INT NOT NULL,    -- 取引先ID
STAFF_IN_CHARGE   INT NOT NULL,    -- 担当者の社員ID
UPDATE_STOCK_FLAG INT NOT NULL,    -- 在庫テーブル更新フラグ
CONSTRAINT FK_BRANCH_ID_3 FOREIGN KEY(BRANCH_ID)
    REFERENCES BRANCH(BRANCH_ID),
CONSTRAINT FK_CUSTOMER_1 FOREIGN KEY(BRANCH_ID, CUSTOMER_ID)
    REFERENCES CUSTOMER(BRANCH_ID, CUSTOMER_ID),
CONSTRAINT FK_STAFF FOREIGN KEY(STAFF_IN_CHARGE)
    REFERENCES STAFF(STAFF_ID)
);

CREATE TABLE SALES_DETAIL (
SALES_ID        INT,          -- 売上ID
SALES_DETAIL_ID INT,          -- 売上詳細ID
PRODUCT_ID      INT NOT NULL, -- 商品ID
PRODUCT_PRICE   INT NOT NULL, -- 商品価格
SALES_COUNT     INT NOT NULL, -- 個数
CONSTRAINT PK_SALES_DETAIL
    PRIMARY KEY(SALES_ID, SALES_DETAIL_ID),
CONSTRAINT FK_SALES_DETAIL FOREIGN KEY(SALES_ID)
    REFERENCES SALES_TRAN(SALES_ID)
    ON DELETE CASCADE,
CONSTRAINT FK_PRODUCT FOREIGN KEY(PRODUCT_ID)
    REFERENCES PRODUCT(PRODUCT_ID)
);

CREATE TABLE SALES_AMOUNT_BY_BRANCH (
TERM_START_DATE DATE,          -- 期初日
BRANCH_ID       INT,           -- 支店ID
SALES_AMOUNT    INT NOT NULL,  -- 売上実績
CONSTRAINT PK_SALES_AMOUNT_BY_BRANCH
    PRIMARY KEY(TERM_START_DATE, BRANCH_ID),
CONSTRAINT FK_BRANCH_ID_4 FOREIGN KEY(BRANCH_ID)
    REFERENCES BRANCH(BRANCH_ID)
);

CREATE TABLE SALES_AMOUNT_BY_CUSTOMER (
TERM_START_DATE DATE,          -- 期初日
BRANCH_ID       INT,           -- 支店ID
CUSTOMER_ID     INT,           -- 取引先ID
SALES_AMOUNT    INT NOT NULL,  -- 売上実績
CONSTRAINT PK_SALES_AMOUNT_BY_CUSTOMER
    PRIMARY KEY(TERM_START_DATE, BRANCH_ID, CUSTOMER_ID),
CONSTRAINT FK_CUSTOMER_2 FOREIGN KEY(BRANCH_ID, CUSTOMER_ID)
    REFERENCES CUSTOMER(BRANCH_ID, CUSTOMER_ID)
);

CREATE TABLE HISTORICAL_SALES_BY_PRODUCT (
PRODUCT_ID  INT,
MONTH       VARCHAR(10),
SALES_COUNT INT NOT NULL,
CONSTRAINT PK_HISTORICAL_SALES_BY_PRODUCT
    PRIMARY KEY(PRODUCT_ID, MONTH)
);

CREATE TABLE HISTORICAL_SALES_BY_PRODUCT_TYPE (
PRODUCT_TYPE_ID INT,
MONTH           VARCHAR(10),
SALES_COUNT     INT NOT NULL,
CONSTRAINT PK_HISTORICAL_SALES_BY_PRODUCT_TYPE
    PRIMARY KEY(PRODUCT_TYPE_ID, MONTH)
);

CREATE TABLE HISTORICAL_SALES_BY_CUSTOMER (
CUSTOMER_ID INT,
MONTH       VARCHAR(10),
SALES_COUNT INT NOT NULL,
CONSTRAINT PK_HISTORICAL_SALES_BY_CUSTOMER
    PRIMARY KEY(CUSTOMER_ID, MONTH)
);

