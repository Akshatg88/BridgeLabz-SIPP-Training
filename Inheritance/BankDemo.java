// BankAccount.java
public class BankAccount {
    protected long accountNumber;
    protected double balance;

    public BankAccount(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}

// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(long acc, double bal, double interestRate) {
        super(acc, bal);
        this.interestRate = interestRate;
    }

    public void displayAccountType() {
        System.out.printf("Savings Account ‑ %.2f%% interest%n", interestRate);
    }
}

// CheckingAccount.java
public class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(long acc, double bal, double limit) {
        super(acc, bal);
        this.withdrawalLimit = limit;
    }

    public void displayAccountType() {
        System.out.printf("Checking Account ‑ limit ₹%.2f per day%n",
                          withdrawalLimit);
    }
}

// FixedDepositAccount.java
public class FixedDepositAccount extends BankAccount {
    private int termMonths;

    public FixedDepositAccount(long acc, double bal, int termMonths) {
        super(acc, bal);
        this.termMonths = termMonths;
    }

    public void displayAccountType() {
        System.out.printf("Fixed Deposit ‑ %d‑month term%n", termMonths);
    }
}

// BankDemo.java
public class BankDemo {
    public static void main(String[] args) {
        BankAccount[] accts = {
            new SavingsAccount(1001, 50000, 3.5),
            new CheckingAccount(1002, 40000, 25000),
            new FixedDepositAccount(1003, 100000, 36)
        };

        for (BankAccount b : accts) {
            if (b instanceof SavingsAccount s)  s.displayAccountType();
            if (b instanceof CheckingAccount c) c.displayAccountType();
            if (b instanceof FixedDepositAccount f) f.displayAccountType();
        }
    }
}
