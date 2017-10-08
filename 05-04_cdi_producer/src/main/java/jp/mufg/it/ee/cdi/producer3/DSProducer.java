package jp.mufg.it.ee.cdi.producer3;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@Dependent
public class DSProducer {
    @Produces
    // @Resource(lookup = "jdbc/MySQLDS")
    @Resource(lookup = "jdbc/DerbyDS")
    private DataSource ds;
}
