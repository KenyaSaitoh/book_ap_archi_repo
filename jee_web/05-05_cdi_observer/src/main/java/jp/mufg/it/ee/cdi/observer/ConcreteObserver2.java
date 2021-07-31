package jp.mufg.it.ee.cdi.observer;

import javax.enterprise.event.Observes;

public class ConcreteObserver2 {
    public void onEvent(@Observes String eventName) {
        System.out.println(
                "[ ConcreteObserver2#onEvent ] eventName => " + eventName);
    }
}