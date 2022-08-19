package com.example.demo.User;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.parser.Part.IgnoreCaseType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Product.ShoeDao;
import com.example.demo.Product.Shoes;
import com.example.demo.Product.shoeRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository repo;
	@Autowired
	UserDao dao;
	@Autowired
	ShoeDao sdao;
	@ResponseBody
	@RequestMapping("/userregister")
	public String userRegister(HttpServletRequest req,HttpServletResponse res)
	{
		User u = new User();
		u.setUname((req.getParameter("uname")));
		u.setUpassword(req.getParameter("upassword"));
		u.setUemail(req.getParameter("uemail"));
		User u1 = dao.adduser(u);
		
		if(u1!=null)
		{
			return "Registration Succesfull";
		}else
		{
			return "Registration Failed";
		}
	}
	
	@RequestMapping("/userlogin")
	public ModelAndView userLogin(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv= new ModelAndView();
		String uname=req.getParameter("uname");
		String upassword= req.getParameter("upassword");
		if(repo.findByUser(uname).equals(repo.findbyPwd(upassword))) {
			mv.setViewName("userpage.jsp");
		}else
		{
		mv.setViewName("userfail.jsp");	
		}
		return mv;
	}
	
	@RequestMapping("/userlist")
	public ModelAndView userlist(HttpServletResponse res,HttpServletRequest req)
	{
		ModelAndView mv=new ModelAndView();
		List<User> ls= dao.alluser();
		mv.addObject("ls", ls);
		mv.setViewName("alluser.jsp");
		return mv;
	}
	
	@RequestMapping("/userproductlist")
	public ModelAndView UserproductList(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		List<Shoes> ls = sdao.getall();
		mv.addObject("list", ls);
		mv.setViewName("userproductlist.jsp");
		return mv;
		
	}
	@RequestMapping("/search")
	public ModelAndView searchproduct(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		Shoes s1= new Shoes();
		
		String s= req.getParameter("ssearch");
		
if(s.equals(s)) {
		List<Shoes> ls1=  sdao.getBybrand(s);
     	mv.addObject("list1", ls1);
			mv.setViewName("shoebrand.jsp");
}else
{
	

				List<Shoes> l2= (List<Shoes>) sdao.getByCategory(s);
				
					mv.addObject("list2", l2);
					mv.setViewName("shoecategory.jsp");
				}


		return mv;
	}

	
	
}
	

