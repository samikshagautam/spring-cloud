package com.ea.order.service;

import com.ea.order.config.ProductRouter;
import com.ea.order.entity.Cart;
import com.ea.order.entity.Product;
import com.ea.order.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRouter productRouter;

    @Autowired
    private RestTemplate restTemplate;

    public Cart addToCart(Cart cart) throws Exception {

        String url = productRouter.url("products/" + cart.getProductId());
        Product product = restTemplate.getForObject(url, Product.class);

        if (product == null) {
            throw new Exception("Product does not exist!");
        }

        cart.setRate(product.getPrice());
        cart.setPrice(product.getPrice() * cart.getQuantity());

        return cartRepository.save(cart);

    }

    public Cart removeCartItem(Long cartId) throws Exception {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            throw new Exception("Cart item not found");
        }
        cartRepository.delete(cart);
        return cart;
    }

    //update cart item
    public Cart updateQty(int qty, Long cartId) throws Exception {
        Cart cart = cartRepository.findById(cartId).get();
        if (cart == null) {
            throw new Exception("Cart item not found!");
        }

        cart.setQuantity(qty);
        cart.setPrice(cart.getRate() * cart.getQuantity());
        return cartRepository.save(cart);
    }

    public List<Cart> getCart(Long userId) {
        return cartRepository.findByAccountId(userId);
    }

    //calculate cart total
    public double getCartTotal(Long userId) {
        List<Cart> carts = getCart(userId);
        double total = 0;
        for (Cart cart : carts) {
            total += cart.getPrice();
        }
        return total;
    }

}
