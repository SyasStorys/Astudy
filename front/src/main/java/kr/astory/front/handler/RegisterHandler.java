package kr.astory.front.handler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import kr.astory.backend.dao.UserDAO;
import kr.astory.backend.dto.Address;
import kr.astory.backend.dto.Cart;
import kr.astory.backend.dto.User;
import kr.astory.front.model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel, User user) {
		registerModel.setUser(user);
	}
	
	
	public void addBilling(RegisterModel registerModel, Address billing) {
		registerModel.setBilling(billing);
	}
	
	
	public String validateUser(User user, MessageContext error) {
	  String transitionValue = "success";
	   if(!user.getPassword().equals(user.getConfirmPassword())) {
		   
		   error.addMessage(new MessageBuilder()
				   .error()
				   .source("confirmPassword")
				   .defaultText("Password does not match confirm password!").build());
	    transitionValue = "failure";    
	   }  
	   if(userDAO.getByEmail(user.getEmail())!=null) {
	    error.addMessage(new MessageBuilder()
	    		.error()
	    		.source("email").defaultText("Email address is already taken!")
	    		.build());
	    transitionValue = "failure";
	   }
	  return transitionValue;
	 }
	
	public String saveAll(RegisterModel registerModel) {
		String transitionValue = "success";
		
		// fetch the user
		User user = registerModel.getUser();
		
		if(user.getRole().equals("USER")) {
			
			Cart cart = new Cart();
			
			cart.setUser(user);
			user.setCart(cart);
		}
		
      // encode the password
	  user.setPassword(passwordEncoder.encode(user.getPassword()));
		
	  // save the user
	  userDAO.add(user);
	  // save the billing address
	  Address billing = registerModel.getBilling();
	  billing.setUserId(user.getId());
	  billing.setBilling(true);  
	  userDAO.addAddress(billing);
	  
	  return transitionValue ;
	 } 
}


