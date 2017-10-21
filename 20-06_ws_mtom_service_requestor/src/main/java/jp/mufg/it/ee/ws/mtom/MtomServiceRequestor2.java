package jp.mufg.it.ee.ws.mtom;

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class MtomServiceRequestor2 {

    public static void main(String[] args) throws Exception {
        System.out.println("[ MtomServiceRequestor2 ] Start");

        // サービスオブジェクトを生成する
        MtomService service = new MtomService();

        // サービスオブジェクトからSEIオブジェクトを取得する
        MtomServicePortType portType =
                service.getMtomServicePortTypePort();

        // Fileインスタンスを生成する
        File targetFile = new File("targetFile.xls");

        // DataHandlerオブジェクトを生成する
        DataHandler dh = new DataHandler(new FileDataSource(targetFile));

        // サービスメソッドを呼び出す
        portType.dataTransfer(dh);

        System.out.println("[ MtomServiceRequestor2 ] End");
    }
}