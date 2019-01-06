package kr.astory.backend.dao;

import java.util.List;

import kr.astory.backend.dto.Cart;
import kr.astory.backend.dto.CartLine;
import kr.astory.backend.dto.OrderDetail;

public interface CartLineDAO {

	// the common methods from previously coded one
	public CartLine get(int id);
	public boolean add(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public List<CartLine> list(int cartId);
	
	// other business method related to the cart lines
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId, int productId);
	
	// udpate a cart
	boolean updateCart(Cart cart);
	boolean addOrderDetail(OrderDetail orderDetail);
	
}
