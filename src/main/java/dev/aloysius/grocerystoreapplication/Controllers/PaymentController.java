package dev.aloysius.grocerystoreapplication.Controllers;

import dev.aloysius.grocerystoreapplication.Domains.PaymentRequest;
import dev.aloysius.grocerystoreapplication.Domains.PaymentResponse;
import dev.aloysius.grocerystoreapplication.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private  final PaymentService paymentService;

    @PostMapping("/pay")
    public PaymentResponse makePayment(@RequestBody PaymentRequest paymentRequest){
        if(paymentService.makePayment(paymentRequest)){
            return new PaymentResponse(HttpStatusCode.valueOf(200), "Payment Successful");
        }
        return new PaymentResponse(HttpStatusCode.valueOf(400), "Payment Request Unsuccessful");
    }

}
