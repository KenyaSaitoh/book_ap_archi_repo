package jp.mufg.it.domainmodel.service;

import jp.mufg.it.domainmodel.domain.AbstractCustomer;
import jp.mufg.it.domainmodel.domain.AbstractTransaction;
import jp.mufg.it.domainmodel.domain.Product;
import jp.mufg.it.domainmodel.dto.ReturnTransactionDTO;

public class ReturnService {

    public void returnProduct(ReturnTransactionDTO returnTransactionDTO)
            throws Exception {

        // 顧客ドメインオブジェクトを取得する
        AbstractCustomer customer = null;

        // 商品ドメインオブジェクトを取得する
        Product product = null;

        // 返品取引ドメインオブジェクトを生成する
        AbstractTransaction returnTransaction = null;

        // 返送料を計算する
        returnTransaction.calcDeliveryCharge();

        // RETURN_TRANSACTIONテーブルに挿入する
        // entityManager.persist(returnTransaction);
    }
}
