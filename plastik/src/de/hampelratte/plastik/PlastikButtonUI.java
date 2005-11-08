package de.hampelratte.plastik;
import de.hampelratte.test.TransparencyTest;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;

import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.UIResource;
import javax.swing.plaf.basic.BasicButtonUI;

//TODO text beim drücken verschieben
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
	
//	class PlastikButtonListener extends BasicButtonListener {
//
//		public PlastikButtonListener(AbstractButton b) {
//			super(b);
//		}
//
//	}
//	
//	protected BasicButtonListener createButtonListener(AbstractButton b) {
//		return new PlastikButtonListener(b);
//	}
	
	/**
	 * Ich bastle hier mal einen Workaround mit dem man auch ohne das isOpaque() 
	 * false liefert transparenzen darstellen kann. Momentan ist die Performance
	 * aber alles andere als gut. Dies kann man aber sicherlich mit einem 
	 * entsprechenden Cache für die erzeugten BufferedImages beheben.
	 * 
	 */
	public void update(Graphics g, JComponent c) {
		AbstractButton button = (AbstractButton) c;
		ButtonModel model = button.getModel();
		
		if (button.isOpaque()) {
			Component parent = button.getParent();
			if (parent instanceof JComponent) {
				JComponent jParent = (JComponent) parent;
				Rectangle bounds = button.getBounds();
				BufferedImage img = c.getGraphicsConfiguration().createCompatibleImage(jParent.getWidth(), jParent.getHeight());
				Graphics gg = img.getGraphics();
				
				//gg.translate(-bounds.x, -bounds.y);
				gg.setClip(bounds.x, bounds.y, bounds.width, bounds.height);
				
				try {
					Method m = JComponent.class.getDeclaredMethod("paintComponent", new Class[]{Graphics.class});
					m.setAccessible(true);
					m.invoke(jParent, new Object[]{gg});
				} catch(Exception e) { e.printStackTrace(); }
				
				//gg.copyArea(bounds.x, bounds.y, bounds.width, bounds.height, -bounds.x, -bounds.y);
				g.drawImage(img,0,0,bounds.width, bounds.height, bounds.x, bounds.y, bounds.x+bounds.width, bounds.y+bounds.height, null);
				
				//TransparencyTest.displayImage(img);
				
				Graphics2D g2d = (Graphics2D) g;
				g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
				g2d.setColor(Color.WHITE);
				g2d.fillRect(0, 0, button.getWidth(), button.getHeight());
			} else {
				// geht nicht... -> normal zeichen
			}		
		} else {
			// normal da Transparent..
		}
	}
	
	
/*	public void update(Graphics g, JComponent c) {
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
	}*/
}
