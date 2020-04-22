package jp.mufg.it.domainmodel.domain;

import java.util.Date;

import jp.mufg.it.domainmodel.util.Util;

public abstract class AbstractTransaction {
    private Integer transactionId;
    private AbstractCustomer customer;
    private Date transactionDate;
    private Integer deliveryCharge;

    public AbstractTransaction(AbstractCustomer customer, Date transactionDate) {
        this.customer = customer;
        this.transactionDate = transactionDate;
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

    protected Integer getDeliveryChargeByAddress() {
        if (Util.isRemoteLocation(customer.getAddress())) {
            // 遠隔地のケース
            return 1300;
        } else {
            // 遠隔地以外のケース
            return 700;
        }
    }

    public abstract void calcDeliveryCharge();
}