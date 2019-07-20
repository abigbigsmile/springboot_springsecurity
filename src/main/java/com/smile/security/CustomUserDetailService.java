package com.smile.security;

import com.smile.mapper.UserMapper;
import com.smile.model.Role;
import com.smile.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "customUserDetailService")
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userMapper.findUserByName(username);
        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
        for(Role role : user.getRoleList()){
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),encoder.encode(user.getPassword().trim()),authorityList);
    }
}
