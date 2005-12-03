package de.hampelratte.plastik;

import de.hampelratte.plastik.theme.PlastikColorTheme;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicToggleButtonUI;
import javax.swing.text.View;

public class PlastikToggleButtonUI extends BasicToggleButtonUI {
	
	private static final PlastikToggleButtonUI TOGGLE_BUTTON_UI = new PlastikToggleButtonUI();
	
	private static Rectangle viewRect  = new Rectangle();
    private static Rectangle textRect  = new Rectangle();
    private static Rectangle iconRect  = new Rectangle();
	private static Rectangle focusRect = new Rectangle();
	
	/**
	 * Der Konstruktor ist protected, da er nur von Subklassen überschrieben
	 * oder aufgerufen werden sollte.
	 */
	protected PlastikToggleButtonUI() {
		super();
	}
	
	public static ComponentUI createUI(JComponent c) {
		return TOGGLE_BUTTON_UI;
	}
	
	public void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		
		Object obj;
		obj = PlastikLookAndFeel.getDefaultOpacity() ? Boolean.TRUE : Boolean.FALSE;
		LookAndFeel.installProperty(b, "opaque", obj);
		
		obj = PlastikLookAndFeel.isRolloverEnabled() ? Boolean.TRUE : Boolean.FALSE;
		LookAndFeel.installProperty(b, "rolloverEnabled", obj);
	}	
	
	public void uninstallDefaults(AbstractButton b) {
		super.uninstallDefaults(b);
		// this is more secure
		LookAndFeel.installProperty(b, "opaque", Boolean.TRUE);
		LookAndFeel.installProperty(b, "rolloverEnabled", Boolean.FALSE);
	}
		
	public void update(Graphics g, JComponent c) {
		
		// if opaque, then fill the background with the parents background-color
		if (c.isOpaque()) {
			Component parent = c.getParent();
			if (parent != null) {
				g.setColor(parent.getBackground());
				g.fillRect(0, 0, c.getWidth(), c.getHeight());
			}
		}
		paint(g, c);
	}
	
	public void paint(Graphics g, JComponent c) {
		AbstractButton b     = (AbstractButton) c;
        ButtonModel    model = b.getModel();
        FontMetrics    fm    = g.getFontMetrics();
        Insets         i     = c.getInsets();
        Font           f     = c.getFont();

        viewRect.x      = i.left;
        viewRect.y      = i.top;
        viewRect.width  = b.getWidth()  - (i.right  + viewRect.x);
        viewRect.height = b.getHeight() - (i.bottom + viewRect.y);

        textRect.x = textRect.y = textRect.width = textRect.height = 0;
        iconRect.x = iconRect.y = iconRect.width = iconRect.height = 0;
		
		 // layout the text and icon
        String text = SwingUtilities.layoutCompoundLabel(
			c, fm, b.getText(), b.getIcon(), 
			b.getVerticalAlignment(), b.getHorizontalAlignment(),
			b.getVerticalTextPosition(), b.getHorizontalTextPosition(),
			viewRect, iconRect, textRect, 
			b.getText() == null ? 0 : b.getIconTextGap()
		);
		
		// painting background
		paintBackground(g, b, model);
		
		// painting icon 
        if (b.getIcon() != null)
			paintIcon(g, c, iconRect);
		
		// painting text
		if (text != null && !text.equals("")) {
			
			Graphics2D g2d = (Graphics2D) g;
			
			// storing original anitalising flag
			Object state = null;
			if (PlastikLookAndFeel.isTextAntialiasing()) {
				state = g2d.getRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING);
				if (state != RenderingHints.VALUE_TEXT_ANTIALIAS_ON) {
					g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
				}
			}
			
			View v = (View) c.getClientProperty(BasicHTML.propertyKey);
			if (v != null) {
				v.paint(g, textRect);
			} else {
				paintText(g, b, textRect, text);
			}
			
			// restoring antialising flag
			if (state != null) {
				g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, state);
			}
		}
		
        // painting focus
        if (b.isFocusPainted() && b.hasFocus()) {
            paintFocus(g,b,viewRect,textRect,iconRect);
        }
	}
	
	private static final int BACKGROUND
			= PlastikColorTheme.TOGGLE_BUTTON
			| PlastikColorTheme.BACKGROUND_COMPONENT;
	
	private static final int BACKGROUND_INACTIVE
			= PlastikColorTheme.TOGGLE_BUTTON
			| PlastikColorTheme.BACKGROUND_COMPONENT
			| PlastikColorTheme.INACTIVE;
	
	private static final int BACKGROUND_PRESSED
			= PlastikColorTheme.TOGGLE_BUTTON
			| PlastikColorTheme.BACKGROUND_PRESSED;
	
	private static final int BACKGROUND_PRESSED_INACTIVE
			= PlastikColorTheme.TOGGLE_BUTTON
			| PlastikColorTheme.BACKGROUND_PRESSED
			| PlastikColorTheme.INACTIVE;
	
	protected void paintBackground(Graphics g, AbstractButton b, ButtonModel model) {
		if (b.isContentAreaFilled()) {
			Color background = b.getBackground();
			PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
			Color top    = null;
			Color bottom = null;
			if (!model.isEnabled()) {
				if (model.isSelected()) {
					top    = theme.getColor(background, BACKGROUND_PRESSED_INACTIVE | PlastikColorTheme.DARKER_GRADIENT);
					bottom = theme.getColor(background, BACKGROUND_PRESSED_INACTIVE | PlastikColorTheme.BRIGHTER_GRADIENT);
				} else {
					top    = theme.getColor(background, BACKGROUND_INACTIVE | PlastikColorTheme.BRIGHTER_GRADIENT);
					bottom = theme.getColor(background, BACKGROUND_INACTIVE | PlastikColorTheme.DARKER_GRADIENT);
				}
			} else if ((model.isArmed() && model.isPressed()) || model.isSelected()) {
				top    = theme.getColor(background, BACKGROUND_PRESSED | PlastikColorTheme.DARKER_GRADIENT);
				bottom = theme.getColor(background, BACKGROUND_PRESSED | PlastikColorTheme.BRIGHTER_GRADIENT);
			} else {
				top    = theme.getColor(background, BACKGROUND | PlastikColorTheme.BRIGHTER_GRADIENT);
				bottom = theme.getColor(background, BACKGROUND | PlastikColorTheme.DARKER_GRADIENT);
			}
			Gradients.drawBoxGradient(g, viewRect, top, bottom);
		}
	}
	
	private static final int FOREGROUND
			= PlastikColorTheme.BUTTON
			| PlastikColorTheme.FOREGROUND_COMPONENT;
	
	private static final int FOREGROUND_INACTIVE
			= PlastikColorTheme.BUTTON
			| PlastikColorTheme.FOREGROUND_COMPONENT
			| PlastikColorTheme.INACTIVE;
	
	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        ButtonModel model = b.getModel();
        FontMetrics fm    = g.getFontMetrics();
        int mnemonicIndex = b.getDisplayedMnemonicIndex();
		int textStep = ((model.isArmed() && model.isPressed()) || model.isSelected()) ? 1 : 0;
		Color foreground = b.getForeground();
		PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
		if (model.isEnabled()) {
			g.setColor(theme.getColor(foreground, FOREGROUND));
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + textStep, textRect.y + fm.getAscent() + textStep);
		} else {
			Color background = b.getBackground();
			g.setColor(theme.getColor(background, FOREGROUND_INACTIVE | PlastikColorTheme.BRIGHTER));
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + 1 + textStep, textRect.y + fm.getAscent() + 1 + textStep);
			g.setColor(theme.getColor(foreground, FOREGROUND_INACTIVE | PlastikColorTheme.DARKER));
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + textStep, textRect.y + fm.getAscent() + textStep);
		}
    }
		
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
		focusRect.setBounds(viewRect);
		
		focusRect.x += 2;
		focusRect.y += 2;
		focusRect.width  -= 5;
		focusRect.height -= 5;
		
		PlastikColorTheme theme = PlastikLookAndFeel.getTheme().getColorTheme();
		Color color = theme.getColor(PlastikColorTheme.BUTTON | PlastikColorTheme.FOCUS);
		g.setColor(color);
		
		Graphics2D g2d = (Graphics2D) g;
		float[] dashes = { 1f, 1f };
		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 1.0f, dashes, 1.0f);
		g2d.setStroke(stroke);
		g2d.drawRect(focusRect.x, focusRect.y, focusRect.width, focusRect.height);		
	}
	
	public Dimension getPreferredSize(JComponent c) {
		Dimension d = super.getPreferredSize(c);
		AbstractButton b = (AbstractButton) c;
		Insets margin = b.getMargin();
		if (margin != null) {
			d.width += margin.left + margin.right;
			d.height += margin.top + margin.bottom;
		}
		return d;
	}
}