package practices;

import java.util.concurrent.*;

public class ProducerConsumerExample {

    private static final BlockingQueue<Integer> queue =
            new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {

        Runnable producer = () -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.put(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        };

        Runnable consumer = () -> {
            try {
                while (true) {
                    int item = queue.take();
                    System.out.println("Consumed: " + item);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {}
        };

        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
