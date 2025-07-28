public class BankMain {
    public static void main(String[] args) {
        BankSystem bank = new BankSystem();

        bank.addAccount("ACC101", 5000);
        bank.addAccount("ACC102", 2000);
        bank.addAccount("ACC103", 8000);

        bank.requestWithdrawal("ACC101");
        bank.requestWithdrawal("ACC102");

        bank.processWithdrawals(1500);
        bank.displayAccountsSortedByBalance();
    }
}
