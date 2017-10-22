package jp.mufg.it.jdbc.sales;

public class SalesDetail {
    private Integer salesId;
    private Integer salesLineId;
    private Integer productId;
    private Integer productPrice;
    private Integer salesCount;

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Integer getSalesDetailId() {
        return salesLineId;
    }

    public void setSalesDetailId(Integer salesLineId) {
        this.salesLineId = salesLineId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }
}
