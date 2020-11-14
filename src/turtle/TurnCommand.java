package turtle;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class TurnCommand extends Command{

	public TurnCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Turtle turtle = (Turtle) model;

		String response = Utilities.ask("New Direction");
		response = response.toLowerCase();
		if(response.contentEquals("north")) {
			turtle.setDirection(Heading.north);
		}else if(response.contentEquals("west")){
			turtle.setDirection(Heading.west);
		}else if(response.contentEquals("south")) {
			turtle.setDirection(Heading.south);
		}else if(response.contentEquals("east")) {
			turtle.setDirection(Heading.east);
		}else
		{
			Utilities.error("Not a valid Direction");
		}
	}

}
