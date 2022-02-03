package com.economysa.motor.configuration.oauth;

import com.economysa.motor.util.ConstantCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * @author QuickDev
 * @version 1.0
 */
@Configuration
public class OAuth2Configuration {

  @Configuration
  @EnableResourceServer
  protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
      http
              .exceptionHandling()
              .authenticationEntryPoint(customAuthenticationEntryPoint)
              .and()
              .logout()
              .logoutUrl(ConstantCore.LOGOUT_URL)
              .logoutSuccessHandler(customLogoutSuccessHandler)
              .and()
              .csrf()
              .requireCsrfProtectionMatcher(new AntPathRequestMatcher(ConstantCore.AUTHORIZE_URL))
              .disable()
              .headers()
              .frameOptions().disable()
              .and()
              .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
              .and()
              .authorizeRequests()
              .antMatchers(ConstantCore.PUBLIC_PATH).permitAll()
              .antMatchers(ConstantCore.SECURED_PATH).authenticated();
    }
  }

  @Configuration
  @EnableAuthorizationServer
  protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
        }

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints
              .tokenStore(tokenStore())
              .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
      clients.inMemory()
              .withClient(OAuthConstant.ANDROID_CLIENT_ID)
              .scopes(OAuthConstant.SCOPE_READ, OAuthConstant.SCOPE_WRITE)
              .authorities(OAuthConstant.ROLE_USER)
              .authorizedGrantTypes(OAuthConstant.GRANT_TYPE_PASSWORD, OAuthConstant.GRANT_TYPE_REFRESH_TOKEN)
              .secret(OAuthConstant.ANDROID_CLIENT_SECRET)
              .accessTokenValiditySeconds(OAuthConstant.NEVER_EXPIRES)
              .and()
              .withClient(OAuthConstant.IOS_CLIENT_ID)
              .scopes(OAuthConstant.SCOPE_READ, OAuthConstant.SCOPE_WRITE)
              .authorities(OAuthConstant.ROLE_USER)
              .authorizedGrantTypes(OAuthConstant.GRANT_TYPE_PASSWORD, OAuthConstant.GRANT_TYPE_REFRESH_TOKEN)
              .secret(OAuthConstant.IOS_CLIENT_SECRET)
              .accessTokenValiditySeconds(OAuthConstant.NEVER_EXPIRES)
              .and()
              .withClient(OAuthConstant.ANGULAR_CLIENT_ID)
              .scopes(OAuthConstant.SCOPE_READ, OAuthConstant.SCOPE_WRITE)
              .authorities(OAuthConstant.ROLE_USER)
              .authorizedGrantTypes(OAuthConstant.GRANT_TYPE_PASSWORD, OAuthConstant.GRANT_TYPE_REFRESH_TOKEN)
              .secret(OAuthConstant.ANGULAR_CLIENT_SECRET)
              .accessTokenValiditySeconds(OAuthConstant.NEVER_EXPIRES);
    }
  }
}
