package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;

public class PlastikCheckBoxUI extends PlastikRadioButtonUI {

	private static final PlastikCheckBoxUI checkboxUI = new PlastikCheckBoxUI();

	public static ComponentUI createUI(JComponent c) {
		return checkboxUI;
	}

	protected void installIcons(AbstractButton b) {
		b.setIcon(PlastikIconFactory.getCheckboxIcon());
	}
	
	protected void uninstallIcons(AbstractButton b) {
		b.setIcon(null);
	}
	
	protected void paintHighlight(Graphics g, Rectangle iconRect) {
		Graphics2D g2 = (Graphics2D)g;
		Color highlight = UIManager.getColor("Common.highlight");
		Color highlightSmoother = UIManager.getColor("Common.highlightSmoother");
		g2.translate(iconRect.x, iconRect.y);
		g2.setColor(highlight);
		g2.drawRect(1,1,10,10);
		g2.setColor(highlightSmoother);
		g2.drawRect(2,2,8,8);
		g2.translate(-iconRect.x, -iconRect.y);
	}
}