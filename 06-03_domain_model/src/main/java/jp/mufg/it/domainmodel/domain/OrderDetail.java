package jp.mufg.it.domainmodel.domain;

public class OrderDetail {
    private Integer orderId;
    private Integer orderDetailId;
    private Integer productId;
    private Integer count;

    // コンストラクタ
    public OrderDetail(Integer orderId, Integer productId, Integer count) {
        this.orderId = orderId;
        this.productId = productId;
        this.count = count;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Integer orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    // 商品IDへのアクセサメソッド
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    // 注文数へのアクセサメソッド
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
