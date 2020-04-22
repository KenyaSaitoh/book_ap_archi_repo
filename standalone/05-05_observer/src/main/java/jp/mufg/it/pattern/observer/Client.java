package jp.mufg.it.pattern.observer;

public class Client {

    public static void main(String[] args) {

        //
        Subject subject = Subject.getInstance();

        Observer observer1 = new ConcreteObserver1();
        subject.addObserver(observer1);

        Observer observer2 = new ConcreteObserver2();
        subject.addObserver(observer2);

        //
        subject.notifyObservers();
    }
}