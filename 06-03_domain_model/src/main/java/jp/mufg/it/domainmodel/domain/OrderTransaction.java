package jp.mufg.it.domainmodel.domain;

import java.util.Date;
import java.util.List;

public class OrderTransaction extends AbstractTransaction {
    private List<OrderDetail> orderDetails;
    private Integer totalPrice;

    // コンストラクタ
    public OrderTransaction(AbstractCustomer customer, Date transactionDate,
            List<OrderDetail> orderDetails, Integer totalPrice,
            String deliveryAddress) {
        super(customer, transactionDate);
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
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

    @Override
    public void calcDeliveryCharge() {
        // 送料を計算する
        // トータル金額が5000円以上かどうかを判定する
        if (5000 <= totalPrice) {
            // トータル金額が5000円以上だったら送料無料
            setDeliveryCharge(0);
        } else {
            // トータル金額が5000円未満のケース
            // 沖縄・小笠原など遠隔地かどうかを判定の上でセット
            setDeliveryCharge(getDeliveryChargeByAddress());
        }
    }
}
