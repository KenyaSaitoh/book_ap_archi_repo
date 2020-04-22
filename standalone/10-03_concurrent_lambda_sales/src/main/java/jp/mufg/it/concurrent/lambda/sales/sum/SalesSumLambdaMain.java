package jp.mufg.it.concurrent.lambda.sales.sum;

import java.util.List;

import jp.mufg.it.concurrent.lambda.sales.Sales;
import jp.mufg.it.concurrent.lambda.sales.SalesListHolder;

public class SalesSumLambdaMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        long sum = salesList.parallelStream()
                .filter(s -> s.getProductId().startsWith("A"))
                .mapToInt(s -> s.getSalesCount())
                .sum();

        System.out.println(sum);
    }
}