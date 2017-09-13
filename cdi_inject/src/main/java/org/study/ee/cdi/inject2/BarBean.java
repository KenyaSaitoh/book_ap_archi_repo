package org.study.ee.cdi.inject2;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class BarBean {
    // ビジネスメソッド
    public int doBusiness(int param) {
        return param * param;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("[ BarBean#postConstruct ]");
    }
}