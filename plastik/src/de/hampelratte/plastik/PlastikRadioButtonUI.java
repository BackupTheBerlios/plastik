package de.hampelratte.plastik;

import java.awt.BasicStroke;
import java.awt.Color;
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
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.plaf.basic.BasicRadioButtonUI;
import javax.swing.text.View;

// TODO use theme colors
public class PlastikRadioButtonUI extends BasicRadioButtonUI {

	private static final PlastikRadioButtonUI radioButtonUI = new PlastikRadioButtonUI();

	protected Color focusColor;

	protected Color highlightColor;

	protected Color disabledTextColor;

	public static ComponentUI createUI(JComponent c) {
		return radioButtonUI;
	}

	public void installDefaults(AbstractButton b) {
		super.installDefaults(b);
		installIcons(b); 
		focusColor = UIManager.getColor("Common.focus");
		highlightColor = UIManager.getColor("Common.highlight");
		disabledTextColor = UIManager.getColor("Common.disabledText");

		Object obj;
		obj = PlastikLookAndFeel.getDefaultOpacity() ? Boolean.TRUE : Boolean.FALSE;
		LookAndFeel.installProperty(b, "opaque", obj);

		obj = PlastikLookAndFeel.isRolloverEnabled() ? Boolean.TRUE	: Boolean.FALSE;
		LookAndFeel.installProperty(b, "rolloverEnabled", obj);
	}

	protected void uninstallDefaults(AbstractButton b) {
		super.uninstallDefaults(b);
		uninstallIcons(b);
		LookAndFeel.installProperty(b, "opaque", Boolean.TRUE);
		LookAndFeel.installProperty(b, "rolloverEnabled", Boolean.FALSE);
	}

	protected Color getDisabledTextColor() {
		return disabledTextColor;
	}

	protected Color getHighlightTextColor() {
		return highlightColor;
	}

	protected Color getFocusColor() {
		return focusColor;
	}

	protected void installIcons(AbstractButton b) {
		b.setIcon(PlastikIconFactory.getRadioButtonIcon());
	}
	
	protected void uninstallIcons(AbstractButton b) {
		b.setIcon(null);
	}

	public synchronized void paint(Graphics g, JComponent c) {
		AbstractButton b = (AbstractButton) c;
		ButtonModel model = b.getModel();

		Dimension size = c.getSize();

		Font f = c.getFont();
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();

		Rectangle viewRect = new Rectangle(size);
		Rectangle iconRect = new Rectangle();
		Rectangle textRect = new Rectangle();

		Insets i = c.getInsets();
		viewRect.x += i.left;
		viewRect.y += i.top;
		viewRect.width -= (i.right + viewRect.x);
		viewRect.height -= (i.bottom + viewRect.y);

		Icon icon = b.getIcon();

		String text = SwingUtilities.layoutCompoundLabel(c, fm, b.getText(),
				icon != null ? icon : getDefaultIcon(), b
						.getVerticalAlignment(), b.getHorizontalAlignment(), b
						.getVerticalTextPosition(), b
						.getHorizontalTextPosition(), viewRect, iconRect,
				textRect, b.getIconTextGap());

		// fill background
		if (b.isContentAreaFilled()) {
			g.setColor(b.getBackground());
			g.fillRect(0, 0, size.width, size.height);
		}

		// Paint the radio button
		if (icon != null) {
			if (!model.isEnabled()) {
				if (model.isSelected()) {
					icon = b.getDisabledSelectedIcon();
				} else {
					icon = b.getDisabledIcon();
				}
			} else if (model.isPressed() && model.isArmed()) {
				icon = b.getPressedIcon();
				if (icon == null) {
					// Use selected icon
					icon = b.getSelectedIcon();
				}
			} else if (model.isSelected()) {
				icon = b.getSelectedIcon();
			}

			if (icon == null) {
				icon = b.getIcon();
			}

			icon.paintIcon(c, g, iconRect.x, iconRect.y);

			if ((b.isRolloverEnabled() && model.isRollover() && model
					.isEnabled())) {
				paintHighlight(g, iconRect);
			}

		} else {
			// TODO hier muss noch was gemacht werden
			getDefaultIcon().paintIcon(c, g, iconRect.x, iconRect.y);
		}

		// Draw the Text
		if (PlastikLookAndFeel.isTextAntialiasing()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
					RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if (text != null) {
			View v = (View) c.getClientProperty(BasicHTML.propertyKey);
			if (v != null) {
				v.paint(g, textRect);
			} else {
				int mnemIndex = b.getDisplayedMnemonicIndex();
				if (model.isEnabled()) {
					// *** paint the text normally
					g.setColor(b.getForeground());
					BasicGraphicsUtils.drawStringUnderlineCharAt(g, text,
							mnemIndex, textRect.x, textRect.y + fm.getAscent());
				} else {
					// *** paint the text disabled
					g.setColor(getDisabledTextColor());
					BasicGraphicsUtils.drawStringUnderlineCharAt(g, text,
							mnemIndex, textRect.x, textRect.y + fm.getAscent());
				}
				if (b.hasFocus() && b.isFocusPainted() && textRect.width > 0
						&& textRect.height > 0) {
					paintFocus(g, textRect, size);
				}
			}
		}
	}

	protected void paintHighlight(Graphics g, Rectangle iconRect) {
		Graphics2D g2 = (Graphics2D) g;
		Color c = getHighlightTextColor();
		// todo farbe mit alpha über installDefaults(performance) aus uimanager
		// holen
		Color highlight = new Color(c.getRed(), c.getGreen(), c.getBlue(), 170);
		g2.setColor(highlight);
		g2.translate(iconRect.x, iconRect.y);
		g2.drawLine(4, 1, 8, 1); // line 2
		g2.drawLine(2, 2, 10, 2); // line 3
		g2.drawLine(2, 3, 3, 3);
		g2.drawLine(9, 3, 10, 3); // lines 4
		g2.drawLine(1, 4, 1, 8);
		g2.drawLine(11, 4, 11, 8); // lines 5 - 9
		g2.drawLine(2, 4, 2, 8);
		g2.drawLine(10, 4, 10, 8); // lines 5 - 9
		g2.drawLine(2, 9, 3, 9);
		g2.drawLine(9, 9, 10, 9); // lines 10
		g2.drawLine(2, 10, 10, 10); // line 11
		g2.drawLine(4, 11, 8, 11); // line 12
		g2.translate(-iconRect.x, -iconRect.y);
	}

	protected void paintFocus(Graphics g, Rectangle t, Dimension d) {
		g.setColor(getFocusColor());
		Graphics2D g2 = (Graphics2D) g;
		float[] dashes = { 0.2f };
		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 1.0f, dashes, 1.0f);
		g2.setStroke(stroke);
		g2.drawRect(t.x - 1, t.y - 1, t.width + 1, t.height + 1);
	}
}
