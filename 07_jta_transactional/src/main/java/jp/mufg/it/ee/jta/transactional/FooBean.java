package jp.mufg.it.ee.jta.transactional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@RequestScoped
@Transactional(TxType.REQUIRED)
public class FooBean {
    // インジェクションポイント（フィールドインジェクション）。
    @Inject
    private BarBean barBean;

    // インジェクションポイント（フィールドインジェクション）。
    @Inject
    private QuxBean quxBean;

    // ビジネスメソッド
    public void doBusiness(int param) {
        System.out.println("[ FooBean#doBusiness ] Start");

        // セッションBean（BarBean）のビジネスメソッドを呼び出す
        barBean.doBusiness(param);

        // セッションBean（QuxBean）のビジネスメソッドを呼び出す
        quxBean.doBusiness(param);

        System.out.println("[ FooBean#doBusiness ] End");
    }
}