package com.example.demo.Admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@Autowired
	AdminRepository repo;
	@Autowired
	AdminDao dao;
	
	@RequestMapping("/login")
	
	public ModelAndView adminlogin(HttpServletRequest req,HttpServletResponse res)
	{
		ModelAndView mv = new ModelAndView();
		String auser=req.getParameter("auser");
		String apassword= req.getParameter("apassword");
		
		if(repo.findByuser(auser).equals(repo.findBypwd(apassword)))
		{
			HttpSession htp = req.getSession();
			htp.setAttribute("auser",auser);
			mv.setViewName("adminsuccess.jsp");
			
		}
		else
		{
			mv.setViewName("adminfailure.jsp");
		}
		return mv; 
	}
	
	@ResponseBody
	@RequestMapping("/password")
	public String changepassword(HttpServletRequest req,HttpServletResponse res)
	{
		Admin admin = new Admin();
		admin.setAuser(req.getParameter("auser"));
		admin.setApassword(req.getParameter("apassword"));
		Admin a1 = dao.updatepassword(admin);
		
		if(a1!=null)
		{
			return "Update Succesfull";
		}else
		{
			return "Update Failed";
		}
		
	}
	
	
}
