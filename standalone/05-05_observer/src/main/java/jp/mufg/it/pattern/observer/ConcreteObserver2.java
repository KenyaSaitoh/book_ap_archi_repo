package jp.mufg.it.pattern.observer;

public class ConcreteObserver2 implements Observer {

    @Override
    public void onEvent(String eventName) {
        System.out.println("[ ConcreteObserver2#onEvent ] eventName => " + eventName);
    }
}