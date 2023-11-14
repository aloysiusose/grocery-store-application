package dev.aloysius.grocerystoreapplication.Domains;

import java.math.BigDecimal;

public record CheckOut(String email, BigDecimal price) {
}
