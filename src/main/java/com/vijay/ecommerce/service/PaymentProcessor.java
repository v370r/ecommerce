package com.vijay.ecommerce.service;

import com.vijay.ecommerce.service.payment.CreditCardPayment;
import com.vijay.ecommerce.service.payment.PayPalPayment;
import com.vijay.ecommerce.service.payment.PaymentMethod;

public class PaymentProcessor {
    public void processPayments() {
        PaymentMethod creditCardPayment = new CreditCardPayment();
        creditCardPayment.processPayment(100.0);

        PaymentMethod payPalPayment = new PayPalPayment();
        payPalPayment.processPayment(200.0);
    }
}