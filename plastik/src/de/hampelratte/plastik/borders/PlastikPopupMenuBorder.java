package de.hampelratte.plastik.borders;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikPopupMenuBorder extends AbstractBorder implements UIResource {
	
	public PlastikPopupMenuBorder() {
	}
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();

		g.translate(x, y);
		
		// lines
		g.setColor(colorTheme.getColor(c.getBackground(), PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BORDER));
		g.drawLine(1, 0, width-2, 0); // top
		g.drawLine(1, height-1, width-2, height-1); // bottom
		g.drawLine(0, 1, 0, height-2); // left
		g.drawLine(width-1, 1, width-1, height-2); // right
		
		// corners
		g.setColor(colorTheme.getColor(c.getBackground(), PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BORDER | PlastikColorTheme.BRIGHTER_MORE));
		g.drawLine(0, 0, 0, 0); // top left
		g.drawLine(width-1, 0, width-1, 0); // top right
		g.drawLine(0, height-1, 0, height-1); // bottom left
		g.drawLine(width-1, height-1, width-1, height-1); // bottom right
		
		g.translate(-x,-y);
	}
	
	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(1, 1, 1, 1));
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top    = 1;
		insets.left   = 1;
		insets.bottom = 1;
		insets.right  = 1;
		return insets;
	}
}