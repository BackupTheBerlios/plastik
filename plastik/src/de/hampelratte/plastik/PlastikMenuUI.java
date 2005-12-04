package de.hampelratte.plastik;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;

public class PlastikMenuUI extends BasicMenuUI {
	
	public PlastikMenuUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuUI();
	}
	
}
