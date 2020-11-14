package turtle;

import mvc.Command;
import mvc.Model;
import mvc.Utilities;

public class MoveCommand extends Command{

	public MoveCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Turtle turtle = (Turtle) model;
		String response = Utilities.ask("Number of Steps;");
		try {
			Integer amount = Integer.parseInt(response);
			turtle.move(amount);
		} catch(Exception e){
			Utilities.error("Must be an integer");
		}
	}

}
