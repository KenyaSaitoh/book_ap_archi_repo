package jp.mufg.it.ee.cdi.di;

import junit.framework.TestCase;

import org.junit.Test;

import jp.mufg.it.ee.cdi.mocking.MockBar;

public class FooImplTest2 {

    @Test
    public void testDoBusiness() throws Exception {
        // モックオブジェクトを生成する。
        Bar bar = new MockBar();

        // Fooインスタンスを生成する。
        Foo foo = new FooImpl(bar);

        // テスト対象メソッドを呼び出す。
        int answer = foo.doBusiness(3);

        // 結果を検証する。
        TestCase.assertEquals(20, answer);
    }
}