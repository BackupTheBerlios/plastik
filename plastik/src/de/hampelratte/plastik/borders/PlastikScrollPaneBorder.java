package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.UIManager;


public class PlastikScrollPaneBorder extends PlastikBorder {

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		
		g.translate(x, y);
		
		// draw background
		Color background = UIManager.getColor("Common.background");
		g.setColor(background);
		g.drawRect(1, 1, width, height);
				
		g.translate(-x, -y);
		
		super.paintBorder(c, g, x, y, width, height);
	}
	
	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top = insets.left = insets.right = insets.bottom = 2;
		return insets;
	}
}
