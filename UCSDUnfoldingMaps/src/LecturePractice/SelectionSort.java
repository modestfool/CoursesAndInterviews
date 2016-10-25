/**
 * 
 */
package LecturePractice;

/**
 * SelectionSort.java 
 * @author Basava R.Kanaparthi(basava.08@gmail.com)
 * Created on Feb 12, 2016
 */
public class SelectionSort {

	public void selectionSort(int[] unsortedArray)
	{
		
		int lastIndex = unsortedArray.length - 1;
		
		for (int sortedTill = 0; sortedTill < lastIndex; sortedTill++)
		{
			int min = unsortedArray[sortedTill];
			int minIndex = sortedTill;
			
			for (int index = sortedTill + 1;index < lastIndex-1; index++)
			{
				if(unsortedArray[index] < min)
				{
					min = unsortedArray[index];
					minIndex = index;
				}
			}
			unsortedArray[minIndex] = unsortedArray[sortedTill];
			unsortedArray[sortedTill] = min;
		}
	}
}
