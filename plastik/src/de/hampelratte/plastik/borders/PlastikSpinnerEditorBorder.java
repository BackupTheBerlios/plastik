package de.hampelratte.plastik.borders;

import java.awt.Component;
import java.awt.Insets;

import javax.swing.JSpinner;

public class PlastikSpinnerEditorBorder extends PlastikComboBoxEditorBorder {

	private JSpinner spinner;
	
	public PlastikSpinnerEditorBorder(JSpinner spinner) {
		super(spinner);
		this.spinner = spinner;
	}

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(0, 0, 0, 0)); // dummy values
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		boolean isLeftToRight = spinner.getComponentOrientation().isLeftToRight();
		insets.top = 2;
		insets.bottom = 1;
		insets.left = isLeftToRight ? 2 : 0;
		insets.right = isLeftToRight ? 0 : 2;
		return insets;
	}
}
