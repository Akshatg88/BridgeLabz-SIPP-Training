import java.time.LocalDate;

public class InsuranceMain {
    public static void main(String[] args) {
        InsuranceSystem system = new InsuranceSystem();

        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5)));

        System.out.println("\nPolicies for Alice:");
        system.getPoliciesByHolder("Alice").forEach(System.out::println);

        System.out.println("\nExpiring in next 30 days:");
        system.getPoliciesExpiringInNext30Days().forEach(System.out::println);

        System.out.println("\nAll policies before removing expired:");
        system.displayAll();

        system.removeExpiredPolicies();

        System.out.println("\nAll policies after removing expired:");
        system.displayAll();
    }
}
