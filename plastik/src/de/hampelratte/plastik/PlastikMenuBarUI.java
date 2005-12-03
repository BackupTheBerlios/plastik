package de.hampelratte.plastik;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;

public class PlastikMenuBarUI extends BasicMenuBarUI {
	
	public PlastikMenuBarUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuBarUI();
    }
	
}
