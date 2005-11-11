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
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicButtonUI;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import javax.swing.plaf.basic.BasicHTML;
import javax.swing.text.View;

public class PlastikButtonUI extends BasicButtonUI {
	
	private static final PlastikButtonUI BUTTON_UI = new PlastikButtonUI();
	
	private boolean defaultsInitialized = false;
	
	private Color  defaultForeground = null;
	private Color  defaultBackground = null;
	private Font   defaultFont       = null;
	private Border defaultBorder     = null;
	private Insets defaultMargin     = null;
	
	/**
	 * Der Konstruktor ist protected, da er nur von Subklassen überschrieben
	 * oder aufgerufen werden sollte.
	 */
	protected PlastikButtonUI() {
		super();
	}
	
	public static ComponentUI createUI(JComponent c) {
		return BUTTON_UI;
	}
	
	
	public void installDefaults(AbstractButton b) {
		String pp = getPropertyPrefix();
		if (!defaultsInitialized) {
			// TODO TextIconGap
			// TextIconGap wird nicht an den Button übergeben, da man hier 
			// UIResource-Objekte nicht von "User"-Objekten unterscheiden kann
			// (kein UIResource-Flag).
			defaultTextIconGap     = ((Integer)UIManager.get(pp + "textIconGap")).intValue();
			defaultTextShiftOffset = ((Integer)UIManager.get(pp + "textShiftOffset")).intValue();
			defaultForeground      = UIManager.getColor(pp + "foreground");
			defaultBackground      = UIManager.getColor(pp + "background");
			defaultFont            = UIManager.getFont(pp + "font");
			defaultBorder          = UIManager.getBorder(pp + "border");
			defaultMargin          = UIManager.getInsets(pp + "margin");
			
			defaultsInitialized = true;
		}
		
		Color  currentForeground = b.getForeground();
		Color  currentBackground = b.getBackground();
		Font   currentFont       = b.getFont();
		Border currentBorder     = b.getBorder();
		Insets currentMargin     = b.getMargin();
		
		// Defaults welche durch diesen Test kommen, können später bedenkenlos
		// wieder entfernt werden, ohne das es beim umschalten zwischen Themes
		// zu Problemen kommt.
		if (currentForeground == null || currentForeground instanceof UIResource) b.setForeground(defaultForeground);
		if (currentBackground == null || currentBackground instanceof UIResource) b.setBackground(defaultBackground);
		if (currentFont       == null || currentFont       instanceof UIResource) b.setFont(defaultFont);
		if (currentBorder     == null || currentBorder     instanceof UIResource) b.setBorder(defaultBorder);
		if (currentMargin     == null || currentMargin     instanceof UIResource) b.setMargin(defaultMargin);
		
		if(PlastikLookAndFeel.getDefaultOpacity() == false) {
			b.setOpaque(false);
		}
		
		if(PlastikLookAndFeel.isRolloverEnabled()) {
			b.setRolloverEnabled(true);
		}
	}
	
	
	public void uninstallDefaults(AbstractButton b) {
		if (b.getForeground() instanceof UIResource) b.setForeground(null);
		if (b.getBackground() instanceof UIResource) b.setForeground(null);
		if (b.getFont()       instanceof UIResource) b.setFont(null);
		if (b.getBorder()     instanceof UIResource) b.setBorder(null);
		if (b.getMargin()     instanceof UIResource) b.setMargin(null);
		
		// Wird mehrfach aufgerufen ist so aber sicher
		defaultsInitialized = false;
	}
	
	/**
	 * Ich bastle hier einen Workaround mit dem man auch ohne das isOpaque() 
	 * false liefert transparenzen darstellen kann. 
	 */
	public void update(Graphics g, JComponent c) {
		AbstractButton button = (AbstractButton) c;
		ButtonModel model = button.getModel();
		
		// Ein Hack um Transparenzen zu ermöglichen.
		PlastikUtils.drawTransparentBackground(g, c);

		// Zeichnen, um die Transparenz wurde sich schon gekümmert!
		paint(g, c);
	}
	
	private static Rectangle viewRect = new Rectangle();
    private static Rectangle textRect = new Rectangle();
    private static Rectangle iconRect = new Rectangle();
	
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
	
	protected void paintBackground(Graphics g, AbstractButton b, ButtonModel model) {
		if (b.isContentAreaFilled()) {
			Color background = b.getBackground();
			Color top    = null;
			Color bottom = null;
			if (background instanceof UIResource) {
				if (!model.isEnabled()) {
					top    = new Color(239, 239, 239);
					bottom = new Color(233, 233, 233);
				} else if (model.isArmed() && model.isPressed()) {
					top    = new Color(203, 205, 209); // TODO ins LaF
					bottom = new Color(213, 215, 219);
				} else {
					top    = new Color(233, 235, 239);
					bottom = new Color(213, 215, 219);
				}
			} else {
				// TODO calculate corresponding colors
				if (!model.isEnabled()) {
					top    = background;
					bottom = background;
				} else {
					top    = background;
					int rgb = PlastikUtils.computeAdjustedColor(background.getRGB(), -25);
					bottom = new Color(rgb);
				}
			}
			// TODO be carefull with the edges..
			Gradients.drawBoxGradient(g, viewRect, top, bottom);
		}
	}
	
	protected void paintText(Graphics g, AbstractButton b, Rectangle textRect, String text) {
        ButtonModel model = b.getModel();
        FontMetrics fm    = g.getFontMetrics();
        int mnemonicIndex = b.getDisplayedMnemonicIndex();
		
		int textStep = (model.isArmed() && model.isPressed()) ? 1 : 0;

		if (model.isEnabled()) {
			g.setColor(b.getForeground());
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + textStep, textRect.y + fm.getAscent() + textStep);
		} else {
			g.setColor(new Color(255,255,255));
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + 1 + textStep, textRect.y + fm.getAscent() + 1 + textStep);
			g.setColor(new Color(200,200,200));
			BasicGraphicsUtils.drawStringUnderlineCharAt(g, text, mnemonicIndex, textRect.x + textStep, textRect.y + fm.getAscent() + textStep);
		}
    }
	
	private static Rectangle focusRect = new Rectangle();
	
	protected void paintFocus(Graphics g, AbstractButton b, Rectangle viewRect, Rectangle textRect, Rectangle iconRect) {
		focusRect.setBounds(viewRect);
		
		focusRect.x += 1;
		focusRect.y += 1;
		focusRect.width  -= 3;
		focusRect.height -= 3;
		
		// TODO use focus color instead of this fixed value
		g.setColor(Color.BLACK);
		Graphics2D g2d = (Graphics2D) g;
		float[] dashes = { 1f, 1f };
		BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 1.0f, dashes, 1.0f);
		g2d.setStroke(stroke);
		g2d.drawRect(focusRect.x, focusRect.y, focusRect.width, focusRect.height);		
	}
	
	public Dimension getPreferredSize(JComponent c) {
		AbstractButton b = (AbstractButton) c;
		String text = b.getText();
		Dimension d = super.getPreferredSize(c);
		if (text != null && !text.equals("") || b.getIcon() == null) {
			d.height = d.height < 22 ? 26 : d.height+4;
			d.width += 12;
		}
		return d;
	}
}
