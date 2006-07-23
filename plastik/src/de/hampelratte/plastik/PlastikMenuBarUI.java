package de.hampelratte.plastik;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuBarUI;

import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikMenuBarUI extends BasicMenuBarUI {
	
	public PlastikMenuBarUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuBarUI();
    }
	
	
	public void paint(Graphics g, JComponent c) {
		Dimension d = c.getSize();
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();
		g.setColor(colorTheme.getColor(PlastikColorTheme.MENU_BAR | PlastikColorTheme.BACKGROUND));
		g.fillRect(0, 0, d.width, d.height);
		
		super.paint(g,c);
    }
}
