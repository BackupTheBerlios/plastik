package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JViewport;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikTextComponentBorder extends AbstractBorder implements
		UIResource {

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(0,0,0,0)); // dummy values
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		// leave room for default visual
		insets.top = insets.left = insets.right = insets.bottom = 2;
		return insets;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		JComponent comp = (JComponent) c;

		// if textarea lies inside of a scrollpane don't draw a border
		if (comp instanceof JTextArea & comp.getParent() instanceof JViewport) {
			return;
		}

		// TODO theme benutzen
		Color contour = UIManager.getColor("Common.contour");
		Color contourSmoother = UIManager.getColor("Common.contourSmoother");
		Color highlight = UIManager.getColor("Common.highlight");
		Color highlightSmoother = UIManager.getColor("Common.highlightSmoother");
		g.translate(x, y);
		
		// fill the whole border area with parent color
		// TODO real transparency
		g.setColor(c.getParent().getBackground());
		g.drawLine(0,0,width-1,0); // top
		g.drawLine(0,1,width-1,1); // top
		g.drawLine(0,0,0,height-1); // left
		g.drawLine(1,0,1,height-1); // left
		g.drawLine(width-1,0,width-1,height-1); // right
		g.drawLine(width-2,0,width-2,height-1); // right
		g.drawLine(0,height-2,width-1,height-2); // bottom
		g.drawLine(0,height-1,width-1,height-1); // bottom
		

		// paint contour
		g.setColor(comp.hasFocus() ? highlight : contour);
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
		g.setColor(comp.hasFocus() ? highlightSmoother : contourSmoother);
		g.drawLine(0, 1, 0, 1); // upperleft
		g.drawLine(1, 0, 1, 0);
		g.drawLine(width - 2, 0, width - 2, 0); // upperright
		g.drawLine(width - 1, 1, width - 1, 1);
		g.drawLine(0, height - 2, 0, height - 2); // lowerleft
		g.drawLine(1, height - 1, 1, height - 1);
		g.drawLine(width - 2, height - 1, width - 2, height - 1); // upperright
		g.drawLine(width - 1, height - 2, width - 1, height - 2);

		// paint inner lines
		g.setColor(contourSmoother);
		g.translate(x, y);
		g.drawLine(2, 1, width - 3, 1); // horizontal
		g.drawLine(1, 2, 1, height - 3); // vertical

		if (comp.hasFocus()) {
			g.setColor(highlightSmoother.darker());
			g.drawLine(2, 1, width - 3, 1);
			g.drawLine(1, 2, 1, height - 3);
			g.setColor(highlight.brighter());
			g.drawLine(2, height - 2, width - 3, height - 2);
			g.drawLine(width - 2, 2, width - 2, height - 3);
		}

		g.translate(-x, -y);
	}
}
