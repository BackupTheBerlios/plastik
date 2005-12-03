package de.hampelratte.plastik.borders;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.border.AbstractBorder;

public class PlastikMenuBarBorder extends AbstractBorder {
	
	public PlastikMenuBarBorder() {
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();
		Color color = colorTheme.getColor(c.getBackground(), PlastikColorTheme.MENU_BAR | PlastikColorTheme.BORDER | PlastikColorTheme.DARKER);
		g.drawLine(x, y+height-1, x+width-1, y+height-1);
	}
	
	public Insets getBorderInsets(Component c) {
		return new Insets(0, 0, 1, 0);
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top    = 0;
		insets.left   = 0;
		insets.bottom = 1;
		insets.right  = 0;
		return insets;
	}
	
}
