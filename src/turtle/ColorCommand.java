package turtle;

import java.awt.Color;

import javax.swing.JColorChooser;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class ColorCommand extends Command{

	public ColorCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Turtle turtle = (Turtle) model;
		if(turtle.getPen() == true) {
			Color newColor = JColorChooser.showDialog(null, "Choose a color", turtle.getColor());
			turtle.setColor(newColor);
		}
		else
			Utilities.error("Cannot change the color if the pen is up");
	}
}


