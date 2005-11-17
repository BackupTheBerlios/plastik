package de.hampelratte.plastik.borders;

import javax.swing.JComponent;
import javax.swing.JSpinner;

public class PlastikSpinnerEditorBorder extends PlastikComboBoxEditorBorder {

	private JSpinner spinner;
	
	public PlastikSpinnerEditorBorder(JSpinner spinner) {
		super(spinner);
		this.spinner = spinner;
	}

	
	public boolean hasFocus(JComponent c) {
		Object p = c.getClientProperty("focus"); 
		if(p != null) {
			return ((Boolean)p).booleanValue();
		} else {
			return false;
		}
	}
}
