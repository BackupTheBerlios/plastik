package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

public class PlastikComboBoxArrowButtonBorder extends AbstractBorder implements
		UIResource {

	private boolean gotColors = false;

	protected Color contour;

	protected Color contourSmoother;

	protected Color highlight;

	protected Color highlightSmoother;

	protected Color background;

	private JComboBox combo;

	public PlastikComboBoxArrowButtonBorder(JComboBox combo) {
		this.combo = combo;
	}

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(0, 0, 0, 0)); // dummy values
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		boolean isLeftToRight = combo.getComponentOrientation().isLeftToRight();

		// leave room for default visual
		insets.top = 2;
		insets.bottom = 1;
		insets.left = isLeftToRight ? 2 : 1;
		insets.right = isLeftToRight ? 1 : 2;
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
		boolean isLeftToRight = combo.getComponentOrientation().isLeftToRight();

		getColors();
		g.translate(x, y);

		// paint contour
		g.setColor(contour);
		// horizontal
		int xpos = isLeftToRight ? 0 : 2;
		int newWidth = isLeftToRight ? width - 3 : width - 1;
		g.drawLine(xpos, 0, newWidth, 0);
		g.drawLine(xpos, height - 1, newWidth, height - 1);
		// vertical
		xpos = isLeftToRight ? width - 1 : 0;
		g.drawLine(xpos, 2, xpos, height - 3);
		xpos = isLeftToRight ? 0 : width - 1;
		g.drawLine(xpos, 1, xpos, height - 2);

		// corners
		xpos = isLeftToRight ? width - 2 : 1;
		g.drawLine(xpos, 1, xpos, 1);
		g.drawLine(xpos, height - 2, xpos, height - 2);

		// smooth corners
		g.setColor(contourSmoother);
		xpos = isLeftToRight ? width - 1 : 0;
		int increment = isLeftToRight ? -1 : 1;
		g.drawLine(xpos, 1, xpos, 1); // upper corner
		g.drawLine(xpos + increment, 0, xpos + increment, 0);
		g.drawLine(xpos, height - 2, xpos, height - 2); // lower corner
		g.drawLine(xpos + increment, height - 1, xpos + increment, height - 1);

		AbstractButton b = (AbstractButton) c;
		
		// paint inner lines
		xpos = isLeftToRight ? 1 : 2;
		newWidth = isLeftToRight ? width - 3 : width - 1;
		g.drawLine(xpos, 1, newWidth, 1); // horizontal
		// TODO farbe ins laf einbauen
		g.setColor(b.getModel().isPressed() ? contourSmoother : new Color(225,225,225));
		g.drawLine(xpos, 2, xpos, height-2); // vertical
		

		if (b.isEnabled() && !b.getModel().isPressed() && b.isRolloverEnabled()
				&& b.getModel().isRollover()) {
			if (isLeftToRight) {
				g.setColor(highlight);
				g.drawLine(1,1,width-3,1);
				g.drawLine(1,height-2,width-3,height-2);
				g.drawLine(1,2,1,height-3);
				g.drawLine(width-2,2,width-2,height-3);
				
				g.setColor(highlightSmoother);
				g.drawLine(2,2,width-3,2);
				g.drawLine(2,height-3,width-3,height-3);
				g.drawLine(2,3,2,height-4);
				g.drawLine(width-3,3,width-3,height-4);
				
			} else {
				g.setColor(highlight);
				g.drawLine(2,1,width-2,1);
				g.drawLine(2,height-2,width-2,height-2);
				g.drawLine(1,2,1,height-3);
				g.drawLine(width-2,2,width-2,height-3);
				
				g.setColor(highlightSmoother);
				g.drawLine(2,2,width-3,2);
				g.drawLine(2,height-3,width-3,height-3);
				g.drawLine(2,3,2,height-4);
				g.drawLine(width-3,3,width-3,height-4);
			}
		}

		// corner background
		g.setColor(background);
		xpos = isLeftToRight ? width - 1 : 0;
		g.drawLine(xpos, 0, xpos, 0);
		g.drawLine(xpos, height - 1, xpos, height - 1);

		g.translate(-x, -y);
	}
}
