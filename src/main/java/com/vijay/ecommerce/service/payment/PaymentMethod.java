package com.vijay.ecommerce.service.payment;

public abstract class PaymentMethod {
    public abstract void processPayment(double amount);
}