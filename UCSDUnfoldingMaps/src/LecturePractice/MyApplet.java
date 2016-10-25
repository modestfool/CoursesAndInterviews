package LecturePractice;

import java.util.Calendar;
import java.util.Date;

import processing.core.PApplet;
import processing.core.PImage;

public class MyApplet extends PApplet{

	private String url = "http://pngimg.com/upload/water_PNG3290.png";
	private PImage backgroundImage;
	Date date = new Date();

	
	public void setup()
	{
		size(200,200);
		backgroundImage = loadImage(url, "png");
	}
	
	public void draw()
	{
		
		backgroundImage.resize(0, height);
		image(backgroundImage, 0, 0);
		fill(255,209,0);
		ellipse(width/4,height/5,width/5,height/5);
	}
}
