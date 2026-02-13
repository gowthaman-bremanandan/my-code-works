package queue.heap.medianFromDataStream;

public class MedianFinderTest {

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian()); // 1.0

        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2.0

        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 2.0
    }
}
