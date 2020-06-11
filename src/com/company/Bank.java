package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
  private final ArrayList<Branch> branchArrayList = new ArrayList<>();

  public void launchBank() {
    System.out.println("Welcome to the banking application!");
    System.out.println("-----------------------------------");
    Scanner in = new Scanner(System.in);
    boolean isLaunched = true;
    while (isLaunched) {
      System.out.println(
        "1. Add a new branch\n2. List all branches\n3. List all customers\n4. Add a new customer\n0. Exit"
      );

      System.out.print("Please make choice: ");
      int choice = in.nextInt();
      switch (choice) {
        case 1 -> { addBranch(); }
        case 2 -> { getBranches(); }
        case 3 -> { getCustomers(); }
        case 4 -> { addCustomer(); }
        case 0 -> {
          System.out.println("Thank you for using banking application");
          isLaunched = false;
        }
      }
    }
  }

  public void addCustomer() {
    Scanner in = new Scanner(System.in);
    System.out.print("\nEnter branch name: ");
    String branchName = in.nextLine();
    boolean branchExists = checkIfBranchExists(branchName);
    if (branchExists) {
      int branchIndex = -1;
      for (int i = 0; i < branchArrayList.size(); i++)
        if (branchArrayList.get(i).getName().matches(branchName)) {
          branchIndex = i;
          break;
        }
      branchArrayList.get(branchIndex).addCustomer();
    } else System.out.println("\nBranch not found...\n");
  }

  public void getBranches() {
    if (branchArrayList.size() == 0) System.out.println("\nNo branches in the list\n");
    else {
      System.out.println();
      for (Branch branch : branchArrayList) System.out.println(branch);
      System.out.println();
    }
  }

  public void addBranch() {
    System.out.print("\nEnter a branch name: ");
    Scanner in = new Scanner(System.in);
    String branchName = in.nextLine();
    if (branchName.length() == 0) System.out.println("Branch name must be provided");
    Branch newBranch = new Branch(branchName);
    branchArrayList.add(newBranch);
    System.out.println("Branch " + branchName + " added successfully\n");
  }

  public void getCustomers() {
    Scanner in = new Scanner(System.in);
    System.out.print("\nPlease enter branch name: ");
    String branchName = in.nextLine();
    boolean branchExists = checkIfBranchExists(branchName);

    if (branchExists) {
      System.out.println("1. Show A list of customers\n2. Show a list of customers and transaction list\n0. Exit");
      System.out.print("Enter your choice: ");
      int choice = in.nextInt();

      int branchIndex = -1;
      for (int i = 0; i < branchArrayList.size(); i++)
        if (branchArrayList.get(i).getName().matches(branchName)) {
          branchIndex = i;
          break;
        }

      Branch selectedBranch = branchArrayList.get(branchIndex);
      switch (choice) {
        case 1 -> { selectedBranch.getCustomers(); }
        case 2 -> { selectedBranch.getCustomers(true); }
        case 0 -> { System.out.println("Cancel function"); }
        default -> { System.out.println("Invalid choice..."); }
      }
    } else System.out.println("\nBranch not found...\n");
  }

  // Helpers
  public boolean checkIfBranchExists(String branchName) {
    for (Branch branch : branchArrayList)
      if (branch.getName().matches(branchName))
        return true;
    return false;
  }
}
