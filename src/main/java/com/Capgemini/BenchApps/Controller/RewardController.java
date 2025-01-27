package com.Capgemini.BenchApps.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Capgemini.BenchApps.Pojo.Customer;
import com.Capgemini.BenchApps.Pojo.Transaction;
import com.Capgemini.BenchApps.Service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	
	@Autowired
    private RewardService rewardService;

    @PostMapping("/transactions")
    public ResponseEntity<String> recordTransaction(@RequestBody Transaction transaction) {
        rewardService.processTransaction(transaction);
        return ResponseEntity.ok("Transaction recorded successfully.");
    }

    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId) {
        Customer customer = rewardService.getCustomer(customerId);
        return customer != null ? ResponseEntity.ok(customer) : ResponseEntity.notFound().build();
    }

    @GetMapping("/customers/{customerId}/months/{month}")
    public ResponseEntity<Map<String, Integer>> getMonthlyPoints(
            @PathVariable String customerId, @PathVariable String month) {
        Map<String, Integer> points = rewardService.getMonthlyPoints(customerId, month);
        return !points.isEmpty() ? ResponseEntity.ok(points) : ResponseEntity.notFound().build();
    }

}
