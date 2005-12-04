package de.hampelratte.plastik;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;

public class PlastikMenuItemUI extends BasicMenuItemUI {
	
	public PlastikMenuItemUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuItemUI();
	}
	
}
