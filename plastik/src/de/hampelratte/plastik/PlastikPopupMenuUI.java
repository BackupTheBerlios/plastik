package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicPopupMenuUI;

import de.hampelratte.plastik.theme.PlastikColorTheme;

public class PlastikPopupMenuUI extends BasicPopupMenuUI {
	
	public PlastikPopupMenuUI() {
	}
	
	public static ComponentUI createUI(JComponent c) {
		return new PlastikPopupMenuUI();
	}
	
	public void update(Graphics g, JComponent c) {
		paint(g, c);
	}
	
	public void paint(Graphics g, JComponent c) {
		Graphics2D g2d = (Graphics2D) g;
		// storing original anitalising flag
		Object state = null;
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			state = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
			if (state != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			}
		}
		
		paintBackground(g, c);
		super.paint(g, c);
		
		// restoring antialising flag
		if (state != null) {
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, state);
		}
	}
	
	public void paintBackground(Graphics g, JComponent c) {
        int menuWidth = c.getWidth();
        int menuHeight = c.getHeight();
		PlastikColorTheme colorTheme = PlastikLookAndFeel.getTheme().getColorTheme();

		Color oldColor = g.getColor();
		g.setColor(colorTheme.getColor(PlastikColorTheme.POPUP_MENU | PlastikColorTheme.BACKGROUND));
		g.fillRect(0, 0, menuWidth, menuHeight);
		
		g.setColor(oldColor);
	}
}