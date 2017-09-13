package org.study.ee.cdi.inject;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent // サーブレットのスコープを引き継ぐ
public class FooImpl implements Foo {
    // インジェクションポイント
    @Inject
    private Bar bar;

    // 引数なしのコンストラクタ
    public FooImpl() {
    }

    // コンストラクタ
    public FooImpl(Bar bar) {
        this.bar = bar;
    }

    // ビジネスメソッド
    public int doBusiness(int param) {
        // Barのビジネスメソッドを呼び出す。
        int retVal = bar.doBusiness(param);
        // Barの結果を受けてビジネスロジックを実行する。
        int result = retVal + retVal;
        return result;
    }
}