package de.hampelratte.plastik;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.metal.MetalButtonUI;

//TODO text beim drücken verschieben
public class PlastikButtonUI extends MetalButtonUI {
	
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
			// TextIconGap wird nicht an den Button übergeben, aber scheinbar
			// auch sonst nirgends verwendet, da man hier UIResource-Objekte
			// nicht von "User"-Objekten unterscheiden kann
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
		
		// TODO PropertyWrapper für Transparenz einführen.
/*
		// Ein Problem stellt die Transparenz der Ecken der Buttons dar. Aus
		// diesem Grund verwenden wir "transparente" Buttons. Allerdings sollte
		// die Ursprüngliche Eigenschaft "opaque" erhalten werden. Dies kann man
		// mit einem PropertyListener erreichen. Die originalen Werte werden
		// dort entgegengenommen, gespeichert aber nicht übernommen, denn
		// schließlich soll unser Button immer nicht "opaque"
 
		// Die originalen Werte des Buttons! Diese werden evtl. überschrieben
		// und daher werden diese hier gesichert, um sie später wieder
		// zurücksetzen zu können.
		PropertyWrapper p = new PropertyWrapper();
		p.setOpaque(b.isOpaque());
 
		b.putClientProperty("plastikWrapper", p);
 
		// Nun setzen wir noch die veränderten Defaults
		b.setOpaque(opaque);
 */
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
	
	class PlastikButtonListener extends BasicButtonListener {
		
		public PlastikButtonListener(AbstractButton b) {
			super(b);
		}
		
		// TODO Wrapper einbinden...
/*
		public void propertyChange(java.beans.PropertyChangeEvent e) {
			super.propertyChange(e);
			String prop = e.getPropertyName();
 
			if (prop.equals("opaque")) {
				AbstractButton b = (AbstractButton) e.getSource();
				checkOpacity(b);
				PropertyWrapper p = (PropertyWrapper) b.getClientProperty("cionWrapper");
				p.setOpaque( ((Boolean)e.getNewValue()).booleanValue() );
			} else if (prop.equals("background")) {
				checkOpacity((AbstractButton) e.getSource());
			}
		}
 
		// Hier fehlt noch eine eindeutige Regelung und den Wrapper nicht vergessen...
		protected void checkOpacity(AbstractButton b) {
			boolean opaque;
			PropertyWrapper p = (PropertyWrapper) b.getClientProperty("cionWrapper");
			opaque = p.isOpaque() && b.isContentAreaFilled();
			if (opaque) {
				if (b.getBackground() instanceof CionBackgroundPainter) {
					opaque = ((CionBackgroundPainter)b.getBackground()).paintsOpaque();
				} else {
					CionBackgroundTheme t = CionLookAndFeel.getCurrentTheme().getBackgroundTheme();
					opaque = t.getButtonBackgroundPainter().paintsOpaque();
				}
			}
			b.setOpaque(opaque);
		}*/
	}
	
	protected BasicButtonListener createButtonListener(AbstractButton b) {
		return new PlastikButtonListener(b);
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
		g.setColor(c.getBackground());
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
			g2.setColor(c.getBackground());
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
