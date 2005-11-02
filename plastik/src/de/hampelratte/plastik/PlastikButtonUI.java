package de.hampelratte.plastik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.metal.MetalButtonUI;

//TODO text beim drücken verschieben
public class PlastikButtonUI extends MetalButtonUI {

	private static final PlastikButtonUI plastikButtonUI = new PlastikButtonUI();

	private boolean defaults_initialized = false;

	private Color focusColor;

	private Color backgroundColor;

	public static ComponentUI createUI(JComponent c) {
		return plastikButtonUI;
	}

	public void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		if (!defaults_initialized) {
			b.setRolloverEnabled(true);
			focusColor = UIManager.getColor("Common.focus");
			backgroundColor = UIManager.getColor("Common.background");
			defaults_initialized = true;
		}
		b.setOpaque(false);
	}

	public void update(Graphics g, JComponent c) {
		AbstractButton button = (AbstractButton) c;
		ButtonModel model = button.getModel();

		// draw background
		Rectangle rect = c.getVisibleRect();
		Insets i = c.getInsets();
		rect.x = i.left;
		rect.y = i.top;
		rect.width = c.getWidth() - (i.right + rect.x);
		rect.height = c.getHeight() - (i.bottom + rect.y);
        g.setColor(backgroundColor);
		g.fillRect(rect.x, rect.y, rect.width, rect.height);

		if (button.isEnabled()) {
			// draw gradient
			if (!model.isPressed()) {
				Color lightGray = new Color(229, 231, 236); // TODO ins laf
				Color darkGray = new Color(206, 207, 213);
				Gradients.drawBoxGradient(g, rect, lightGray, darkGray);
			}
		} else {
			Graphics2D g2 = (Graphics2D) g;
			g2.setColor(backgroundColor);
			g2.fillRoundRect((int) rect.getX(), (int) rect.getY(), (int) rect
					.getWidth() - 1, (int) rect.getHeight() - 1, 4, 4);
		}
		
		if(PlastikLookAndFeel.isTextAntialiasing()) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
	                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		super.paint(g, c);
	}
	
	protected void paintButtonPressed(Graphics g, AbstractButton b) {
		Rectangle rect = b.getVisibleRect();
		Insets i = b.getInsets();
		rect.x = i.left;
		rect.y = i.top;
		rect.width = b.getWidth() - (i.right + rect.x);
		rect.height = b.getHeight() - (i.bottom + rect.y);
		Color color1 = new Color(182, 185, 189);
		Color color2 = new Color(189, 191, 195);
		Gradients.drawBoxGradient(g, rect, color1, color2);
	}

	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect,
			Rectangle textRect, Rectangle iconRect) {
		g.setColor(focusColor);
		Graphics2D g2 = (Graphics2D) g;
		float[] dashes = { 0.2f };
		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 1.0f, dashes, 1.0f);
		g2.setStroke(stroke);
		g.drawRect(textRect.x - 2, textRect.y, textRect.width + 2,
				textRect.height - 1);
	}
}
