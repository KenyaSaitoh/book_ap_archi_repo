package jp.mufg.it.ee.rs.hello;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/*")
public class MyApplication extends Application {
}
