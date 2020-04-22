package jp.mufg.it.ee.cdi.producer2;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import org.apache.log4j.Logger;

@Dependent
public class LogProducer {
    @Produces
    public static Logger getLogger(InjectionPoint ip){
        return Logger.getLogger(ip.getMember().getDeclaringClass());
    }
}
