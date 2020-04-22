package jp.mufg.it.mybatis.company.test.base;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

public class MyBatisTestBase {

    public SqlSession sqlSession;

    // 共通前処理（初期化）
    @Before
    public void init() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-3-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            sqlSession = ssf.openSession();
            is.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    // 共通後処理
    @After
    public void clean() {
    }

    // コミット
    public void commit() {
        sqlSession.commit();
    }
}