package com.company;
import java.util.ArrayList;

public class Customer {
  private final String name;
  private final ArrayList<Double> transactionArrayList = new ArrayList<>();

  public Customer(String name) { this.name = name; }
  public String getName() { return this.name; }

  public void addTransaction(double transactionValue) {
    if (transactionValue <= 0.0) System.out.println("Invalid Value");
    else this.transactionArrayList.add(transactionValue);
  }

  public void getTransactions() {
    if (transactionArrayList.size() == 0) System.out.println("\nNo transactions in the list\n");
    else {
      for (int i = 0; i < transactionArrayList.size(); i++) {
        Double transaction = transactionArrayList.get(i);
        System.out.println("\tTransaction " + (i + 1) + ": " + transaction);
      }
      System.out.println();
    }
  }

  @Override
  public String toString() { return getName() + " --> total " + transactionArrayList.size() + " transactions"; }
}
