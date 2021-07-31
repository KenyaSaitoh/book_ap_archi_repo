package jp.mufg.it.ee.cdi.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class LogInterceptor {
    // インターセプタメソッド
    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        // 呼び出し先クラス名とメソッド名を取得し、出力する
        String className =
                context.getMethod().getDeclaringClass().getSimpleName();
        String methodName = context.getMethod().getName();
        System.out.println("[ " + className + "#" + methodName + " ]");

        // 引数を取得し、出力する
        Object[] params = context.getParameters();
        if (params != null) {
            for (Object param : params)
                System.out.println("param => " + param);
        }

        // 呼び出し対象のメソッドを実際に呼び出し、戻り値を受け取る
        Object retVal = context.proceed();

        // 戻り値を出力する
        System.out.println("return => " + retVal);

        // 戻り値を返す
        return retVal;
    }
}