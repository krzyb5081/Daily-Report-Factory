package com.krzyb5081.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.krzyb5081.app.model.UserModel;
import com.krzyb5081.app.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	private final PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userModel = userRepo.findByUserName(username).orElseThrow();
    	
		return User.withUsername(userModel.getUserName())
				.password(userModel.getPassword())
				.roles(userModel.getRole())
				.build();
	}
	
	public String createUser(UserModel userModel) {
		if (userRepo.findByUserName(userModel.getUserName()).isPresent()) {
			return "redirect:/register?error";
		}
		userModel.setRole("USER");
		userModel.setPassword(encoder.encode(userModel.getPassword()));
		userRepo.save(userModel);
		
		return "login";
	}
}
