package jp.mufg.it.domainmodel.domain;

import java.util.Date;

public class ReturnTransaction extends AbstractTransaction {
    private Product product;
    private OrderTransaction originalOrderTransaction;

    public ReturnTransaction(AbstractCustomer customer, Date transactionDate,
            Product product, OrderTransaction originalOrderTransaction,
            DeliveryChargeStrategy deliveryChargeStrategy) {
        super(customer, transactionDate, deliveryChargeStrategy);
        this.product = product;
        this.originalOrderTransaction = originalOrderTransaction;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public OrderTransaction getOriginalOrderTransaction() {
        return originalOrderTransaction;
    }

    public void setOriginalOrderTransaction(
            OrderTransaction originalOrderTransaction) {
        this.originalOrderTransaction = originalOrderTransaction;
    }
}