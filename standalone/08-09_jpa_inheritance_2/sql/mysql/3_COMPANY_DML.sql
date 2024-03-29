-- 一括削除
DELETE FROM FULLTIMER;
DELETE FROM PARTTIMER;
DELETE FROM EMPLOYEE;
DELETE FROM DEPARTMENT;

-- 部署テーブル
INSERT INTO DEPARTMENT VALUES(1, '企画部', '東京本社');
INSERT INTO DEPARTMENT VALUES(2, '人事部', '東京本社');
INSERT INTO DEPARTMENT VALUES(3, '営業部', '新宿新都心支社');
INSERT INTO DEPARTMENT VALUES(4, '商品開発部', '新宿東口支社');
INSERT INTO DEPARTMENT VALUES(5, '総務部', '東京本社');

-- 社員テーブル
INSERT INTO EMPLOYEE VALUES(10001, 'Alice', 3, '1', '2012-04-01');
INSERT INTO EMPLOYEE VALUES(10002, 'Bob', 1, '1', '2012-04-01');
INSERT INTO EMPLOYEE VALUES(10003, 'Carol', 2, '1', '2012-04-01');
INSERT INTO EMPLOYEE VALUES(10004, 'Dave', 3, '1', '2012-04-01');
INSERT INTO EMPLOYEE VALUES(10005, 'Ellen', 3, '1', '2013-04-01');
INSERT INTO EMPLOYEE VALUES(10006, 'Frank', 1, '1', '2013-10-01');
INSERT INTO EMPLOYEE VALUES(10007, 'Ivan', 4, '1', '2014-01-01');
INSERT INTO EMPLOYEE VALUES(10008, 'Justin', 2, '1', '2014-04-01');
INSERT INTO EMPLOYEE VALUES(10009, 'Mallory', 4, '1', '2014-7-01');
INSERT INTO EMPLOYEE VALUES(10010, 'Matilda', 3, '1', '2015-08-01');
INSERT INTO EMPLOYEE VALUES(10011, 'Oscar', 4, '1', '2015-11-01');
INSERT INTO EMPLOYEE VALUES(10012, 'Pat', 4, '1', '2016-04-01');
INSERT INTO EMPLOYEE VALUES(10013, 'Peggy', 3, '1', '2016-10-01');
INSERT INTO EMPLOYEE VALUES(10014, 'Victor', null, '1', '2017-04-01');
INSERT INTO EMPLOYEE VALUES(20001, 'Trudy', 1, '2', '2015-04-01');
INSERT INTO EMPLOYEE VALUES(20002, 'Walter', 2, '2', '2016-04-01');

-- 社員テーブル
INSERT INTO FULLTIMER VALUES(10001, 0, 500000);
INSERT INTO FULLTIMER VALUES(10002, 0, 450000);
INSERT INTO FULLTIMER VALUES(10003, 2, 350000);
INSERT INTO FULLTIMER VALUES(10004, 1, 400000);
INSERT INTO FULLTIMER VALUES(10005, 2, 300000);
INSERT INTO FULLTIMER VALUES(10006, 3, 250000);
INSERT INTO FULLTIMER VALUES(10007, 0, 480000);
INSERT INTO FULLTIMER VALUES(10008, 0, 460000);
INSERT INTO FULLTIMER VALUES(10009, 1, 420000);
INSERT INTO FULLTIMER VALUES(10010, 3, 280000);
INSERT INTO FULLTIMER VALUES(10011, 2, 320000);
INSERT INTO FULLTIMER VALUES(10012, 3, 240000);
INSERT INTO FULLTIMER VALUES(10013, 3, 270000);
INSERT INTO FULLTIMER VALUES(10014, 3, 220000);

INSERT INTO PARTTIMER VALUES(20001, 2000);
INSERT INTO PARTTIMER VALUES(20002, 1750);