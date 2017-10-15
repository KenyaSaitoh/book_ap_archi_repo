package jp.mufg.it.transactionscript.logic;

import jp.mufg.it.transactionscript.dto.CustomerDTO;
import jp.mufg.it.transactionscript.dto.OrderDetailDTO;
import jp.mufg.it.transactionscript.dto.OrderTransactionDTO;
import jp.mufg.it.transactionscript.dto.ProductDTO;
import jp.mufg.it.transactionscript.dto.ReturnTransactionDTO;
import jp.mufg.it.transactionscript.util.Util;

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
