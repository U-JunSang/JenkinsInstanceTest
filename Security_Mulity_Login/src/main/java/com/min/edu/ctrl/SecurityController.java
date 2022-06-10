package com.min.edu.ctrl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.min.edu.dtos.MemberDto;
import com.min.edu.model.Login_IService;

public class SecurityController implements UserDetailsService {

	@Autowired
	private Login_IService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("------------------"+"AdminSecurityController 작동중");
		MemberDto dto = service.loginChk(username);
		System.out.println("------------------"+username);
		System.out.println("------------------"+dto.getPw());
		
		
		List <SimpleGrantedAuthority> roles = new ArrayList<SimpleGrantedAuthority>();

		roles.add(new SimpleGrantedAuthority(dto.getAuth())); // ADMIN
		
		UserDetails user = new User(username,dto.getPw(),roles); // nobrand01, 1234(암호), role
		
		return user;
	}


}
