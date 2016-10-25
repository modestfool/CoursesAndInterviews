package Intuit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author: basavakanaparthi
 * on 05,Oct,2016 at 12:31 AM.
 */
public class AdjacencyList {

    class Adjacency
    {
        private TreeMap<String,HashSet<String>> adjacencyList;
        private void printAdj(TreeMap<String, HashSet<String>> adjacencyList) {
            for (Map.Entry<String, HashSet<String>> e : adjacencyList.entrySet()) {
                if (e.getValue().isEmpty())
                    System.out.println(e.getKey() + ": " + "None");
                else
                    System.out.println(e.getKey() + ": " + toString(e.getValue()));
            }
        }

        private String toString(HashSet<String> s) {
            StringBuilder sb = new StringBuilder();
            for (String value : s)
                sb.append(value).append(", ");
            return sb.substring(0, sb.length() - 2);
        }
        public Adjacency(String empFile, String friendsFile)
        {
//            adjacencyList = new
        }
    }
        public static void main(String[] args) throws FileNotFoundException {
            //assert args.length ==3;
            String employeesFile = "/Users/basavakanaparthi/Documents/odrive/Google Drive/Stony Brook/workspace/Interviews/src/Intuit/employees.csv";//args[1];
            String friendshipsFile =
                    "/Users/basavakanaparthi/Documents/odrive/Google Drive/Stony Brook/workspace/Interviews/src/Intuit/friendships.csv";//args[2];
            TreeMap<String,HashSet<String>> adjacencyList = new TreeMap<>();
            Scanner scanner = new Scanner(new File(employeesFile));
            scanner.nextLine();
    //        scanner.useDelimiter(",");
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                adjacencyList.put(line.split(",")[0], new HashSet<>());
            }
            scanner.close();
            scanner = new Scanner(new File(friendshipsFile));
            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                adjacencyList.get(parts[0]).add(parts[1]);
                adjacencyList.get(parts[1]).add(parts[0]);
            }
//            /printAdj(adjacencyList);
        }


}
