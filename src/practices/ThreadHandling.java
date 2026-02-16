package practices;

import java.time.LocalTime;
import java.util.concurrent.*;

public class ThreadHandling {

    // ONLY 3 threads for everything
    private static final ScheduledThreadPoolExecutor executor =
            new ScheduledThreadPoolExecutor(3);

    public static void main(String[] args) {

        String action = "cron"; // change here

        // Call 10 times
        for (int i = 1; i <= 10; i++) {
            handleAction(action, i);
        }
    }

    // ===================================================
    // Switch moved here
    // ===================================================
    private static void handleAction(String action, int taskNumber) {

        switch (action.toLowerCase()) {

            case "cron":
                startCronJob(taskNumber);
                break;

            case "scheduler":
                startScheduledTask(taskNumber);
                break;

            case "thread":
                startNormalThreadTask(taskNumber);
                break;

            case "leader":
                startLeaderElectionSimulation(taskNumber);
                break;

            default:
                System.out.println("Invalid action");
        }
    }

    // ===================================================
    // 1️⃣ Cron Job (Runs every 5 sec continuously)
    // ===================================================
    private static void startCronJob(int taskNumber) {

        executor.scheduleAtFixedRate(() -> {
            System.out.println(LocalTime.now() +
                    " | Cron Task " + taskNumber +
                    " running on " + Thread.currentThread().getName());
        }, 0, 5, TimeUnit.SECONDS);
    }

    // ===================================================
    // 2️⃣ Scheduler (Runs once after 10 sec)
    // ===================================================
    private static void startScheduledTask(int taskNumber) {

        executor.schedule(() -> {
            System.out.println(LocalTime.now() +
                    " | Scheduled Task " + taskNumber +
                    " executed on " + Thread.currentThread().getName());
        }, 10, TimeUnit.SECONDS);
    }

    // ===================================================
    // 3️⃣ Normal Background Task
    // ===================================================
    private static void startNormalThreadTask(int taskNumber) {

        executor.execute(() -> {
            System.out.println(LocalTime.now() +
                    " | Background Task " + taskNumber +
                    " started on " + Thread.currentThread().getName());

            try {
                Thread.sleep(4000);
            } catch (InterruptedException ignored) {}
        });
    }

    // ===================================================
    // 4️⃣ Leader Election Simulation (Every 7 sec)
    // ===================================================
    private static void startLeaderElectionSimulation(int taskNumber) {

        executor.scheduleAtFixedRate(() -> {
            System.out.println(LocalTime.now() +
                    " | Leader Attempt " + taskNumber +
                    " on " + Thread.currentThread().getName());
        }, 0, 7, TimeUnit.SECONDS);
    }
}
