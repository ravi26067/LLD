import java.util.HashMap;

import algorithms.RateLimiter;
import algorithms.TokenBucket;

public class RateLimiterService {
    HashMap<String, ThrotleRule> clientRulesCache;
    HashMap<String, RateLimiter> rateLimiterHashmap;
    ThrotleRuleService throtleRuleService;

    public RateLimiterService() {
        this.clientRulesCache = new HashMap<>();
        this.rateLimiterHashmap = new HashMap<>();
        this.throtleRuleService = ThrotleRuleService.getInstance();
    }

    public boolean isRateLimitedUserRequest(String clientId) {
        createUserIfNotTheir(clientId);
        return rateLimiterHashmap.get(clientId).allowRequest();
    }

    private void createUserIfNotTheir(String userId) {
        if (!clientRulesCache.containsKey(userId)) {
            ThrotleRule clientRules = throtleRuleService.getClientRule(userId);
            clientRulesCache.put(userId, clientRules);
        }
        if (!rateLimiterHashmap.containsKey(userId)) {
            ThrotleRule throtleRule = clientRulesCache.get(userId);
            RateLimiter rateLimiter = new TokenBucket(throtleRule.getBucketSize(), throtleRule.getRefillRate());
            rateLimiterHashmap.put(userId, rateLimiter);
        }
    }

}
