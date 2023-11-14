package dev.aloysius.grocerystoreapplication.Service;

import dev.aloysius.grocerystoreapplication.Domains.*;
import dev.aloysius.grocerystoreapplication.Repository.CartItemsRepository;
import dev.aloysius.grocerystoreapplication.Repository.CustomersRepository;
import dev.aloysius.grocerystoreapplication.Repository.ProductsRepository;
import dev.aloysius.grocerystoreapplication.Repository.ShoppingCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroceryService {
    private final ProductsRepository productsRepository;
    private final CustomersRepository customersRepository;
    private final CartItemsRepository cartItemsRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ApplicationEventPublisher eventPublisher;

    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    public List<Products> findByCategory(String category) {
        return productsRepository.findByProductCategory(category, PageRequest.ofSize(10));
    }

    public ShoppingCart addToCart(Products products, int quantity, String name) {

        CartItems cartItems = new CartItems();
        cartItems.setProducts(products);
        cartItems.setQuantity(quantity);
        cartItems.setSubAmount();
        cartItemsRepository.save(cartItems);


        Customers customers = customersRepository.findByUsername(name).orElseThrow();


        if (shoppingCartRepository.findByCustomersId(customers.getId()).isEmpty()) {
            ShoppingCart shoppingCart = new ShoppingCart();
            shoppingCart.setId(customers.getId());
            shoppingCartRepository.save(shoppingCart);
        }

        ShoppingCart shoppingCart = shoppingCartRepository.findByCustomersId(customers.getId()).get();
        shoppingCart.getCartItems().add(cartItems);
        shoppingCartRepository.save(shoppingCart);

    return shoppingCart;

    }

    public String checkOut(ShoppingCart cart, String name) {
        // pull out the shopping cart from the db, take the amount and forward to the payment gateway/service
        Customers customer = customersRepository.findByUsername(name).orElseThrow(()-> new UsernameNotFoundException("Please log in"));
        ShoppingCart cart1 = shoppingCartRepository.findByCustomersId(customer.getId()).orElseThrow();

        BigDecimal totalAmount = cart1.getTotalAmount();

        eventPublisher.publishEvent(new CheckOut(name, cart1.getTotalAmount()));
        // if payment is successful, create an order by converting shopping cart to order, then delete shopping cart
        List<CartItems> listOfOrderItems = new ArrayList<>(cart.getCartItems());

        Orders orders = new Orders();
        orders.setTotalAmount(cart.getTotalAmount());
        orders.setItemsList(listOfOrderItems);

        //shoppingCartRepository.delete();


        /*
        a placeholder for payment gateway implementation
         */

        return "order successful";
    }
     /*
    check out takes the price from the shopping cart and send to the payment system. if successful, an order is created a
    and a response is sent back
     */
}
