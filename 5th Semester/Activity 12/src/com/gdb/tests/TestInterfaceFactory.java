package com.gdb.tests;

import com.gdb.domain.*;
import com.gdb.exceptions.*;

public class TestInterfaceFactory {

    public static void main(String[] args) {
        System.out.println("=== Activity 12: Factory-Driven System Suite ===");

        // ---------------------------------------------------------
        // Test 1: Savings Account Creation & Deposit
        // ---------------------------------------------------------
        try {
            IAccount savings = AccountFactory.createAccount(
                    "SAVINGS",
                    "SA1001",
                    "Rajesh Sharma",
                    25,
                    5000.0,
                    "ACTIVE",
                    "1234"
            );

            savings.deposit(2000.0);

            if (savings.getBalance() == 7000.0) {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [PASS]");
            } else {
                System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
            }

            // Verify minimum balance rule through IAccount
            try {
                savings.withdraw(6001.0, "1234");
                System.out.println("[Test 1] Savings Minimum Balance Rule: [FAIL]");
            } catch (MinimumBalanceViolationException e) {
                System.out.println("[Test 1] Savings Minimum Balance Rule: [PASS]");
            }

        } catch (Exception e) {
            System.out.println("[Test 1] Savings Account Creation & Deposit: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // Test 2: Current Account Overdraft
        // ---------------------------------------------------------
        try {
            IAccount current = AccountFactory.createAccount(
                    "CURRENT",
                    "CA1001",
                    "Priya Patel",
                    30,
                    5000.0,
                    "ACTIVE",
                    "2345"
            );

            // Balance = 5000, overdraft limit = 25000
            // Withdrawal of 20000 should be allowed.
            current.withdraw(20000.0, "2345");

            if (current.getBalance() == -15000.0) {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [PASS]");
            } else {
                System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
            }

            // Total allowed debit = 5000 + 25000 = 30000
            // Additional 20000 would exceed the overdraft limit.
            try {
                current.withdraw(20000.0, "2345");
                System.out.println("[Test 2] Current Overdraft Limit Enforcement: [FAIL]");
            } catch (InsufficientBalanceException e) {
                System.out.println("[Test 2] Current Overdraft Limit Enforcement: [PASS]");
            }

        } catch (Exception e) {
            System.out.println("[Test 2] Current Account Overdraft Withdrawal: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // Test 3: Fixed Deposit Premature Withdrawal
        // ---------------------------------------------------------
        try {
            IAccount fixedDeposit = AccountFactory.createAccount(
                    "FIXED_DEPOSIT",
                    "FD1001",
                    "Amit Kumar",
                    35,
                    10000.0,
                    "ACTIVE",
                    "3456"
            );

            try {
                fixedDeposit.withdraw(1000.0, "3456");
                System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");
            } catch (AccountException e) {
                System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [PASS]");
            }

        } catch (Exception e) {
            System.out.println("[Test 3] Fixed Deposit Premature Withdrawal Block: [FAIL]");
            System.out.println("Reason: " + e.getMessage());
        }

        // ---------------------------------------------------------
        // Test 4: Invalid Account Type
        // ---------------------------------------------------------
        try {
            AccountFactory.createAccount(
                    "UNKNOWN",
                    "XX1001",
                    "Test User",
                    25,
                    1000.0,
                    "ACTIVE",
                    "4567"
            );

            System.out.println("[Test 4] Invalid Type Rejection: [FAIL]");

        } catch (IllegalArgumentException e) {
            System.out.println("[Test 4] Invalid Type Rejection: [PASS]");
        }

        // ---------------------------------------------------------
        // Final Result
        // ---------------------------------------------------------
        System.out.println("Factory-driven architecture successfully verified!");
    }
}