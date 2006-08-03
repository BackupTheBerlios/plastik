package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class PlastikScrollButton extends JButton {

	private boolean gotColors = false;

	private Color background;

	private Color contour;

	private Color contourSmoother;

	private Color innerContour;

	private Color innerContourPressed;

	private Color contourDisabled;

	private Color contourDisabledSmoother;

	private int size;

	private ButtonModel model;
	
	private int direction; 

	public PlastikScrollButton(int direction, int width) {
		super.setSize(width, width);
		this.direction = direction;
		this.size = width;
		model = this.getModel();
	}

	private void initColors() {
		if (!gotColors) {
			background = UIManager.getColor("Common.background");
			contour = UIManager.getColor("Common.contour");
			contourSmoother = UIManager.getColor("Common.contourSmoother");
			innerContour = UIManager.getColor("Common.innerContour");
			innerContourPressed = UIManager
					.getColor("Common.innerContourPressed");
			contourDisabled = UIManager.getColor("Common.contourDisabled");
			contourDisabledSmoother = UIManager
					.getColor("Common.contourDisabledSmoother");
			gotColors = true;
		}
	}

	public void paint(Graphics g) {
		initColors();
		BufferedImage image = new BufferedImage(size, size,
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D) image.getGraphics();

		if (direction == SwingConstants.NORTH) {
			// TODO real transparency
			// paint transparent corners
			Color parentColor = getParent().getParent().getBackground();
			if(getParent().getParent() instanceof JScrollPane && !getParent().getParent().isOpaque()) {
				parentColor = getParent().getParent().getParent().getBackground();
			}
			g2.setColor(parentColor);
			g2.drawLine(0, 0, 0, 0);
			g2.drawLine(size - 1, 0, size - 1, 0);
						
			// contour
			g2.setColor(model.isEnabled() ? contour : contourDisabled);
			g2.drawLine(2, 0, size - 3, 0);
			g2.drawLine(1, 1, 1, 1);
			g2.drawLine(size - 2, 1, size - 2, 1);
			g2.drawLine(0, 2, 0, size - 2);
			g2.drawLine(size - 1, 2, size - 1, size - 2);
			g2.drawLine(1, size - 1, size - 2, size - 1);
			// contour smoother
			g2.setColor(model.isEnabled() ? contourSmoother
					: contourDisabledSmoother);
			g2.drawLine(1, 0, 1, 0);
			g2.drawLine(0, 1, 0, 1);
			g2.drawLine(size - 2, 0, size - 2, 0);
			g2.drawLine(size - 1, 1, size - 1, 1);
			g2.drawLine(0, size - 1, 0, size - 1);
			g2.drawLine(size - 1, size - 1, size - 1, size - 1);

			// inner lines
			g2.drawLine(size - 2, 2, size - 2, size - 2);
			g2.drawLine(1, size - 2, size - 3, size - 2);

			if (!isEnabled() || model.isPressed()) {
				g2.fillRect(1, 1, size - 3, size - 3);
			} else {
				// gradient
				Color lightGray = new Color(229, 231, 236);
				Color darkGray = new Color(206, 207, 213);
				GradientPaint gp = new GradientPaint(2, 2, lightGray, size,2,
						darkGray);
				g2.setPaint(gp);
				g2.fillRect(2, 2, size - 4, size - 4);
			}

			// arrow
			g2.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
							: innerContour)
							: innerContourPressed);
			int arrowHeight = size / 4;
			int startY = ((size + 1) - arrowHeight) / 2;
			int startX = (size / 2) - 1;
			if (model.isPressed()) {
				startY++;
				startX++;
			}
			for (int line = 0; line < arrowHeight; line++) {
				g2.drawLine(startX - line, startY + line, startX + line, startY
						+ line);
			}

			g.drawImage(image, 0, 0, background, this);
		} else if(direction == SwingConstants.SOUTH) {
			// TODO real transparency
			// paint transparent corners
			Color parentColor = getParent().getParent().getBackground();
			if(getParent().getParent() instanceof JScrollPane && !getParent().getParent().isOpaque()) {
				parentColor = getParent().getParent().getParent().getBackground();
			}
			g2.setColor(parentColor);
			g2.drawLine(0, size-1, 0, size-1);
			g2.drawLine(size - 1, size-1, size - 1, size-1);
			
			// contour
			g2.setColor(model.isEnabled() ? contour : contourDisabled);
			g2.drawLine(2, size-1, size - 3, size-1);
			g2.drawLine(1, size-2, 1, size-2);
			g2.drawLine(size - 2, size-2, size - 2, size-2);
			g2.drawLine(0, 1, 0, size - 3);
			g2.drawLine(size - 1, 1, size - 1, size - 3);
			g2.drawLine(1, 0, size - 2, 0);
			// contour smoother
			g2.setColor(model.isEnabled() ? contourSmoother
					: contourDisabledSmoother);
			g2.drawLine(0, 0, 0, 0);
			g2.drawLine(size-1, 0, size-1, 0);
			g2.drawLine(size - 2, size-1, size - 2, size-1);
			g2.drawLine(size - 1, size-2, size - 1, size-2);
			g2.drawLine(0, size - 2, 0, size - 2);
			g2.drawLine(1, size - 1, 1, size - 1);

			// inner lines
			g2.drawLine(size - 2, 1, size - 2, size - 3);
			g2.drawLine(2, size - 2, size - 3, size - 2);
			
			if (!isEnabled() || model.isPressed()) {
				g2.fillRect(1, 1, size - 3, size - 3);
			} else {
				// gradient
				Color lightGray = new Color(229, 231, 236);
				Color darkGray = new Color(206, 207, 213);
				GradientPaint gp = new GradientPaint(2, 2, lightGray, size, 2,
						darkGray);
				g2.setPaint(gp);
				g2.fillRect(2, 2, size - 4, size - 4);
			}
			
			// arrow
			g2.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
							: innerContour)
							: innerContourPressed);
			int arrowHeight = size / 4;
			int startY = size - 1 - ((size + 1) - arrowHeight) / 2;
			int startX = (size / 2) - 1;
			if (model.isPressed()) {
				startY++;
				startX++;
			}
			for (int line = 0; line < arrowHeight; line++) {
				g2.drawLine(startX - line, startY - line, startX + line, startY
						- line);
			}

			g.drawImage(image, 0, 0, background, this);
		} else if(direction == SwingConstants.EAST) {
			// TODO real transparency
			// paint transparent corners
			Color parentColor = getParent().getParent().getBackground();
			if(getParent().getParent() instanceof JScrollPane && !getParent().getParent().isOpaque()) {
				parentColor = getParent().getParent().getParent().getBackground();
			}
			g2.setColor(parentColor);
			g2.drawLine(size-1, 0, size-1, 0);
			g2.drawLine(size - 1, size-1, size - 1, size-1);
			
			// contour
			g2.setColor(model.isEnabled() ? contour : contourDisabled);
			g2.drawLine(size-1, 2, size - 1, size-3); // fertig
			g2.drawLine(size-2, 1, size-2,1);
			g2.drawLine(size - 2, size-2, size - 2, size-2);
			g2.drawLine(1, 0, size - 3, 0);
			g2.drawLine(1, size-1, size - 3, size - 1);
			g2.drawLine(0, 1, 0, size - 2);
			
			// contour smoother
			g2.setColor(model.isEnabled() ? contourSmoother
					: contourDisabledSmoother);
			g2.drawLine(0, 0, 0, 0);
			g2.drawLine(0, size-1, 0, size-1);
			g2.drawLine(size - 2, size-1, size - 2, size-1);
			g2.drawLine(size - 1, size-2, size - 1, size-2);
			g2.drawLine(size - 2, 0, size - 2,0);
			g2.drawLine(size - 1, 1, size - 1,1);
			
			// inner lines
			g2.drawLine(1, size - 2, size - 3, size - 2);
			g2.drawLine(size-2, 2, size - 2, size - 3);
			
			if (!isEnabled() || model.isPressed()) {
				g2.fillRect(1, 1, size - 3, size - 3);
			} else {
				// gradient
				Color lightGray = new Color(229, 231, 236);
				Color darkGray = new Color(206, 207, 213);
				GradientPaint gp = new GradientPaint(2, 2, lightGray, 2, size,
						darkGray);
				g2.setPaint(gp);
				g2.fillRect(2, 2, size - 4, size - 4);
			}
			
			// arrow
			g2.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
							: innerContour)
							: innerContourPressed);
			int arrowHeight = size / 4;
			int startX = size - 1 - ((size + 1) - arrowHeight) / 2;
			int startY = (size / 2) - 1;
			if (model.isPressed()) {
				startY++;
				startX++;
			}
			for (int line = 0; line < arrowHeight; line++) {
				g2.drawLine(startX - line, startY - line, startX - line, startY
						+ line);
			}

			g.drawImage(image, 0, 0, background, this);
		} else if(direction == SwingConstants.WEST) {
			// TODO real transparency
			// paint transparent corners
			Color parentColor = getParent().getParent().getBackground();
			if(getParent().getParent() instanceof JScrollPane && !getParent().getParent().isOpaque()) {
				parentColor = getParent().getParent().getParent().getBackground();
			}
			g2.setColor(parentColor);
			g2.drawLine(0, 0, 0, 0);
			g2.drawLine(0, size-1, 0, size-1);
			
			// contour
			g2.setColor(model.isEnabled() ? contour : contourDisabled);
			g2.drawLine(0, 2, 0, size - 3);
			g2.drawLine(1, 1, 1, 1);
			g2.drawLine(1, size - 2, 1, size - 2);
			g2.drawLine(2, 0, size - 2, 0);
			g2.drawLine(2, size - 1, size - 2, size - 1);
			g2.drawLine(size - 1, 1, size - 1, size - 2);
			
			// contour smoother
			g2.setColor(model.isEnabled() ? contourSmoother
					: contourDisabledSmoother);
			g2.drawLine(1, 0, 1, 0);
			g2.drawLine(0, 1, 0, 1);
			g2.drawLine(0, size - 2, 0, size - 2);
			g2.drawLine(1, size - 1, 1, size - 1);
			g2.drawLine(size - 1, 0, size - 1, 0);
			g2.drawLine(size - 1, size - 1, size - 1, size - 1);
			
			// inner lines
			g2.drawLine(2, size - 2, size - 2, size - 2);
			g2.drawLine(size - 2, 1, size - 2, size - 3);
			
			if (!isEnabled() || model.isPressed()) {
				g2.fillRect(1, 1, size - 3, size - 3);
			} else {
				// gradient
				Color lightGray = new Color(229, 231, 236);
				Color darkGray = new Color(206, 207, 213);
				GradientPaint gp = new GradientPaint(2, 2, lightGray, 2, size,
						darkGray);
				g2.setPaint(gp);
				g2.fillRect(2, 2, size - 4, size - 4);
			}
			
			// arrow
			g2.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
							: innerContour)
							: innerContourPressed);
			int arrowHeight = size / 4;
			int startX = ((size + 1) - arrowHeight) / 2;
			int startY = (size / 2) - 1;
			if (model.isPressed()) {
				startY++;
				startX++;
			}
			for (int line = 0; line < arrowHeight; line++) {
				g2.drawLine(startX + line, startY + line, startX + line, startY
						- line);
			}

			g.drawImage(image, 0, 0, background, this);
		}
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(size, size);
	}
}
