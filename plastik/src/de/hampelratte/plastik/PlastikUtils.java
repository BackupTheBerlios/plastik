package de.hampelratte.plastik;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.lang.reflect.Method;
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
	 * @depreacted this is now obsolete
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
	
	
// TODO: Remove the colorAdjustment Methods! 
// (all colors should be provided by the theme)
	
	/**
	 * Berechnet aus der übergebenen Farbe eine hellere (1 bis 255) bzw. eine 
	 * dunklere (-1 bis -255) Farbe. Dabei orientiert sich die Berechnung an dem
	 * HSL-Farbmodel (L-Lightness).
	 * 
	 * @param color Die Farbe von der die hellere oder dunklere Farbe bestimmt 
	 *              werden soll.
	 * @param light Ein Integer zwischen -255 und 255 welcher die 
	 *              Helligkeitsänderung angibt.
	 * @return Die berechnete Farbe.
	 */
	public static final Color computeAdjustedColor(Color color, int light) {
		return new Color(computeAdjustedColor(color.getRGB(), light));
	}
		
	/**
	 * Berechnet aus der übergebenen Farbe eine hellere (1 bis 255) bzw. eine 
	 * dunklere (-1 bis -255) Farbe. Dabei orientiert sich die Berechnung an dem
	 * HSL-Farbmodel (L-Lightness).
	 * 
	 * @param rgb Die Farbe als int von der die hellere oder dunklere Farbe 
	 *            bestimmt werden soll.
	 * @param light Ein Integer zwischen -255 und 255 welcher die 
	 *              Helligkeitsänderung angibt.
	 * @return Die berechnete Farbe als int.
	 */
	public static final int computeAdjustedColor(int rgb, int light) {
		float h, s, l;
		int r = (rgb >> 16) & 0xFF;
		int g = (rgb >>  8) & 0xFF;
		int b = (rgb >>  0) & 0xFF;
	
		int max = Math.max(r, Math.max(g, b));
		int min = Math.min(r, Math.min(g, b));
		
		float sum = max + min;
		float dif = max - min;
		
		l = sum / 2.0f / 255.0f;
		if (max == min) {
			h = s = 0.0f;
		} else {
			s = (l <= 0.5f) ? dif/sum : dif/(2.0f*255.0f - sum);
		
			if (r == max) {
				h =             (g-b) / dif / 6.0f;
			} else if (g == max) {
				h = 1.0f/3.0f + (b-r) / dif / 6.0f;
			} else {
				h = 2.0f/3.0f + (r-g) / dif / 6.0f;
			}

			if (h < 0.0f) {
				h += 1.0f;
			}
		}
		
	
		l += (float) light / 255.0f;
		l = Math.max(0.0f, Math.min(1.0f, l));
		
		
		sum = (l <= 0.5) ? l*(s+1.0f) : l+s - l*s;
		dif = 2.0f * l - sum;
		r = Math.round((255.0f * hueToRGB(dif, sum, h+1.0f/3.0f)));
		g = Math.round((255.0f * hueToRGB(dif, sum, h          )));
		b = Math.round((255.0f * hueToRGB(dif, sum, h-1.0f/3.0f)));
		
		return 0xFF000000 | (r << 16) | (g << 8) | (b << 0);
	}
	
	private static final float hueToRGB(float dif, float sum, float h) {
		if (h < 0.0f) {
			h += 1.0f;
		} else if (h > 1.0f) {
			h -= 1.0f;
		}
		if (h*6.0f < 1.0f) {
			return dif + (sum - dif) * h * 6.0f;
		}
		if (h*2.0f < 1.0f) {
			return sum;
		}
		if (h*3.0f < 2.0f) {
			return dif + (sum - dif) * (2.0f/3.0f-h) * 6.0f;
		}
		return dif;
	}
	
}
