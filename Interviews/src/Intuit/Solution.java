package Intuit;

import java.io.File;
import java.util.*;

/**
 * @author: basavakanaparthi
 * on 05,Oct,2016 at 1:15 AM.
 */

class Employee{
    int employee_id;
    String name;
    String department;
    public Employee(int employee_id, String name, String department) {
        super();
        this.employee_id = employee_id;
        this.name = name;
        this.department = department;
    }
}
public class Solution {

    private static void printAdj(HashMap<String, List<String>> map, List<Employee> employees){
        for (Employee e:employees){

            if (map.containsKey(String.valueOf(e.employee_id))){
                System.out.println(e.employee_id + ": " + map.get(String.valueOf(e.employee_id)).toString());
            }
            else
                System.out.println(e.employee_id + ": " + "None");
        }
    }

    public static void main(String[] args) {
        try{
            String employeesFile = "/Users/basavakanaparthi/Documents/odrive/Google Drive/Stony Brook/workspace/Interviews/src/Intuit/employees.csv";//args[1];
            String friendshipsFile =
                    "/Users/basavakanaparthi/Documents/odrive/Google Drive/Stony Brook/workspace/Interviews/src/Intuit/friendships.csv";//args[2];

            List<Employee> list = new ArrayList<Employee>();
            File file1 = new File(employeesFile);//new File("employees.csv");
            Scanner input = new Scanner(file1);
            input.nextLine();
            while (input.hasNextLine()) {
                String[] s = input.nextLine().split(",");
                list.add(new Employee(Integer.valueOf(s[0]), s[1], s[2]));
            }
            input.close();


            HashMap<String, List<String>> map = new HashMap<>();
            File file2 = new File(friendshipsFile);//new File("friendships
            // .csv");
            Scanner input1 = new Scanner(file2);
            input1.nextLine();
            while (input1.hasNextLine()) {
                String[] i = input1.nextLine().split(",");
                if(map.containsKey(i[0])){
                    List<String> a = map.get(i[0]);
                    a.add(i[1]);
                    map.put(i[0], a);
                }else{
                    List<String> a = new ArrayList<>();
                    a.add(i[1]);
                    map.put(i[0], a);
                }

                if(map.containsKey(i[1])){
                    List<String> a = map.get(i[1]);
                    a.add(i[0]);
                    map.put(i[1], a);
                }else{
                    List<String> a = new ArrayList<>();
                    a.add(i[0]);
                    map.put(i[1], a);
                }
            }
            input1.close();
            printAdj(map,list);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
