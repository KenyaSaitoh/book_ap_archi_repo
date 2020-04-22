package jp.mufg.it.ee.cdi.di;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BarImpl implements Bar {

    // ビジネスメソッド
    public int doBusiness(int param) {
        return param * param;
    }
}