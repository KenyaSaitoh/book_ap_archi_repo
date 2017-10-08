package jp.mufg.it.ee.cdi.observer;

import javax.enterprise.event.Observes;

public class ConcreteObserver1 {
    public void onEvent(@Observes String eventName) {
        System.out.println(
                "[ ConcreteObserver1#onEvent ] eventName ---> " + eventName);
    }
}