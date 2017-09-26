package jp.mufg.it.ee.cdi.producer1;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

@Dependent
public class BarProducer {

    @SuppressWarnings("unused")
    @Produces
    @Named("bar")
    public static Bar getBar() {
        if (true) {
            return new BarImpl1();
        } else {
            return new BarImpl2();
        }
    }
}
