package dev.aloysius.grocerystoreapplication.Controllers;

import dev.aloysius.grocerystoreapplication.Domains.Products;
import dev.aloysius.grocerystoreapplication.Domains.ShoppingCart;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class GroceryControllers {

    @PostMapping("/products/add")
    public void addProducts(@RequestBody Products products){

    }
    @GetMapping("/products/all")
    public List<Products> allProducts(){
        return null;
    }

    @GetMapping("/products/all/")
    public List<Products> allProducts(@RequestParam String category){
        return null;
    }

    public ShoppingCart addToCart(@RequestBody Products products, @PathVariable int quantity){
        //this should for a cart item in the shopping cart
        return null;
    }
    @GetMapping("/products/checkout")
    public String checkOut(){
        return null;
    }

    /*
    check out takes the price from the shopping cart and send to the payment system. if successful, an order is created a
    and a response is sent back
     */



}
