package com.quickdev.base.configuration.oauth;

import com.quickdev.base.app.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author QuickDev
 * @version 1.0
 */
@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

  @Autowired private UserService userService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    com.quickdev.base.app.security.entity.User user = userService.get(email);

    grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));
    return new User(user.getEmail(), user.getPassword(), grantedAuthorities);
  }
}
