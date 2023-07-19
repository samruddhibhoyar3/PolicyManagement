package com.premium.premiummanagement;

import com.premium.premiummanagement.entity.PremiumPayments;
import com.premium.premiummanagement.repository.PremiumPaymentsRepository;
import com.premium.premiummanagement.service.PremiumPaymentsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PremiumPaymentsServiceTest {

    @Mock
    private PremiumPaymentsRepository premiumPaymentsRepository;

    private PremiumPaymentsService premiumPaymentsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        premiumPaymentsService = new PremiumPaymentsService();
    }

    @Test
    public void testCalculateLateFee() {
        // Arrange
        PremiumPayments premiumPayments = new PremiumPayments();
        premiumPayments.setPaymentDate(LocalDate.of(2023, 6, 10));
        premiumPayments.setPremiumAmount(1000);

        // Act
        float lateFee = premiumPaymentsService.calculateLateFee(premiumPayments);

        // Assert
        assertEquals(1.25, lateFee);
    }
    
    @Test
    public void testCalculateLateFeeWithLateDays() {
        // Arrange
        PremiumPayments premiumPayments = new PremiumPayments();
        premiumPayments.setPaymentDate(LocalDate.of(2023, 6, 5));
        premiumPayments.setPremiumAmount(1000);

        // Act
        float lateFee = premiumPaymentsService.calculateLateFee(premiumPayments);

        // Assert
        assertEquals(0, lateFee);
    }
    
    @Test
    public void testCalculateLateFeeWithZeroPremiumAmount() {
        // Arrange
        PremiumPayments premiumPayments = new PremiumPayments();
        premiumPayments.setPaymentDate(LocalDate.of(2023, 6, 10));
        premiumPayments.setPremiumAmount(2000);

        // Act
        float lateFee = premiumPaymentsService.calculateLateFee(premiumPayments);

        // Assert
        assertEquals(2.5, lateFee);
    }

    // Add more test cases as needed for other scenarios
}

