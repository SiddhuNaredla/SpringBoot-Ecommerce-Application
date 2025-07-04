package com.example.ecomproject.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class UserPrinciple implements UserDetails {

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    public boolean isAccountNonExpired(){
        return UserDetails.super.isAccountNonExpired();
    }

//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
