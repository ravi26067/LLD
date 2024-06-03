import java.util.HashMap;

public class ThrotleRuleService {
    HashMap<String, ThrotleRule> clientThrotleRules;
    private static volatile ThrotleRuleService instance;

    public ThrotleRuleService() {
        clientThrotleRules = new HashMap<>();
    }

    public void createRule(String clientId, ThrotleRule throtleRule) {
        clientThrotleRules.put(clientId, throtleRule);
    }

    public ThrotleRule getClientRule(String clientId) {
        return clientThrotleRules.get(clientId);
    }

    public static ThrotleRuleService getInstance() {
        if (instance == null) {
            synchronized (ThrotleRuleService.class) {
                if (instance == null) {
                    instance = new ThrotleRuleService();
                }
            }
        }
        return instance;
    }
}
