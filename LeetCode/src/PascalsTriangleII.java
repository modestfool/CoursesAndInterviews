import java.util.ArrayList;
import java.util.List;

/**
 * @author: basavakanaparthi
 * on 23,Oct,2016 at 11:02 PM.
 */
/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
 */
public class PascalsTriangleII
{
    public static List<Integer> getRow(int rowIndex)
    {

        List<Integer> row = new ArrayList<>();
        row.add(1);
        if (rowIndex == 0)
            return row;
        List<Integer> currRow = new ArrayList<>();
        int i = 0;
        while(i <= rowIndex)
        {
            currRow = new ArrayList<>();
            for (int j = 0; j <= i; j++)
            {
                if (j == 0 || j == i)
                    currRow.add(1);
                else
                {
                    currRow.add(row.get(j-1) + row.get(j));
                }
            }
            //System.out.println(currRow.toString());
            row = currRow;
            i++;
        }
        return currRow;

    }

    public static void main(String[] args) {
        System.out.println(getRow(1).toString());
    }
}
