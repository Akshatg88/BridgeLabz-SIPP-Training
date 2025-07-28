import java.util.*;

public class BankSystem {
    private HashMap<String, Double> accountMap = new HashMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accNo, double balance) {
        accountMap.put(accNo, balance);
    }

    public void requestWithdrawal(String accNo) {
        if (accountMap.containsKey(accNo)) {
            withdrawalQueue.add(accNo);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String accNo = withdrawalQueue.poll();
            double bal = accountMap.get(accNo);
            if (bal >= amount) {
                accountMap.put(accNo, bal - amount);
                System.out.println("₹" + amount + " withdrawn from " + accNo);
            } else {
                System.out.println("Insufficient balance in " + accNo);
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (String accNo : accountMap.keySet()) {
            double bal = accountMap.get(accNo);
            sorted.computeIfAbsent(bal, k -> new ArrayList<>()).add(accNo);
        }

        System.out.println("Accounts sorted by balance:");
        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + ": ₹" + entry.getKey());
            }
        }
    }
}
