package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Branch {
  private final String name;
  private final ArrayList<Customer> customerArrayList = new ArrayList<>();

  public Branch(String name) { this.name = name; }

  public String getName() { return this.name; }

  public void addCustomer() {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter customer's name: ");
    String customerName = in.nextLine();

    if (customerName.length() == 0) {
      System.out.println("Customer's name must be provided");
      return;
    }
    Customer newCustomer = new Customer(customerName);

    System.out.print("How many transactions for " + customerName + ": ");
    int nTransactions = in.nextInt();
    for (int i = 0; i < nTransactions; i++) {
      System.out.print("Transaction " + (i + 1) + ": ");
      double transaction = in.nextDouble();
      newCustomer.addTransaction(transaction);
    }

    customerArrayList.add(newCustomer);
    System.out.println("Customer " + customerName + " added successfully");
    System.out.println();
  }

  public void getCustomers() {
    if (customerArrayList.size() == 0) System.out.println("\nNo customers in the list\n");
    else {
      System.out.println();
      for (Customer customer : customerArrayList) System.out.println(customer);
      System.out.println();
    }
  }

  public void getCustomers(boolean withTransactions) {
    if (customerArrayList.size() == 0) System.out.println("\nNo customers in the list\n");
    else {
      System.out.println();
      for (Customer customer : customerArrayList) {
        System.out.println(customer);
        customer.getTransactions();
      }
      System.out.println();
    }
  }

  @Override
  public String toString() {
    return "Branch " + getName() + " --> " + customerArrayList.size() + " customers ";
  }
}
