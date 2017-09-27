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
@Transactional(TxType.REQUIRED)
public class QuxBean {

    // インジェクションポイント
    @Resource(lookup = "jdbc/MySQLDS")
    private DataSource ds;

    // 引数なしのコンストラクタ
    public QuxBean() {
    }

    // コンストラクタ
    public QuxBean(DataSource ds) {
        this.ds = ds;
    }

    // ビジネスメソッド
    public void doBusiness(int param) {
        System.out.println("[ QuxBean#doBusiness ] Start");
        Connection conn = null;
        try {
            // OPERATIONテーブルの、主キーが"Qux"のローを更新する
            conn = ds.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE BUSINESS SET COUNT = COUNT + ? " +
                    "WHERE NAME = 'Qux'");
            pstmt.setInt(1, param);
            pstmt.executeUpdate();

            // 引数が0未満の場合は、例外をスローする
            if (param < 0) {
                throw new RuntimeException("param is invalid");
            }

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

        System.out.println("[ QuxBean#doBusiness ] End");
    }
}