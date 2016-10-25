package Pelton;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: basavakanaparthi
 * on 16,Oct,2016 at 12:37 AM.
 */
public class FinalDiscountedPrice
{
    public static void getCost(int[] prices)
    {
        Stack<Integer> priceStack = new Stack<>();
        int[] discounts = new int[prices.length];
        int cost = 0;
        for(int i = 0; i < prices.length; i++)
        {
            while (!priceStack.isEmpty() && prices[priceStack.peek()] >=
                    prices[i])
            {
                int c = priceStack.pop();
                discounts[c] = prices[i];
            }
            priceStack.push(i);
        }

        for (int i = 0; i < prices.length; i++)
            cost += prices[i] - discounts[i];
        System.out.println(cost);
        System.out.println(Arrays.toString(discounts));
        for (int i = 0; i < discounts.length; i++)
            if(discounts[i] == 0)
                System.out.print(i + " ");
    }
    public static void main(String[] args) {
        int[] arr ={1,3,3,2,5};
        getCost(arr);
    }
}
