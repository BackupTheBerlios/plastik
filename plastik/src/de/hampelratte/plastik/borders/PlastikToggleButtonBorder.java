package de.hampelratte.plastik.borders;

import de.hampelratte.plastik.PlastikLookAndFeel;
import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JButton;
import javax.swing.border.AbstractBorder;
import javax.swing.plaf.UIResource;

public class PlastikToggleButtonBorder extends AbstractBorder implements UIResource {
	
	// TODO use TOGGLE_BUTTON instead of BUTTON
	
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
		AbstractButton button = (AbstractButton) c;
		ButtonModel model = button.getModel();
		PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
		
		g.translate(x, y);
		int x1 = 0, y1 = 0;
		int x2 = width-1, y2 = height-1;
		
		if (button instanceof JButton && ((JButton)button).isDefaultButton()) {
			g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND | PlastikColorTheme.DARKER));
			drawRoundRect(g, x1, y1, x2, y2);
			g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND | PlastikColorTheme.DARKER_GRADIENT));
			drawRoundRectCorners(g, x1, y1, x2, y2);
			x1++; y1++;	x2--; y2--;
		}
		
		g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BORDER));
		drawRoundRect(g, x1, y1, x2, y2);
		g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.BORDER | PlastikColorTheme.BRIGHTER));
		drawRoundRectCorners(g, x1, y1, x2, y2);
		
		if (button.isContentAreaFilled()) {
			Color top, bottom;
			Color background = button.getBackground();
			if (!model.isEnabled()) {
				if (model.isSelected()) {
					top    = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_PRESSED | PlastikColorTheme.INACTIVE | PlastikColorTheme.BRIGHTER);
					bottom = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_PRESSED | PlastikColorTheme.INACTIVE | PlastikColorTheme.DARKER);
				} else {
					top    = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_COMPONENT | PlastikColorTheme.INACTIVE | PlastikColorTheme.BRIGHTER);
					bottom = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_COMPONENT | PlastikColorTheme.INACTIVE | PlastikColorTheme.DARKER);
				}
			} else if ((model.isArmed() && model.isPressed()) || model.isSelected()) {
				top    = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_PRESSED | PlastikColorTheme.BRIGHTER);
				bottom = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_PRESSED | PlastikColorTheme.DARKER);
			} else {
				top    = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_COMPONENT | PlastikColorTheme.BRIGHTER);
				bottom = theme.getColor(background, PlastikColorTheme.BUTTON | PlastikColorTheme.BACKGROUND_COMPONENT | PlastikColorTheme.DARKER);
			}

			g.setColor(top);
			g.drawLine(x1+2, y1+1, x2-2, y1+1);
			g.drawLine(x1+1, y1+2, x1+1, y2-2);

			g.setColor(bottom);
			g.drawLine(x1+2, y2-1, x2-2, y2-1);
			g.drawLine(x2-1, y1+2, x2-1, y2-2);
		}
		
		if (button.isEnabled() && !model.isPressed() && button.isRolloverEnabled() && model.isRollover() && !model.isSelected()) {
			g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.ROLLOVER));
			g.drawLine(x1+2, y1+1, x2-2, y1+1);
			g.drawLine(x1+2, y2-1, x2-2, y2-1);
			
			g.setColor(theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.ROLLOVER | PlastikColorTheme.BRIGHTER));
			g.drawLine(x1+1, y1+2, x2-1, y1+2);
			g.drawLine(x1+1, y2-2, x2-1, y2-2);
		}
		
		g.translate(-x, -y);
	}
	
	private void drawRoundRect(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(x1+1, y1+1, x1+1, y1+1);
		g.drawLine(x1+2, y1,   x2-2, y1);
		g.drawLine(x2-1, y1+1, x2-1, y1+1);
		g.drawLine(x2,   y1+2, x2,   y2-2);
		g.drawLine(x2-1, y2-1, x2-1, y2-1);
		g.drawLine(x2-2, y2,   x1+2, y2);
		g.drawLine(x1+1, y2-1, x1+1, y2-1);
		g.drawLine(x1,   y2-2, x1,   y1+2);		
	}
	
	private void drawRoundRectCorners(Graphics g, int x1, int y1, int x2, int y2) {
		g.drawLine(x1,   y1+1, x1+1, y1);
		g.drawLine(x2-1, y1,   x2,   y1+1);
		g.drawLine(x2-1, y2,   x2,   y2-1);
		g.drawLine(x1,   y2-1, x1+1, y2);		
	}

	public Insets getBorderInsets(Component c) {
		return getBorderInsets(c, new Insets(0, 0, 0, 0));
	}

	public Insets getBorderInsets(Component c, Insets insets) {
		insets.top = insets.left = insets.right = insets.bottom = 2;
		return insets;
	}
}