package jp.mufg.it.domainmodel.domain;

public class PlatinumCustomer extends AbstractCustomer {

    public PlatinumCustomer(String name, Integer customerType, String address,
            Integer point) {
        super(name, customerType, address, point);
    }

    @Override
    public void checkTotalPriceLimit(Integer totalPrice) throws Exception {
        if (500000 < totalPrice) {
            throw new Exception("限度額オーバー");
        }
    }

    @Override
    public void addPoint(Integer point) {
        setPoint(point * 3);
    }
}
