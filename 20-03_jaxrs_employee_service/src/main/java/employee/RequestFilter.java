package org.study.ee.rs.server.employee;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext)
            throws IOException {

        System.out.println("length ---> " + requestContext.getLength());
        System.out.println("SecurityContext ---> " + requestContext.getSecurityContext());
    }
}
