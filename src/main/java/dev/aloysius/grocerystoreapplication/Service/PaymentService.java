package dev.aloysius.grocerystoreapplication.Service;

import dev.aloysius.grocerystoreapplication.Domains.CheckOut;
import dev.aloysius.grocerystoreapplication.Domains.PaymentRequest;
import dev.aloysius.grocerystoreapplication.Domains.PaymentResponse;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PaymentService {



    public boolean makePayment(PaymentRequest paymentRequest){
        return paymentRequest.expiryDate().isAfter(LocalDate.now()) && paymentRequest.cardNo() != null;
    }
}
