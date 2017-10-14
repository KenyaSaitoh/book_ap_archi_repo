package org.study.pattern.transactionscript.logic;

import org.study.pattern.transactionscript.dto.CustomerDTO;
import org.study.pattern.transactionscript.dto.OrderDetailDTO;
import org.study.pattern.transactionscript.dto.OrderTransactionDTO;
import org.study.pattern.transactionscript.dto.ProductDTO;
import org.study.pattern.transactionscript.dto.ReturnTransactionDTO;
import org.study.pattern.transactionscript.util.Util;

public class ReturnLogic {

    public void returnProduct(ReturnTransactionDTO returnTransaction) {

        // 顧客オブジェクトを取得する
        CustomerDTO customer = null;

        // 商品オブジェクトを取得する
        ProductDTO product = null;

        // 返送料を計算する
        // 対象商品が無料返品可能かどうかを判定する
        if (product.canFreeReturn()) {
            // 対象商品が無料返品可能のケース
            returnTransaction.setDeliveryCharge(0);
        } else {
            // 対象商品が無料返品不可のケース
            // 沖縄・小笠原など遠隔地かどうかを判定
            if (Util.isRemoteLocation(customer.getAddress())) {
                // 遠隔地のケース
                returnTransaction.setDeliveryCharge(1300);
            } else {
                // 遠隔地以外のケース
                returnTransaction.setDeliveryCharge(700);
            }
        }

        // RETURN_TRANSACTIONテーブルに挿入する
        // ReturnTransactionDAO.persist(returnTransaction);
    }
}
