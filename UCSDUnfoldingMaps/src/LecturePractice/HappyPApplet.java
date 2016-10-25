package LecturePractice;

import processing.core.PApplet;

public class HappyPApplet extends PApplet{

	public void setup()
	{
		size(400,400);
		background(200,200,200);
	}
	public void draw()
	{
		fill(255,255,0);
		ellipse(200,200,390,390);
		fill(0,0,0);
		ellipse(110,130,70,70);
		ellipse(290,130,70,70);
		noFill();
		arc(200,280,75,75,0,PI);
		
	}
}
