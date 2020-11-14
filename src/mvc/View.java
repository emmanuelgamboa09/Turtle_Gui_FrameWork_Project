package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
public class View extends JComponent implements PropertyChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Model model;
	
	public View(Model model) {
		super();
		this.model = model;
		model.addPropertyChangeListener(this);
	}
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		if(this.model != null) this.model.removePropertyChangeListener(this);
		this.model = model;
		if(model != null)
		{
			this.model.addPropertyChangeListener(this);
			repaint();
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}

}
