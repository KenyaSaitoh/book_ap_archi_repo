package jp.mufg.it.ee.ws.mtom;

public class MtomServiceRequestor1 {

    public static void main(String[] args) {
        System.out.println("[ MtomServiceRequestor1 ] Start");

        // サービスオブジェクトを生成する。
        MtomService service = new MtomService();

        // サービスオブジェクトからSEIオブジェクトを取得する。
        MtomServicePortType portType =
                service.getMtomServicePortTypePort();

        // サービスメソッドを呼び出す。
        portType.byteTransfer(new byte[]{1, 2, 3});

        System.out.println("[ MtomServiceRequestor1 ] End");
    }
}