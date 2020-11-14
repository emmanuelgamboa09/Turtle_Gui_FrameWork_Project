package mvc;

import java.beans.*;
import java.io.*;

abstract public class Bean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	transient protected PropertyChangeSupport mPcs =
			new PropertyChangeSupport(this);

	transient protected VetoableChangeSupport mVcs =
			new VetoableChangeSupport(this);
	
	public void initSupport()
	{
		if(mPcs == null) mPcs = new PropertyChangeSupport(this);
		if(mVcs == null) mVcs = new VetoableChangeSupport(this);
	}
	
	public void fireVetoableChange(String propertyName, Object oldValue, Object newValue) throws PropertyVetoException {
		mVcs.fireVetoableChange(propertyName, oldValue, newValue);
	}

	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		mPcs.firePropertyChange(propertyName, oldValue, newValue);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		mPcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		mPcs.removePropertyChangeListener(listener);
	}

	public void addVetoableChangeListener(VetoableChangeListener listener) {
		mVcs.addVetoableChangeListener(listener);
	}

	public void removeVetoableChangeListener(VetoableChangeListener listener) {
		mVcs.removeVetoableChangeListener(listener);
	}

}
