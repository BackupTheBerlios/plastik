package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;

public class PlastikButtonBorder extends PlastikBorder implements UIResource {

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		super.paintBorder(c, g, x, y, width, height);

		Color highlightColor = UIManager.getColor("Common.highlight");
		Color highlightSmoother = UIManager
				.getColor("Common.highlightSmoother");

		AbstractButton b = (AbstractButton) c;

		// draw dark 3d lines over the bright 3d lines, if the button is pressed
		if(b.getModel().isPressed()) {
			g.setColor(new Color(195, 195, 201)); // darker lines TODO ins laf
			g.drawLine(2, 1, width - 3, 1);
			g.drawLine(1, 2, 1, height - 3);
		}
		
		// draw highlight
		g.translate(x,y);
		if (b.isEnabled() && !b.getModel().isPressed() && b.isRolloverEnabled()
				&& b.getModel().isRollover()) {
			g.setColor(highlightColor);
			g.drawLine(2, 1, width - 3, 1);
			g.drawLine(2, height - 2, width - 3, height - 2);

			g.setColor(highlightSmoother);
			g.drawLine(1, 2, width - 2, 2);
			g.drawLine(1, height - 3, width - 2, height - 3);
		}
		g.translate(-x,-y);
	}
}
