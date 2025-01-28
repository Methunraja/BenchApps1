Project: Reward System

This project implements a basic reward system for customers. Customers earn points for transactions they make. The number of points awarded depends on the transaction amount.

Project Structure:

The project is divided into two main packages:

com.Capgemini.BenchApps.Controller: This package contains the RewardController class which handles incoming HTTP requests and delegates them to the RewardService class for processing.
com.Capgemini.BenchApps.Service: This package contains the RewardService class which implements the business logic for calculating points, processing transactions, and retrieving customer information.

Implementation Details:

Customer Data: Customer data is stored in-memory using a static Map within the RewardService class. This is a simple approach for demonstration purposes. In a real-world application, you would likely use a database or another persistent storage mechanism.
Transaction Processing: The processTransaction method in the RewardService class calculates the points earned for a transaction based on the transaction amount. The logic is as follows:
Transactions exceeding $100 earn 2 points for every dollar above $100.
Transactions between $50 and $100 (inclusive) earn 1 point per dollar.
Transactions below $50 earn no points. The calculated points are added to the customer's total points and monthly points for the month of the transaction.

API Endpoints: The RewardController class exposes the following API endpoints:

/api/rewards/transactions: This endpoint accepts a POST request with a JSON representation of a transaction object in the request body. The controller calls the processTransaction method in the RewardService to record the transaction.

/api/rewards/customers/{customerId}: This endpoint accepts a GET request with a customer ID path variable. The controller calls the getCustomer method in the RewardService to retrieve the customer information.

/api/rewards/customers/{customerId}/months/{month}: This endpoint accepts a GET request with a customer ID and month path variables. The controller calls the getMonthlyPoints method in the RewardService to retrieve the customer's points for the specified month.
