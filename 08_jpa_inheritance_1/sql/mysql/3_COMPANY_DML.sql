-- InheritanceType.SINGLE_TABLE

-- 一括削除
DELETE FROM EMPLOYEE;
DELETE FROM DEPARTMENT;

-- 部署テーブル
INSERT INTO DEPARTMENT VALUES(1, '企画部', '大手町ビル', 8);
INSERT INTO DEPARTMENT VALUES(2, '業務システム部', '日本橋第一ビル', null);
INSERT INTO DEPARTMENT VALUES(3, '情報システム部', '芝ビル', 2);
INSERT INTO DEPARTMENT VALUES(4, '基盤技術部', '日本橋第二ビル', 5);
INSERT INTO DEPARTMENT VALUES(5, 'ネットワーク管理部', '大手町ビル', null);
INSERT INTO DEPARTMENT VALUES(6, 'システム運用部', '千葉ビル', 2);

-- 社員テーブル
INSERT INTO EMPLOYEE VALUES(10001, 'さいとう けんや', 1, '1', '1994-04-01', 'マネージャ', 500000, null);
INSERT INTO EMPLOYEE VALUES(10002, 'こやなぎ もとき', 4, '1', '1995-04-01', 'マネージャ', 440000, null);
INSERT INTO EMPLOYEE VALUES(10003, 'とさ てっぺい', 2, '1', '1996-04-01', 'マネージャ', 470000, null);
INSERT INTO EMPLOYEE VALUES(10004, 'まつうら えいじろう', 3, '1', '1997-04-01', 'マネージャ', 450000, null);
INSERT INTO EMPLOYEE VALUES(10005, 'やまもと しんや', 2, '1', '1999-04-01', 'プロジェクトリーダ', 420060, null);
INSERT INTO EMPLOYEE VALUES(10006, 'こいけ こうじ', 5, '1', '2001-04-01', 'プロジェクトリーダ', 350000, null);
INSERT INTO EMPLOYEE VALUES(10007, 'にらさわ ふみと', 3, '1', '2001-10-01', 'プロジェクトリーダ', 380000, null);
INSERT INTO EMPLOYEE VALUES(10008, 'かわらい まいこ', 1, '1', '2002-04-01', 'プロジェクトリーダ', 370000, null);
INSERT INTO EMPLOYEE VALUES(10009, 'いのうえ たくと', 2, '1', '2004-04-01', 'アーキテクト', 340000, null);
INSERT INTO EMPLOYEE VALUES(10010, 'しばた ようすけ', 4, '1', '2004-04-01', 'プロジェクトリーダ', 360000, null);
INSERT INTO EMPLOYEE VALUES(10011, 'おおまさ ゆうさく', 3, '1', '2004-10-01', 'システムエンジニア', 320000, null);
INSERT INTO EMPLOYEE VALUES(10012, 'かとう まゆこ', 5, '1', '2005-04-01', 'システムエンジニア', 330000, null);
INSERT INTO EMPLOYEE VALUES(10013, 'ふじもと たくみ', 5, '1', '2006-04-01', 'マネージャ', 450000, null);
INSERT INTO EMPLOYEE VALUES(10014, 'くろだ ゆういち', 4, '1', '2007-11-01', 'アーキテクト', 370000, null);
INSERT INTO EMPLOYEE VALUES(10015, 'しまもと ひろや', 4, '1', '2008-07-01', 'システムエンジニア', 300000, null);
INSERT INTO EMPLOYEE VALUES(10016, 'しょうじ ゆか', 2, '1', '2009-04-01', 'システムエンジニア', 290000, null);
INSERT INTO EMPLOYEE VALUES(10017, 'すずき とおる', 3, '1', '2010-04-01', 'プログラマ', 280000, null);
INSERT INTO EMPLOYEE VALUES(10018, 'いざわ ゆい', null, '1', '2011-04-01', 'プログラマ', 270000, null);
INSERT INTO EMPLOYEE VALUES(20061, 'さとう あさみ', 1, '2', '2008-05-15', null, null, 1400);
INSERT INTO EMPLOYEE VALUES(20062, 'くらがね えみこ', 2, '2', '2008-08-12', null, null, 1200);
INSERT INTO EMPLOYEE VALUES(20063, 'たけむら みな', 3, '2', '2009-02-08', null, null, 1300);
INSERT INTO EMPLOYEE VALUES(20064, 'うかわ あつこ', 4, '2', '2010-03-22', null, null, 1400);
