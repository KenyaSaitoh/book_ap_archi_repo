package jp.mufg.it.ee.cdi.conversation;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class SessionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hreq = (HttpServletRequest)request;

        // リクエストの文字コードをUTF-8にセットする。
        hreq.setCharacterEncoding("UTF-8");

        // セッションを生成しておく。
        HttpSession session = hreq.getSession(true);
        // セッションに対して同期処理を行う。
        synchronized(session) {
            chain.doFilter(request, response);
        }
    }

    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }
}