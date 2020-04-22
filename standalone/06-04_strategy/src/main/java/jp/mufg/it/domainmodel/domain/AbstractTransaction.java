package jp.mufg.it.domainmodel.domain;

import java.util.Date;

public abstract class AbstractTransaction {
    private Integer transactionId;
    private AbstractCustomer customer;
    private Date transactionDate;
    private Integer deliveryCharge;
    private DeliveryChargeStrategy deliveryChargeStrategy;

    public AbstractTransaction(AbstractCustomer customer, Date transactionDate,
            DeliveryChargeStrategy deliveryChargeStrategy) {
        this.customer = customer;
        this.transactionDate = transactionDate;
        this.deliveryChargeStrategy = deliveryChargeStrategy;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public AbstractCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(AbstractCustomer customer) {
        this.customer = customer;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getDeliveryCharge() {
        return deliveryCharge;
    }

    public void setDeliveryCharge(Integer deliveryCharge) {
        this.deliveryCharge = deliveryCharge;
    }

    public void calcDeliveryCharge() {
        this.deliveryCharge = deliveryChargeStrategy.calcDeliveryCharge();
    }
}