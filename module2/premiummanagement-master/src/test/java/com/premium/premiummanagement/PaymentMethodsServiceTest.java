package com.premium.premiummanagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.premium.premiummanagement.entity.PaymentMethods;
import com.premium.premiummanagement.repository.PaymentMethodsRepository;
import com.premium.premiummanagement.service.PaymentMethodsService;

@SpringBootTest
public class PaymentMethodsServiceTest {

    @Mock
    private PaymentMethodsRepository paymentMethodsRepository;

    @InjectMocks
    private PaymentMethodsService paymentMethodsService;

    @Test
    public void testGetPaymentMethods() {
        PaymentMethods payment1 = new PaymentMethods();
        payment1.setId(1);
        payment1.setPaymentMethod("UPI");

        PaymentMethods payment2 = new PaymentMethods();
        payment2.setId(2);
        payment2.setPaymentMethod("CASH");
        
        PaymentMethods payment3 = new PaymentMethods();
        payment3.setId(3);
        payment3.setPaymentMethod("BANK");

        List<PaymentMethods> expectedPayments = Arrays.asList(payment1, payment2,payment3);

        when(paymentMethodsRepository.findAll()).thenReturn(expectedPayments);
        //when this method is called, we want to define a specific behavior for it.

        List<PaymentMethods> actualPayments = paymentMethodsService.getPaymentMethods();

        assertEquals(expectedPayments, actualPayments);
    }
}