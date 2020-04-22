package jp.mufg.it.concurrent.forkjoin.sales;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;

public class ForkjoinSalesMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();

        // タスクの実行を行なうプールを生成する
        ForkJoinPool pool = new ForkJoinPool();
        Map<String, Integer> resultMap = pool.invoke(
                new SalesTask(salesList, "A"));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " / " + resultMap.get(key));
        }
    }
}
