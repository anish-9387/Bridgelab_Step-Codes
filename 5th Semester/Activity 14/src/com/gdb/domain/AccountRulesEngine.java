package com.gdb.domain;

public class AccountRulesEngine {

    private static AccountRulesPropertiesLoader savingsLoader =
        new AccountRulesPropertiesLoader(
            "src/main/resources/config/rules/savings.properties"
        );

    // Determine savings bucket based on account tenure.
    public static String getSavingsBucket(int tenureYears) {

        if (tenureYears >= 5) {
            return "privilege";
        }

        if (tenureYears >= 3) {
            return "premium";
        }

        if (tenureYears >= 1) {
            return "standard";
        }

        return "new";
    }

    // Get minimum balance from external properties.
    public static double getSavingsMinBalance(int tenureYears) {

        String bucket = getSavingsBucket(tenureYears);

        String key = "min.balance." + bucket;

        return savingsLoader.getDouble(key, 10000.0);
    }

    // Get interest rate from external properties.
    public static double getSavingsInterestRate(int tenureYears) {

        String bucket = getSavingsBucket(tenureYears);

        String key = "interest.rate." + bucket;

        return savingsLoader.getDouble(key, 2.70);
    }

    // Current account overdraft rule.
    public static double getCurrentOverdraftLimit(
            double monthlyTurnover) {

        return Math.max(
            25000.0,
            monthlyTurnover * 2.5
        );
    }

    // Fixed deposit interest rule.
    public static double getFDInterestRate(int months) {

        if (months >= 36) {
            return 7.50;
        }

        if (months >= 12) {
            return 6.50;
        }

        return 5.00;
    }
}