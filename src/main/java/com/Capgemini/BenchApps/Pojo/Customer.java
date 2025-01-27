package com.Capgemini.BenchApps.Pojo;

import java.util.HashMap;
import java.util.Map;

public class Customer {
	
	private String customerId;
	private String firstName;
    private String lastName;
    private Integer totalPoints;
    private Map<String, Integer> monthlyPoints = new HashMap<>();
    
	public Customer(String customerId, String firstName, String lastName, Integer totalPoints,
			Map<String, Integer> monthlyPoints) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalPoints = totalPoints;
		this.monthlyPoints = monthlyPoints;
	}
	
    
    
    
    
   
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(Integer totalPoints) {
		this.totalPoints = totalPoints;
	}
	public Map<String, Integer> getMonthlyPoints() {
		return monthlyPoints;
	}
	public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
		this.monthlyPoints = monthlyPoints;
	}
	
}
