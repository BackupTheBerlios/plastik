package de.hampelratte.plastik;

import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuItemUI;

public class PlastikMenuItemUI extends BasicMenuItemUI {
	
	public PlastikMenuItemUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuItemUI();
	}
	
	public void paintBackground(Graphics g, JMenuItem item, Color bgColor) {
		ButtonModel model = menuItem.getModel();
        int menuWidth = menuItem.getWidth();
        int menuHeight = menuItem.getHeight();
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();

		Color oldColor = g.getColor();
		
		Color background = colorTheme.getColor(menuItem.getBackground(), PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND);
		g.setColor(background);
		g.fillRect(0, 0, menuWidth, menuHeight);
		
		if (model.isArmed()) {
			Color top            = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER);
			Color topGradient    = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER_GRADIENT);
			Color bottomGradient = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.ROLLOVER | PlastikColorTheme.DARKER_GRADIENT);
			Color bottom         = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.ROLLOVER | PlastikColorTheme.DARKER);
			g.setColor(top);
			g.drawLine(0, 0, menuWidth-1, 0);
			Gradients.drawBoxGradient(g, 0, 1, menuWidth, menuHeight-2, topGradient, bottomGradient);
			g.setColor(bottom);
			g.drawLine(0, menuHeight-1, menuWidth-1, menuHeight-1);
		} 
		
		g.setColor(oldColor);
	}
	
	
	
}
