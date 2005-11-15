package de.hampelratte.plastik.theme;

import de.hampelratte.plastik.PlastikColorUIResource;
import de.hampelratte.plastik.PlastikUtils;
import java.awt.Color;
import java.util.ArrayList;

public abstract class AbstractColorTheme implements PlastikColorTheme {
	
	protected int[] adjustmentValues;
	protected int colorCount;
	protected PlastikColorUIResource[] colorArray;
	
	public AbstractColorTheme() {
		colorCount = 256 * UI_COUNT; // 256 colors per ui
		adjustmentValues = new int[colorCount];
		precomputeAdjustmentValues();
		colorArray = new PlastikColorUIResource[colorCount];
	}
	
	private void precomputeAdjustmentValues() {
		for (int i=0; i<colorCount; i+=16) {
			// active
			adjustmentValues[i]   =   0;
			adjustmentValues[i+1] =  20;
			adjustmentValues[i+2] =  40;
			adjustmentValues[i+3] =  10;
			adjustmentValues[i+4] = -20;
			adjustmentValues[i+5] = -40;
			adjustmentValues[i+6] = -10;
			// inactive
			adjustmentValues[i+8]  =   0;
			adjustmentValues[i+9]  =  10;
			adjustmentValues[i+10] =  20;
			adjustmentValues[i+11] =   5;
			adjustmentValues[i+12] = -10;
			adjustmentValues[i+13] = -20;
			adjustmentValues[i+14] =  -5;
		}
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
				// Frage nach der Grundfarbe von COMMON:
				color = getColor(COMMON + (index & (INACTIVE_MASK | TYPES_MASK)));
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
