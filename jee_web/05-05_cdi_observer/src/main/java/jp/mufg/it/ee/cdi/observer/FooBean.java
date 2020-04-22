package jp.mufg.it.ee.cdi.observer;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class FooBean {
    // インジェクションポイント
    @Inject
    private Subject subject;

    // ビジネスメソッド
    public void doBusiness() {
        subject.notifyObservers();
    }
}