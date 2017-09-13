package org.study.ee.cdi.inject;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named("barImpl1")
public class BarImpl implements Bar {

    // ビジネスメソッド
    public int doBusiness(int param) {
        return param * param;
    }
}