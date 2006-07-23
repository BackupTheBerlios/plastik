package de.hampelratte.plastik.borders;

import java.awt.Color;
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
	
	// TODO herausfinden, wer hier schon den hintergrund malt und dann die ecken abrunden
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		/*
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();
		Color color = colorTheme.getColor(c.getBackground(), PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BORDER);
		g.setColor(color);
		g.drawLine(x, y, width, 1);
		g.drawLine(x, y+height, width, 1);
		*/
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