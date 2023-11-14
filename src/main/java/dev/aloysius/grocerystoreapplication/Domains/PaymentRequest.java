package dev.aloysius.grocerystoreapplication.Domains;

import java.time.LocalDate;

public record PaymentRequest(String cardNo, LocalDate expiryDate, int cvv) {
}
