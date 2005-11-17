package de.hampelratte.plastik.borders;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;

import de.hampelratte.plastik.PlastikUtils;

public class PlastikButtonBorder extends PlastikBorder implements UIResource {

	public void paintBorder(Component c, Graphics g, int x, int y, int width,
			int height) {
		super.paintBorder(c, g, x, y, width, height);

		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();

		Color highlightColor = UIManager.getColor("Common.highlight");
		Color highlightSmoother = UIManager
				.getColor("Common.highlightSmoother");
		Color background = b.getBackground();
		Color top;
		Color bottom;
		g.translate(x, y);

		// draw 3d lines
		// farben sind die gradienten vom button // TODO ins LaF
		if (background instanceof UIResource) {
			if (!model.isEnabled()) {
				top = new Color(239, 239, 239);
				bottom = new Color(233, 233, 233);
			} else if (model.isArmed() && model.isPressed()) {
				top = new Color(203, 205, 209);
				bottom = new Color(213, 215, 219);
			} else {
				top = new Color(233, 235, 239);
				bottom = new Color(213, 215, 219);
			}
		} else {
			// TODO calculate corresponding colors
			if (!model.isEnabled()) {
				top = background;
				bottom = background;
			} else {
				top = background;
				int rgb = PlastikUtils.computeAdjustedColor(
						background.getRGB(), -25);
				bottom = new Color(rgb);
			}
		}

		g.setColor(top); // lighter line
		g.drawLine(2, 1, width - 3, 1);
		g.drawLine(1, 2, 1, height - 3);
		g.setColor(bottom); // darker lines
		g.drawLine(2, height - 2, width - 3, height - 2);
		g.drawLine(width - 2, 2, width - 2, height - 3);

		// draw highlight
		if (b.isEnabled() && !b.getModel().isPressed() && b.isRolloverEnabled()
				&& b.getModel().isRollover()) {
			g.setColor(highlightColor);
			g.drawLine(2, 1, width - 3, 1);
			g.drawLine(2, height - 2, width - 3, height - 2);

			g.setColor(highlightSmoother);
			g.drawLine(1, 2, width - 2, 2);
			g.drawLine(1, height - 3, width - 2, height - 3);
		}
		g.translate(-x, -y);
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		AbstractButton b = (AbstractButton) c;
		insets.top = insets.left = insets.right = insets.bottom = 2;
		/*
		 * if(b.getModel().isPressed() || !b.isEnabled()) { insets.top =
		 * insets.left = insets.right = insets.bottom = 1; } else { insets.top =
		 * insets.left = insets.right = insets.bottom = 2; }
		 */
		return insets;
	}
}