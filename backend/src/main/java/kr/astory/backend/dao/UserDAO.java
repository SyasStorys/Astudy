package kr.astory.backend.dao;

import java.util.List;

import kr.astory.backend.dto.Address;
import kr.astory.backend.dto.Cart;
import kr.astory.backend.dto.User;

public interface UserDAO {

	// add an user
	boolean addUser(User user);
	User getByEmail(String email);

	boolean add(User user);
	
	//add an address
	boolean addAddress(Address address);
	// alternative
	//Address getBillingAddress(int userId);
	//List<Address> listShippingAddresses(int userId);
	
	
	//update a cart
	boolean updateCart(Cart cart);
	Address getBillingAddress(int id);
	List<Address> listShippingAddresses(int id);
	Address getAddress(int shippingId);
	
}

