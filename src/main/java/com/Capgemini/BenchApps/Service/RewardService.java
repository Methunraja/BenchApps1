package com.Capgemini.BenchApps.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Capgemini.BenchApps.Pojo.Customer;
import com.Capgemini.BenchApps.Pojo.Transaction;

@Service
public class RewardService {
	
	private static final Map<String, Customer> customers = new HashMap<>();

    static {
        
        customers.put("Manoj", new Customer("Manoj", "Manojkumar", "Doshi", 0, new HashMap<>()));
        customers.put("Hari", new Customer("Hari", "Janumoye", "Omkar", 0, new HashMap<>()));
    }
    
    public int calculatePoints(Transaction transaction) {
        BigDecimal amount = transaction.getAmount();
        int points = 0;

        if (amount.compareTo(BigDecimal.valueOf(100)) > 0) {
            points += (amount.subtract(BigDecimal.valueOf(100))).intValue() * 2;
        }

        if (amount.compareTo(BigDecimal.valueOf(50)) >= 0 && 
                amount.compareTo(BigDecimal.valueOf(100)) <= 0) {
            points += amount.intValue();
        }

        return points;
    }

    public void processTransaction(Transaction transaction) {
        int points = calculatePoints(transaction);

        Customer customer = customers.getOrDefault(transaction.getCustomerId(), 
                new Customer(transaction.getCustomerId(), null, null, 0, new HashMap<>()));

        customer.setTotalPoints(customer.getTotalPoints() + points);

        String month = transaction.getTransactionDate().getMonth().toString();
        customer.getMonthlyPoints().put(month, 
                customer.getMonthlyPoints().getOrDefault(month, 0) + points);

        customers.put(transaction.getCustomerId(), customer);
    }

    public Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public Map<String, Integer> getMonthlyPoints(String customerId, String month) {
        Customer customer = customers.get(customerId);
        return customer != null ? Map.of(month, customer.getMonthlyPoints().getOrDefault(month, 0)) 
                                : Map.of(); 
    }

}
