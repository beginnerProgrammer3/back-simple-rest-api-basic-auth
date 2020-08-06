package com.skorupa.simplerestapi.services;


import com.skorupa.simplerestapi.model.ApkUser;
import com.skorupa.simplerestapi.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImp implements UserDetailsService {

    private UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final ApkUser userApk = userRepository.findUserByUsername(username);
        if (userApk == null){
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(userApk.getUsername()).password(userApk.getPassword()).authorities("USER").build();
        if(userApk.isEnabled()==true){
        return user;
        }else {
            return null;
        }
    }
}
