package turtle;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.UIManager;

import mvc.*;
public class TurtleViewer extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int ORIGIN_CORDINATES = 3;

	public TurtleViewer(Turtle turtle)
	{
		super(turtle);
	}

	public void paintComponent(Graphics gc)
	{
		Graphics2D g2 = (Graphics2D) gc;
		Turtle turtle = (Turtle) model;
		g2.setStroke(new BasicStroke(5));
		for(int i = 0; i < turtle.getPoints().size(); i++)
		{
			Points temp = turtle.getPoints().get(i);
			Points temp2 = turtle.getPoints().get(i+1);
			g2.setColor(temp.getColor());
			g2.drawLine(temp.getX() + Turtle.LINE_ALIGNMENT, temp.getY() + Turtle.LINE_ALIGNMENT, 
					temp2.getX() + Turtle.LINE_ALIGNMENT, temp2.getY() + Turtle.LINE_ALIGNMENT);
			i++;
		}
		g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawRect(ORIGIN_CORDINATES, ORIGIN_CORDINATES, Turtle.WORLD_SIZE + Turtle.LINE_ALIGNMENT, 
				Turtle.WORLD_SIZE + Turtle.LINE_ALIGNMENT);
		
		g2.setStroke(new BasicStroke(1));
		if(turtle.getPen() == false) {
			g2.setColor(UIManager.getColor ( "Panel.background" ));
			g2.fillOval(turtle.getX(), turtle.getY(), Turtle.TURTLE_SIZE, Turtle.TURTLE_SIZE);
			g2.setColor(Color.BLACK);
			g2.drawOval(turtle.getX(), turtle.getY(), Turtle.TURTLE_SIZE, Turtle.TURTLE_SIZE);
		}
		else {
			g2.setColor(turtle.getColor());
			g2.fillOval(turtle.getX(), turtle.getY(), Turtle.TURTLE_SIZE, Turtle.TURTLE_SIZE);
		}
	}
}
