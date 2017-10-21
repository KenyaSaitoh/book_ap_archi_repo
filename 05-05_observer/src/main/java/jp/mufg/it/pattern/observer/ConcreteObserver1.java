package jp.mufg.it.pattern.observer;

public class ConcreteObserver1 implements Observer {

    @Override
    public void onEvent(String eventName) {
        System.out.println("[ ConcreteObserver1#onEvent ] eventName ---> " + eventName);
    }
}