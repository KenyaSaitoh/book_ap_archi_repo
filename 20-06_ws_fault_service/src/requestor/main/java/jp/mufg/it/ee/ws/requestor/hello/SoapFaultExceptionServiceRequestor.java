package jp.mufg.it.ee.ws.requestor.hello;

import java.util.Iterator;
import javax.xml.soap.Detail;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

import jp.mufg.it.ee.ws.provider.hello.SoapFaultExceptionService;
import jp.mufg.it.ee.ws.provider.hello.SoapFaultExceptionServicePortType;

public class SoapFaultExceptionServiceRequestor {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("[ SoapFaultExceptionServiceRequestor ] Start");

        // サービスオブジェクトを生成する。
        SoapFaultExceptionService service = new SoapFaultExceptionService();

        // サービスオブジェクトからSEIオブジェクトを取得する。
        SoapFaultExceptionServicePortType portType =
                service.getSoapFaultExceptionServicePortTypePort();

        // サービスメソッドを呼び出す。 → SOAPフォールト例外発生
        try {
            portType.sayHello("Webservice", 3);
        } catch(SOAPFaultException sfe) {
            System.out.println("===== SOAPFaultException =====");
            SOAPFault fault = sfe.getFault();
            System.out.println("  FaultCode ---> " + fault.getFaultCode());
            System.out.println("  FaultString ---> " + fault.getFaultString());
            System.out.println("  FaultActor ---> " + fault.getFaultActor());
            System.out.println("===== Detail =====");
            Detail detail = fault.getDetail();
            Iterator<SOAPElement> i = detail.getChildElements();
            while (i.hasNext()) {
                SOAPElement element = i.next();
                System.out.println("  " + element.getTagName() + " ---> " +
                        element.getTextContent());
            }
        }

        System.out.println("[ SoapFaultExceptionServiceRequestor ] End");
    }
}