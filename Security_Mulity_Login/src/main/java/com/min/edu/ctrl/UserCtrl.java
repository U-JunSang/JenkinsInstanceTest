package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCtrl {
	
	@RequestMapping(value = "/user/init.do")
	public String move() {
		System.out.println("사용자 이동 ");
		return "user";
	}
}
