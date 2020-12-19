package com.keshar.rentcloud.autorizationserver.service;

import com.keshar.rentcloud.autorizationserver.model.AuthUserDetail;
import com.keshar.rentcloud.autorizationserver.model.User;
import com.keshar.rentcloud.autorizationserver.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service("userDetailsService")
public class UserDetailServiceImple implements UserDetailsService {

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDetailRepository.findByUsername(s);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("Username or Password is mismatch"));

        UserDetails userDetails = new AuthUserDetail(optionalUser.get());

        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;

    }
}
