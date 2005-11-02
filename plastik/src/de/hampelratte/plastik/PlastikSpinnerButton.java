package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.hampelratte.plastik.borders.PlastikSpinnerButtonBorder;

//FIXME button wird beim ersten drücken zu hell (wie disabled)
public class PlastikSpinnerButton extends JButton {

	private int orientation = 0;

	private int arrowHeight = 4;

	private Color innerContour = UIManager.getColor("Common.innerContour");

	private Color innerContourPressed = UIManager
			.getColor("Common.innerContourPressed");

	public PlastikSpinnerButton(int orientation, PlastikSpinnerUI spinnerUI, JSpinner spinner) {
		this.orientation = orientation;
		this.setBorder(new PlastikSpinnerButtonBorder(orientation, this,
						spinnerUI, spinner));
		this.setPreferredSize(new Dimension(17, 13));
		this.setRolloverEnabled(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintArrow(g, orientation);
	}

	private void paintArrow(Graphics g, int orientation) {
		if (orientation == SwingConstants.NORTH) {
			g.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
							: innerContour)
							: innerContourPressed);
			int startY = ((getHeight() + 1) - arrowHeight) / 2;
			int startX = (getWidth() / 2);
			for (int line = 0; line < arrowHeight; line++) {
				g.drawLine(startX - line, startY + line, startX + line, startY
						+ line);
			}
		} else {
			g.setColor(model.isEnabled() ? (model.isPressed() ? innerContourPressed
					: innerContour)
					: innerContourPressed);
			int startY = getHeight() - 1 - ((getHeight() + 1) - arrowHeight) / 2;
			int startX = (getWidth() / 2);
			
			for (int line = 0; line < arrowHeight; line++) {
				g.drawLine(startX - line, startY - line, startX + line, startY
						- line);
			}
		}
	}
}
