package jp.mufg.it.mybatis.company.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionHolder {

    private static SqlSessionHolder instance = new SqlSessionHolder();

    public static SqlSessionHolder getInstance() {
        return instance;
    }

    private SqlSessionHolder() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-3-config.xml");
            SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
            sqlSession = ssf.openSession();
            is.close();
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }
}