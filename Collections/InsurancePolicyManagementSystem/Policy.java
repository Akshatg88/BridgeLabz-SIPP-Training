import java.time.LocalDate;

public class Policy {
    private String policyNumber;
    private String holderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() { return policyNumber; }
    public String getHolderName() { return holderName; }
    public LocalDate getExpiryDate() { return expiryDate; }

    @Override
    public String toString() {
        return policyNumber + " - " + holderName + " - " + expiryDate;
    }
}
