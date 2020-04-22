package jp.mufg.it.domainmodel.service;

import java.util.List;

import jp.mufg.it.domainmodel.domain.AbstractCustomer;
import jp.mufg.it.domainmodel.domain.DeliveryChargeStrategy;
import jp.mufg.it.domainmodel.domain.NormalDeliveryChargeStrategy;
import jp.mufg.it.domainmodel.domain.OrderDetail;
import jp.mufg.it.domainmodel.domain.OrderTransaction;
import jp.mufg.it.domainmodel.domain.SpecialDeliveryChargeStrategy;
import jp.mufg.it.domainmodel.dto.OrderTransactionDTO;

public class OrderService {

    // 注文する
    public void placeOrder(OrderTransactionDTO orderTransactionDTO)
            throws Exception {

        // 顧客ドメインオブジェクトを取得する
        Integer customerId = orderTransactionDTO.getCustomerId();
        AbstractCustomer customer = null;
        // Customer customer = CustomerDAO.findCustomer(customerId);

        // 送料計算アルゴリズムのStrategyを取得する
        DeliveryChargeStrategy deliveryChargeStrategy = null;
        switch(customer.getCustomerType()) {
        case 1 :
            deliveryChargeStrategy = new NormalDeliveryChargeStrategy(
                    orderTransactionDTO.getTotalPrice(), customer.getAddress());
            break;
        case 2 :
            deliveryChargeStrategy = new SpecialDeliveryChargeStrategy(
                    orderTransactionDTO.getTotalPrice(), customer.getAddress());
            break;
        case 3 :
            deliveryChargeStrategy = new SpecialDeliveryChargeStrategy(
                    orderTransactionDTO.getTotalPrice(), customer.getAddress());
            break;
        }

        // 注文取引ドメインオブジェクトを生成する
        OrderTransaction orderTransaction = null;
        List<OrderDetail> orderDetailList = null;
        /*
        OrderTransaction orderTransaction = new OrderTransaction(customer,
                orderTransactionDTO.getOrderDate(), orderDetailList,
                orderTransactionDTO.getTotalPrice(),
                customer.getAddress(), deliveryChargeStrategy);
        */

        // 限度額チェックを行う
        customer.checkTotalPriceLimit(orderTransactionDTO.getTotalPrice());

        // ポイントを計算して加算する
        Integer point = orderTransactionDTO.getTotalPrice() / 10;
        customer.addPoint(point);

        // CUSTOMERテーブル(ポイントのみ)を更新する
        // entityManager.merge(customer);

        // 送料を計算する
        orderTransaction.calcDeliveryCharge();

        // ORDER_TRANSACTIONテーブルに挿入する
        // entityManager.persist(orderTransaction);
    }
}
