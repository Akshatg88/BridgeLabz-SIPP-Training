import java.util.*;

abstract class BankAccount {
    private final long accountNumber;
    private final String holderName;
    private double balance;
    protected BankAccount(long acc,String name,double bal){
        this.accountNumber=acc;this.holderName=name;this.balance=bal;
    }
    public void deposit(double amt){ balance+=amt; }
    public void withdraw(double amt){ balance-=amt; }
    public double getBalance(){ return balance; }
    public abstract double calculateInterest();
}

interface Loanable{
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

class SavingsAccount extends BankAccount implements Loanable{
    public SavingsAccount(long acc,String name,double bal){super(acc,name,bal);}
    @Override public double calculateInterest(){ return getBalance()*0.04; }
    @Override public void applyForLoan(double amt){/*…*/ }
    @Override public boolean calculateLoanEligibility(){ return getBalance()>10_000; }
}

class CurrentAccount extends BankAccount implements Loanable{
    public CurrentAccount(long acc,String name,double bal){super(acc,name,bal);}
    @Override public double calculateInterest(){ return 0; }
    @Override public void applyForLoan(double amt){/*…*/ }
    @Override public boolean calculateLoanEligibility(){ return true; }
}

public class BankDemo{
    public static void main(String[]args){
        List<BankAccount> accts=List.of(
            new SavingsAccount(1001,"Kim",20_000),
            new CurrentAccount(1002,"Lee",5_000));
        accts.forEach(a->System.out.println(a.calculateInterest()));
    }
}
