package de.hampelratte.plastik;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuSeparatorUI;

public class PlastikPopupMenuSeparatorUI extends BasicPopupMenuSeparatorUI {

	public static ComponentUI createUI(JComponent c) {
		return new PlastikPopupMenuSeparatorUI();
	}

	public void paint(Graphics g, JComponent c) {
		Dimension s = c.getSize();

		g.setColor(c.getBackground());
		g.drawLine(4, 0, s.width-4, 0);
	}
	
	public Dimension getPreferredSize(JComponent c) {
		return new Dimension(0, 1);
	}
}
