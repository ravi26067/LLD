public class UserIdentificationService {
    RateLimiterService rateLimiterService;

    public UserIdentificationService() {
        rateLimiterService = new RateLimiterService();
    }

    public String serveRequest(String clientId) {
        boolean isAllowed = rateLimiterService.isRateLimitedUserRequest(clientId);
        if (isAllowed) {
            return "Request Served";
        } else {
            return "Too many requests, please try again";
        }
    }
}
