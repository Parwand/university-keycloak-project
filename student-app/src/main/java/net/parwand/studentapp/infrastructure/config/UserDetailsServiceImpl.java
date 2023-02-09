package net.parwand.studentapp.infrastructure.config;

import net.parwand.studentapp.applicationservice.service.UserService;
import net.parwand.studentapp.domain.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(
                role -> grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole()))
        );
        return new UserDetailsImpl(user, grantedAuthorities);
    }

}
