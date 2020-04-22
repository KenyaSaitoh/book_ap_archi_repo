package jp.mufg.it.concurrent.lambda.sales.sum;

import java.util.List;

import jp.mufg.it.concurrent.lambda.sales.Sales;
import jp.mufg.it.concurrent.lambda.sales.SalesListHolder;

public class SalesSumLoopMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        long sum = 0L;
        for (Sales s : salesList) {
            if (s.getProductId().startsWith("A")) {
                sum = sum + s.getSalesCount();
            }
        }

        System.out.println(sum);
    }
}