package jp.mufg.it.ee.cdi.producer1;

public class BarImpl1 implements Bar {

    // ビジネスメソッド
    public int doBusiness(int param) {
        return param * param;
    }
}