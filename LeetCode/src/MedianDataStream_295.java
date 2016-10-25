import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: basavakanaparthi
 * on 10,Oct,2016 at 7:06 AM.
 */
/*
    https://leetcode.com/problems/find-median-from-data-stream/
    Median is the middle value in an ordered integer list.
    If the size of the list is even, there is no middle value.
    So the median is the mean of the two middle value.

    Examples:
    [2,3,4] , the median is 3

    [2,3], the median is (2 + 3) / 2 = 2.5

    Design a data structure that supports the following two operations:

    void addNum(int num) - Add a integer number from the data stream to the data structure.
    double findMedian() - Return the median of all elements so far.
    For example:

    add(1)
    add(2)
    findMedian() -> 1.5
    add(3)
    findMedian() -> 2
 */
public class MedianDataStream_295 {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new
                                                                Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // Adds a number into the data structure.
    public static void addNum(int num)
    {
        double med = findMedian();
        if(num <= med)
            maxHeap.add(num);
        else
            minHeap.add(num);

        if (minHeap.size() > maxHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
        else if (maxHeap.size() - minHeap.size() > 1)
        {
            minHeap.offer(maxHeap.poll());
        }
    }

    // Returns the median of current data stream
    public static double findMedian()
    {
        if (maxHeap.isEmpty() && minHeap.isEmpty())
            return 0.0;
        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return (maxHeap.peek() + minHeap.peek())/2.0;
    }

    public static void main(String[] args)
    {
        addNum(1);
        System.out.println(maxHeap.toString() + " " + minHeap.toString());
        System.out.println(findMedian());
        addNum(-2);
        System.out.println(maxHeap.toString() + " " + minHeap.toString());
        System.out.println(findMedian());
        addNum(3);
        System.out.println(maxHeap.toString() + " " + minHeap.toString());
        System.out.println(findMedian());
        addNum(-4);
        System.out.println(maxHeap.toString() + " " + minHeap.toString());
        System.out.println(findMedian());
        addNum(5);
        System.out.println(maxHeap.toString() + " " + minHeap.toString());
        System.out.println(findMedian());
    }
}
