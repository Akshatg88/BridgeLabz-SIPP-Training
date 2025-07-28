import java.time.LocalDate;
import java.util.*;

public class InsuranceSystem {
    private HashMap<String, Policy> policyMap = new HashMap<>();
    private LinkedHashMap<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        insertionOrderMap.put(policy.getPolicyNumber(), policy);
        expiryMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringInNext30Days() {
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        List<Policy> result = new ArrayList<>();
        expiryMap.subMap(now, true, limit, true).values().forEach(result::addAll);
        return result;
    }

    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : policyMap.values()) {
            if (p.getHolderName().equalsIgnoreCase(holderName)) {
                result.add(p);
            }
        }
        return result;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        expiryMap.headMap(now, false).values().forEach(list -> {
            for (Policy p : list) {
                policyMap.remove(p.getPolicyNumber());
                insertionOrderMap.remove(p.getPolicyNumber());
            }
        });
        expiryMap.headMap(now, false).clear();
    }

    public void displayAll() {
        insertionOrderMap.values().forEach(System.out::println);
    }
}
