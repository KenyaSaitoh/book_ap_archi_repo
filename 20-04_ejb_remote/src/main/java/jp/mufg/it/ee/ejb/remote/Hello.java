package jp.mufg.it.ee.ejb.remote;

import javax.ejb.Remote;

@Remote
public interface Hello {
    public String sayHello(String personName);
}