package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

public class PlastikBorder extends AbstractBorder implements UIResource {

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		Color contour = UIManager.getColor("Common.contour");
		Color contourSmoother = UIManager.getColor("Common.contourSmoother");
		Color background = UIManager.getColor("Common.background");

		g.translate(x, y);

		{ // draw background
			g.setColor(background);
			// top
			g.drawLine(1, 0, width - 2, 0);
			g.drawLine(0, 1, width - 1, 1);
			// bottom
			g.drawLine(1, height - 1, width - 2, height - 1);
			g.drawLine(0, height - 2, width - 1, height - 2);
			// left
			g.drawLine(0, 2, 0, height - 3);
			g.drawLine(1, 1, 1, height - 2);
			// right
			g.drawLine(width-1, 2, width-1, height - 3);
			g.drawLine(width-2, 1, width-2, height - 2);
		}

		g.setColor(contour);
		// horizontal
		g.drawLine(2, 0, width - 3, 0);
		g.drawLine(2, height - 1, width - 3, height - 1);
		// vertical
		g.drawLine(0, 2, 0, height - 3);
		g.drawLine(width - 1, 2, width - 1, height - 3);

		
		// corners
		g.drawLine(1, 1, 1, 1);
		g.drawLine(1, height - 2, 1, height - 2);
		g.drawLine(width - 2, 1, width - 2, 1);
		g.drawLine(width - 2, height - 2, width - 2, height - 2);

		// smooth corners
		g.setColor(contourSmoother);
		g.drawLine(0, 1, 0, 1); // upperleft
		g.drawLine(1, 0, 1, 0);
		g.drawLine(width - 2, 0, width - 2, 0); // upperright
		g.drawLine(width - 1, 1, width - 1, 1);
		g.drawLine(0, height - 2, 0, height - 2); // lowerleft
		g.drawLine(1, height - 1, 1, height - 1);
		g.drawLine(width - 2, height - 1, width - 2, height - 1); // upperright
		g.drawLine(width - 1, height - 2, width - 1, height - 2);
		
		// TODO 3d streifen in den uimanager einarbeiten
		// draw 3d effect lines
		// FIXME sind die hier überhaupt richtig?
		// vielleicht sollte der normale plastikborder nur insets 1 haben und keine 3d streifen
		g.setColor(new Color(241, 241, 246)); // bright lines
		g.drawLine(2, 1, width - 3, 1);
		g.drawLine(1, 2, 1, height - 3);
		g.setColor(new Color(195, 195, 201)); // darker lines
		g.drawLine(2, height - 2, width - 3, height - 2);
		g.drawLine(width - 2, 2, width - 2, height - 3);
		
		g.translate(-x, -y);
	}

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(2, 2, 2, 2));
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top = insets.left = insets.right = insets.bottom = 2;
		return insets;
	}
}
