package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import de.hampelratte.plastik.PlastikUtils;
import java.awt.Color;
import java.util.ArrayList;

public abstract class AbstractColorTheme implements PlastikColorTheme {
	
	// colors used by KDE
	protected static final int KDE_DEFAULT_BACKGROUND           = 0;
	protected static final int KDE_DEFAULT_TEXT                 = 1;
	protected static final int KDE_SELECTED_BACKGROUND          = 2;
	protected static final int KDE_SELECTED_TEXT                = 3;
	protected static final int KDE_LINK                         = 4;
	protected static final int KDE_USED_LINK                    = 5;
	protected static final int KDE_WINDOW_BACKGROUND            = 6;
	protected static final int KDE_WINDOW_TEXT                  = 7;
	protected static final int KDE_BUTTON_BACKGROUND            = 8;
	protected static final int KDE_BUTTON_TEXT                  = 9;
	protected static final int KDE_ACTIVE_TITLEBAR              = 10;
	protected static final int KDE_ACTIVE_TITLEBAR_TEXT         = 11;
	protected static final int KDE_ACTIVE_TITLEBAR_GRADIENT     = 12;
	protected static final int KDE_ACTIVE_TITLEBAR_BUTTON       = 13;
	protected static final int KDE_INACTIVE_TITLEBAR            = 14;
	protected static final int KDE_INACTIVE_TITLEBAR_TEXT       = 15;
	protected static final int KDE_INACTIVE_TITLEBAR_GRADIENT   = 16;
	protected static final int KDE_INACTIVE_TITLEBAR_BUTTON     = 17;
	protected static final int KDE_ACTIVE_WINDOWBORDER          = 18;
	protected static final int KDE_ACTIVE_WINDOWBORDER_HANDLE   = 19;
	protected static final int KDE_INACTIVE_WINDOWBORDER        = 20;
	protected static final int KDE_INACTIVE_WINDOWBORDER_HANDLE = 21;
	protected static final int KDE_ALTERNATIVE_LIST_BACKGROUND  = 22;
	
	// colors and adjustmentvalues
	protected int colorCount;
	protected int[] adjustmentValues;
	protected PlastikColorUIResource[] colorArray;
	
	public AbstractColorTheme() {
		colorCount = 256 * UI_COUNT; // 256 colors per ui
		adjustmentValues = new int[colorCount];
		precomputeAdjustmentValues();
		colorArray = new PlastikColorUIResource[colorCount];
	}
	
	// TODO implement this (horror)
	protected void setKDEColor(Color color, int type) {
		switch (type) {
			case KDE_BUTTON_BACKGROUND:
				//1. delete colors
				deleteColors(BACKGROUND_COMPONENT);
				//2. define colors
				//3. define adjustmentvalues
				break;
			
		}
	}
	
	protected void deleteColors(int colorType) {
		colorType = colorType << TYPES_SHIFT;
		
		// Alle Komponenten durchlaufen und an die Stelle des betreffenden 
		// colorTypes springen.
		for (int i=colorType; i<colorCount; i+=256) {
			
			// Jede Variation (active/darker etc.) löschen.
			for (int j=0; j<16; j++) {
				colorArray[i+j] = null;
			}
		}
	}
	
	
	private void precomputeAdjustmentValues() {
		for (int i=0; i<colorCount; i+=16) {
			// active
			adjustmentValues[i]    =   0; // normal
			adjustmentValues[i+1]  =  20; // brighter
			adjustmentValues[i+2]  =  40; // brighter more
			adjustmentValues[i+3]  =  10; // brighter gradient
			adjustmentValues[i+4]  = -20; // darker
			adjustmentValues[i+5]  = -40; // darker more
			adjustmentValues[i+6]  = -10; // darker gradient
			// inactive
			adjustmentValues[i+8]  =   0; // normal
			adjustmentValues[i+9]  =  10; // brighter
			adjustmentValues[i+10] =  20; // brighter more
			adjustmentValues[i+11] =   5; // brighter gradient
			adjustmentValues[i+12] = -10; // darker
			adjustmentValues[i+13] = -20; // darker more
			adjustmentValues[i+14] =  -5; // darker gradient
		}
	}
	
	/**
	 * Bestimmt einen Korrekturwert, bestehend aus der Änderung der Helligkeit 
	 * und des Alpha-Wertes.
	 *
	 * @param brightnessAdjustment Helligkeitsänderung im Bereich (-255..255)
	 * @param alphaAdjustment Alphakanaländerung im Bereich (-255..255)
	 * @return Es wird ein Wert zurückgegeben welcher die beiden Änderungen 
	 *         vereint.
	 * TODO translate comment
	 */
	public static int computeAdjustmentValue(int brightnessAdjustment, int alphaAdjustment) {
		if (brightnessAdjustment < -255 || brightnessAdjustment > 255)
			throw new IllegalArgumentException("brightnessAdjustment "+brightnessAdjustment+" out of range (-255..255)");
		if (alphaAdjustment < -255 || brightnessAdjustment > 255)
			throw new IllegalArgumentException("alphaAdjustment "+alphaAdjustment+" out of range (-255..255)");
		brightnessAdjustment += 255; //max = 255+255 = 510, min = -255+255 = 0 (9 Bit)
		alphaAdjustment      += 255; //max = 255+255 = 510, min = -255+255 = 0 (9 Bit)
		int adjustmentValue = brightnessAdjustment & (alphaAdjustment << 16);
		return adjustmentValue;
	}
	
	/**
	 * Gewinnt aus einem Korrekturwert die Helligkeitsänderung.
	 */
	public static int getBrightnessAdjustment(int adjustmentValue) {
		return (adjustmentValue & 0xFFFF) - 255;
	}
	
	/**
	 * Gewinnt aus einem Korrekturwert die Alphaänderung
	 */
	public static int getAlphaAdjustment(int adjustmentValue) {
		return ((adjustmentValue >> 16) & 0xFFFF) - 255;
	}
	
	/**
	 * Setzt den Helligkeitskorrekturwert für eine einzelne Farbe.
	 * Die entsprechende Farbe wird dabei aber nicht aktualisiert, dies muss 
	 * manuel geschehen.
	 */
	public void setAdjustmentValue(int adjustmentValue, int type) {
		adjustmentValues[type] = adjustmentValue;
	}
		
	/**
	 * Gibt den Helligkeitskorrekturwert für eine einzelne Farbe zurück.
	 */
	public int getAdjustmentValue(int type) {
		return adjustmentValues[type];
	}
	
	public void setColor(int r, int g, int b, int a, int type) {
		setColor(new Color(r,g,b,a), type);
	}
	
	public void setColor(int r, int g, int b, int type) {
		setColor(new Color(r,g,b), type);
	}
	
	/**
	 * Setzt eine eine einzelne Grundfarbe (Farbe ohne Varianten). Dabei wird 
	 * aber sehr wohl zwischen ACTIVE und INACTIVE unterschieden. 
	 */
	public void setColor(Color color, int type) {
		int index = type & (INACTIVE_MASK | TYPES_MASK | UI_MASK); // ignoring the variants
		int ad = adjustmentValues[index];
		int rgb = color.getRGB();
		if (ad != 0) {
			rgb = computeAdjustedColor(rgb, ad);
		}
		colorArray[index] = new PlastikColorUIResource(rgb);		
	}
	
	/**
	 * This function should return a cached version of the color if the param 
	 * color is an instance of PlastikColorUIResource. If the param is no 
	 * UIResource then it should return a computed color.
	 *
	 * @param color the color-object of the component.
	 * @param type the requested type.
	 */
	public Color getColor(Color color, int type) {
		if (color instanceof PlastikColorUIResource) {
			return getColor(type);
		}
		return computeColor(color, type);
	}
	
	public PlastikColorUIResource getColor(int type) {
		PlastikColorUIResource color = colorArray[type];
		
		if (color != null) {
			return color;
		} 
		
		// Die Farbe existiert nicht, daher wird als Erstes die Frage 
		// gestellt ob es sich um eine Variante oder eine "Grundfarbe" 
		// (Variante ist NORMAL) handelt. [index zeigt auf die Grundfarbe]
		int index = type & (INACTIVE_MASK | TYPES_MASK | UI_MASK);
		if (index == type) {
			// Es ist eine "Grundfarbe", da die Variante NORMAL (0) ist.
			// Es wird nun bei COMMON nachgefragt, da dort die "Grundfarbe" auf 
			// jeden Fall vorhanden sein sollte, es sei denn dieser Aufruf fragt 
			// bereits nach COMMON
			if ((type & UI_MASK) == COMMON) {
				throw new IllegalStateException("at least the basecolors for COMMON must be defined");
			} else {
				// Die Farbe wird von COMMON abgefragt, entsprechend des 
				// Adjustments verändert (falls != 0) und gespeichert.
				color = getColor(COMMON + (type & (INACTIVE_MASK | TYPES_MASK)));
				if (adjustmentValues[type] != 0) {
					color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
				}
				colorArray[type] = color;
			}	
		} else {
			// Es ist keine "Grundfarbe", da die Variante nicht NORMAL (0) ist.
			// Es wird nun bei COMMON nachgefragt, da dies zumindest die 
			// "Grundfarbe" liefern können muss, es sei denn dieser Aufruf fragt 
			// bereits nach COMMON.
			if ((type & UI_MASK) == COMMON) {
				// Frage nach der Grundfarbe:
				color = getColor(index);
				if (adjustmentValues[type] != 0) {
					color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
				}
				colorArray[type] = color;
			} else {
				// Frage nach der eigenen Grundfarbe.
				//color = getColor(COMMON + (index & (INACTIVE_MASK | TYPES_MASK)));
				color = getColor(index);
				if (adjustmentValues[type] != 0) {
					color = new PlastikColorUIResource(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
				}
				colorArray[type] = color;
			}
		}
		return color;
	}
	
	public Color computeColor(Color color, int type) {
		return new Color(computeAdjustedColor(color.getRGB(), adjustmentValues[type]));
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
	public static final int computeAdjustedColor(int argb, int adjustmentValue) {
		int light = getBrightnessAdjustment(adjustmentValue);
		int alpha = getAlphaAdjustment(adjustmentValue);
		
		float h, s, l;
		int a = (argb >> 24) & 0xFF;
		int r = (argb >> 16) & 0xFF;
		int g = (argb >>  8) & 0xFF;
		int b = (argb >>  0) & 0xFF;
	
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

		a += alpha;
		a = Math.max(0, Math.min(255, a));

		return (a << 24) | (r << 16) | (g << 8) | (b << 0);
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
