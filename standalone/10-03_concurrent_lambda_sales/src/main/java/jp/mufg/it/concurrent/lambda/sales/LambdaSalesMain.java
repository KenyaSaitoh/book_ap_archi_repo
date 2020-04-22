package jp.mufg.it.concurrent.lambda.sales;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LambdaSalesMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        Map<String, Integer> resultMap = salesList.parallelStream()
                .filter(s -> s.getProductId().startsWith("A"))
                .map(s -> {
                    String pid = s.getProductId().replace("-", "");
                    return new Sales(s.getSalesId(), pid, s.getSalesCount());
                    })
                .collect(Collectors.groupingBy(
                        Sales::getProductId,
                        Collectors.summingInt(Sales::getSalesCount)));

        for (String key : resultMap.keySet()) {
            System.out.println(key + " / " + resultMap.get(key));
        }
    }
}