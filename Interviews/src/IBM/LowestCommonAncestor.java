package IBM;

import java.util.*;

/**
 * @author: basavakanaparthi
 * on 15,Sep,2016 at 10:55 PM.
 */

/*
IBM desires to develop a service to help a client quickly find a manager who
can resolve the conflict between two employees.
When there is a conflict between two employees, the closest common manager should help resolve the conflict.
The developers plan to test the service by providing an example reporting hierarchy to enable the identification of
the closest common manager for two employees. Your goal is to develop an algorithm for IBM to efficiently perform this task.
To keep things simple, they just use a single relationship "isManagerOf" between any two employees.

For example, consider a reporting structure represented as a set of triples:

    Tom isManagerOf Mary
    Mary isManagerOf Bob
    Mary isManagerOf Sam
    Bob isManagerOf John
    Sam isManagerOf Pete
    Sam isManagerOf Katie
    The manager who should resolve the conflict between Bob and Mary is Tom(Mary's manager).
    The manager who should resolve the conflict between Pete and Katie is Sam(both employees' manager).
    The manager who should resolve the conflict between Bob and Pete is Mary(Bob's manager and Pete's manager's manager).

Assumptions:

    There will be at least one isManagerOf relationship.
    There can be a maximum of 15 team member to a single manager
    No cross management would exist i.e., a person can have only one manager
    There can be a maximum of 100 levels of manager relationships in the corporation
Input:
    R1,R2,R3,R4...Rn,Person1,Person2 R1...Rn - A comma separated list of "isManagerOf" relationships.
     Each relationship being represented by an arrow "Manager->Person".
     Person1,Person2 - The name of the two employee that have conflict

Output:
The name of the manager who can resolve the conflict
Note: Please be prepared to provide a video follow-up response to describe your approach to this exercise.


 */
public class LowestCommonAncestor {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] relations = input.split(",");
        String emp1 = relations[relations.length-2];
        String emp2 = relations[relations.length-1];
        relations = Arrays.copyOf(relations,relations.length-2);
        HashMap<String,List<String>> managers = new HashMap<>();
        HashMap<String,String> employees = new HashMap<>();
        for (String r : relations)
        {
            String[] emps = r.split("->");
            if (managers.containsKey(emps[0]))
            {
                List<String> dummy = managers.get(emps[0]);
                dummy.add(emps[1]);
                managers.put(emps[0],dummy);
            }
            else
            {
                List<String> dummy = new ArrayList<>();dummy.add(emps[1]);
                managers.put(emps[0],dummy);
            }
            employees.put(emps[1],emps[0]);
        }
        Set<String> managersSet = managers.keySet();
        managersSet.removeAll(employees.keySet());
        assert managersSet.size() == 1;
        Employee root = new Employee();

        for (String i :managersSet)
        {
            root.setName(i);
            List<Employee> manages = new ArrayList<>();
            for(String m:managers.get(i))
            {
                Employee emp = new Employee();
                emp.setName(m);
                emp.setManagees(null);
                manages.add(emp);
            }
            root.setManagees(manages);
            managers.remove(i);
        }
        addNodes(root, managers);
    }


    public static  void addNodes(Employee root, HashMap<String, List<String>> map)
    {
        if(root == null)
            return;
        List<Employee> children = root.getManagees();
        for(Employee child : children)
        {
            List<String> mngs = map.get(child.getName());
            List<Employee> manages = new ArrayList<>();
            for(String x : mngs)
            {
                Employee emp = new Employee();
                emp.setName(x);
                emp.setManagees(null);
                manages.add(emp);
            }
            child.setManagees(manages);
            addNodes(child, map);
        }
    }

    public static void inOrderTraversal(Employee root)
    {
        if (root == null)
            return;
        System.out.println();
    }
}


class Employee{
    private String Name;
    private List<Employee> managees;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Employee> getManagees() {
        return managees;
    }

    public void setManagees(List<Employee> managees) {
        this.managees = managees;
    }

}
