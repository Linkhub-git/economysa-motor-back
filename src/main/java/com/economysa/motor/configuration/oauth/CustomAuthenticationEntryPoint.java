package com.economysa.motor.configuration.oauth;

import com.economysa.motor.util.ConstantMessage;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author QuickDev
 * @version 1.0
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
  public void commence(HttpServletRequest request,
                       HttpServletResponse response,
                       AuthenticationException ae) throws IOException, ServletException {
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ConstantMessage.ACCESS_DENIED);
  }
}
