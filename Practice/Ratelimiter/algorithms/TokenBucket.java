package algorithms;

public class TokenBucket implements RateLimiter {

    private final long maxBucketSize;
    private final long refillRate;
    private double currentBucketSize;
    private long lastRefillTimestamp;

    public TokenBucket(long maxBucketSize, long refillRate) {
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        this.currentBucketSize = maxBucketSize;
        this.lastRefillTimestamp = System.nanoTime();
    }

    @Override
    public synchronized boolean allowRequest() {
        refill();
        if (currentBucketSize >= 1) {
            currentBucketSize--;
            return true;
        } else {
            return false;
        }
    }

    private void refill() {
        long now = System.nanoTime();
        double tokensToAdd = (now - lastRefillTimestamp) * refillRate / 1e9;
        System.out.println("before filled: " + currentBucketSize + " ");
        currentBucketSize = Math.min(currentBucketSize + tokensToAdd, maxBucketSize);
        System.out.println("after filled: " + currentBucketSize + " ");
        lastRefillTimestamp = now;
    }

}
