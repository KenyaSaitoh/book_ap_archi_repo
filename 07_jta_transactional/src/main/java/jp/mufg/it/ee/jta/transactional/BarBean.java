package jp.mufg.it.ee.jta.transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Dependent
@Transactional(TxType.REQUIRES_NEW)
public class BarBean {

    // インジェクションポイント
    @Resource(lookup = "jdbc/MySQLDS")
    private DataSource ds;

    // 引数なしのコンストラクタ
    public BarBean() {
    }

    // コンストラクタ
    public BarBean(DataSource ds) {
        this.ds = ds;
    }

    // ビジネスメソッド
    public void doBusiness(int param) {
        System.out.println("[ BarBean#doBusiness ] Start");
        Connection conn = null;
        try {
            // OPERATIONテーブルの、主キーが"Bar"のローを更新する
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE BUSINESS SET COUNT = COUNT + ? " +
                    "WHERE NAME = 'Bar'");
            pstmt.setInt(1, param);
            pstmt.executeUpdate();

        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            // コネクションをクローズする
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
        }

        System.out.println("[ BarBean#doBusiness ] End");
    }
}