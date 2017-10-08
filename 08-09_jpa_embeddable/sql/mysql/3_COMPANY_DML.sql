-- 一括削除
DELETE FROM EMPLOYEE;
DELETE FROM DEPARTMENT;

-- 部署テーブル
INSERT INTO DEPARTMENT VALUES(1, '企画部', '東京本社', '100-0000', '東京都千代田区', '1-2-3');
INSERT INTO DEPARTMENT VALUES(2, '人事部', '東京本社', '100-0000', '東京都千代田区', '1-2-3');
INSERT INTO DEPARTMENT VALUES(3, '営業部', '新宿支社', '160-0001', '東京都新宿区', '1-2-3');
INSERT INTO DEPARTMENT VALUES(4, '商品開発部', '新宿支社', '160-0001', '東京都新宿区', '1-2-3');

-- 社員テーブル
INSERT INTO EMPLOYEE VALUES(10001, 'Alice', 3, 0, 500000, '132-0000', '東京都江戸川区', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10002, 'Bob', 1, 0, 450000, '279-0000', '千葉県浦安市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10003, 'Carol', 2, 2, 350000, '270-1300', '千葉県印西市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10004, 'Dave', 3, 1, 400000, '221-0000', '神奈川県横浜市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10005, 'Ellen', 3, 2, 300000, '184-0000', '東京都小金井市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10006, 'Frank', 1, 3, 250000, null, null, null);
INSERT INTO EMPLOYEE VALUES(10007, 'Ivan', 4, 0, 480000, '182-0000  ', '東京都調布市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10008, 'Justin', 2, 0, 460000, '220-0000', '神奈川県横浜市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10009, 'Mallory', 4, 1, 420000, '273-0000', '千葉県船橋市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10010, 'Matilda', 3, 3, 280000, null, null, null);
INSERT INTO EMPLOYEE VALUES(10011, 'Oscar', 4, 2, 320000, '340-0000', '埼玉県草加市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10012, 'Pat', 4, 3, 240000, '210-0000', '神奈川県川崎市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10013, 'Peggy', 3, 3, 270000, '331-0000', '埼玉県さいたま市', '1-2-3');
INSERT INTO EMPLOYEE VALUES(10014, 'Victor', null, 3, 220000, null, null, null);
