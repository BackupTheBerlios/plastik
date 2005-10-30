package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import de.hampelratte.plastik.PlastikSpinnerButton;
import de.hampelratte.plastik.PlastikSpinnerUI;

public class PlastikSpinnerButtonBorder extends AbstractBorder implements
		Border {

	private int position = SwingConstants.NORTH_EAST;

	private JButton button;

	private JSpinner spinner;

	private PlastikSpinnerUI spinnerUI;

	private Color contour = UIManager.getColor("Common.contour");

	private Color contourSmoother = UIManager
			.getColor("Common.contourSmoother");

	public PlastikSpinnerButtonBorder(int position,
			PlastikSpinnerButton button, PlastikSpinnerUI spinnerUI,
			JSpinner spinner) {
		this.position = position;
		this.button = button;
		this.spinner = spinner;
	}

	public boolean isBorderOpaque() {
		return false;
	}

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		g.translate(x, y);
		g.setColor(contour);

		switch (position) {
		case SwingConstants.NORTH:
			if (spinner.getComponentOrientation().isLeftToRight()) {
				g.drawLine(1, 0, width - 3, 0); // top
				g.drawLine(0, 0, 0, height - 1); // left
				g.drawLine(width - 1, 2, width - 1, height - 1); // right
				g.drawLine(1, height - 1, width - 2, height - 1); // bottom
				// round corner
				g.drawLine(width - 2, 1, width - 2, 1);
				g.setColor(contourSmoother);
				g.drawLine(width - 2, 0, width - 2, 0);
				g.drawLine(width - 1, 1, width - 1, 1);
			} else {
				g.drawLine(2, 0, width - 2, 0); // top
				g.drawLine(0, 2, 0, height - 1); // left
				g.drawLine(width - 1, 0, width - 1, height - 1); // right
				g.drawLine(2, height - 1, width - 2, height - 1); // bottom
				// round corner
				g.drawLine(1, 1, 1, 1);
				g.setColor(contourSmoother);
				g.drawLine(1, 0, 1, 0);
				g.drawLine(0, 1, 0, 1);
			}
			break;
		case SwingConstants.SOUTH:
			if (spinner.getComponentOrientation().isLeftToRight()) {
				g.drawLine(1, 0, width - 2, 0); // top
				g.drawLine(0, 0, 0, height - 1); // left
				g.drawLine(width - 1, 0, width - 1, height - 3); // right
				g.drawLine(1, height - 1, width - 3, height - 1); // bottom
				// round corner
				g.drawLine(width - 2, height - 2, width - 2, height - 2);
				g.setColor(contourSmoother);
				g.drawLine(width - 2, height - 1, width - 2, height - 1);
				g.drawLine(width - 1, height - 2, width - 1, height - 2);
			} else {
				g.drawLine(2, 0, width - 1, 0); // top
				g.drawLine(0, 0, 0, height - 3); // left
				g.drawLine(width - 1, 0, width - 1, height - 1); // right
				g.drawLine(2, height - 1, width - 2, height - 1); // bottom
				// round corner
				g.drawLine(1, height - 2, 1, height - 2);
				g.setColor(contourSmoother);
				g.drawLine(1, height - 1, 1, height - 1);
				g.drawLine(0, height - 2, 0, height - 2);
			}
			break;
		default:
			break;
		}

		// paint rollover highlight
		if (button.isEnabled() && !button.getModel().isPressed()
				&& button.isRolloverEnabled() && button.getModel().isRollover()) {
		}

		g.translate(-x, -y);
	}

	public Insets getBorderInsets(Component c) {
		return new Insets(2, 2, 2, 2);
	}

}
