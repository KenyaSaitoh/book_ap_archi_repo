package jp.mufg.it.ee.ws.provider.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloFaultServicePortType",
        serviceName = "HelloFaultService")
public class HelloFaultService {

    // サービスメソッド～チェック例外を意図的にスロー
    @WebMethod
    public String sayHello(String personName, int count)
                throws FooException {
        System.out.println("[ HelloFaultService#sayHello2 ] Start");
        throw new FooException("Service Provider Exception");
    }

    // サービスメソッド～チェック例外を意図的にスロー
    @WebMethod
    public void doBusiness() throws BusinessException {
        throw new BusinessException("Service Provider Exception");
    }
}