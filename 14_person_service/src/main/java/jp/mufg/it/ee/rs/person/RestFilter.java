package jp.mufg.it.ee.rs.person;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RestFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestCtx,
            ContainerResponseContext responseCtx) throws IOException {
        responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseCtx.getHeaders().add("Access-Control-Allow-Methods",
                "GET, POST, DELETE, PUT, OPTIONS");
        responseCtx.getHeaders().add("Access-Control-Allow-Headers",
                "Content-Type");
    }
}
