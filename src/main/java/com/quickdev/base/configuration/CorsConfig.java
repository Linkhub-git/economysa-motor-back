package com.quickdev.base.configuration;

import com.quickdev.base.util.ConstantCore;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QuickDev
 * @version 1.0
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements Filter {

  public CorsConfig() {
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletResponse response = (HttpServletResponse) res;
    HttpServletRequest request = (HttpServletRequest) req;
    response.setHeader(ConstantCore.CORS_HEADER_1, ConstantCore.ASTERISK);
    response.setHeader(ConstantCore.CORS_HEADER_2, ConstantCore.ALLOWED_HTTP_METHODS);
    response.setHeader(ConstantCore.CORS_HEADER_3, ConstantCore.MAX_AGE_VALUE);
    response.setHeader(ConstantCore.CORS_HEADER_4, ConstantCore.ALLOWED_HEADERS);

    if (ConstantCore.HTTP_METHOD_OPTIONS.equalsIgnoreCase(request.getMethod())) {
        response.setStatus(HttpServletResponse.SC_OK);
    } else {
        chain.doFilter(req, res);
    }
  }

  @Override
  public void init(FilterConfig filterConfig) {}

  @Override
  public void destroy() {}
}
