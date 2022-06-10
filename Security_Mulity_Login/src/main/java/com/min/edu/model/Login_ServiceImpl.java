package com.min.edu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.min.edu.dtos.MemberDto;

@Service
public class Login_ServiceImpl implements Login_IService{

	@Autowired
	private Login_IDao dao;
	
	@Override
	public MemberDto loginChk(String id) {
		return dao.loginChk(id);
	}

	@Override
	public boolean signUp(MemberDto dto) {
		return dao.signUp(dto);
	}

}
