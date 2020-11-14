package turtle;
import mvc.*;

public class TurtleFactory implements AppFactory{

	@Override
	public Model makeModel() {
		return new Turtle();
	}

	@Override
	public String[] getEditCommands() {
		return new String[] {"Turn", "Move", "Pen", "Clear", "Color"};

	}

	@Override
	public Command makeEditCommand(Model model, String type) {
		if (type == "Turn")
			return new TurnCommand(model);
		else if(type == "Color")
			return new ColorCommand(model);
		else if(type == "Pen")
			return new PenCommand(model);
		else if(type == "Move")
			return new MoveCommand(model);
		else if(type == "Clear")
			return new ClearCommand(model);
		return null;
	}

	@Override
	public String getTitle() {
		return "Turtle Drawing Simulator";
	}

	@Override
	public String[] getHelp() {
		return new String[] {"click Turn to change your direction", 
				"click Move to enter a value to move the turtle",
				"click Clear to erase what has been drawn in the field",
				"click Pen to either draw or not draw when moving the turtle",
				"click Color to change the color that is being drawed when the turtle moves"};
	}

	@Override
	public String about() {
		return "Turtle Drawing Simulator version 1.0. Copyright 2020 by Emmanuel Gamboa";
	}

}
