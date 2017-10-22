
package jp.mufg.it.ee.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloServicePortType", targetNamespace = "http://hello.ws.ee.it.mufg.jp/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloServicePortType {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHelloResponse")
    @Action(input = "http://hello.ws.ee.it.mufg.jp/HelloServicePortType/sayHelloRequest", output = "http://hello.ws.ee.it.mufg.jp/HelloServicePortType/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}