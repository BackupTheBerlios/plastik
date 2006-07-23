package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.Serializable;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.UIManager;
import javax.swing.plaf.UIResource;

public class PlastikIconFactory {

	private static boolean gotColors = false;

	private static Color contour;

	private static Color contourSmoother;

	private static Color contourDisabled;

	private static Color contourDisabledSmoother;

	private static Color innerContour;

	private static Color innerContourSmoother;
	
	private static Color innerContourPressed;

	private static Color innerContourPressedSmoother;

	private static Icon radioButtonIcon;

	private static Icon checkboxIcon;

	private static void getColors() {
		if (!gotColors) {
			contour = UIManager.getColor("Common.contour");
			contourSmoother = UIManager.getColor("Common.contourSmoother");
			innerContour = UIManager.getColor("Common.innerContour");
			innerContourSmoother = UIManager.getColor("Common.innerContourSmoother");
			innerContourPressed = UIManager.getColor("Common.innerContourPressed");
			innerContourPressedSmoother = UIManager.getColor("Common.innerContourSmootherPressed");
			contourDisabled = UIManager.getColor("Common.contourDisabled");
			contourDisabledSmoother = UIManager.getColor("Common.contourDisabledSmoother");

			gotColors = true;
		}
	}

	public static Icon getCheckboxIcon() {
		if (checkboxIcon == null) {
			checkboxIcon = new CheckboxIcon();
		}
		return checkboxIcon;
	}

	public static Icon getRadioButtonIcon() {
		if (radioButtonIcon == null) {
			radioButtonIcon = new RadioButtonIcon();
		}
		return radioButtonIcon;
	}

	private static class RadioButtonIcon implements Icon, UIResource,
			Serializable {

		public int getIconHeight() {
			return 13;
		}

		public int getIconWidth() {
			return 13;
		}

		public void paintIcon(Component c, Graphics g, int x, int y) {
			getColors();
			Graphics2D g2 = (Graphics2D) g;
			AbstractButton button = (AbstractButton)c;
			ButtonModel model = button.getModel();

			// fill radiobutton
			if(model.isEnabled()) {
				Gradients.drawRoundGradient(g, new Rectangle(x, y, 13, 13),
					new Color(252, 252, 252), new Color(236, 236, 236));
			} else {
				g2.setColor(button.getBackground());
				g2.fillOval(x, y, 13, 13);
			}

			g2.translate(x, y);
			// draw contour
			g2.setColor(contourSmoother);
			g2.drawLine(3, 0, 3, 0);
			g2.drawLine(9, 0, 9, 0); // line 1
			g2.drawLine(4, 1, 4, 1);
			g2.drawLine(8, 1, 8, 1); // line 2
			g2.drawLine(2, 2, 2, 2);
			g2.drawLine(10, 2, 10, 2); // line 3
			g2.drawLine(0, 3, 0, 3);
			g2.drawLine(12, 3, 12, 3); // line 4
			g2.drawLine(1, 4, 1, 4);
			g2.drawLine(11, 4, 11, 4); // line 5
			g2.drawLine(1, 8, 1, 8);
			g2.drawLine(11, 8, 11, 8); // line 9
			g2.drawLine(0, 9, 0, 9);
			g2.drawLine(12, 9, 12, 9); // line 10
			g2.drawLine(2, 10, 2, 10);
			g2.drawLine(10, 10, 10, 10); // line 11
			g2.drawLine(4, 11, 4, 11);
			g2.drawLine(8, 11, 8, 11); // line 12
			g2.drawLine(3, 12, 3, 12);
			g2.drawLine(9, 12, 9, 12); // line 13

			g2.setColor(contour);
			g2.drawLine(4, 0, 8, 0); // line 1
			g2.drawLine(2, 1, 3, 1);
			g2.drawLine(9, 1, 10, 1); // line 2
			g2.drawLine(1, 2, 1, 3);
			g2.drawLine(11, 2, 11, 3); // lines 3 & 4
			g2.drawLine(0, 4, 0, 8);
			g2.drawLine(12, 4, 12, 8); // lines 5 - 9
			g2.drawLine(1, 9, 1, 10);
			g2.drawLine(11, 9, 11, 10); // lines 10 & 11
			g2.drawLine(2, 11, 3, 11);
			g2.drawLine(9, 11, 10, 11); // line 12
			g2.drawLine(4, 12, 8, 12); // line 13
			
			if(model.isPressed()) {
				g2.setColor(innerContourPressedSmoother);
				g2.drawLine(4, 3, 4, 3);
				g2.drawLine(8, 3, 8, 3); // line 4
				g2.drawLine(3, 4, 3, 4);
				g2.drawLine(5, 4, 7, 4);
				g2.drawLine(9, 4, 9, 4); // line 5
				g2.drawLine(4, 5, 5, 5); // line 6
				g2.drawLine(4, 6, 4, 6); // line 7
				g2.drawLine(4, 7, 4, 7); // line 8
				g2.drawLine(3, 8, 3, 8);
				g2.drawLine(9, 8, 9, 8); // line 9
				g2.drawLine(4, 9, 4, 9);
				g2.drawLine(8, 9, 8, 9); // line 10
				g2.setColor(innerContourPressed);
				g2.drawLine(5, 3, 7, 3); // line 4
				g2.drawLine(4, 4, 4, 4);
				g2.drawLine(8, 4, 8, 4); // line 5
				g2.drawLine(3, 5, 3, 5);
				g2.drawLine(6, 5, 9, 5); // line 6
				g2.drawLine(3, 6, 3, 6);
				g2.drawLine(5, 6, 9, 6); // line 7
				g2.drawLine(3, 7, 3, 7);
				g2.drawLine(5, 7, 9, 7); // line 8
				g2.drawLine(4, 8, 8, 8); // line 9
				g2.drawLine(5, 9, 7, 9); // line 4
			} else if(model.isSelected()) {
				if(model.isEnabled() && !model.isPressed()) {
					g2.setColor(innerContourSmoother);
					g2.drawLine(4, 3, 4, 3);
					g2.drawLine(8, 3, 8, 3); // line 4
					g2.drawLine(3, 4, 3, 4);
					g2.drawLine(9, 4, 9, 4); // line 5
					g2.drawLine(3, 8, 3, 8);
					g2.drawLine(9, 8, 9, 8); // line 9
					g2.drawLine(4, 9, 4, 9);
					g2.drawLine(8, 9, 8, 9); // line 10
					g2.setColor(innerContour);
					g2.drawLine(5, 3, 7, 3); // line 4
					g2.drawLine(4, 4, 8, 4); // line 5
					g2.drawLine(3, 5, 9, 5); // line 6
					g2.drawLine(3, 6, 9, 6); // line 7
					g2.drawLine(3, 7, 9, 7); // line 8
					g2.drawLine(4, 8, 8, 8); // line 9
					g2.drawLine(5, 9, 7, 9); // line 4
				} else {
					g2.setColor(contourDisabledSmoother);
					g2.drawLine(4, 3, 4, 3);
					g2.drawLine(8, 3, 8, 3); // line 4
					g2.drawLine(3, 4, 3, 4);
					g2.drawLine(5, 4, 7, 4);
					g2.drawLine(9, 4, 9, 4); // line 5
					g2.drawLine(4, 5, 5, 5); // line 6
					g2.drawLine(4, 6, 4, 6); // line 7
					g2.drawLine(4, 7, 4, 7); // line 8
					g2.drawLine(3, 8, 3, 8);
					g2.drawLine(9, 8, 9, 8); // line 9
					g2.drawLine(4, 9, 4, 9);
					g2.drawLine(8, 9, 8, 9); // line 10
					g2.setColor(contourDisabled);
					g2.drawLine(5, 3, 7, 3); // line 4
					g2.drawLine(4, 4, 4, 4);
					g2.drawLine(8, 4, 8, 4); // line 5
					g2.drawLine(3, 5, 3, 5);
					g2.drawLine(6, 5, 9, 5); // line 6
					g2.drawLine(3, 6, 3, 6);
					g2.drawLine(5, 6, 9, 6); // line 7
					g2.drawLine(3, 7, 3, 7);
					g2.drawLine(5, 7, 9, 7); // line 8
					g2.drawLine(4, 8, 8, 8); // line 9
					g2.drawLine(5, 9, 7, 9); // line 4
				}
			}
		
			g2.translate(-x, -y);
		}
	}

	private static class CheckboxIcon implements Icon, UIResource, Serializable {

		public int getIconHeight() {
			return 13;
		}

		public int getIconWidth() {
			return 13;
		}

		public void paintIcon(Component c, Graphics g, int x, int y) {
			getColors();
			Graphics2D g2 = (Graphics2D) g;
			AbstractButton button = (AbstractButton)c;
			ButtonModel model = button.getModel();

			// fill checkbox
			if(model.isEnabled()) {
				Gradients.drawBoxGradient(g, new Rectangle(x, y, 13, 13),
						new Color(252, 252, 252), new Color(236, 236, 236));
			} else {
				g2.setColor(button.getBackground());
				g2.fillRect(x, y, 13, 13);
			}

			g2.translate(x, y);
			g2.setColor(contourSmoother);
			g2.drawLine(0, 0, 0, 0);
			g2.drawLine(12, 0, 12, 0);
			g2.drawLine(0, 12, 0, 12);
			g2.drawLine(12, 12, 12, 12);
			g2.setColor(contour);
			g2.drawLine(1, 0, 11, 0);
			g2.drawLine(0, 1, 0, 11);
			g2.drawLine(12, 1, 12, 11);
			g2.drawLine(1, 12, 11, 12);
			
			if(model.isPressed()) {
				g2.setColor(innerContourPressed);
				g2.drawLine(3, 2, 10, 9);
				g2.drawLine(3, 3, 9, 9);
				g2.drawLine(2, 3, 9, 10);
				g2.drawLine(2, 9, 2, 9);
				g2.drawLine(3, 8, 3, 8);
				g2.drawLine(4, 7, 4, 7);
				g2.drawLine(7, 4, 7, 4);
				g2.drawLine(8, 3, 8, 3);
				g2.drawLine(9, 2, 9, 2);
				g2.drawLine(3, 9, 3, 9);
				g2.drawLine(4, 8, 4, 8);
				g2.drawLine(5, 7, 5, 7);
				g2.drawLine(7, 5, 7, 5);
				g2.drawLine(8, 4, 8, 4);
				g2.drawLine(9, 3, 9, 3);
				g2.drawLine(3, 10, 3, 10);
				g2.drawLine(4, 9, 4, 9);
				g2.drawLine(5, 8, 5, 8);
				g2.drawLine(8, 5, 8, 5);
				g2.drawLine(9, 4, 9, 4);
				g2.drawLine(10, 3, 10, 3);
				g.setColor(innerContourPressedSmoother);
				g2.drawLine(2, 2, 2, 2);
				g2.drawLine(2, 10, 2, 10);
				g2.drawLine(10, 2, 10, 2);
				g2.drawLine(10, 10, 10, 10);
				g2.drawLine(4, 2, 6, 4);
				g2.drawLine(2, 4, 4, 6);
				g2.drawLine(8, 6, 10, 8);
				g2.drawLine(6, 8, 8, 10);
				g2.drawLine(2, 8, 2, 8);
				g2.drawLine(3, 7, 3, 7);
				g2.drawLine(8, 2, 8, 2);
				g2.drawLine(7, 3, 7, 3);
				g2.drawLine(4, 10, 4, 10);
				g2.drawLine(5, 9, 5, 9);
				g2.drawLine(10, 4, 10, 4);
			} else if(model.isSelected()) {
				if(model.isEnabled()) {
					g2.setColor(innerContour);
					g2.drawLine(3, 2, 10, 9);
					g2.drawLine(3, 3, 9, 9);
					g2.drawLine(2, 3, 9, 10);
					g2.drawLine(2, 9, 2, 9);
					g2.drawLine(3, 8, 3, 8);
					g2.drawLine(4, 7, 4, 7);
					g2.drawLine(7, 4, 7, 4);
					g2.drawLine(8, 3, 8, 3);
					g2.drawLine(9, 2, 9, 2);
					g2.drawLine(3, 9, 3, 9);
					g2.drawLine(4, 8, 4, 8);
					g2.drawLine(5, 7, 5, 7);
					g2.drawLine(7, 5, 7, 5);
					g2.drawLine(8, 4, 8, 4);
					g2.drawLine(9, 3, 9, 3);
					g2.drawLine(3, 10, 3, 10);
					g2.drawLine(4, 9, 4, 9);
					g2.drawLine(5, 8, 5, 8);
					g2.drawLine(8, 5, 8, 5);
					g2.drawLine(9, 4, 9, 4);
					g2.drawLine(10, 3, 10, 3);
					g.setColor(innerContourSmoother);
					g2.drawLine(2, 2, 2, 2);
					g2.drawLine(2, 10, 2, 10);
					g2.drawLine(10, 2, 10, 2);
					g2.drawLine(10, 10, 10, 10);
					g2.drawLine(4, 2, 6, 4);
					g2.drawLine(2, 4, 4, 6);
					g2.drawLine(8, 6, 10, 8);
					g2.drawLine(6, 8, 8, 10);
					g2.drawLine(2, 8, 2, 8);
					g2.drawLine(3, 7, 3, 7);
					g2.drawLine(8, 2, 8, 2);
					g2.drawLine(7, 3, 7, 3);
					g2.drawLine(4, 10, 4, 10);
					g2.drawLine(5, 9, 5, 9);
					g2.drawLine(10, 4, 10, 4);
				} else {
					g2.setColor(contourDisabled);
					g2.drawLine(3, 2, 10, 9);
					g2.drawLine(3, 3, 9, 9);
					g2.drawLine(2, 3, 9, 10);
					g2.drawLine(2, 9, 2, 9);
					g2.drawLine(3, 8, 3, 8);
					g2.drawLine(4, 7, 4, 7);
					g2.drawLine(7, 4, 7, 4);
					g2.drawLine(8, 3, 8, 3);
					g2.drawLine(9, 2, 9, 2);
					g2.drawLine(3, 9, 3, 9);
					g2.drawLine(4, 8, 4, 8);
					g2.drawLine(5, 7, 5, 7);
					g2.drawLine(7, 5, 7, 5);
					g2.drawLine(8, 4, 8, 4);
					g2.drawLine(9, 3, 9, 3);
					g2.drawLine(3, 10, 3, 10);
					g2.drawLine(4, 9, 4, 9);
					g2.drawLine(5, 8, 5, 8);
					g2.drawLine(8, 5, 8, 5);
					g2.drawLine(9, 4, 9, 4);
					g2.drawLine(10, 3, 10, 3);
					g.setColor(contourDisabledSmoother);
					g2.drawLine(2, 2, 2, 2);
					g2.drawLine(2, 10, 2, 10);
					g2.drawLine(10, 2, 10, 2);
					g2.drawLine(10, 10, 10, 10);
					g2.drawLine(4, 2, 6, 4);
					g2.drawLine(2, 4, 4, 6);
					g2.drawLine(8, 6, 10, 8);
					g2.drawLine(6, 8, 8, 10);
					g2.drawLine(2, 8, 2, 8);
					g2.drawLine(3, 7, 3, 7);
					g2.drawLine(8, 2, 8, 2);
					g2.drawLine(7, 3, 7, 3);
					g2.drawLine(4, 10, 4, 10);
					g2.drawLine(5, 9, 5, 9);
					g2.drawLine(10, 4, 10, 4);
				}
			}
		
			g2.translate(-x, -y);
		}
	}
}