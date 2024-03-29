
package jp.mufg.it.ee.ws.hello;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloOnewayServicePortType", targetNamespace = "http://hello.ws.ee.it.mufg.jp/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloOnewayServicePortType {


    /**
     * 
     * @param arg1
     * @param arg0
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHello")
    @Action(input = "http://hello.ws.ee.it.mufg.jp/HelloOnewayServicePortType/sayHello")
    public void sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
