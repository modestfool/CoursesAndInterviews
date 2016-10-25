import java.util.Scanner;

/**
 * @author: basavakanaparthi
 * on 03,Oct,2016 at 2:50 AM.
 */
/*
    Given n non-negative integers a1, a2, ..., an, where each represents a
     point at coordinate (i, ai). n vertical lines are drawn such that the two
      endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
      with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
 */
public class ContainerMostWater_11 {
    public static int maxArea(int[] height) {

        int max = 0;
        int localMax;
        int left = 0;
        int right = height.length - 1;
        while (left<right)
        {
            if (height[left] < height[right])
            {
                localMax = (right-left)*Math.min(height[left], height[right]);
                left ++;
            }
            else
            {
                localMax = (right-left)*Math.min(height[left], height[right]);
                right--;
            }
            if (localMax > max)
                max = localMax;
        }
        return max;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = in.nextInt();
        System.out.println(maxArea(arr));
    }
}
