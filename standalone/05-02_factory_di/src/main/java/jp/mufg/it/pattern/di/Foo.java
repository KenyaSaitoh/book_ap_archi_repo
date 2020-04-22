package jp.mufg.it.pattern.di;

public class Foo {

    // 呼び出し先クラスのインタフェース型フィールド
    private Bar bar;

    // 呼び出し先クラスへのアクセサメソッド
    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    // ビジネスメソッド
    public int doBusiness(int param) {
        System.out.println("[ Foo#doBusiness ] Start");

        // Barのビジネスメソッドを呼び出す
        int retVal = bar.doBusiness(param);

        // Barの結果を受けてビジネスロジックを実行する
        int result = retVal + retVal;

        System.out.println("[ Foo#doBusiness ] End");
        return result;
    }
}