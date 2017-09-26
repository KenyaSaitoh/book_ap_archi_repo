package jp.mufg.it.ee.cdi.interceptor;

import javax.enterprise.context.RequestScoped;
import javax.interceptor.Interceptors;

@RequestScoped
@Interceptors(LogInterceptor.class)
public class BarBean implements Bar {
    // ビジネスメソッド
    public int doBusiness(int param) {
        System.out.println("[ BarBean#doBusiness ] Start");
        int answer = param * param;
        System.out.println("  Answer ---> " + answer);
        System.out.println("[ BarBean#doBusiness ] End");
        return answer;
    }
}