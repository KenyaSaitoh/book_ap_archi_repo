package jp.mufg.it.ee.cdi.di;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
public class BarImpl implements Bar {

    // ビジネスメソッド
    public int doBusiness(int param) {
        return param * param;
    }
}