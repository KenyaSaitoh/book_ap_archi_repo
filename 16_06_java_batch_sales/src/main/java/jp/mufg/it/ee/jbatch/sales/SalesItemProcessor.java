package jp.mufg.it.ee.jbatch.sales;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class SalesItemProcessor implements ItemProcessor {

    @Override
    public Object processItem(Object item) throws Exception {
        System.out.println("[ SalesItemProcessor#processItem ]");
        return item;
    }
}
