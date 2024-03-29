
package jp.mufg.it.ee.ws.hello;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloAsyncServicePortType", targetNamespace = "http://hello.ws.ee.it.mufg.jp/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface HelloAsyncServicePortType {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns javax.xml.ws.Response<jp.mufg.it.ee.ws.hello.SayHelloResponse>
     */
    @WebMethod(operationName = "sayHello")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHelloResponse")
    public Response<SayHelloResponse> sayHelloAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @param asyncHandler
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "sayHello")
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://hello.ws.ee.it.mufg.jp/", className = "jp.mufg.it.ee.ws.hello.SayHelloResponse")
    public Future<?> sayHelloAsync(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<SayHelloResponse> asyncHandler);

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
    @Action(input = "http://hello.ws.ee.it.mufg.jp/HelloAsyncServicePortType/sayHelloRequest", output = "http://hello.ws.ee.it.mufg.jp/HelloAsyncServicePortType/sayHelloResponse")
    public String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        int arg1);

}
