package jp.mufg.it.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Subject {
    private static Subject subject = new Subject();

    public static Subject getInstance() {
        return subject;
    }

    private Subject() {
    }

    // フィールド（ Observerを登録するためのコレクション）
    private List<Observer> observers = new ArrayList<Observer>();

    // Observerを登録する
    public synchronized void addObserver(Observer observer) {
        observers.add(observer);
    }

    // イベントを一斉に通知する
    public synchronized void notifyObservers() {
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()) {
            Observer observer = iterator.next();
            observer.onEvent("The event fired!");
        }
    }
}