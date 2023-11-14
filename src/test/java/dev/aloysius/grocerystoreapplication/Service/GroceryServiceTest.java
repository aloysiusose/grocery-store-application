package dev.aloysius.grocerystoreapplication.Service;

import dev.aloysius.grocerystoreapplication.Domains.CartItems;
import dev.aloysius.grocerystoreapplication.Domains.Customers;
import dev.aloysius.grocerystoreapplication.Domains.Products;
import dev.aloysius.grocerystoreapplication.Domains.ShoppingCart;
import dev.aloysius.grocerystoreapplication.Repository.CartItemsRepository;
import dev.aloysius.grocerystoreapplication.Repository.CustomersRepository;
import dev.aloysius.grocerystoreapplication.Repository.ProductsRepository;
import dev.aloysius.grocerystoreapplication.Repository.ShoppingCartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.support.PageableUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithMockUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class GroceryServiceTest {
    @Mock
    private CustomersRepository customersRepository;
    @Mock
    private CartItemsRepository cartItemsRepository;
    @Mock
    private ShoppingCartRepository shoppingCartRepository;
    @Mock
    private ProductsRepository productsRepository;
    @InjectMocks
    private GroceryService underTest;

    @Test
    void shouldFindAllProducts(){

        underTest.findAll();
        verify(productsRepository).findAll();

    }

    @Test
    void addToCart() {
        Products products = new Products();
        products.setPrice(BigDecimal.valueOf(15.6));
        products.setId(2L); products.setName("beer"); products.setInStock(true);


        CartItems cartItems = new CartItems();
        cartItems.setProducts(products);
        cartItems.setQuantity(3);
        cartItems.setSubAmount();

        Customers c1 = new Customers();
        c1.setId(1L); c1.setEmail("adf"); c1.setLastName("asdf"); c1.setFirstName("sdfv"); c1.setUsername("andrew");
        c1.setCustomerSince(LocalDate.now());


        Mockito.when(customersRepository.findByUsername(c1.getUsername())).thenReturn(Optional.of(c1));

        ShoppingCart sh = new ShoppingCart();
        sh.getCartItems().add(cartItems);
        sh.setCustomers(c1);

        Mockito.when(shoppingCartRepository.findByCustomersId(c1.getId())).thenReturn(Optional.of(sh));


        ShoppingCart shoppingCart = underTest.addToCart(products, 3, c1.getUsername());

        assertNotNull(underTest);
        verify(cartItemsRepository).save(any(CartItems.class));
        verify(shoppingCartRepository).save(sh);

        assertEquals(sh, shoppingCart);


    }
}