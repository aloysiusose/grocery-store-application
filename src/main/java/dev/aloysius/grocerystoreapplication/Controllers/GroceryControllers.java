package dev.aloysius.grocerystoreapplication.Controllers;

import dev.aloysius.grocerystoreapplication.Domains.Products;
import dev.aloysius.grocerystoreapplication.Domains.ShoppingCart;
import dev.aloysius.grocerystoreapplication.Service.GroceryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class GroceryControllers {
    private final GroceryService groceryService;

    @PostMapping("/products/add")
    public void addProducts(@RequestBody Products products){

    }
    @GetMapping("/products/all")
    public List<Products> allProducts(){
        return groceryService.findAll();
    }

    @GetMapping("/products/all/")
    public List<Products> allProducts(@RequestParam String category){
        return groceryService.findByCategory(category);
    }
    @PostMapping("/products/cart/add/{quantity}")
    public ShoppingCart addToCart(@RequestBody Products products, @PathVariable int quantity){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();

        return groceryService.addToCart(products, quantity, name);
    }
    @GetMapping("/products/checkout")
    public String checkOut(ShoppingCart cart){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return groceryService.checkOut(cart, name);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception ex){
        return  ResponseEntity.badRequest().body(ex.getMessage());
    }





}
