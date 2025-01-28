package com.Capgemini.BenchApps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.Capgemini.BenchApps.Pojo.Customer;
import com.Capgemini.BenchApps.Pojo.Transaction;
import com.Capgemini.BenchApps.Service.RewardService;

@SpringBootTest
class BenchAppsApplicationTests {
	
	@InjectMocks
    private RewardService rewardService;
	
	@Mock
    private Customer mockCustomer;

	@BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); 
    }
    
    
    @Test
    public void testCalculatePoints_AmountAbove100() {
        Transaction transaction = new Transaction("customer1", BigDecimal.valueOf(150));
        int points = rewardService.calculatePoints(transaction);
        assertEquals(100, points);
    }

    @Test
    public void testCalculatePoints_AmountBetween50And100() {
        Transaction transaction = new Transaction("customer1", BigDecimal.valueOf(75));
        int points = rewardService.calculatePoints(transaction);
        assertEquals(75, points);
    }

    @Test
    public void testCalculatePoints_AmountBelow50() {
        Transaction transaction = new Transaction("customer1", BigDecimal.valueOf(25));
        int points = rewardService.calculatePoints(transaction);
        assertEquals(0, points);
    }

    
    @Test
    public void testGetMonthlyPoints_ExistingCustomerMonth() {
        when(mockCustomer.getMonthlyPoints()).thenReturn(new HashMap<String, Integer>() {{ put("Jan", 25); }});
        Map<String, Integer> points = rewardService.getMonthlyPoints("customer1", "Jan");
        assertEquals(1, points.size());
        assertEquals(25, points.get("Jan").intValue());
    }

    @Test
    public void testGetMonthlyPoints_NonExistingCustomerMonth() {
        when(mockCustomer.getMonthlyPoints()).thenReturn(new HashMap<>());
        Map<String, Integer> points = rewardService.getMonthlyPoints("customer1", "Feb");
        assertEquals(0, points.size());
    }


	@Test
	void contextLoads() {
	}

}
