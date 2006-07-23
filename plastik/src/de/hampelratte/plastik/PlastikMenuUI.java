package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicMenuUI;

import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikMenuUI extends BasicMenuUI {
	
	public PlastikMenuUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikMenuUI();
	}
	
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		// storing original anitalising flag
		Object state = null;
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			state = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			if (state != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
		}
		
		super.paint(g, c);
		
		// restoring antialising flag
		if (state != null) {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, state);
		}
	}
	
	public void paintBackground(Graphics g, JMenuItem item, Color bgColor) {
        int menuWidth = item.getWidth();
        int menuHeight = item.getHeight();
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();

		Color oldColor = g.getColor();
		
		JMenu menu = (JMenu) item;
		Color background = colorTheme.getColor(item.getBackground(), PlastikColorTheme.MENU | PlastikColorTheme.BACKGROUND);
		if(!menu.isTopLevelMenu()) {
			background = colorTheme.getColor(menuItem.getBackground(), PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND);
		}
		g.setColor(background);
		g.fillRect(0, 0, menuWidth, menuHeight);
		
		ButtonModel model = item.getModel();
		if (!menu.isTopLevelMenu() && (model.isArmed()|| (menuItem instanceof JMenu && model.isSelected())) ) {
			selectionForeground = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.FOREGROUND_TEXT | PlastikColorTheme.ROLLOVER);
			Color top            = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER);
			Color topGradient    = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER_GRADIENT);
			Color bottomGradient = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND | PlastikColorTheme.ROLLOVER | PlastikColorTheme.DARKER_GRADIENT);
			Color bottom         = colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND | PlastikColorTheme.ROLLOVER | PlastikColorTheme.DARKER);
			g.setColor(top);
			g.drawLine(0, 0, menuWidth-1, 0);
			Gradients.drawBoxGradient(g, 0, 1, menuWidth, menuHeight-2, topGradient, bottomGradient);
			g.setColor(bottom);
			g.drawLine(0, menuHeight-1, menuWidth-1, menuHeight-1);
		}
		
		g.setColor(oldColor);
	}
}