package de.hampelratte.plastik;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalToolTipUI;

public class PlastikToolTipUI extends MetalToolTipUI {
	public static ComponentUI createUI(JComponent c) {
		return new PlastikToolTipUI();
	}

	public void paint(Graphics g, JComponent c) {
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paint(g,c);
	}
}
