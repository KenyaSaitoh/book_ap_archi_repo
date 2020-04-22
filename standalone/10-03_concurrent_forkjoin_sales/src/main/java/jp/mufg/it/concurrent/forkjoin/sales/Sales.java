package jp.mufg.it.concurrent.forkjoin.sales;

public class Sales {
    private final Integer salesId;
    private final String productId;
    private final Integer salesCount;

    public Sales(Integer salesId, String productId, Integer salesCount) {
        this.salesId = salesId;
        this.productId = productId;
        this.salesCount = salesCount;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public String getProductId() {
        return productId;
    }

    public Integer getSalesCount() {
        return salesCount;
    }
}
