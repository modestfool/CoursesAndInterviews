package AkunaCapital;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: basavakanaparthi
 * on 14,Sep,2016 at 7:46 PM.
 */
public class CheapestTransform
{
    public static void main(String[] args) {
        HashMap<Character, HashMap<Character, Integer>> cost_function = new HashMap<>();
        HashMap<Character, Integer> dummy = new HashMap<>();
        dummy.put('a', 0);
        dummy.put('b', 3);
        dummy.put('c', 2);
        cost_function.put('a', dummy);
        dummy.clear();
        dummy.put('a', 5);
        dummy.put('b', 0);
        dummy.put('c', 2);
        cost_function.put('b', dummy);
        dummy.clear();
        dummy.put('a', 1);
        dummy.put('b', 6);
        dummy.put('c', 0);
        cost_function.put('c', dummy);
        String input = "abc";
        String output = "aac";
        int cost = getCost(input,output,cost_function);
        System.out.println(cost);

    }

    private static int getCost(String input, String output, HashMap<Character, HashMap<Character, Integer>> cost_function)
    {
        int cost = 0;
        HashMap<Character, Integer> dummy = new HashMap<>();
        for (int i = 0; i < input.length(); i++)
        {
            char in = input.charAt(i);
            char out = output.charAt(i);
//            System.out.println(in + ":" + out);
            if (in != out)
            {
                System.out.println(in + ":" + out);
                dummy = cost_function.get(in);
                int localcost = Integer.MAX_VALUE;
                for(Map.Entry<Character,Integer> e :dummy.entrySet())
                {
                    if (e.getKey() == out)
                    {
                        if (localcost > e.getValue())
                            localcost = e.getValue();
                    }

                    for(Map.Entry<Character,Integer> e2: cost_function.get(e.getKey()).entrySet())
                    {
                        if (e2.getKey() == out)
                        {
                            if (localcost > (e2.getValue() + e.getValue()))
                                localcost = e2.getValue() + e.getValue();
                        }
                    }
                    System.out.println(localcost);
                }

                cost+= localcost;
            }
        }
        return cost;
    }
}
