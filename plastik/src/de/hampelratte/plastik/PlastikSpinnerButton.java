package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import de.hampelratte.plastik.borders.PlastikSpinnerButtonBorder;

//FIXME button wird beim ersten drücken zu hell (wie disabled)
public class PlastikSpinnerButton extends JButton implements MouseListener {

	private int orientation = 0;

	private int arrowHeight = 4;

	private Color innerContour = UIManager.getColor("Common.innerContour");

	private Color innerContourPressed = UIManager
			.getColor("Common.innerContourPressed");
	
	private PlastikSpinnerUI spinnerUI;

	public PlastikSpinnerButton(int orientation, PlastikSpinnerUI spinnerUI, JSpinner spinner) {
		this.orientation = orientation;
		this.spinnerUI = spinnerUI;
		this.setBorder(new PlastikSpinnerButtonBorder(orientation, this,
						spinnerUI, spinner));
		this.setPreferredSize(new Dimension(17, 13));
		if(PlastikLookAndFeel.isRolloverEnabled()) {
			this.setRolloverEnabled(true);
		}
		this.addMouseListener(this);
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


	public void mouseEntered(MouseEvent e) {
		spinnerUI.getPreviousButton().getModel().setRollover(true);
		spinnerUI.getPreviousButton().repaint();
		spinnerUI.getNextButton().getModel().setRollover(true);
		spinnerUI.getNextButton().repaint();
	}

	public void mouseExited(MouseEvent e) {
		spinnerUI.getPreviousButton().getModel().setRollover(false);
		spinnerUI.getPreviousButton().repaint();
		spinnerUI.getNextButton().getModel().setRollover(false);
		spinnerUI.getNextButton().repaint();
	}

	public void mousePressed(MouseEvent e) {
		spinnerUI.getEditor().putClientProperty("focus", Boolean.TRUE);
		spinnerUI.getEditor().repaint();
	}

	public void mouseReleased(MouseEvent e) {
		
	}
	
	public void mouseClicked(MouseEvent e) {
		
	}
}
