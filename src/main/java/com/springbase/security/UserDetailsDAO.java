package com.springbase.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springbase.user.UserRepository;

@Repository
public class UserDetailsDAO implements UserDetailsService {

	@Autowired
	private UserRepository users;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return users.findByEmail(username)
					.orElseThrow(() -> new UsernameNotFoundException("User not found"));
	}

}