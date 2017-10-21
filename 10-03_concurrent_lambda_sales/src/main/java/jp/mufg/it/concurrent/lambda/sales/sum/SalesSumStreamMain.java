package jp.mufg.it.concurrent.lambda.sales.sum;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import jp.mufg.it.concurrent.lambda.sales.Sales;
import jp.mufg.it.concurrent.lambda.sales.SalesListHolder;

public class SalesSumStreamMain {
    public static void main(String[] args) {
        List<Sales> salesList = SalesListHolder.getSalesList();
        long sum = salesList.parallelStream()
                .filter(new Predicate<Sales>() {
                    public boolean test(Sales s) {
                        return s.getProductId().startsWith("A");
                    }
                })
                .mapToInt(new ToIntFunction<Sales>() {
                    public int applyAsInt(Sales s) {
                        return s.getSalesCount();
                    }
                })
                .sum();

        System.out.println(sum);
    }
}