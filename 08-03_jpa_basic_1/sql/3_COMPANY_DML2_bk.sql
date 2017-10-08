-- 一括削除
DELETE FROM EMPLOYEE;

-- 社員テーブル
INSERT INTO EMPLOYEE VALUES(10001, 'Alice', '営業部', '2012-04-01', 'MANAGER', 500000, null);
INSERT INTO EMPLOYEE VALUES(10002, 'Bob', '企画部', '2012-04-01', 'MANAGER', 450000, null);
INSERT INTO EMPLOYEE VALUES(10003, 'Carol', '人事部', '2012-04-01', 'LEADER', 350000, null);
INSERT INTO EMPLOYEE VALUES(10004, 'Dave', '営業部', '2012-04-01', 'LEADER', 400000, null);
INSERT INTO EMPLOYEE VALUES(10005, 'Ellen', '営業部', '2014-04-01', 'CHIEF', 300000, null);
INSERT INTO EMPLOYEE VALUES(10006, 'Frank', '企画部', '2014-04-01', 'ASSOCIATE', 250000, null);
INSERT INTO EMPLOYEE VALUES(10007, 'Ivan', '営業部', '2015-10-01', 'ASSOCIATE', 270000, null);
INSERT INTO EMPLOYEE VALUES(10008, 'Justin', '人事部', '2016-04-01', 'MANAGER', 480000, null);
INSERT INTO EMPLOYEE VALUES(10009, 'Mallory', '企画部', '2016-04-01', 'CHIEF', 320000, null);
INSERT INTO EMPLOYEE VALUES(10010, 'Matilda', '営業部', '2017-04-01', 'ASSOCIATE', 230000, null);

INSERT INTO EMPLOYEE VALUES(10011, 'Oscar', '営業部', '2004-10-01', 'SYSTEM_ENGINEER', 320000, null);
INSERT INTO EMPLOYEE VALUES(10012, 'Pat', '営業部', '2005-04-01', 'SYSTEM_ENGINEER', 330000, null);
INSERT INTO EMPLOYEE VALUES(10013, 'Peggy', 'ネットワーク管理部', '2006-04-01', 'MANAGER', 450000, null);
INSERT INTO EMPLOYEE VALUES(10014, 'Victor', '基盤技術部', '2007-11-01', 'ARCHITECT', 370000, null);
INSERT INTO EMPLOYEE VALUES(10015, 'Steve', '基盤技術部', '2008-07-01', 'SYSTEM_ENGINEER', 300000, null);
INSERT INTO EMPLOYEE VALUES(10016, 'Trent', '業務システム部', '2009-04-01', 'SYSTEM_ENGINEER', 290000, null);
INSERT INTO EMPLOYEE VALUES(10017, 'Trudy', '情報システム部', '2010-04-01', 'PROGRAMMER', 280000, null);
INSERT INTO EMPLOYEE VALUES(10018, 'Walter', null, '2011-04-01', 'PROGRAMMER', 270000, null);