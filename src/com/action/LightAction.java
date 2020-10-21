package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bean.Cart;
import com.bean.Clocktype;
import com.bean.Light;
import com.bean.Order;
import com.bean.OrderDetail;
import com.bean.Orders;
import com.bean.User;
import com.service.LightService;

@Controller
public class LightAction {
	@Autowired
	private LightService lightService;
	@RequestMapping("/lightlist")
	public String lightlist(Model model) {
		List<Light> list = lightService.findAll();
		model.addAttribute("lightlist",list);
		return "lightlist";
	}
	@RequestMapping("/products")
	public String clocklist(Model model) {
		List<Light> list=lightService.findAll();
		model.addAttribute("clocklist",list);
		return "products";
	}
	@RequestMapping("/beproducts")
	public String clocklists(Model model) {
		List<Light> list=lightService.findAll();
		model.addAttribute("clocklists",list);
		return "beproducts";
	}
	@RequestMapping("/single")
	public String clockid(Integer id,Model model) {
		List<Light> list=lightService.findByid(id);
		model.addAttribute("clockid",list);
		return "single";
	}
	
	@RequestMapping("/addcart")
//	public String addcart(Cart cart,Model model,Integer id,Integer num,Double count,Double price) {
//		boolean result=lightService.addCart(cart,id);
//		if(result) {
//			return "redirect:checkout.do";
//		}else {
//			model.addAttribute("errormsg","添加失败");
//			return "addcart";
//		}
//	}
	public String addcart(Cart cart,Model model) {
		//boolean result=lightService.addCart(id);
//		if(result) {              //存在相同id
//			boolean result1=lightService.addQty(id);
//			if(result1) {
//				return "redirect:products.do";
//			}else {
//				model.addAttribute("errormsg","增加数量失败");
//				return "addcartnum";
//			}
//		}else {
			boolean result2=lightService.addCarts(cart);
			if(result2) {
				return "redirect:products.do";
			}else {
				model.addAttribute("errormsg", "添加失败");
				return "products";
			}
		}
	//}
	@RequestMapping("/checkout")
	public String cartlist(Model model,HttpSession session) {
		//String id=(String)session.getAttribute("uid");
		Integer uid=(Integer)session.getAttribute("uid");
		List<Cart> list=lightService.selectCart(uid);
		model.addAttribute("cartlist",list);
		return "checkout";
	}
	@RequestMapping("/deletebyid")
	public String deleteCartByid(Integer id,Model model) {
		boolean result=lightService.deleteCartByid(id);
		if(result) {
			return "redirect:checkout.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "deletebyid";
		}
	}
	@RequestMapping("/emptycart")
	public String deleteCart(Cart cart,Model model) {
		boolean result=lightService.deleteCart(cart);
		if(result) {
			return "redirect:products.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "emptycart";
		}
	}
	@RequestMapping("/addcartnum")
	public String addCartNum(Integer id,Model model) {
		boolean result=lightService.addCartNum(id);
		if(result) {
			return "redirect:showCart.do";
		}else {
			model.addAttribute("errormsg","增加数量失败");
			return "products";
		}
	}
	@RequestMapping("/reducecartnum")
	//@RequestMapping(value="/redirect",method=RequestMethod.GET)
	public String reduceCartNum(Integer id,Model model,Integer uid) {
		boolean result=lightService.reduceCartNum(id);
		//attr.addAttribute("uid", uid); 
		if(result){
			return "redirect:showCart.do";
		}else {
			model.addAttribute("errormsg","数量减少失败");
			return "products";
		}
	}
	@RequestMapping("/sumcart")
	public String sumCart(Cart cart,Model model1,Model model2,HttpSession session) {
		//String id=(String)session.getAttribute("uid");
		Integer uid=(Integer)session.getAttribute("uid");
		Double sum=lightService.sumCart(cart,uid);
		List<Cart> list=lightService.selectCart(uid);
		model1.addAttribute("cartlist",list);
		model2.addAttribute("sum",sum);
		return "sumcart";
	}
	@RequestMapping("/showCart")
	public String showCart(Model model,HttpSession session){
		Integer uid=(Integer)session.getAttribute("uid");
		List<Cart> list=lightService.selectCart(uid);
		model.addAttribute("cartlist",list);
		return "checkouts";
	}
	
	@RequestMapping("/insertOrderDetail")
	public String insertOrderDetail(OrderDetail detail,Model model,HttpSession session) {
		int orderid=lightService.insertOrderDetail(detail);
		session.setAttribute("orderid", orderid);
		Integer uid=(Integer)session.getAttribute("uid");
		List<Cart> list=lightService.selectCart(uid);
		model.addAttribute("orderlist",list);
		List<OrderDetail> list1=lightService.showOrders(orderid);
		model.addAttribute("orderdetail",list1);
		return "showorder";
	}
	@RequestMapping("/insertOrderMsg")
	public String insertOrderMsg(Model model,HttpSession session) {
		Integer uid=(Integer)session.getAttribute("uid");
		Integer detailid=(Integer)session.getAttribute("orderid");
		boolean result=lightService.insertOrderMsg(uid,detailid);
		if(result) {
			return "redirect:products.do";
		}else {
			model.addAttribute("errormsg","增加数量失败");
			return "addcartnum";
		}
	}
	@RequestMapping("/cancelorder")
	public String cancelOrder(Model model,HttpSession session) {
		Integer id=(Integer)session.getAttribute("orderid");
		boolean result=lightService.cancelOrder(id);
		if(result) {
			return "redirect:products.do";
		}else {
			model.addAttribute("errormsg", "删除失败");
			return "cancelorder";
		}
	}
	@RequestMapping("/showorders")
	public String showOrder(OrderDetail orderdetail,Model model,HttpSession session) {
		Integer uid=(Integer)session.getAttribute("uid");
		System.out.println(uid);
		List<OrderDetail> detail=lightService.showOrder(uid);
		model.addAttribute("detailmsg",detail);
		return "usershoworder";
	}
	@RequestMapping("/usershowordermsg")
	public String userShowOrder(HttpServletRequest request,Order order,Model model,HttpSession session) {
		String id=(String)request.getParameter("detailid");
		Integer orderid=Integer.parseInt(id);
		System.out.println(orderid);
		List<Order> orderlist=lightService.userShowOrder(orderid);
		model.addAttribute("orderlist",orderlist);
		return "usershowordermsg";
	}
	@RequestMapping("/usershowproductbytype")
	public String showClockBytype(Model model,String typename) {
		List<Light> list=lightService.showProductBytype(typename);
		model.addAttribute("list",list);
		System.out.println(list.size());
		return "usershowproductbytype";
	}
	
}
