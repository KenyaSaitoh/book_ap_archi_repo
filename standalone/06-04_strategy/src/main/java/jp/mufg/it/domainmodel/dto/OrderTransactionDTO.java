package jp.mufg.it.domainmodel.dto;

import java.util.Date;
import java.util.List;

public class OrderTransactionDTO {
    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private List<OrderDetailDTO> orderDetails;
    private Integer totalPrice;
    private Integer deliveryCharge;

    // コンストラクタ
    public OrderTransactionDTO(Integer customerId, Date orderDate,
            List<OrderDetailDTO> orderDetails, Integer totalPrice) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailDTO> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }
}
