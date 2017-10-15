package jp.mufg.it.ee.ws.provider.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.soap.Detail;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.soap.SOAPFaultException;

@WebService(name = "SoapFaultExceptionServicePortType",
        serviceName = "SoapFaultExceptionService")
public class SoapFaultExceptionService {

    // サービスメソッド
    @WebMethod
    public String sayHello(String personName, int count) {
        System.out.println("[ SoapFaultExceptionService#sayHello ] Start");
        // SAAJによって明示的にSOAPFaultException例外を生成する。
        SOAPFault fault;
        try {
            SOAPFactory factory = SOAPFactory.newInstance();

            // SOAPフォールトの情報をセットする。
            fault = factory.createFault();
            fault.setFaultCode("HogeFaultCode");
            fault.setFaultString("HogeFaultString");

            /* 上記は、以下のようにしてもよい。
            fault = factory.createFault("HogeFaultString",
                    new QName("", "HogeFaultCode"));
            */

            fault.setFaultActor("HogeFaultActor");
            Detail detail = fault.addDetail();
            detail.addChildElement("ErrorCode").addTextNode("E-9999");
            detail.addChildElement("ErrorMessage").addTextNode(
                    "Error Occured!!!");

        } catch(SOAPException se) {
            throw new RuntimeException(se);
        }
        SOAPFaultException sfe = new SOAPFaultException(fault);
        throw sfe;
    }
}