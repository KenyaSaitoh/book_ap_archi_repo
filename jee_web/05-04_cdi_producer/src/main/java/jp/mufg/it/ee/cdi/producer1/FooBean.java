package jp.mufg.it.ee.cdi.producer1;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Dependent
public class FooBean {
    // インジェクションポイント
    @Inject
    @Named("bar")
    private Bar bar;

    // 引数なしのコンストラクタ
    public FooBean() {
    }

    // コンストラクタ
    public FooBean(Bar bar) {
        this.bar = bar;
    }

    // ビジネスメソッド
    public int doBusiness(int param) {
        // Barのビジネスメソッドを呼び出す
        int retVal = bar.doBusiness(param);
        // Barの結果を受けてビジネスロジックを実行する
        int result = retVal + retVal;
        return result;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[ FooBean#postConstruct ]");
    }
}