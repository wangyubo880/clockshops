package com.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;
import com.service.ClockService;

@Controller
public class ClockAction {
	@Autowired
	private ClockService clockService;
	//显示商品列表
	@RequestMapping("/productlist")
	public String selectClockList(Model model) {
		List<Light> list=clockService.findClock();
		model.addAttribute("clocklist",list);
		return "productlist";
	}
	
	@RequestMapping("/admindelete")
	public String adminDelete(Integer id,Model model) {
		boolean result=clockService.admindelete(id);
		if(result) {
			return "redirect:productlist.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "admindelete";
		}
	}
	//根据名称查询
	@RequestMapping("/selectbyname")
	public String selectByName(Model model,String name) {
		List<Light> list=clockService.fuzzyClock(name);
		model.addAttribute("clockname",list);
		return "productnamelist";
	}
	//根据类别查询
	@RequestMapping("/selectbytype")
	public String selectByType(Model model,String name) {
		List<Light> list=clockService.selectByTypename(name);
		model.addAttribute("clock",list);
		return "productypelist";
	}
	//添加类别
	@RequestMapping("/addclocktype")
	public String addClockType(Model model,@RequestParam("typename") String typeName) {
		Clocktype clocktype = new Clocktype();
		clocktype.setTypename(typeName);
		boolean result=clockService.addClockType(clocktype);
		if(result) {
			return "redirect:productlist.do";
		}else {
			return "addclocktype";
		}
	}
	//查询订单
	@RequestMapping("/orderlist")
	public String showOrderDetail(Model model) {
		List<OrderDetail> detail=clockService.showOrder();
		model.addAttribute("detail", detail);
		return "orderlist";
	}
	//根据用户id查询订单
	@RequestMapping("/orderlistbyid")
	public String showOrderByid(Model model,Integer uid) {
		List<OrderDetail> orderid=clockService.showOrderByid(uid);
		model.addAttribute("orderid", orderid);
		return "orderlistbyid";
	}
	//确认订单
	@RequestMapping("/adminconfirmorder")
	public String adminConfirmOrder(Model model,Integer id) {
		System.out.println(id);
		boolean result=clockService.adminConfirmOrder(id);
		if(result) {
			return "redirect:orderlist.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "adminconfirmorder";
		}
	}
	//添加商品显示类别
	@RequestMapping("/adminaddproducts")
	public String showType(Clocktype clocktype,Model model) {
		List<Clocktype> clocktypes=clockService.showType();
		model.addAttribute("clocktypes",clocktypes);
		return "adminaddproducts";
	}
	//添加商品
	@RequestMapping("/adminaddclock")
	public String addClock(Model model,HttpServletRequest request,@RequestParam("clocktype") Integer typeid,@RequestParam("name") String name,@RequestParam("price") Double price,@RequestParam("imgs") MultipartFile imgs)throws Exception{
		Light light=new Light();
		Clocktype type=new Clocktype();
		System.out.println(typeid);
		type.setTypeid(typeid);
		light.setName(name);
		light.setPrice(price);
		light.setClocktype(type);
		try {
			//上传图片
			String originalFilename = imgs.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(imgs.getBytes(), new File(realPath+"\\"+fileName));
				light.setImg(fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","上传图片失败");
			return "login";
		}
		boolean result=clockService.addClock(light);
		if(result) {
			return "redirect:productlist.do";
		}else {
			model.addAttribute("errormsg", "注册失败");
			return "productlist.do";
		}
	}
	
	//显示需要修改的内容
	@RequestMapping("/showupdateclock")
	public String showUpdateClock(Clocktype clocktype,Model model,Integer id,HttpSession session) {
		List<Clocktype> clocktypes=clockService.showType();
		model.addAttribute("clocktypes",clocktypes);
		List<Light> light=clockService.showUpdateLight(id);
		session.setAttribute("clockid", id);
		model.addAttribute("light",light);
		return "showupdateclock";
	}
	//修改商品
	@RequestMapping("/adminupdateclock")
	public String adminUpdateClock(HttpSession session,Model model,HttpServletRequest request,@RequestParam("clocktype") Integer typeid,@RequestParam("name") String name,@RequestParam("price") Double price,@RequestParam("imgs") MultipartFile imgs)throws Exception{
		Light light=new Light();
		Clocktype type=new Clocktype();
		type.setTypeid(typeid);
		light.setName(name);
		light.setPrice(price);
		light.setClocktype(type);
		try {
			//上传图片
			String originalFilename = imgs.getOriginalFilename();	
			if(originalFilename!=null && !originalFilename.equals("")) {
				
				String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\")+1);
				String realPath = request.getServletContext().getRealPath("admins/bookimg");
				FileCopyUtils.copy(imgs.getBytes(), new File(realPath+"\\"+fileName));
				light.setImg(fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("failMsg","上传图片失败");
			return "login";
		}
		Integer clockid=(Integer)session.getAttribute("clockid");
		boolean result=clockService.adminUpdateClock(light, clockid);
		if(result) {
			return "redirect:productlist.do";
		}else {
			return "redirect:productlist.do";
		}
	}
	@RequestMapping("/adminshowordermsg")
	public String userShowOrder(Integer id,HttpServletRequest request,Orders order,Model model,HttpSession session) {
		System.out.println(id);
		List<Orders> orderlists=clockService.userShowOrder(id);
		int a=orderlists.size();
		System.out.println(a);
		model.addAttribute("orderlists",orderlists);
		return "adminshowordermsg";
	}
	@RequestMapping("/adminshowuser")
	public String adminShowUser(User user,Model model) {
		List<User> list=clockService.adminShowUser();
		model.addAttribute("adminuserlist",list);
		return "adminshowuser";
	}
	@RequestMapping("/adminselectuserbyusername")
	public String adminShowUserByusername(String username,User user,Model model){
		List<User> list=clockService.adminShowUserbyusername(username);
		model.addAttribute("usernamelists",list);
		return "adminselectuserbyusername";
	}
	@RequestMapping("/adminselectuserbyname")
	public String adminShowUserByname(String name,User user,Model model){
		List<User> list=clockService.adminShowUserbyname(name);
		model.addAttribute("namelists",list);
		return "adminselectuserbyname";
	}
	@RequestMapping("/admindeleteuserbyid")
	public String adminDeleteUserByid(Integer id,Model model) {
		boolean result=clockService.adminDeleteUser(id);
		if(result) {
			return "redirect:adminshowuser.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "deletebyid";
		}
	}
	@RequestMapping("/admindeleteuserbyidbatch")
	public String adminDeleteUserByidbatch(@RequestParam("ids")Integer[] ids,Model model) {
		boolean result=clockService.adminDeleteUserbatch(ids);
		if(result) {
			return "redirect:adminshowuser.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "deletebyid";
		}
	}
}
