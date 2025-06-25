class BankAccount {
    // 1) static
    static String bankName = "State Bank of Java";
    private static int totalAccounts = 0;

    // 3) final
    private final long accountNumber;
    private String accountHolderName;

    // 2) this
    BankAccount(String accountHolderName, long accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        totalAccounts++;
    }

    static int getTotalAccounts() {
        return totalAccounts;
    }

    void display() {
        // 4) instanceof
        if (this instanceof BankAccount) {
            System.out.printf("[%s] %s → #%d%n",
                    bankName, accountHolderName, accountNumber);
        }
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Alice", 1001L);
        BankAccount a2 = new BankAccount("Bob",   1002L);

        a1.display();
        a2.display();
        System.out.println("Total open accounts: " + BankAccount.getTotalAccounts());
    }
}
