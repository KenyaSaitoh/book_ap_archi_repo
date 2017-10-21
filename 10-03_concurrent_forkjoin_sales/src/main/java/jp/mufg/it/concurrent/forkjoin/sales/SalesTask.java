package jp.mufg.it.concurrent.forkjoin.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class SalesTask extends RecursiveTask<Map<String, Integer>> {
    private static final int THRESHOLD = 100;
    private List<Sales> salesList;
    private String productType;

    public SalesTask(List<Sales> salesList, String targetProductType) {
        this.salesList = salesList;
        this.productType = targetProductType;
    }

    @Override
    protected Map<String, Integer> compute() {
        if (salesList.size() < THRESHOLD) {
            // リストのサイズがTHRESHOLD未満の場合、加算処理を行う
            Map<String, Integer> resultMap = new HashMap<String, Integer>();
            for (Sales s : salesList) {
                if (s.getProductId().startsWith(productType)) {
                    String pid = s.getProductId().replace("-", "");
                    Integer count = resultMap.get(pid);
                    if (count != null) {
                        resultMap.put(pid, count + s.getSalesCount());
                    } else {
                        resultMap.put(pid, s.getSalesCount());
                    }
                }
            }
            return resultMap;

        } else {
            // リストのサイズがTHRESHOLD以上の場合、
            // 要素数が半分のサブリストに分割し、再帰的に処理を行う
            int m = this.salesList.size() / 2;
            List<Sales> salesList1 = salesList.subList(0, m);
            List<Sales> salesList2 = salesList.subList(m, salesList.size());

            // 非同期処理を実行する
            SalesTask task1 = new SalesTask(salesList1, productType);
            task1.fork();

            // 非同期処理を実行する
            SalesTask task2 = new SalesTask(salesList2, productType);
            task2.fork();

            // 非同期に実行した処理の結果を待ち合わせて取得する
            Map<String, Integer> resultMap1 = task1.join();
            Map<String, Integer> resultMap2 = task2.join();

            for (String key : resultMap2.keySet()) {
                Integer value = resultMap1.get(key);
                if (value != null) {
                    resultMap1.put(key, value + resultMap2.get(key));
                } else {
                    resultMap1.put(key, resultMap2.get(key));
                }
            }
            return resultMap1;
        }
    }
}