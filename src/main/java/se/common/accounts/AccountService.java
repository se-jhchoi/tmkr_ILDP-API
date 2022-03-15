package se.common.accounts;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import se.mapper.app.AccountMapper;

@Service
public class AccountService implements UserDetailsService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	Account account = null;
		try {
			account = accountMapper.selectAccountInfo(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return new AccountAdapter(account);
    }
}
