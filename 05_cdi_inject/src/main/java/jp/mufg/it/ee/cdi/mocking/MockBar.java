package jp.mufg.it.ee.cdi.mocking;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import jp.mufg.it.ee.cdi.di.Bar;

@RequestScoped
@Alternative
public class MockBar implements Bar {
    public int doBusiness(int param) {
        return 10;
    }
}