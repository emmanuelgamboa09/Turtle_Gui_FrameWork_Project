package turtle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import mvc.Model;

public class Turtle extends Model{
	static final int WORLD_SIZE = 250;
	public static final int LINE_ALIGNMENT = Turtle.TURTLE_SIZE/ 2;
	public static final int TURTLE_SIZE = 10;
	private int x = 120, y = 120;
	private Heading direction = Heading.north;
	private Color color;
	private Boolean pen = false;
	private List<Points> points = new ArrayList<Points>();

	public List<Points> getPoints(){
		return points;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Heading getDirection() {
		return direction;
	}
	public void setDirection(Heading direction) {
		this.direction = direction;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
		changed();
	}
	public Boolean getPen() {
		return pen;
	}
	public void setPen(Boolean pen) {
		this.pen = pen;
		changed();
	}

	public void clear() {
		points.clear();
		changed();
	}
	public void move(Integer amount) {
		if(pen == true) {
			Points temp = new Points(this.x, this.y, this.color);
			points.add(temp);
		}

		if(direction == Heading.north) {
			y = y - amount;
		} else if(direction == Heading.east) {
			x = x + amount;
		}else if (direction == Heading.south) {
			y = y + amount;
		}
		else {
			x = x - amount;
		}
		if(pen == true) {
			outOfBoundsCheckerWithPenDown(amount);
			points.add(new Points(x  , y , color));
		}else {
			outOfBoundsCheckerWithPenUp(amount);
		}
		changed();
	}
	public void outOfBoundsCheckerWithPenUp(int steps) {
		int numberOfLoops = 1;

		if(steps > WORLD_SIZE)
			numberOfLoops = steps/WORLD_SIZE;

		if(y < 0) {
			y = y + (WORLD_SIZE * numberOfLoops);
		}
		else if(x < 0) {
			x = x + (WORLD_SIZE * numberOfLoops);
		}
		else if(y > WORLD_SIZE) {
			y =y - (WORLD_SIZE * numberOfLoops);
		}
		else if(x > WORLD_SIZE) {
			x = x - (WORLD_SIZE * numberOfLoops);
		}
	}
	public void outOfBoundsCheckerWithPenDown(int steps)
	{
		int numberOfLoops = 1;

		if(steps > WORLD_SIZE)
			numberOfLoops = steps/WORLD_SIZE;

		if(y < 0 ){
			points.add(new Points(x , 0 , color));
			points.add(new Points(x, WORLD_SIZE, color));
			y = y  + (WORLD_SIZE * numberOfLoops);
		}
		else if(x < 0 ){
			points.add(new Points(0  , y, color));
			points.add(new Points(WORLD_SIZE , y, color));
			x = x + (WORLD_SIZE * numberOfLoops);
		}
		else if(y > WORLD_SIZE) {
			points.add(new Points(x, WORLD_SIZE , color));
			points.add(new Points(x , 0  , color));
			y = y - (WORLD_SIZE * numberOfLoops);
		}
		else if(x > WORLD_SIZE) {
			points.add(new Points(WORLD_SIZE , y, color));
			points.add(new Points(0 , y, color));
			x = x - (WORLD_SIZE * numberOfLoops);
		}
	}	
}
