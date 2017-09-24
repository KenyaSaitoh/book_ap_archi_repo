package jp.mufg.it.domainmodel.domain;

import java.util.Date;

public class ReturnTransaction extends AbstractTransaction {
    private Product product;
    private OrderTransaction originalOrderTransaction;

    public ReturnTransaction(AbstractCustomer customer, Date transactionDate,
            Product product, OrderTransaction originalOrderTransaction) {
        super(customer, transactionDate);
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

    @Override
    public void calcDeliveryCharge() {
        // 送料を計算する
        // 対象商品が無料返品可能かどうかを判定する
        if (product.canFreeReturn()) {
            // 対象商品が無料返品可能のケース
            setDeliveryCharge(0);
        } else {
            // 対象商品が無料返品不可のケース
            // 沖縄・小笠原など遠隔地かどうかを判定の上でセット
            setDeliveryCharge(getDeliveryChargeByAddress());
        }
    }
}