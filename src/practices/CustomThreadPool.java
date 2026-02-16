package practices;

import java.util.concurrent.*;

public class CustomThreadPool {

    private final BlockingQueue<Runnable> queue;
    private final Thread[] workers;

    public CustomThreadPool(int poolSize, int queueSize) {
        queue = new ArrayBlockingQueue<>(queueSize);
        workers = new Thread[poolSize];

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Thread(new Worker());
            workers[i].start();
        }
    }

    public void submit(Runnable task) {
        if (!queue.offer(task)) {
            System.out.println("Task rejected!");
        }
    }

    private class Worker implements Runnable {
        public void run() {
            while (true) {
                try {
                    Runnable task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }
}
