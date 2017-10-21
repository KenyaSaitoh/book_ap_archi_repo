package jp.mufg.it.domainmodel.domain;

import jp.mufg.it.domainmodel.util.Util;

public class SpecialDeliveryChargeStrategy implements DeliveryChargeStrategy {

    private Integer totalPrice;
    private String address;

    public SpecialDeliveryChargeStrategy(Integer totalPrice, String address) {
        this.totalPrice = totalPrice;
        this.address = address;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Integer calcDeliveryCharge() {
        // 送料を計算する
        // トータル金額が2000円以上かどうかを判定する
        if (2000 <= totalPrice) {
            // トータル金額が2000円以上だったら送料無料
            return 0;
        } else {
            // トータル金額が2000円未満のケース
            // 沖縄・小笠原など遠隔地かどうかを判定の上でセット
            if (Util.isRemoteLocation(address)) {
                // 遠隔地のケース
                return 1000;
            } else {
                // 遠隔地以外のケース
                return 500;
            }
        }
    }
}
