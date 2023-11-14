package dev.aloysius.grocerystoreapplication.Service;

import dev.aloysius.grocerystoreapplication.Domains.CheckOut;
import dev.aloysius.grocerystoreapplication.Domains.PaymentResponse;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @EventListener
    public PaymentResponse handlePayment(CheckOut checkOut){

return  null;
    }

    public boolean makePayment(){
        return true;
    }
}
