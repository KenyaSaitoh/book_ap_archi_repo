package org.study.ee.ws.provider.mtom;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.ws.soap.MTOM;

@WebService(name = "MtomServicePortType",
        serviceName = "MtomService")
public class MtomService {

    // サービスメソッド
    @WebMethod
    @MTOM
    public void byteTransfer(byte[] bytes) {
        System.out.println("[ MtomService#byteTransfer ] Start");
        for (byte b : bytes) {
            System.out.print(b);
        }
        System.out.println("[ MtomService#byteTransfer ] End");
    }

    // サービスメソッド
    @WebMethod
    @MTOM
    public void dataTransfer(
            @XmlMimeType("application/octet-stream") DataHandler data) {
        System.out.println("[ MtomService#sayHello ] Start");
        try {
            InputStream is = data.getInputStream();
            int c = 0;
            while((c = is.read()) != -1) {
                System.out.println(c);
            }
        } catch(IOException ioe) {
        }
        System.out.println("[ MtomService#sayHello ] End");
    }
}