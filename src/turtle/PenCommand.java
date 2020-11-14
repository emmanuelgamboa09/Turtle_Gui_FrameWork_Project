package turtle;
import mvc.*;
public class PenCommand extends Command{

	public PenCommand(Model model) {
		super(model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		Turtle turtle = (Turtle) model;
		if(turtle.getPen() == false) {
			turtle.setPen(true);
		}
		else
			turtle.setPen(false);
	}
}
