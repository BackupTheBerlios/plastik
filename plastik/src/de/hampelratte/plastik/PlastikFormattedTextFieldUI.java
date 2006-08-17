package de.hampelratte.plastik;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;


public class PlastikFormattedTextFieldUI extends PlastikTextFieldUI {

	public static ComponentUI createUI(JComponent c) {
		return new PlastikFormattedTextFieldUI();
	}
}