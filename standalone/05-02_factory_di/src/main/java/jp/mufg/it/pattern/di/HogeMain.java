package jp.mufg.it.pattern.di;

public class HogeMain {

    public static void main(String[] args) {
        System.out.println("[ HogeMain#main ] Start");

        // Fooインスタンスを生成する
        Foo foo = new Foo();

        // BarBeanクラス（本物）かMockBarクラス（偽物）のどちらかの
        // インスタンスを生成する
        Bar bar = new BarBean();
        // Bar bar = new MockBar();

        // Fooに対し、呼び出し先クラスであるBarへの依存性をインジェクションする
        foo.setBar(bar);

        // Fooのビジネスメソッドを呼び出す
        int result = foo.doBusiness(3);

        System.out.println("result ---> " + result);
        System.out.println("[ HogeMain#main ] End");
    }
}