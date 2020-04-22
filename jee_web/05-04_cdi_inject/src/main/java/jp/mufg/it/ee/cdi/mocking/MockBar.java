package jp.mufg.it.ee.cdi.mocking;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

import jp.mufg.it.ee.cdi.di.Bar;

@RequestScoped
@Alternative
//ビジネスメソッド
public class MockBar implements Bar {
    public int doBusiness(int param) {
     // Fooが単体テストを実施しやすくなるように実装する
     // ここでは常に10を返す
        return 10;
    }
}