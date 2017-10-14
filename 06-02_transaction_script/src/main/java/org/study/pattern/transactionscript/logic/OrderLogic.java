package org.study.pattern.transactionscript.logic;

import java.util.List;

import org.study.pattern.transactionscript.dto.CustomerDTO;
import org.study.pattern.transactionscript.dto.OrderDetailDTO;
import org.study.pattern.transactionscript.dto.OrderTransactionDTO;
import org.study.pattern.transactionscript.dto.ProductDTO;
import org.study.pattern.transactionscript.dto.ReturnTransactionDTO;
import org.study.pattern.transactionscript.util.Util;

public class OrderLogic {

    // 注文する
    public void placeOrder(OrderTransactionDTO orderTransaction)
            throws Exception{

        // 顧客オブジェクトを生成する
        Integer customerId = orderTransaction.getCustomerId();
        CustomerDTO customer = null;
        // Customer customer = CustomerDAO.findCustomer(customerId);

        // 限度額チェックを行う
        if (customer.getCustomerType().equals(1)) {
            // 一般会員の場合は10万以上で限度額オーバー
            if (100000 < orderTransaction.getTotalPrice()) {
                throw new Exception("限度額オーバー");
            }
        } else if(customer.getCustomerType().equals(2)) {
            // ゴールド会員の場合は30万以上で限度額オーバー
            if (300000 < orderTransaction.getTotalPrice()) {
                throw new Exception("限度額オーバー");
            }
        } else {
            // ありえない条件分岐（例外スロー）
        }

        // ポイントを計算して加算する
        Integer point = orderTransaction.getTotalPrice() / 10;
        if (customer.getCustomerType().equals(1)) {
            // 一般会員の場合はポイントをそのまま加算する
            customer.setPoint(customer.getPoint() + point);
        } else if(customer.getCustomerType().equals(2)) {
            // ゴールド会員の場合はポイントを2倍して加算する
            customer.setPoint(customer.getPoint() + point * 2);
        } else {
            // ありえない条件分岐（例外スロー）
        }

        // CUSTOMERテーブル(ポイントのみ)を更新する
        // CustomerDAO.updatePoint(customer);

        // 送料を計算する
        // トータル金額が5000円以上かどうかを判定する
        if (5000 <= orderTransaction.getTotalPrice()) {
            // トータル金額が5000円以上だったら送料無料
            orderTransaction.setDeliveryCharge(0);
        } else {
            // トータル金額が5000円未満のケース
            // 沖縄・小笠原など遠隔地かどうかを判定
            if (Util.isRemoteLocation(customer.getAddress())) {
                // 遠隔地のケース
                orderTransaction.setDeliveryCharge(1300);
            } else {
                // 遠隔地以外のケース
                orderTransaction.setDeliveryCharge(700);
            }
        }

        // ORDER_TRANSACTIONテーブルに挿入する
        // OrderTransactionDAO.persist(orderTransaction);
    }
}
