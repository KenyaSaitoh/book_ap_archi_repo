-- 人員テーブル
CREATE TABLE PERSON (
ID          INT NOT NULL AUTO_INCREMENT, -- ID
PERSON_NAME VARCHAR(30) NOT NULL,        -- 名前
AGE         INT NOT NULL,                -- 年齢
GENDER      VARCHAR(10) NOT NULL,        -- 性別
PRIMARY KEY(ID)
);