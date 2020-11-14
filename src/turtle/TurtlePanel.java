package turtle;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.AppFactory;
import mvc.AppPanel;


public class TurtlePanel extends AppPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton turn;
	private JButton color;
	private JButton pen;
	private JButton move;
	private JButton clear;

	public TurtlePanel(AppFactory factory) {
		super(factory);
		TurtleViewer view = new TurtleViewer((Turtle) model);
		this.setLayout(new GridLayout(1,2));
		turn = new JButton("Turn");
		turn.addActionListener(this);
		color = new JButton("Color");
		color.addActionListener(this);
		pen = new JButton("Pen");
		pen.addActionListener(this);
		move = new JButton("Move");
		move.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		JPanel buttonPanel = new JPanel();
     	buttonPanel.setLayout(new GridLayout(5,1));
     	JPanel buttonPanel2 = new JPanel();
		JPanel panel = new JPanel();
		panel.add(turn);
		buttonPanel.add(panel);
		panel = new JPanel();
		panel.add(move);
		buttonPanel.add(panel);
		panel = new JPanel();
		panel.add(clear);
		buttonPanel.add(panel);
		panel = new JPanel();
		panel.add(pen);
		buttonPanel.add(panel);
		panel = new JPanel();
		panel.add(color);
		buttonPanel.add(color);
		buttonPanel2.add(buttonPanel, "North");

		add(buttonPanel2, "WEST");
		add(view, "East");
	}


	public static void main(String[] args)
	{
		AppFactory factory = new TurtleFactory();
		AppPanel panel = new TurtlePanel(factory);
		panel.display();
	}
}




