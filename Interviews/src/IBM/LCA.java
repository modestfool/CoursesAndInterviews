package IBM;

/**
 * @author: basavakanaparthi
 * on 21,Oct,2016 at 11:02 PM.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LCA {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String s;

        while ((s = in.readLine()) != null)
        {

//            System.out.println(s);

            String [] relations = s.split(",");

            if(relations.length<=2)return;

            String person1 = relations[relations.length-2];

            String person2 = relations[relations.length-1];

            Map<String, String> managersMap = new HashMap<>();

            for(int i=0;i<relations.length-2;i++) {
                managersMap.put(relations[i].split("->")[1], relations[i].split("->")[0]);
            }
//            int d1 = getDepth(person1, managersMap);
//            int d2 = getDepth(person2, managersMap);
//            System.out.println(d1 + " " + d2);
//            int d = d1 - d2;
//            if (d < 0)
//            {
//                String tmp = person1;
//                person1 = person2;
//                person2 = tmp;
//                d = -d;
//            }
//            while (d-- > 0)
//                person1 = managersMap.get(person1);
//
//            while (!managersMap.get(person1).equals(managersMap.get(person2)))
//            {
//                if(managersMap.get(person2).equals(managersMap.get(person1))) {
//                    System.out.println(managersMap.get(person1));
//                    return;
//                }
//                else
//                {
//                    person1 = managersMap.get(person1);
//                    person2 = managersMap.get(person2);
//                }
//            }
            boolean flag = false;

            while(!managersMap.get(person2).equals(managersMap.get(person1))){

                if(managersMap.get(person2).equals(person1)){

                    System.out.println(managersMap.get(person1));

                    return;

                } else if (managersMap.get(person1).equals(person2)){

                    System.out.println(managersMap.get(person2));

                    return;

                } else {

                    if(flag){

                        person1=managersMap.get(person1);
                        flag=!flag;
                    }else{
                        person2=managersMap.get(person2);
                        flag=!flag;
                    }

                }

            }

            System.out.println(managersMap.get(person2));

        }

    }

    private static int getDepth(String person, Map<String, String> cParents) {
        int level = 0;
        if (!cParents.containsKey(person))
            return -1;
        while (cParents.containsKey(person))
        {
            level++;
            person = cParents.get(person);
        }
        return level;
    }

}