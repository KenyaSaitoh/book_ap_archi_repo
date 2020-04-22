package jp.mufg.it.domainmodel.domain;

import java.util.Date;
import java.util.List;

public class OrderTransaction extends AbstractTransaction {
    private List<OrderDetail> orderDetails;
    private Integer totalPrice;
    private String deliveryAddress;

    // コンストラクタ
    public OrderTransaction(AbstractCustomer customer, Date transactionDate,
            List<OrderDetail> orderDetails, Integer totalPrice,
            String deliveryAddress,
            DeliveryChargeStrategy deliveryChargeStrategy) {
        super(customer, transactionDate, deliveryChargeStrategy);
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
