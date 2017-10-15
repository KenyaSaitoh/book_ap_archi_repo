package jp.mufg.it.mybatis.company.test;


import org.apache.ibatis.jdbc.SQL;
import org.junit.Test;

import jp.mufg.it.mybatis.company.test.base.MyBatisTestBase;

public class MyBatisSqlBuilderTest extends MyBatisTestBase {

    @Test
    public void test1() {
        System.out.println("[ test1 ] Start");
        SQL sql = new SQL() {{
            SELECT("*");
            FROM("EMPLOYEE e");
        }};
        sql.WHERE("e.EMPLOYEE_ID = 10001");
        System.out.println(sql.toString());
        System.out.println("[ test1 ] End\n");
    }
}