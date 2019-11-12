package com.ea.order.controller;

import com.ea.order.entity.Cart;
import com.ea.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public Cart addCart(@RequestBody Cart cart) throws Exception {
        return cartService.addToCart(cart);
    }

    @DeleteMapping("/{id}")
    public Cart deleteCart(@PathVariable("id") Long id, @RequestBody Cart cart) throws Exception {
        return cartService.removeCartItem(id);

    }

    @PatchMapping("/{id}")
    public Cart updateCart(@PathVariable("id") Long id, @RequestBody Cart cart) throws Exception {
        return cartService.updateQty(cart.getQuantity(), id);
    }

    @GetMapping("/{id}")
    public List<Cart> getByUserId(@PathVariable("id") Long userId) {
        return cartService.getCart(userId);
    }

    @GetMapping("/total/{id}")
    public Double getCartTotal(@PathVariable("id") Long userId) {
        return cartService.getCartTotal(userId);
    }
}
