package com.action;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Admin;
import com.bean.Receive;
import com.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.service.UserService;

@Controller
public class UserAction {
	   
		@Autowired
		private UserService userService;
		@RequestMapping("/userlist")
		public String userlist(Model model) {
			List<User> list = userService.findAll();
			model.addAttribute("userlist",list);
			return "userlist";
		}
//		@RequestMapping("/registers")
//		public String register(User user,Model model) {
//			boolean result = userService.register(user);
//			if(result) {
//				return "redirect:login.jsp";
//			}else {
//				model.addAttribute("errormsg", "×¢²áÊ§°Ü");
//				return "register";
//			}
//			
//		}
		@RequestMapping("/register")
		public String registers(User user,Model model,HttpServletRequest request,@RequestParam("imgs") MultipartFile imgs)throws Exception {
			System.out.println(imgs);
//			user.setName(name);
//			user.setUsername(username);
//			user.setAddress(address);
//			user.setEmail(email);
//			user.setPhone(phone);
//			user.setPassword(password);
			
			try {
				//ÉÏ´«Í¼Æ¬
				String originalFilename = imgs.getOriginalFilename();	
				if(originalFilename!=null && !originalFilename.equals("")) {
					
					String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
					String realPath = request.getServletContext().getRealPath("admins/bookimg");
					FileCopyUtils.copy(imgs.getBytes(), new File(realPath+"\\"+fileName));
					user.setImg(fileName);
				}
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("failMsg","ÉÏ´«Í¼Æ¬Ê§°Ü");
				return "login";
			}
			boolean result = userService.register(user,user.getImg());
			if(result) {
				return "redirect:login.jsp";
			}else {
				model.addAttribute("errormsg", "×¢²áÊ§°Ü");
				return "register";
			}
		}

		@RequestMapping("/login")
		public String login(String username,String password,Model model1,Model model2,HttpSession session,User user) {
			boolean result=userService.login(username, password);
			if(result) {
				model1.addAttribute("username",username);
				int uid=userService.selectid(username);
				model2.addAttribute("userid",uid);
				session.setAttribute("username", username);
				session.setAttribute("uid", uid);
				return "successlogin";
			}else {
				model1.addAttribute("errormsg", "×¢²áÊ§°Ü");
				return "login";
			}
		}
		@RequestMapping("/mymessage")
		public String showUserMessage(HttpSession session,Model model){
			Integer uid=(Integer)session.getAttribute("uid");
			List<User> list=userService.findUserById(uid);
			model.addAttribute("userlist",list);
			return "mymessage";
		}
		@RequestMapping("/updateMessage")
		public String updateUserMessage(HttpSession session,Model model){
			//String id=(String)session.getAttribute("uid");
			Integer uid=(Integer)session.getAttribute("uid");
			List<User> list=userService.findUserById(uid);
			model.addAttribute("userlists",list);
			return "updateMessage";
		}
//		@RequestMapping("/updateUserMessage")
//		public String updateMessage(HttpSession session,Model model,Integer id,String name,String username,String email,String address,String phone,String password) {
//			Integer uid=(Integer)session.getAttribute("uid");
//			boolean result=userService.updateUser(uid, name, username, email, address, phone, password);
//			if(result) {
//				return "redirect:mymessage.do";
//			}else {
//				return "updateMessage";
//			}
//		}
		@RequestMapping("/updateUserMessage")
		public String updateMessage(HttpSession session,Model model,HttpServletRequest request,@RequestParam("name") String name,@RequestParam("username") String username,@RequestParam("email") String email,@RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("password") String password,@RequestParam("imgs") MultipartFile imgs) throws Exception{
			User user=new User();
			user.setName(name);
			user.setUsername(username);
			user.setAddress(address);
			user.setEmail(email);
			user.setPhone(phone);
			user.setPassword(password);
			try {
				//ÉÏ´«Í¼Æ¬
				String originalFilename = imgs.getOriginalFilename();	
				if(originalFilename!=null && !originalFilename.equals("")) {
					
					String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
					String realPath = request.getServletContext().getRealPath("admins/bookimg");
					FileCopyUtils.copy(imgs.getBytes(), new File(realPath+"\\"+fileName));
					user.setImg(fileName);
				}
			}catch(Exception e) {
				e.printStackTrace();
				model.addAttribute("failMsg","ÉÏ´«Í¼Æ¬Ê§°Ü");
				return "login";
			}
			Integer uid=(Integer)session.getAttribute("uid");
			boolean result=userService.updateUser(uid, user);
			if(result) {
				return "redirect:mymessage.do";
			}else {
				return "updateMessage";
			}
		}
		@RequestMapping("/receiving")
		public String showReceivingMessage(HttpSession session,Model model){
			Integer uid=(Integer)session.getAttribute("uid");
			List<Receive> list=userService.selectReceiveMesage(uid);
			model.addAttribute("receivelist",list);
			return "receiving";
		}
		//¹ÜÀíÔ±Ìí¼Ó
				@RequestMapping("/adminregister")
				public String addAdmin(Admin admin,Model model) {
					System.out.println(admin.getAdminame());
					System.out.println(admin.getPassword());
					boolean result=userService.addAdmin(admin);
					if(result) {
						return "redirect:adminlogin.jsp";
					}else {
						model.addAttribute("errormsg", "×¢²áÊ§°Ü");
						return "register";
					}
				}
}
