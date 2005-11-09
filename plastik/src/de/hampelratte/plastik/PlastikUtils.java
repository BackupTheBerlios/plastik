package de.hampelratte.plastik;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
import javax.swing.AbstractButton;
import javax.swing.ButtonModel;
import javax.swing.JComponent;

public class PlastikUtils {
	
	private static Method paintComponentMethod;
	
	static {
		try {
			paintComponentMethod = JComponent.class.getDeclaredMethod("paintComponent", new Class[]{Graphics.class});
			paintComponentMethod.setAccessible(true);
		} catch (Exception ex) {
			// this should never happen
			ex.printStackTrace();
		}
	}

	private PlastikUtils() {
	}
	
	/**
	 * Dies ist ein Trick um einen transparenten Hintergrund zu emulieren, da 
	 * dies aus verschiedenen Gründen nicht besser funktioniert.
	 *
	 * @param g Das Graphics-Objekt mit dem die Komponente gezeichnet wird
	 * @param component Die Komponente selbst
	 */
	public static void drawTransparentBackground(Graphics g, JComponent component) {	
		if (component.isOpaque()) {
			Component parent = component.getParent();
			Rectangle bounds = component.getBounds();
			
			if (parent instanceof JComponent) { // Hier funktioniert der Hack
				JComponent jParent = (JComponent) parent;
				
				//Bild zum hineinzeichnen besorgen.
				BufferedImage img = PlastikImageCache.getCachedImage(component.getGraphicsConfiguration(), jParent.getWidth(), jParent.getHeight());
				Graphics gg = img.getGraphics();
				
				//Beschränkung auf einen bestimmten Bereich um die Performance 
				//zu steigern.
				gg.setClip(bounds.x, bounds.y, bounds.width, bounds.height);
				
				try {
					paintComponentMethod.invoke(jParent, new Object[]{gg});
				} catch(Exception ex) {
					// this should never happen
					ex.printStackTrace(); 
				}
				
				g.drawImage(img, 0, 0, bounds.width, bounds.height, bounds.x, bounds.y, bounds.x+bounds.width, bounds.y+bounds.height, null);
				
			} else { // Component bietet die Möglichkeit nicht daher einfache Lösung
				g.setColor(parent.getBackground());
				g.fillRect(0, 0, bounds.width, bounds.height);
			}
		}
	}
	
}
