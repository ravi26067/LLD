import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ThrotleRule rule = new ThrotleRule();
        ThrotleRuleService throtleRuleService = ThrotleRuleService.getInstance();
        throtleRuleService.createRule("client1", rule);

        UserIdentificationService request = new UserIdentificationService();

        ExecutorService executor = Executors.newFixedThreadPool(1);

        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);

        Long startTime = System.currentTimeMillis();

        Runnable r = () -> {
            System.out.println("client1 " + Thread.currentThread().getName() + "--" + request.serveRequest("client1"));
        };
        scheduledExecutor.scheduleAtFixedRate(r, 0, 50, TimeUnit.MILLISECONDS);
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
            Long endTime = System.currentTimeMillis();
            System.out.println("total time " + (endTime - startTime));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}