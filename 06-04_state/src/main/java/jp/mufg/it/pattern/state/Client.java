package jp.mufg.it.pattern.state;

public class Client {
    public static void main(String[] args) {
        Business business = new Business();
        business.createDocument();
        business.applyDocument();
        business.rejectDocument();
        business.applyDocument();
        business.approveDocument();
    }
}
