package jp.mufg.it.domainmodel.dto;

import java.util.Date;

public class ReturnTransactionDTO {
    private Integer returnId;
    private Integer customerId;
    private Date returnDate;
    private Integer productId;
    private Integer deliveryCharge;
    private Integer originalOrderId;

    public ReturnTransactionDTO(Integer returnId, Integer customerId,
            Date returnDate, Integer productId, Integer originalOrderId) {
        this.customerId = customerId;
        this.returnDate = returnDate;
        this.productId = productId;
        this.originalOrderId = originalOrderId;
    }

    public Integer getReturnId() {
        return returnId;
    }

    public void setReturnId(Integer returnId) {
        this.returnId = returnId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public Integer getOriginalOrderId() {
        return originalOrderId;
    }

    public void setOriginalOrderId(Integer originalOrderId) {
        this.originalOrderId = originalOrderId;
    }
}