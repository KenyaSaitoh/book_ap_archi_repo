package jp.mufg.it.ee.cdi.observer;

import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;

// 下位レイヤーに相当するコンポーネント
@Dependent
public class Subject {
    // インジェクションポイント
    @Inject
    private Event<String> event;

    // イベントを通知する
    public void notifyObservers() {
        this.event.fire("The event fired!");;
    }
}