package com.premium.premiummanagement;

import com.premium.premiummanagement.entity.PremiumsMaster;
import com.premium.premiummanagement.repository.PremiumMasterRepository;
import com.premium.premiummanagement.service.PremiumMasterService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PremiumMasterServiceTest {

    @Mock  //helps in creating mock objects for isolated testing
    private PremiumMasterRepository premiumMasterRepository;

    private PremiumMasterService premiumMasterService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        premiumMasterService = new PremiumMasterService(premiumMasterRepository);
    }

    @Test
    public void testGetListSubscriptionId_ExistingSubscriptionId() {
        int subscriptionId = 123;
        PremiumsMaster premium = new PremiumsMaster();
        premium.setSubscriptionId(subscriptionId);

        List<PremiumsMaster> premiumList = new ArrayList<>();
        premiumList.add(premium);

        when(premiumMasterRepository.findAll()).thenReturn(premiumList);
        PremiumsMaster result = premiumMasterService.getListSubscriptionId(subscriptionId);
        assertEquals(premium, result);
    }

    @Test
    public void testGetListSubscriptionId_NonExistingSubscriptionId() {
        int subscriptionId = 456;

        List<PremiumsMaster> premiumList = new ArrayList<>();

        when(premiumMasterRepository.findAll()).thenReturn(premiumList);
        PremiumsMaster result = premiumMasterService.getListSubscriptionId(subscriptionId);
        assertEquals(null, result);
    }

    @Test
    public void testGetListUsername_ExistingUsername() {
        // Arrange
        String username = "john";
        PremiumsMaster premium = new PremiumsMaster();
        premium.setUsername(username);

        List<PremiumsMaster> premiumList = new ArrayList<>();
        premiumList.add(premium);
        when(premiumMasterRepository.findAll()).thenReturn(premiumList);
        PremiumsMaster result = premiumMasterService.getListUsername(username);
        assertEquals(premium, result);
    }

    @Test
    public void testGetListUsername_NonExistingUsername() {
        String username = "jane";
        List<PremiumsMaster> premiumList = new ArrayList<>();
        when(premiumMasterRepository.findAll()).thenReturn(premiumList);
        PremiumsMaster result = premiumMasterService.getListUsername(username);
        assertEquals(null, result);
    }

    @Test
    public void testGetPaymentsBefore9thDate() {
        LocalDate ninthDate = LocalDate.now().withDayOfMonth(9);
        List<PremiumsMaster> expectedList = new ArrayList<>();
        PremiumsMaster premium1 = new PremiumsMaster();
        PremiumsMaster premium2 = new PremiumsMaster();
        expectedList.add(premium1);
        expectedList.add(premium2);

        when(premiumMasterRepository.findByLastPaymentDateDayLessThan(ninthDate)).thenReturn(expectedList);
        List<PremiumsMaster> resultList = premiumMasterService.getPaymentsBefore9thDate();
        assertEquals(expectedList, resultList);
    }
}
