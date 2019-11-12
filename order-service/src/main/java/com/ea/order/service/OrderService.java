package com.ea.order.service;

import com.ea.order.config.PaymentRouter;
import com.ea.order.entity.*;
import com.ea.order.repository.OrderItemRepository;
import com.ea.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartService cartService;

    @Autowired
    private RestTemplate template;

    @Autowired
    private PaymentRouter paymentRouter;

    //place an Order using the transaction id
    public Order placeAnOrder(Long tranId) throws Exception {
        String url = paymentRouter.url("transaction/paypal/" + tranId);
        PayPalTransaction payPalTransaction = template.getForObject(url, PayPalTransaction.class);

        if (payPalTransaction == null) {
            throw new Exception("Transaction not found!");
        }
        List<Cart> cart = cartService.getCart(payPalTransaction.getAccountId());
        Order order = new Order();
        order.setStatus(OrderStatus.Received);

        order.setAccountId(payPalTransaction.getAccountId());
        order.setAddressId(payPalTransaction.getShippingId());
        order.setShippingCost(10.0);
        order.setPaymentType("paypal");
        order.setSubTotal(cartService.getCartTotal(payPalTransaction.getAccountId()));
        order.setOrderTotal(order.getSubTotal() + order.getShippingCost());

        Order order1 = orderRepository.save(order);

        for (Cart cart1 : cart) {
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(cart1.getProductId());
            orderItem.setOrderId(order1.getId());
            orderItem.setPrice(cart1.getPrice());
            orderItem.setQuantity(cart1.getQuantity());
            orderItem.setRate(cart1.getRate());

            //save order item to database
            OrderItem orderItem1 = orderItemRepository.save(orderItem);
            //add order item to order object
            order1.getOrderItems().add(orderItem1);

            cartService.removeCartItem(cart1.getId());
        }

        return order1;
    }
}
