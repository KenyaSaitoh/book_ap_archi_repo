package jp.mufg.it.ee.concurrent.sales;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class SalesTask implements Callable<Map<String, Integer>> {
    private List<Sales> salesList;
    private String productType;

    public SalesTask(List<Sales> salesList, String productType) {
        this.salesList = salesList;
        this.productType = productType;
    }

    @Override
    public Map<String, Integer> call() throws Exception {
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        for (Sales s : salesList) {
            if (s.getProductId().startsWith(productType)) {
                String pid = s.getProductId().replace("-", "");
                Integer sum = resultMap.get(pid);
                if (sum != null) {
                    resultMap.put(pid, sum + s.getSalesCount());
                } else {
                    resultMap.put(pid, s.getSalesCount());
                }
            }
        }
        return resultMap;
    }
}