package jp.mufg.it.ee.cdi.di;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent // インジェクション先のライフサイクルに準じる
public class FooImpl implements Foo {
    // インジェクションポイント
    @Inject
    private Bar bar;

    // コンストラクタ
    public FooImpl(Bar bar) {
        this.bar = bar;
    }

    // 引数無しのコンストラクタ
    public FooImpl() {
    }

    // ビジネスメソッド
    public int doBusiness(int param) {
        // Barのビジネスメソッドを呼び出す
        int retVal = bar.doBusiness(param);
        // Barの結果を受けてビジネスロジックを実行する
        int result = retVal + retVal;
        return result;
    }
}