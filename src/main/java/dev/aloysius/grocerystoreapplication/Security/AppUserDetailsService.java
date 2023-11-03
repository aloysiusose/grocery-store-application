package dev.aloysius.grocerystoreapplication.Security;

import dev.aloysius.grocerystoreapplication.Domains.Admin;
import dev.aloysius.grocerystoreapplication.Domains.ApplicationUsers;
import dev.aloysius.grocerystoreapplication.Domains.Customers;
import dev.aloysius.grocerystoreapplication.Repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final CustomersRepository customersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customersRepository.findByUsername(username).map(AppUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("User with username %s not found".formatted(username)));
    }

    protected static class AppUserDetails extends Customers implements UserDetails{
        public AppUserDetails(Customers users) {
            super(users);
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;

        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

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
}
