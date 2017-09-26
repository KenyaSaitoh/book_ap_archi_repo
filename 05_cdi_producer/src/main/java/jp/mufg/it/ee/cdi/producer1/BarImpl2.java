package jp.mufg.it.ee.cdi.producer1;

public class BarImpl2 implements Bar {

    // ビジネスメソッド
    public int doBusiness(int param) {
        return (int)Math.pow(param, 3);
    }
}