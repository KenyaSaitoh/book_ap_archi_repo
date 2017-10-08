package jp.mufg.it.domainmodel.domain;

public class GoldCustomer extends AbstractCustomer {

    public GoldCustomer(String name, Integer customerType, String address,
            Integer point) {
        super(name, customerType, address, point);
    }

    @Override
    public void checkTotalPriceLimit(Integer totalPrice) throws Exception {
        if (300000 < totalPrice) {
            throw new Exception("限度額オーバー");
        }
    }

    @Override
    public void addPoint(Integer point) {
        setPoint(point * 2);
    }
}
