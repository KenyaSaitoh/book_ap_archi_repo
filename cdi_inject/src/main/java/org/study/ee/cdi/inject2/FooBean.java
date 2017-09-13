package org.study.ee.cdi.inject2;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent // サーブレットのスコープを引き継ぐ
public class FooBean {
    // インジェクションポイント
    @Inject
    private BarBean barBean;

    // 引数なしのコンストラクタ
    public FooBean() {
    }

    // コンストラクタ
    public FooBean(BarBean barBean) {
        this.barBean = barBean;
    }

    // ビジネスメソッド
    public int doBusiness(int param) {
        // Barのビジネスメソッドを呼び出す。
        int retVal = barBean.doBusiness(param);
        // Barの結果を受けてビジネスロジックを実行する。
        int result = retVal + retVal;
        return result;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[ FooBean#postConstruct ]");
    }
}