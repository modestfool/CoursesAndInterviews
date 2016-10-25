package Optiver;

import java.util.PriorityQueue;

/**
 * @author: basavakanaparthi
 * on 06,Oct,2016 at 7:03 AM.
 */
public class ThirdLargest {

    static int ThirdLargest(int[] arr)
    {
        int k = 3; // Largest number needed.
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
        for(int i: arr)
        {
            if(heap.contains(i))
                continue;
            heap.offer(i);

            if(heap.size()>k){
                heap.poll();
            }
        }

        return heap.peek();
    }
    public static void main(String[] args) {
        int[] arr = {3,12,14,6,8};
        System.out.println(ThirdLargest(arr));
    }
}
