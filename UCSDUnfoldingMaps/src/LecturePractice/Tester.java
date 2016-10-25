package LecturePractice;

public class Tester {
	public static void main (String[] args)
	{
		double[] coords = {5.0,0.0};
		ArrayLocation accra = new ArrayLocation(coords);
		coords[0] = 32.9;
		coords[1] = -117.9;
		System.out.println(accra.coords[0]);
	}
}
