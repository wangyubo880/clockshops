package com.action;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bean.Admin;
import com.bean.User;
import com.service.AdminService;
import com.service.UserService;

@Controller
public class AdminAction {
	@Autowired
	private UserService userService;
	@RequestMapping("/adminlogin")
	public String login(String adminame,String password,Model model1,HttpSession session) {
		boolean result=userService.adminlogin(adminame, password);
		if(result) {
			model1.addAttribute("adminame",adminame);
			
			session.setAttribute("adminame", adminame);
			return "redirect:admindex.jsp";
		}else {
			model1.addAttribute("errormsg", "×¢²áÊ§°Ü");
			return "redirect:adminlogin.jsp";
		}
	}
	
	
}
