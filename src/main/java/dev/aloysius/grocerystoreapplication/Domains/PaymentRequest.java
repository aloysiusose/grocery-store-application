package dev.aloysius.grocerystoreapplication.Domains;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentRequest(BigDecimal amountDue, String cardNo, LocalDate expiryDate, int cvv) {
}
