package LecturePractice;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.GeoJSONReader;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
import processing.core.PApplet;

public class LifeExpectancy extends PApplet{
	
	UnfoldingMap map;
	Map<String,Float> lifeExpectancyMap;
	List<Feature> countries;
	List<Marker> countryMarkers;
	public void setup()
	{
		size(800,600,OPENGL);
		map = new UnfoldingMap(this, 50, 50, 700, 500, new Google.GoogleMapProvider());
		MapUtils.createDefaultEventDispatcher(this, map);
		lifeExpectancyMap = loadLifeExpectancyFromCSV("LifeExpectancyWorldBank.csv");
		countries = GeoJSONReader.loadData(this, "countries.geo.json");
		countryMarkers = MapUtils.createSimpleMarkers(countries);
		map.addMarkers(countryMarkers);
		shadeCountries();
	}
	

	public void draw()
	{
		map.draw();
	}
	
	private Map<String, Float> loadLifeExpectancyFromCSV(String fileName)
	{
		Map<String,Float> lifeExpectancyMap = new HashMap<String, Float>();
		String[] rows = loadStrings(fileName);
		for (String row:rows)
		{
			String[] columns = row.split(",");
			if (row!=null)
			{
				try{
					float value = Float.parseFloat(columns[5]);
					lifeExpectancyMap.put(columns[4], value);
				}
				catch(NumberFormatException e)
				{
					try{
						float value = Float.parseFloat(columns[6]);
						lifeExpectancyMap.put(columns[4], value);
					}
					catch(NumberFormatException e1)
					{
						System.out.println(e1.toString());
					}
				}
			}
		}
		return lifeExpectancyMap;
	}

	private void shadeCountries() {
		
		for (Marker marker : countryMarkers)
		{
			String countryId = marker.getId();
			
			if(lifeExpectancyMap.containsKey(countryId))
			{
				float lifeExp = lifeExpectancyMap.get(countryId);
				int colorLevel = (int) map(lifeExp,40,90,10,255);
				marker.setColor(color(255-colorLevel,100,colorLevel));
			}
			else 
			{
				marker.setColor(color(150,150,150));
			}
		}
		
	}
}
