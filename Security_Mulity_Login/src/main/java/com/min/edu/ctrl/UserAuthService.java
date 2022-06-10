package com.min.edu.ctrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.min.edu.dtos.InfoUser;
import com.min.edu.dtos.MemberDto;
import com.min.edu.model.Login_IService;

public class UserAuthService  implements AuthenticationProvider{

	@Autowired
	private Login_IService service;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		System.out.println("-------------------------");
		// 
		String username = (String)authentication.getPrincipal();		
		String user_pw = (String)authentication.getCredentials();
		
		System.out.println("MemberAuthService: id:{} , pwd:{}"+ username +"//"+ user_pw);
		
		MemberDto dto = service.loginChk(username);
		
		// 정보가 없으면 나간다.
		if ( username == null || username == "" ) {
			throw new BadCredentialsException("Member 로그인 아이디가 없습니다." + username );
		}
//		if ( user_pw == null || user_pw == ""  ) {
//			throw new BadCredentialsException("Member 로그인 암호가 없습니다." + user_pw );
//		}
		
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(dto.getAuth())); // ADMIN
				
		
		// 로그인한 사용자의 부가정보를 담아준다.
		InfoUser user_info = new InfoUser();
		user_info.setAddress("서울 한강");
		user_info.setName("양화대교");
		user_info.setPhone("00-000-1111");
		
        // 반환할 값을 만든다.
        UsernamePasswordAuthenticationToken result 
        	= new UsernamePasswordAuthenticationToken(username, user_pw, roles);
        
        // 로그인한 사용자의 정보를 detail 에 넣어준다.
        result.setDetails(user_info);
        
		return result;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
