package kr.astory.front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.astory.backend.dao.CategoryDAO;
import kr.astory.backend.dao.ProductDAO;
import kr.astory.backend.dto.Category;
import kr.astory.backend.dto.Product;
import kr.astory.front.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value= {"/", "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		mv.addObject("title", "Astory Front");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		
		return mv;
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		
		return mv;
	}
	@RequestMapping(value="/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		
		return mv;
	}
	
	
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "All Products");
		
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts", true);
		
		return mv;
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		
		Category category = null;
		category = categoryDAO.get(id);
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", category.getName());
		
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts", true);
		
		return mv;
	}
	
	/**
	 * Viewing a single product
	 */
	
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//-----------------------------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		return mv;
	}
	
	
	/* having similar mapping to our flow id */
	@RequestMapping(value="/register")
	public ModelAndView register() {
		
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Register");
		
		return mv;
	}
	
	
	/* Login */
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {
		
		ModelAndView mv = new ModelAndView("login");
		
		if(error != null) {
			mv.addObject("message", "Invalid Username and Password!");
		}
		if(logout != null) {
			mv.addObject("message", "User has successfully logout!");
		}
		
		mv.addObject("title", "Login");
		return mv;
	}
	
	/* access denied page */
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		
		ModelAndView mv = new ModelAndView("error");
		
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You awre not authorized to view this page!");
		
		return mv;
	}
	
	/* Logout */
	@RequestMapping(value = "/perform-logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		// first we are going to fetch the authentication
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(auth!=null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		
		return "redirect:/login?logout";
	}
	
	
}
