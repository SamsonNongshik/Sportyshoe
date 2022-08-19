package com.example.demo.Product;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShoeController {
	@Autowired
	ShoeDao dao;
	
	@RequestMapping("/add")
	public ModelAndView addproduct(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv= new ModelAndView();
		Shoes s = new Shoes();
		s.setScat(req.getParameter("scat"));
		s.setSbrand(req.getParameter("sbrand"));
		s.setSprice(Integer.parseInt(req.getParameter("sprice")));
		s.setSdesc(req.getParameter("sdesc"));
		s.setSquqntity(Integer.parseInt(req.getParameter("squantity")));
		
		Shoes s1=dao.insert(s);
		
		if(s1!=null)
		{
			mv.setViewName("adminsuccess.jsp");
			
		}
		return mv;
		}
	
	@RequestMapping("/getall")
	public ModelAndView getproduct(HttpServletRequest req, HttpServletResponse res)
	{
		ModelAndView mv= new ModelAndView();
		List<Shoes> ls = dao.getall();
		mv.addObject("list", ls);
		mv.setViewName("listproduct.jsp");
		return mv;
				
	}
	@ResponseBody
	@RequestMapping("/update")
	public String update(HttpServletRequest req,HttpServletResponse res)
	{
		Shoes s = new Shoes();
		s.setSid(Integer.parseInt(req.getParameter("sid")));
		s.setScat(req.getParameter("scat"));
		s.setSbrand(req.getParameter("sbrand"));
		s.setSprice(Integer.parseInt(req.getParameter("sprice")));
		s.setSdesc(req.getParameter("sdesc"));
		s.setSquqntity(Integer.parseInt(req.getParameter("squantity")));
		
		Shoes s1 = dao.update(s);
		if(s1!=null)
		{
			return "Update Successful";
		}else
		{
			return "Update Fail";
		}
	}
	@ResponseBody
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req,HttpServletResponse res)
	{
		Shoes s = new Shoes();
		int sid=Integer.parseInt(req.getParameter("sid"));
		dao.delete(sid);
		
		return "Deleted succesfully";
			
		}
	}

