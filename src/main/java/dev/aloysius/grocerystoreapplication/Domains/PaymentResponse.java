package dev.aloysius.grocerystoreapplication.Domains;

import org.springframework.http.HttpStatusCode;

public record PaymentResponse(HttpStatusCode statusCode, String msg) {
}
