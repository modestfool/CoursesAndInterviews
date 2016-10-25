/**
 * 
 */
package LecturePractice;

/**
 * Airport.java 
 * @author Basava R.Kanaparthi(basava.08@gmail.com)
 * Created on Feb 12, 2016
 */
public class Airport {
	private String city;
	private String airportCode;
	private String country;
	
	/**
	 * 
	 */
	public Airport(String city, String airportCode, String country) {
		
		this.city = city;
		this.airportCode = airportCode;
		this.country = country;
	}
	
	
	public String getCity()
	{
		return this.city;
	}
	

	public String getAirportCode()
	{
		return this.airportCode;
	}


	public String getCountry()
	{
		return this.country;
	}
	
	public static String findAirportCode (String toFind, Airport[] airports){
		String airportCode = null;
		for (Airport a : airports)
		{
			if (a.getCity().equals(toFind))
			{
				airportCode = a.getAirportCode();
				break;
			}
		}
		return airportCode;
	}
	
	public static String findAirportCodeBS (String toFind, Airport[] airports){
		int low = 0;
		int high = airports.length - 1;
		int mid;
		while(low <= high)
		{
			mid = (low + high)/2;
			int compare = toFind.compareTo(airports[mid].getCity());
			if (compare == 0)
				return airports[mid].getAirportCode();
			else if (compare < 0)
			{
				high = mid -1;
			}
			else
			{
				low = mid + 1;
			}
		}
		return null;
	}

}
