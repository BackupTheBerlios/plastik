package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

public class PlastikComboBoxEditorBorder extends AbstractBorder implements
		UIResource {

	private boolean gotColors = false;

	protected Color contour;

	protected Color contourSmoother;

	protected Color highlight;

	protected Color highlightSmoother;

	protected Color background;

	private JComponent component;

	public PlastikComboBoxEditorBorder(JComponent comp) {
		this.component = comp;
	}

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(0, 0, 0, 0)); // dummy values
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		boolean isLeftToRight = component.getComponentOrientation().isLeftToRight();
		insets.top = 2;
		insets.bottom = 1;
		insets.left = isLeftToRight ? 2 : 0;
		insets.right = isLeftToRight ? 0 : 1;
		return insets;
	}

	private void getColors() {
		if (!gotColors) {
			contour = UIManager.getColor("Common.contour");
			contourSmoother = UIManager.getColor("Common.contourSmoother");
			highlight = UIManager.getColor("Common.highlight");
			highlightSmoother = UIManager.getColor("Common.highlightSmoother");
			background = UIManager.getColor("Common.background");
			gotColors = true;
		}
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		JComponent comp = (JComponent) c;
		boolean isLeftToRight = component.getComponentOrientation().isLeftToRight();

		getColors();
		g.translate(x, y);
		
		int xpos = 0;
		int newWidth = 0;
		
		/*
		{ // paint background
			g.setColor(background);
			xpos = isLeftToRight ? 1 : 0;
			newWidth = isLeftToRight ? width - 1 : width - 2;
			g.drawLine(xpos, 0, newWidth, 0);
			g.drawLine(xpos, 1, newWidth, 1);
			g.drawLine(xpos, height - 1, newWidth, height - 1);
			// vertical
			xpos = isLeftToRight ? 0 : width - 1;
			g.drawLine(xpos, 1, xpos, height - 2);
			xpos = isLeftToRight ? 1 : width - 2;
			g.drawLine(xpos, 1, xpos, height - 2);
		}*/

		{ // paint contour 
			g.setColor(hasFocus(comp) ? highlight : contour);
			// horizontal
			xpos = isLeftToRight ? 2 : 0;
			newWidth = isLeftToRight ? width - 1 : width - 3;
			g.drawLine(xpos, 0, newWidth, 0);
			g.drawLine(xpos, height - 1, newWidth, height - 1);
			// vertical
			xpos = isLeftToRight ? 0 : width - 1;
			g.drawLine(xpos, 2, xpos, height - 3);
		}

		// corners
		xpos = isLeftToRight ? 1 : width - 2;
		g.drawLine(xpos, 1, xpos, 1);
		g.drawLine(xpos, height - 2, xpos, height - 2);

		// smooth corners
		g.setColor(hasFocus(comp) ? highlightSmoother : contourSmoother);
		xpos = isLeftToRight ? 0 : width - 1;
		int increment = isLeftToRight ? 1 : -1;
		g.drawLine(xpos, 1, xpos, 1); // upper corner
		g.drawLine(xpos + increment, 0, xpos + increment, 0);
		g.drawLine(xpos, height - 2, xpos, height - 2); // lower corner
		g.drawLine(xpos + increment, height - 1, xpos + increment, height - 1);

		// paint inner lines
		g.setColor(contourSmoother);
		xpos = isLeftToRight ? 2 : 0;
		newWidth = isLeftToRight ? width - 1 : width - 3;
		g.drawLine(xpos, 1, newWidth, 1); // horizontal
		xpos = isLeftToRight ? 1 : width - 2;
		g.drawLine(xpos, 2, xpos, height - 3); // vertical

		if (hasFocus(comp)) {
			if (isLeftToRight) {
				g.setColor(highlightSmoother.darker());
				g.drawLine(2, 1, width - 1, 1);
				g.drawLine(1, 2, 1, height - 3);
				g.setColor(highlight.brighter());
				g.drawLine(2, height - 2, width - 1, height - 2);
				g.drawLine(width-1, 2, width-1, height - 3);
			} else {
				g.setColor(highlightSmoother.darker());
				g.drawLine(0, 1, width - 3, 1);
				g.setColor(highlight.brighter());
				g.drawLine(0, 2, 0, height - 3);
				g.drawLine(0, height - 2, width - 3, height - 2);
				g.drawLine(width - 2, 2, width - 2, height - 3);
			}
		}

		g.translate(-x, -y);
	}
	
	public boolean hasFocus(JComponent c) {
		return c.hasFocus();
	}
}
