package jp.mufg.it.ee.ejb.async;

import java.util.concurrent.Future;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

@Stateless
public class AsyncBean {

    @Asynchronous
    public <T> Future<Integer> execute(String param) {
        // 意図的に1000ミリ秒～5000秒（ランダムに決定）スリープする
        try {
            ThreadUtil.sleepRandomTime(1000, 5000);
        } catch(RuntimeException re) {
        }
        int result = param.length();
        return new AsyncResult<Integer>(result);
    }
}