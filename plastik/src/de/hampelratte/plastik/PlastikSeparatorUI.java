package de.hampelratte.plastik;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSeparatorUI;

import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikSeparatorUI extends BasicSeparatorUI {

	public static ComponentUI createUI(JComponent c) {
		return new PlastikSeparatorUI();
	}

	public void paint(Graphics g, JComponent c) {
		Dimension s = c.getSize();

		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();
		g.setColor(colorTheme.getColor(PlastikColorTheme.MENU_ITEM | PlastikColorTheme.BACKGROUND));
		
		if (((JSeparator) c).getOrientation() == JSeparator.VERTICAL) {
			g.drawLine(0, 0, 0, s.height);
			g.drawLine(1, 0, 1, s.height);
			g.setColor(c.getBackground());
			g.drawLine(1, 4, 1, s.height-4);
		} else { // HORIZONTAL
			g.drawLine(0, 0, s.width, 0);
			g.drawLine(0, 1, s.width, 1);
			g.setColor(c.getBackground());
			g.drawLine(4, 1, s.width-4, 1);
		}
	}
	
	public Dimension getPreferredSize(JComponent c) {
		if (((JSeparator) c).getOrientation() == JSeparator.VERTICAL)
			return new Dimension(2, 0);
		else
			return new Dimension(0, 2);
	}
}
