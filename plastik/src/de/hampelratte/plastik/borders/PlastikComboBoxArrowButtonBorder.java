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
		insets.top = 2;
		insets.bottom = 1;
		insets.left = isLeftToRight ? 1 : 2;
		insets.right = isLeftToRight ? 2 : 1;
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

		// paint background
		g.setColor(background);
		int xpos = isLeftToRight ? 0 : 1;
		int newWidth = isLeftToRight ? width - 2 : width - 1;

		AbstractButton b = (AbstractButton) c;
		// draw dark 3d lines over the bright 3d lines, if the button is pressed
		if (b.getModel().isPressed()) {
			g.setColor(new Color(182, 185, 189)); // darker lines TODO ins laf
			xpos = isLeftToRight ? 1 : 2;
			newWidth = isLeftToRight ? width - 3 : width - 2;
			g.drawLine(xpos, 1, newWidth, 1);
			xpos = isLeftToRight ? width - 2 : 1;
			g.drawLine(xpos, 2, xpos, height - 3);
		}

		if (isLeftToRight) {
			if (combo.isEditable()) {
				{ // paint background
					// TODO real transparency
					g.setColor(combo.getParent().getBackground());
					g.drawRect(0, 0, width - 1, height - 1);
					g.setColor(combo.getBackground());
					// horizontal
					g.drawLine(0, 0, width - 3, 0);
					g.drawLine(0, height - 1, width - 3, height - 1);
					g.drawLine(1, 1, width - 3, 1);
					// vertical
					g.drawLine(width - 1, 2, width - 1, height - 3);
					g.drawLine(0, 1, 0, height - 2);
					g.drawLine(width - 2, 2, width - 2, height - 3);

					// corners
					g.drawLine(width - 2, 1, width - 2, 1); // top right
					g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom right
					// smooth corners
					g.drawLine(width - 2, 0, width - 2, 0); // top right
					g.drawLine(width - 1, 1, width - 1, 1);
					g.drawLine(width - 1, height - 2, width - 1, height - 2); // bottom right
					g.drawLine(width - 2, height - 1, width - 2, height - 1);
				}

				// paint contour
				g.setColor(contour);
				// horizontal
				g.drawLine(0, 0, width - 3, 0);
				g.drawLine(0, height - 1, width - 3, height - 1);
				// vertical
				g.drawLine(width - 1, 2, width - 1, height - 3);
				g.drawLine(0, 1, 0, height - 2);

				// corners
				g.drawLine(width - 2, 1, width - 2, 1); // top right
				g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom right

				// smooth corners
				g.setColor(contourSmoother);
				g.drawLine(width - 2, 0, width - 2, 0); // top right
				g.drawLine(width - 1, 1, width - 1, 1);
				g.drawLine(width - 1, height - 2, width - 1, height - 2); // bottom right
				g.drawLine(width - 2, height - 1, width - 2, height - 1);
			} else {
				{ // paint background
					// TODO real transparency
					g.setColor(combo.getParent().getBackground());
					g.drawRect(0, 0, width - 1, height - 1);
					
					g.setColor(combo.getBackground());
					// horizontal
					g.drawLine(1, 0, width - 2, 0);
					g.drawLine(2, 1, width - 3, 1);
					g.drawLine(1, height - 1, width - 2, height - 1);
					// vertical
					g.drawLine(width - 1, 1, width - 1, height - 2);
					g.drawLine(width - 2, 2, width - 2, height - 3);
					g.drawLine(0, 1, 0, height - 2);

					// corners
					g.drawLine(1, 1, 1, 1); // top left
					g.drawLine(1, height - 2, 1, height - 2); // bottom left
					g.drawLine(width - 2, 1, width - 2, 1); // top right
					g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom right
				}
				
				// paint contour
				g.setColor(contour);
				// horizontal
				g.drawLine(2, 0, width - 3, 0);
				g.drawLine(2, height - 1, width - 3, height - 1);
				// vertical
				g.drawLine(width - 1, 2, width - 1, height - 3);
				g.drawLine(0, 2, 0, height - 3);

				// corners
				g.drawLine(1, 1, 1, 1); // top left
				g.drawLine(1, height - 2, 1, height - 2); // bottom left
				g.drawLine(width - 2, 1, width - 2, 1); // top right
				g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom right

				// smooth corners
				g.setColor(contourSmoother);
				g.drawLine(width - 2, 0, width - 2, 0); // top right
				g.drawLine(width - 1, 1, width - 1, 1);
				g.drawLine(width - 1, height - 2, width - 1, height - 2); // bottom right
				g.drawLine(width - 2, height - 1, width - 2, height - 1);
				g.drawLine(1, 0, 1, 0); // top left
				g.drawLine(0, 1, 0, 1);
				g.drawLine(0, height - 2, 0, height - 2); // bottom left
				g.drawLine(1, height - 1, 1, height - 1);
			}
		} else {
			if (combo.isEditable()) {
				{ // paint background
					// TODO real transparency
					g.setColor(combo.getParent().getBackground());
					g.drawRect(0, 0, width - 1, height - 1);
					g.setColor(combo.getBackground());
					// horizontal
					g.drawLine(2, 0, width - 1, 0);
					g.drawLine(2, 1, width - 1, 1);
					g.drawLine(2, height - 1, width - 1, height - 1);
					// vertical
					g.drawLine(0, 2, 0, height - 3);
					g.drawLine(1, 2, 1, height - 3);
					g.drawLine(width - 1, 1, width - 1, height - 2);

					// corners
					g.drawLine(1, 1, 1, 1); // top right
					g.drawLine(1, height - 2, 1, height - 2); // bottom right

					// smooth corners
					g.drawLine(1, 0, 1, 0); // top right
					g.drawLine(0, 1, 0, 1);
					g.drawLine(0, height - 2, 0, height - 2); // bottom right
					g.drawLine(1, height - 1, 1, height - 1);
				}
				
				// paint contour
				g.setColor(contour);
				// horizontal
				g.drawLine(2, 0, width - 1, 0);
				g.drawLine(2, height - 1, width - 1, height - 1);
				// vertical
				g.drawLine(0, 2, 0, height - 3);
				g.drawLine(width - 1, 1, width - 1, height - 2);

				// corners
				g.drawLine(1, 1, 1, 1); // top left
				g.drawLine(1, height - 2, 1, height - 2); // bottom left

				// smooth corners
				g.setColor(contourSmoother);
				g.drawLine(1, 0, 1, 0); // top left
				g.drawLine(0, 1, 0, 1);
				g.drawLine(0, height - 2, 0, height - 2); // bottom left
				g.drawLine(1, height - 1, 1, height - 1);
			} else {
				{ // paint background
					// TODO real transparency
					g.setColor(combo.getParent().getBackground());
					g.drawRect(0, 0, width - 1, height - 1);
					
					g.setColor(combo.getBackground());
					// horizontal
					g.drawLine(1, 0, width - 2, 0);
					g.drawLine(2, 1, width - 3, 1);
					g.drawLine(1, height - 1, width - 2, height - 1);
					// vertical
					g.drawLine(width - 1, 1, width - 1, height - 2);
					g.drawLine(0, 1, 0, height - 2);
					g.drawLine(1, 2, 1, height - 3);

					// corners
					g.drawLine(1, 1, 1, 1); // top left
					g.drawLine(1, height - 2, 1, height - 2); // bottom left
					g.drawLine(width - 2, 1, width - 2, 1); // top right
					g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom right
				}
				
				// paint contour
				g.setColor(contour);
				// horizontal
				g.drawLine(2, 0, width - 3, 0);
				g.drawLine(2, height - 1, width - 3, height - 1);
				// vertical
				g.drawLine(width - 1, 2, width - 1, height - 3);
				g.drawLine(0, 2, 0, height - 3);

				// corners
				g.drawLine(1, 1, 1, 1); // top left
				g.drawLine(1, height - 2, 1, height - 2); // bottom left
				g.drawLine(width - 2, 1, width - 2, 1); // top right
				g.drawLine(width - 2, height - 2, width - 2, height - 2); // bottom

				// smooth corners
				g.setColor(contourSmoother);
				g.drawLine(width - 2, 0, width - 2, 0); // top right
				g.drawLine(width - 1, 1, width - 1, 1);
				g.drawLine(width - 1, height - 2, width - 1, height - 2); // bottom right
				g.drawLine(width - 2, height - 1, width - 2, height - 1);
				g.drawLine(1, 0, 1, 0); // top left
				g.drawLine(0, 1, 0, 1);
				g.drawLine(0, height - 2, 0, height - 2); // bottom left
				g.drawLine(1, height - 1, 1, height - 1);
			}
		}

		if (b.isEnabled() && !b.getModel().isPressed() && b.isRolloverEnabled()
				&& b.getModel().isRollover()) {
			if (isLeftToRight) {
				g.setColor(highlight);
				g.drawLine(1, 1, width - 3, 1);
				g.drawLine(1, height - 2, width - 3, height - 2);
				g.drawLine(1, 2, 1, height - 3);
				g.drawLine(width - 2, 2, width - 2, height - 3);

				g.setColor(highlightSmoother);
				g.drawLine(2, 2, width - 3, 2);
				g.drawLine(2, height - 3, width - 3, height - 3);
				g.drawLine(2, 3, 2, height - 4);
				g.drawLine(width - 3, 3, width - 3, height - 4);

			} else {
				g.setColor(highlight);
				g.drawLine(2, 1, width - 2, 1);
				g.drawLine(2, height - 2, width - 2, height - 2);
				g.drawLine(1, 2, 1, height - 3);
				g.drawLine(width - 2, 2, width - 2, height - 3);

				g.setColor(highlightSmoother);
				g.drawLine(2, 2, width - 3, 2);
				g.drawLine(2, height - 3, width - 3, height - 3);
				g.drawLine(2, 3, 2, height - 4);
				g.drawLine(width - 3, 3, width - 3, height - 4);
			}
		}

		g.translate(-x, -y);
	}
}
