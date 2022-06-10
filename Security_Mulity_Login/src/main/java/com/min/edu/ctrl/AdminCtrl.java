package com.min.edu.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCtrl {

	@RequestMapping(value = "/admin/init.do")
	public String move() {
		System.out.println("관리자 이동 ");
		return "admin";
	}
	
}
